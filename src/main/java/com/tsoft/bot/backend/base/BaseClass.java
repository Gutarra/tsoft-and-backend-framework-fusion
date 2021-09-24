package com.tsoft.bot.backend.base;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.tsoft.bot.backend.objects.ServiceObjects;
import com.tsoft.bot.backend.utility.FileHelper;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static net.serenitybdd.rest.SerenityRest.given;

public class BaseClass {
    protected String RUTA_EXCEL;
    protected String METODO;
    protected String URL;

    protected String valueOfJsonpath;
    protected String valueOfRegex;

    public void setExcel(String ruta) {
        this.RUTA_EXCEL = ruta;
    }

    protected List<HashMap<String, String>> getData;

    //Metodo integrado :P
    public String datoExcel(String casoPrueba, String columna) throws Throwable {
        int countPage = Integer.parseInt(casoPrueba) - 1;
        return getData.get(countPage).get(columna);
    }


    private RequestSpecification ReqManager = SerenityRest.given();
    protected Response currentResponse;

    public void get()
    {
        currentResponse = ReqManager.get(URL).then().extract().response();
    }

    public void post()
    {
        currentResponse =  ReqManager.post(URL).then().extract().response();
    }
    public void put()
    {
        currentResponse =  ReqManager.put(URL).then().extract().response();
    }
    public void patch()
    {
        currentResponse =  ReqManager.patch(URL).then().extract().response();
    }
    public void delete()
    {
        currentResponse =  ReqManager.delete(URL).then().extract().response();
    }
    public void addBody(String stringBody) throws IOException {
        if (!stringBody.equals(""))
        {
            String body;
            if (stringBody.contains("ARCHIVO"))
            {
                String archivo = stringBody.split("\"")[1].trim();
                if (!archivo.contains(":"))
                    archivo = FileHelper.getProjectFolder() + "/src/test/resources/extrafiles/" + archivo;
                body = FileUtils.readFileToString(new File(archivo), StandardCharsets.UTF_8);
                if (body.contains("echo %"))
                    body = changeStringWithParameters(body);
                ReqManager.body(body);
            }
            else
            {
                if (stringBody.contains("echo %"))
                    stringBody = changeStringWithParameters(stringBody);
                ReqManager.body(stringBody);
            }
        }
    }

    public void setURL(String url)
    {
        if (url.contains("echo %"))
            this.URL = changeStringWithParameters(url);
        else
            this.URL = url;
    }

    public void setHeaders(String stringHeaders, String stringValues) throws IOException {
        if (!stringHeaders.equals(""))
        {
            if (stringValues.contains("echo %"))
                stringValues = changeStringWithParameters(stringValues);
            String[] headers;
            String[] values;
            if (!stringHeaders.equals("ARCHIVO"))
            {
                headers = stringHeaders.split(",");
                values = stringValues.split(",");
            }
            else
            {
                headers = extractValues(stringHeaders + stringValues,"KEYS");
                values = extractValues(stringHeaders + stringValues,"VALUES");
            }

            for (int i = 0; i < headers.length; i++)
            {
                ReqManager.header(headers[i],values[i]);
            }
        }
    }
    public void setCookies(String[] names, String[] values)
    {
        for (int i = 0; i < names.length; i++)
        {
            ReqManager.cookie(names[i],values[i]);
        }
    }

    public String[] extractValues(String data,String value) throws IOException {
        String dataProcess;
        String[] values;
        if (data.contains("ARCHIVO"))
        {
            String archivo = data.split("\"")[1].trim();
            if (!archivo.contains(":"))
                archivo = FileHelper.getProjectFolder() + "/src/test/resources/extrafiles/" + archivo;
            dataProcess = FileUtils.readFileToString(new File(archivo), StandardCharsets.UTF_8);
            if (dataProcess.contains("echo %"))
                dataProcess = changeStringWithParameters(dataProcess);
        }
        else
        {
            dataProcess = data;
            if (dataProcess.contains("echo %"))
                dataProcess = changeStringWithParameters(dataProcess);

        }
        dataProcess = dataProcess.replace("\n","");
        dataProcess = dataProcess.replace("\r","");
        int separator = 0;
        if (dataProcess.contains("&"))
            separator = 1;
        else if (dataProcess.contains(","))
            separator = 2;
        String[] array1 = dataProcess.split("[&,]");
        values = new String[array1.length];
        for (int i = 0; i < array1.length; i++)
        {
            String[] current;
            if (separator == 1)
                current = array1[i].split("=");
            else if (separator == 2)
                current = array1[i].split(":");
            else
                current = array1[i].split(":");

            if (value == "KEYS")
                values[i] = current[0];
            else if (value == "VALUES")
                values[i] = current[1];
        }
        return values;
    }

    public void setParameters(String stringParameters) throws IOException {
        if (!stringParameters.equals(""))
        {
            if(stringParameters.contains("echo %"))
                stringParameters = changeStringWithParameters(stringParameters);
            String[] keys = extractValues(stringParameters,"KEYS");
            String[] values = extractValues(stringParameters,"VALUES");

            for (int i = 0; i < keys.length; i++)
            {
                ReqManager.param(keys[i],values[i]);
            }
        }
    }
    public void setParam(String key, String value)
    {
        ReqManager.param(key,value);
    }
    public void setCookie(String key, String value)
    {
        ReqManager.cookie(key,value);
    }
    public void setHeader(String key, String value)
    {
        ReqManager.header(key,value);
    }
    public void configureMethod(String Metodo)
    {
        this.METODO = Metodo;
    }
    public void sendRequest()
    {
        if (this.METODO.equals("GET"))
            get();
        else if (this.METODO.equals("POST"))
            post();
        else if (this.METODO.equals("PUT"))
            put();
        else if (this.METODO.equals("PATCH"))
            patch();
        else if (this.METODO.equals("DELETE"))
            delete();
    }

    public void regExprExtractor(String expression, String source, String group)
    {
        if (!expression.equals(""))
        {
            int groupNumber;
            if (group.equals(""))
                groupNumber = 1;
            else
                groupNumber = Integer.parseInt(group);
            Pattern pattern = Pattern.compile(expression);
            Matcher matcher = pattern.matcher(source);
            if (matcher.find())
                this.valueOfRegex = matcher.group(groupNumber);
            else
                this.valueOfRegex = "";
        }
    }

    public String regExprExtractor(String expression, String source, int group)
    {
        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(source);
        if (matcher.find())
            return matcher.group(group);
        else
            return  "";
    }

    public void jsonPathExtractor(String jsonPathExpression, Response source)
    {
        if (!jsonPathExpression.equals("") && source.getContentType().contains("application/json"))
        {
            Object document = Configuration.defaultConfiguration().jsonProvider().parse(source.getBody().asString());
            this.valueOfJsonpath = JsonPath.read(document, jsonPathExpression).toString();
        }
    }

    public void saveParameter(String nameParam, String value)
    {
        if (!nameParam.equals(""))
            ServiceObjects.parameters.put(nameParam,value);
    }
    public String changeStringWithParameters(String source)
    {
        String formatString = source;
        String macthValue = regExprExtractor("echo %(.+?)%",formatString,1);
        while (!macthValue.isEmpty())
        {
            formatString = formatString.replace("echo %"+macthValue+"%",ServiceObjects.parameters.get(macthValue));
            macthValue = regExprExtractor("echo %(.+?)%",formatString,1);
        }
        return formatString;
    }

    public void validaresquemajson(String json) throws IOException {
        if (json.equals("")){
            Serenity.recordReportData()
                    .withTitle("No corresponde Validacion")
                    .andContents("El nombre de archivo encontrado es: '"+json +"' Valor Vacio");
        }else{
            if (currentResponse.getContentType().contains("application/json"))
            {
                given().then().body(matchesJsonSchemaInClasspath("schemas/"+json+".json"));
                Path jsonesperado = Paths.get("src/test/resources/schemas/"+json+".json");
                Serenity.recordReportData().withTitle("Esquema Json Esperado").fromFile(jsonesperado);
            }
            else
            {
                Serenity.recordReportData()
                        .withTitle("El response no es de tipo json")
                        .andContents("no re realizo la validación");
            }
        }
    }
}
