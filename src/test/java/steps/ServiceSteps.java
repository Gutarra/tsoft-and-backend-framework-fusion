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
        ExcelReader.setExcel(ruta,data);
        setTestDetails(dataExcel(ServiceExcelObjects.COLUMN_CASE), dataExcel(ServiceExcelObjects.COLUMN_DESC));
    }

    @Cuando("configuramos la url")
    public void configuramosLaUrlDesdeEl() throws Throwable {
        setURL(dataExcel(ServiceExcelObjects.COLUMN_RUTA));
    }

    @Y("se configura el metodo de la solicitud")
    public void seConfiguraElMetodoDeLaSolicitud() throws Throwable {
        configureMethod(dataExcel(ServiceExcelObjects.COLUMN_METHOD));
    }

    @Y("agregamos los headers")
    public void agregamosLosHeadersDesdeEl() throws Throwable {
        setHeaders(dataExcel(ServiceExcelObjects.COLUMN_HEADERS));
    }

    @Y("adjuntamos el body a la solicitud")
    public void adjuntamosElBodyALaSolicitudDesdeEl() throws Throwable {
        addBody(dataExcel(ServiceExcelObjects.COLUMN_BODY));
    }

    @Y("configuramos los parameters o query strings")
    public void configuramosLosParametersOQueryStringsDesdeEl() throws Throwable {
        setParameters(dataExcel(ServiceExcelObjects.COLUMN_PARAMETERS));
    }

    @Entonces("enviamos la solicitud al servidor")
    public void enviamosLaSolicitudAlServidor() {
        sendRequest();
    }

    @Y("verificamos el status code")
    public void verificamosElStatusCode() throws Throwable {
        int statusCodeExpected = Integer.parseInt(dataExcel(ServiceExcelObjects.COLUMN_CRE));
        currentResponse.then().statusCode(statusCodeExpected);
    }

    @Y("validamos el Content-Type de la respuesta")
    public void validamosElContentTypeDeLaRespuesta() throws Throwable {
        String contentTypeExpected = dataExcel(ServiceExcelObjects.COLUMN_VALIDATECTYPE);
        currentResponse.then().contentType(contentTypeExpected);
    }

    @Cuando("la respuesta es de tipo applicationjson se valida mediante el squema json")
    public void laRespuestaEsDeTipoApplicationJsonSeValidaMedianteElSquemaJson() throws Throwable {
        String jsonSchema = dataExcel(ServiceExcelObjects.COLUMN_VLDEJ);
        validateJSONSchema(jsonSchema);
    }

    @Y("capturamos datos mediante una regex")
    public void capturamosDatosMedianteUnaRegex() throws Throwable {
        saveRegex(dataExcel(ServiceExcelObjects.COLUMN_REGEX),currentResponse);
    }

    @Y("capturamos datos mediante un jsonpath")
    public void capturamosDatosMedianteUnJsonpath() throws Throwable {
        saveJsonpath(dataExcel(ServiceExcelObjects.COLUMN_JSONPATH),currentResponse);
        saveSimpleJSONPath(dataExcel(ServiceExcelObjects.COLUMN_JSONPATH_SIMPLE),currentResponse);
    }
}
