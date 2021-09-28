# language: es
Característica: Probar APIs
	@All
  	Esquema del escenario: Prueba API
		Dado que se tiene un archivo "<Excel>" con los datos para la prueba
		Y se agregan los headers especificados: "<Dato>"
		Y se añade el cuerpo de la solicitud desde el: "<Dato>"
		Y se configura los parametros de busqueda: "<Dato>"
		Cuando se configura la url: "<Dato>"
		Y se configura el tipo de solicitud: "<Dato>"
		Y se envia la solicitud al servidor
		Entonces se verifica el código de respuesta del servidor según el:"<Dato>"
		Y se valida el tipo de respuesta esperado según el: "<Dato>"
		Y se valida la respuesta con un esquema json según el:"<Dato>"
		Y se captura un dato mediante una regex: "<Dato>"
		Y se compara el resultado del regex: "<Dato>"
		Y guardamos el "<Dato>" obtenido mediante regexp
		Y se captura un dato mediante una query de jsonpath: "<Dato>"
		Y se compara el resultado del jsonpath: "<Dato>"
		Y guardamos el "<Dato>" obtenido mediante jsonpath

		Ejemplos:
	  		|     Excel          |    Dato       |
	  		#|DEFAULT         	 |1              |
	  		#|ProyectoAPI         |2              |
	  		#|ProyectoAPI         |3              |
	  		#|ProyectoAPI         |4              |
	  		#|ProyectoAPI         |5              |
	  		#|ProyectoAPI         |6              |
	  		#|ProyectoAPI         |7              |
	  		#|ProyectoAPI         |8              |
	  		#|ProyectoAPI         |9              |
	  		|ProyectoAPI         |10             |
	  		#|ProyectoAPI       	 |11             |
	  		#|DEFAULT	         |12             |

	@apitest
	Esquema del escenario: Prueba API
		Dado que se tiene un archivo "<Excel>" con los datos para la prueba
		Y se agregan los headers especificados: "<Dato>"
		Y se añade el cuerpo de la solicitud desde el: "<Dato>"
		Y se configura los parametros de busqueda: "<Dato>"
		Cuando se configura la url: "<Dato>"
		Y se configura el tipo de solicitud: "<Dato>"
		Y se envia la solicitud al servidor
		Entonces se verifica el código de respuesta del servidor según el:"<Dato>"
		Y se valida el tipo de respuesta esperado según el: "<Dato>"
		Y se valida la respuesta con un esquema json según el:"<Dato>"
		Y se captura un dato mediante una regex: "<Dato>"
		Y se compara el resultado del regex: "<Dato>"
		Y guardamos el "<Dato>" obtenido mediante regexp
		Y se captura un dato mediante una query de jsonpath: "<Dato>"
		Y se compara el resultado del jsonpath: "<Dato>"
		Y guardamos el "<Dato>" obtenido mediante jsonpath

		Ejemplos:
			|     Excel          |    Dato       |
			|ProyectoAPI         |1              |
			|ProyectoAPI         |2            	 |
