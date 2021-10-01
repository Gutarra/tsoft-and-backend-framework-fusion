# language: es
Característica: Probar APIs
	@API
  	Esquema del escenario: Prueba API
		Dado que se proporciona un archivo "<Excel>" con el "<Dato>" para la prueba
		Cuando configuramos la url desde el : "<Dato>"
		Y se configura el metodo de la solicitud: "<Dato>"
		Y agregamos los headers desde el "<Dato>"
		Y adjuntamos el body a la solicitud desde el "<Dato>"
		Y configuramos los parameters o query strings desde el "<Dato>"
		Entonces enviamos la solicitud al servidor
		Y verificamos el status code:"<Dato>"
		Y validamos el Content-Type de la respuesta: "<Dato>"
		Cuando la respuesta es de tipo applicationjson se valida mediante un squema json:"<Dato>"
		Y capturamos un dato mediante una regex:"<Dato>"
		Y capturamos un dato mediante un jsonpath:"<Dato>"

		Ejemplos:
	  		|     Excel          |    Dato       |
	  		| ProyectoAPI.xlsm   | 1             |
	  		| ProyectoAPI.xlsm   | 2             |
	  		| ProyectoAPI.xlsm   | 11            |
	  		| ProyectoAPI.xlsm   | 12            |
