Feature: FlujoWEB_DELIVERY

  @Test1
  Scenario Outline: Login WEB DELIVERY

    Given Ingreso a la url de WEB DELIVERY "<caso_prueba>"
    When Ingreso el usuario de WEB DELIVERY"<caso_prueba>"
    And La contraseña de WEB DELIVERY"<caso_prueba>"
    Then se da clic en el boton login de WEB DELIVERY ingresando correctamente

    Examples:
      | caso_prueba |
      |           1 |


  @Test2
  Scenario Outline: Ajuste de inventario WEB DELIVERY

    Given Ingreso a la url de WEB DELIVERY "<caso_prueba>"
    When Ingreso el usuario de WEB DELIVERY"<caso_prueba>"
    And La contraseña de WEB DELIVERY"<caso_prueba>"
    Then se da clic en el boton login de WEB DELIVERY ingresando correctamente
    Given Se da click en el boton IR A en WEB DELIVERY "<caso_prueba>"
    When seleccionar ajuste de inventario
    And click en el boton nuevo registro
    And seleccionamos el tipo ABASTECIMIENTO "<caso_prueba>"
    And ingresamos un comentario "<caso_prueba>"
    And ingresamos guia de remision "<caso_prueba>"
    And ingresamos el archivo "<caso_prueba>"
    And click en ejecutar ajuste y aceptar mensaje
    And validar que los archivos hayan cargado

    Examples:
      | caso_prueba |
      |           1 |



  @Test3
  Scenario Outline: BUSCAR ORDEN WEB DELIVERY

    Given Ingreso a la url de WEB DELIVERY "<caso_prueba>"
    When Ingreso el usuario de WEB DELIVERY"<caso_prueba>"
    And La contraseña de WEB DELIVERY"<caso_prueba>"
    Then se da clic en el boton login de WEB DELIVERY ingresando correctamente
    Given Se da click en el boton IR A en WEB DELIVERY "<caso_prueba>"
    When Seleccionar auditoria de pedidos en WEB DELIVERY "<caso_prueba>"
    And Ingresar y buscar el numero de orden en WEB DELIVERY "<caso_prueba>"
    Then Se encontrara la orden "<caso_prueba>"

    Examples:
      | caso_prueba |
      |           1 |

  @Test4
  Scenario Outline: SELECCIONAR AGENDAMIENTO WEB DELIVERY

    Given Ingreso a la url de WEB DELIVERY "<caso_prueba>"
    When Ingreso el usuario de WEB DELIVERY"<caso_prueba>"
    And La contraseña de WEB DELIVERY"<caso_prueba>"
    Then se da clic en el boton login de WEB DELIVERY ingresando correctamente
    Given Se da click en el boton IR A en WEB DELIVERY "<caso_prueba>"
    When Seleccionar auditoria de pedidos en WEB DELIVERY "<caso_prueba>"
    And Ingresar y buscar el numero de orden en WEB DELIVERY "<caso_prueba>"
    Then Se encontrara la orden "<caso_prueba>"
    Given Se da click en el boton agendar pedido "<caso_prueba>"
    When Seleccionar fecha del pedido "<caso_prueba>"
    And se da click en el boton aceptar "<caso_prueba>"
    Then se verifica que el estado del pedido sea agendado "<caso_prueba>"


    Examples:
      | caso_prueba |
      |           1 |

  @Test5
  Scenario Outline: ASIGNACION DE SERIES WEB DELIVERY

    Given Ingreso a la url de WEB DELIVERY "<caso_prueba>"
    When Ingreso el usuario de WEB DELIVERY"<caso_prueba>"
    And La contraseña de WEB DELIVERY"<caso_prueba>"
    Then se da clic en el boton login de WEB DELIVERY ingresando correctamente
    Given Se da click en el boton IR A en WEB DELIVERY "<caso_prueba>"
    When Seleccionar auditoria de pedidos en WEB DELIVERY "<caso_prueba>"
    And Ingresar y buscar el numero de orden en WEB DELIVERY "<caso_prueba>"
    Then Se encontrara la orden "<caso_prueba>"
    Given Se da click en el boton agendar pedido "<caso_prueba>"
    When Seleccionar fecha del pedido "<caso_prueba>"
    And se da click en el boton aceptar "<caso_prueba>"
    Then se verifica que el estado del pedido sea agendado "<caso_prueba>"
    Given Se da click en el boton IR A en WEB DELIVERY "<caso_prueba>"
    When Seleccionar asignacion de series en WEB DELIVERY
    And ingresar y buscar el numero de orden "<caso_prueba>"
    Then Se encontrara con exito la orden




    Examples:
      | caso_prueba |
      |           1 |

  @Test6
  Scenario Outline: INGRESO DE MATERIALES WEB DELIVERY

    Given Ingreso a la url de WEB DELIVERY "<caso_prueba>"
    When Ingreso el usuario de WEB DELIVERY"<caso_prueba>"
    And La contraseña de WEB DELIVERY"<caso_prueba>"
    Then se da clic en el boton login de WEB DELIVERY ingresando correctamente
    Given Se da click en el boton IR A en WEB DELIVERY "<caso_prueba>"
    When Seleccionar auditoria de pedidos en WEB DELIVERY "<caso_prueba>"
    And Ingresar y buscar el numero de orden en WEB DELIVERY "<caso_prueba>"
    Then Se encontrara la orden "<caso_prueba>"
    Given Se da click en el boton agendar pedido "<caso_prueba>"
    When Seleccionar fecha del pedido "<caso_prueba>"
    And se da click en el boton aceptar "<caso_prueba>"
    Then se verifica que el estado del pedido sea agendado "<caso_prueba>"
    Given Se da click en el boton IR A en WEB DELIVERY "<caso_prueba>"
    When Seleccionar asignacion de series en WEB DELIVERY
    And ingresar y buscar el numero de orden "<caso_prueba>"
    Then Se encontrara con exito la orden
    Given Ingresar el numero de IMEI "<caso_prueba>"
    When Ingresar el numero de SIMCARD "<caso_prueba>"
    And click en el boton validar serie
    And Click en aceptar mensaje de validacion
    And Click en aceptar mensaje de refrescar sistema
    And ingresar y buscar el numero de orden "<caso_prueba>"
    Then Se encontrara con exito la orden
    And verificar que la orden quede en estado VALIDADO "<caso_prueba>"

    Examples:
      | caso_prueba |
      |           1 |


  @Test7
  Scenario Outline: IMPRESION DE DOCUMENTOS -  WEB DELIVERY

    Given Ingreso a la url de WEB DELIVERY "<caso_prueba>"
    When Ingreso el usuario de WEB DELIVERY"<caso_prueba>"
    And La contraseña de WEB DELIVERY"<caso_prueba>"
    Then se da clic en el boton login de WEB DELIVERY ingresando correctamente
    Given Se da click en el boton IR A en WEB DELIVERY "<caso_prueba>"
    When seleccionar ajuste de inventario
    And click en el boton nuevo registro
    And seleccionamos el tipo ABASTECIMIENTO "<caso_prueba>"
    And ingresamos un comentario "<caso_prueba>"
    And ingresamos guia de remision "<caso_prueba>"
    And ingresamos el archivo "<caso_prueba>"
    And click en ejecutar ajuste y aceptar mensaje
    And validar que los archivos hayan cargado
    Given Se da click en el boton IR A en WEB DELIVERY "<caso_prueba>"
    When Seleccionar auditoria de pedidos en WEB DELIVERY "<caso_prueba>"
    And Ingresar y buscar el numero de orden en WEB DELIVERY "<caso_prueba>"
    Then Se encontrara la orden "<caso_prueba>"
    Given Se da click en el boton agendar pedido "<caso_prueba>"
    When Seleccionar fecha del pedido "<caso_prueba>"
    And se da click en el boton aceptar "<caso_prueba>"
    Then se verifica que el estado del pedido sea agendado "<caso_prueba>"
    Given Se da click en el boton IR A en WEB DELIVERY "<caso_prueba>"
    When Seleccionar asignacion de series en WEB DELIVERY
    And ingresar y buscar el numero de orden "<caso_prueba>"
    Then Se encontrara con exito la orden
    Given Ingresar el numero de IMEI "<caso_prueba>"
    When Ingresar el numero de SIMCARD "<caso_prueba>"
    And click en el boton validar serie
    And Click en aceptar mensaje de validacion
    And Click en aceptar mensaje de refrescar sistema
    And ingresar y buscar el numero de orden "<caso_prueba>"
    Then Se encontrara con exito la orden
    And verificar que la orden quede en estado VALIDADO "<caso_prueba>"
    Given Se da click en el boton IR A en WEB DELIVERY "<caso_prueba>"
    When Seleccionar impresion de documentos en WEB DELIVERY
    And ingresar y buscar el numero de orden. "<caso_prueba>"
    When click en ejecutar informes
    And Imprimir guia de remision
    And Reporte de preparacion por almacen
    And Reporte de preparacion por envio
    And Imprimir etiqueta
    Then cerramos la ejecucion de informes
    And ingresar y buscar el numero de orden. "<caso_prueba>"
    Then verificar estado de los informes REALIZADO

    Examples:
      | caso_prueba |
      |           1 |

  @Test8
  Scenario Outline: IMPRESION DE DOCUMENTOS - Imprimir guia de remision

    Given Ingreso a la url de WEB DELIVERY "<caso_prueba>"
    When Ingreso el usuario de WEB DELIVERY"<caso_prueba>"
    And La contraseña de WEB DELIVERY"<caso_prueba>"
    Then se da clic en el boton login de WEB DELIVERY ingresando correctamente
    Given Se da click en el boton IR A en WEB DELIVERY "<caso_prueba>"
    When Seleccionar impresion de documentos en WEB DELIVERY
    And ingresar y buscar el numero de orden. "<caso_prueba>"
    When click en ejecutar informes
    And Imprimir guia de remision
    And Reporte de preparacion por almacen
    Examples:
      | caso_prueba |
      |           1 |

  @Test9
  Scenario Outline: IMPRESION DE DOCUMENTOS - Imprimir guia de remision

    Given Ingreso a la url de WEB DELIVERY "<caso_prueba>"
    When Ingreso el usuario de WEB DELIVERY"<caso_prueba>"
    And La contraseña de WEB DELIVERY"<caso_prueba>"
    Then se da clic en el boton login de WEB DELIVERY ingresando correctamente
    Given Se da click en el boton IR A en WEB DELIVERY "<caso_prueba>"
    When Seleccionar impresion de documentos en WEB DELIVERY
    And ingresar y buscar el numero de orden. "<caso_prueba>"
    When click en ejecutar informes
    And Reporte de preparacion por almacen
    Examples:
      | caso_prueba |
      |           1 |


  @Test10
  Scenario Outline: IMPRESION DE DOCUMENTOS - Reporte de preparacion por envio

    Given Ingreso a la url de WEB DELIVERY "<caso_prueba>"
    When Ingreso el usuario de WEB DELIVERY"<caso_prueba>"
    And La contraseña de WEB DELIVERY"<caso_prueba>"
    Then se da clic en el boton login de WEB DELIVERY ingresando correctamente
    Given Se da click en el boton IR A en WEB DELIVERY "<caso_prueba>"
    When Seleccionar impresion de documentos en WEB DELIVERY
    And ingresar y buscar el numero de orden. "<caso_prueba>"
    When click en ejecutar informes
    And Reporte de preparacion por envio
    Examples:
      | caso_prueba |
      |           1 |
  @Test11
  Scenario Outline: IMPRESION DE DOCUMENTOS - Reporte de preparacion por pedido

    Given Ingreso a la url de WEB DELIVERY "<caso_prueba>"
    When Ingreso el usuario de WEB DELIVERY"<caso_prueba>"
    And La contraseña de WEB DELIVERY"<caso_prueba>"
    Then se da clic en el boton login de WEB DELIVERY ingresando correctamente
    Given Se da click en el boton IR A en WEB DELIVERY "<caso_prueba>"
    When Seleccionar impresion de documentos en WEB DELIVERY
    And ingresar y buscar el numero de orden. "<caso_prueba>"
    When click en ejecutar informes
    And Reporte de preparacion por pedido
    Examples:
      | caso_prueba |
      |           1 |