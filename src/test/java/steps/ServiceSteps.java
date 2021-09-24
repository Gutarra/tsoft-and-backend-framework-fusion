package steps;

import com.tsoft.bot.backend.base.BaseClass;
import com.tsoft.bot.backend.objects.ServiceExcelObjects;
import com.tsoft.bot.backend.utility.ExcelReader;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import static org.junit.Assert.*;

public class ServiceSteps extends BaseClass {



    @Dado("que se tiene un archivo {string} con los datos para la prueba")
    public void queSeTieneUnArchivoConLosDatosParaLaPrueba(String ruta) throws Throwable {
        setExcel(ruta);
        this.getData = ExcelReader.data(this.RUTA_EXCEL, ServiceExcelObjects.PAGE_DATA);
    }

    @Cuando("se configura la url: {string}")
    public void seConfiguraLaUrl(String dato) throws Throwable {
        setURL(datoExcel(dato,ServiceExcelObjects.COLUMN_RUTA));
    }

    @Y("se configura los parametros de busqueda: {string}")
    public void seConfiguraLosParametrosDeBusqueda(String dato) throws Throwable {
        setParameters(datoExcel(dato,ServiceExcelObjects.COLUMN_PARAMETERS));
    }

    @Y("se configura el tipo de solicitud: {string}")
    public void seConfiguraElTipoDeSolicitud(String dato) throws Throwable  {
        configureMethod(datoExcel(dato,ServiceExcelObjects.COLUMN_METODO));
    }

    @Y("se agregan los headers especificados: {string}")
    public void seAgreganLosHeadersEspecificados(String dato) throws Throwable {
        setHeaders(datoExcel(dato,ServiceExcelObjects.COLUMN_HEADERSK),datoExcel(dato,ServiceExcelObjects.COLUMN_HEADERSV));
    }

    @Y("se añade el cuerpo de la solicitud desde el: {string}")
    public void seAniadeElCuerpoDeLaSolicitudDesdeEl(String dato) throws Throwable {
        addBody(datoExcel(dato,ServiceExcelObjects.COLUMN_BODY));
    }

    @Y("se envia la solicitud al servidor")
    public void seEnviaLaSolicitudAlServidor() {
        sendRequest();
    }

    @Entonces("se verifica el código de respuesta del servidor según el:{string}")
    public void seVerificaElCodigoDeRespuestaDelServidorSegunEl(String casoPrueba) throws Throwable {
        int codigoEsperado = Integer.parseInt(datoExcel(casoPrueba, ServiceExcelObjects.COLUMN_CRE));
        currentResponse.then().statusCode(codigoEsperado);
    }

    @Y("se valida el tipo de respuesta esperado según el: {string}")
    public void seValidaElTipoDeRespuestaEsperadoSegunEl(String casoPrueba) throws Throwable {
        String contentTypeEsperado = datoExcel(casoPrueba, ServiceExcelObjects.COLUMN_VALIDARCTYPE);
        currentResponse.then().contentType(contentTypeEsperado);
    }

    @Y("se valida la respuesta con un esquema json según el:{string}")
    public void seValidaLaRespuestaConUnEsquemaJsonSegunEl(String dato) throws Throwable {
        String validarjson = datoExcel(dato, ServiceExcelObjects.COLUMN_VLDEJ);
        validaresquemajson(validarjson);
    }

    @Y("se captura un dato mediante una regex: {string}")
    public void seCapturaUnDatoMedianteUnaRegex(String dato) throws Throwable {
        regExprExtractor(datoExcel(dato,ServiceExcelObjects.COLUMN_VLDREGEX), currentResponse.getBody().asString(),datoExcel(dato,ServiceExcelObjects.COLUMN_REGEXGROUP));
    }

    @Y("se compara el resultado del regex: {string}")
    public void seComparaElResultadoDelRegex(String dato) throws Throwable {
        String valorEsperado = datoExcel(dato, ServiceExcelObjects.COLUMN_REGEXVALE);
        if (!valorEsperado.equals(""))
            assertEquals(valorEsperado,this.valueOfRegex);
    }

    @Y("se captura un dato mediante una query de jsonpath: {string}")
    public void seCapturaUnDatoMedianteUnaQueryDeJsonpath(String dato) throws Throwable  {
        jsonPathExtractor(datoExcel(dato,ServiceExcelObjects.COLUMN_VLDJSONPATH),currentResponse);
    }

    @Y("se compara el resultado del jsonpath: {string}")
    public void seComparaElResultadoDelJsonpath(String dato) throws Throwable {
        String valorEsperado = datoExcel(dato, ServiceExcelObjects.COLUMN_JSONPATHVALE);
        if (!valorEsperado.equals(""))
            assertEquals(valorEsperado,this.valueOfJsonpath);

    }
    @Y("guardamos el {string} optenido mediante regexp")
    public void guardamosElOptenidoMedianteRegexp(String data) throws Throwable {
        saveParameter(datoExcel(data,ServiceExcelObjects.COLUMN_SAVEREGEXAS),valueOfRegex);
    }

    @Y("guardamos el {string} optenido mediante jsonpath")
    public void guardamosElOptenidoMedianteJsonpath(String data) throws Throwable {
        saveParameter(datoExcel(data,ServiceExcelObjects.COLUMN_SAVEJSONPATHAS),valueOfJsonpath);
    }
}
