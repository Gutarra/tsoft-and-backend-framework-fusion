Feature: FlujoMCSS

  @LoginMCSS
  Scenario Outline: Login MCSS

    Given Ingreso a la url de MCSS "<caso_prueba>"
    When Ingreso el usuario de MCSS"<caso_prueba>"
    And La contraseña de MCSS"<caso_prueba>"
    Then se da clic en el boton login de MCSS ingresando correctamente



    Examples:
      | caso_prueba |
      |           1 |

