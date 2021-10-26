# language: es
Característica: Probar APIs
	@API
  	Esquema del escenario: Prueba API
		Dado que se proporciona un archivo "<Excel>" con el "<Dato>" para la prueba
		Cuando configuramos la url
		Y se configura el metodo de la solicitud
		Y agregamos los headers
		Y adjuntamos el body a la solicitud
		Y configuramos los parameters o query strings
		Entonces enviamos la solicitud al servidor
		Y verificamos el status code
		Y validamos el Content-Type de la respuesta
		Cuando la respuesta es de tipo applicationjson se valida mediante el squema json
		Y capturamos datos mediante una regex
		Y capturamos datos mediante un jsonpath

		Ejemplos:
	  		|     Excel          |    Dato       |
	  		| ProyectoAPI.xlsm   | 2             |
	  		| ProyectoAPI.xlsm   | 3             |
	  		# | ProyectoAPI.xlsm   | 1             |
	  		# | ProyectoAPI.xlsm   | 3             |
	  		# | ProyectoAPI.xlsm   | 12            |
	  		# | ProyectoAPI.xlsm   | 13            |
