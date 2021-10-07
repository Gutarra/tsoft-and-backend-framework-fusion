package steps;

import com.tsoft.bot.backend.base.BaseClass;
import com.tsoft.bot.backend.objects.ServiceExcelObjects;
import com.tsoft.bot.both.utility.ExcelReader;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;

public class ServiceSteps extends BaseClass {

    @Dado("que se proporciona un archivo {string} con el {string} para la prueba")
    public void queSeProporcionaUnArchivoConElDatoParaLaPrueba(String ruta,String data) throws Throwable {
        setExcel(ruta);
        this.getData = ExcelReader.data(this.RUTA_EXCEL, ServiceExcelObjects.PAGE_DATA);
        setTestDetails(dataExcel(data,ServiceExcelObjects.COLUMN_CASE), dataExcel(data,ServiceExcelObjects.COLUMN_DESC));
    }

    @Cuando("configuramos la url desde el : {string}")
    public void configuramosLaUrlDesdeEl(String dato) throws Throwable {
        setURL(dataExcel(dato,ServiceExcelObjects.COLUMN_RUTA));
    }

    @Y("se configura el metodo de la solicitud: {string}")
    public void seConfiguraElMetodoDeLaSolicitud(String dato) throws Throwable {
        configureMethod(dataExcel(dato,ServiceExcelObjects.COLUMN_METHOD));
    }

    @Y("agregamos los headers desde el {string}")
    public void agregamosLosHeadersDesdeEl(String dato) throws Throwable {
        setHeaders(dataExcel(dato,ServiceExcelObjects.COLUMN_HEADERS));
    }

    @Y("adjuntamos el body a la solicitud desde el {string}")
    public void adjuntamosElBodyALaSolicitudDesdeEl(String dato) throws Throwable {
        addBody(dataExcel(dato,ServiceExcelObjects.COLUMN_BODY));
    }

    @Y("configuramos los parameters o query strings desde el {string}")
    public void configuramosLosParametersOQueryStringsDesdeEl(String dato) throws Throwable {
        setParameters(dataExcel(dato,ServiceExcelObjects.COLUMN_PARAMETERS));
    }

    @Entonces("enviamos la solicitud al servidor")
    public void enviamosLaSolicitudAlServidor() {
        sendRequest();
    }

    @Y("verificamos el status code:{string}")
    public void verificamosElStatusCode(String dato) throws Throwable {
        int statusCodeExpected = Integer.parseInt(dataExcel(dato, ServiceExcelObjects.COLUMN_CRE));
        currentResponse.then().statusCode(statusCodeExpected);
    }

    @Y("validamos el Content-Type de la respuesta: {string}")
    public void validamosElContentTypeDeLaRespuesta(String dato) throws Throwable {
        String contentTypeExpected = dataExcel(dato, ServiceExcelObjects.COLUMN_VALIDATECTYPE);
        currentResponse.then().contentType(contentTypeExpected);
    }

    @Cuando("la respuesta es de tipo applicationjson se valida mediante un squema json:{string}")
    public void laRespuestaEsDeTipoApplicationJsonSeValidaMedianteUnSquemaJson(String dato) throws Throwable {
        String jsonSchema = dataExcel(dato, ServiceExcelObjects.COLUMN_VLDEJ);
        validateJSONSchema(jsonSchema);
    }

    @Y("capturamos un dato mediante una regex:{string}")
    public void capturamosUnDatoMedianteUnaRegex(String data) throws Throwable {
        saveRegex(dataExcel(data,ServiceExcelObjects.COLUMN_REGEX),currentResponse,data);
    }

    @Y("capturamos un dato mediante un jsonpath:{string}")
    public void capturamosUnDatoMedianteUnJsonpath(String data) throws Throwable {
        saveJsonpath(dataExcel(data,ServiceExcelObjects.COLUMN_JSONPATH),currentResponse,data);
    }
}
