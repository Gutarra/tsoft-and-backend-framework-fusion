# language: es
Característica: Transacciones en la página opencart.abstracta.us

    @buy-product
    Esquema del escenario: Comprar productos online
        Dado que el usuario ingresa a la página
        Cuando inicia sesion en la página según el <caso>
        Y ingresa al listado de productos
        Y selecciona un producto
        Entonces se agrega al carrito de compras
        Y registra los datos para el envio <caso>
        Entonces se confirma la creacción de la orden

        Ejemplos:
            | caso |
            | 2    |