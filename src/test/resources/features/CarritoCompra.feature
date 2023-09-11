Feature: Como usuario del portal https://www.demoblaze.com/
  deseo seleccionar los productos alli ofrecidos
  para poder realizar su compra

  @realizarCompra
  Scenario Outline: Realizar flujo de compra con dos productos
    Given ingreso al portal demoblaze
    When agrego los productos al carrito de compra "<producto1>" "<producto2>"
    And visualizo el carrito con los productos agregados "<producto1>" "<producto2>"
    And completo el formulario de compra "<nombre>" "<pais>" "<ciudad>" "<numeroTarjeta>" "<mes>" "<anio>"
    Then verifico que la compra se haya realizado correctamente
    Examples:
    | producto1         | producto2         | nombre      | pais     | ciudad | numeroTarjeta | mes | anio |
    | Samsung galaxy s6 | Nokia lumia 1520  | Juan Perez  | Colombia | Bogota | 12365478965   | 07  | 2028 |
    | Samsung galaxy s6 | Nokia lumia 1520  | Juan Perez  | Colombia | Bogota | 12365478965   | 07  | 2028 |
    | Samsung galaxy s6 | Nokia lumia 1520  | Juan Perez  | Colombia | Bogota | 12365478965   | 07  | 2028 |
    | Samsung galaxy s6 | Nokia lumia 1520  | Juan Perez  | Colombia | Bogota | 12365478965   | 07  | 2028 |
    | Samsung galaxy s6 | Nokia lumia 1520  | Juan Perez  | Colombia | Bogota | 12365478965   | 07  | 2028 |
    | Samsung galaxy s6 | Nokia lumia 1520  | Juan Perez  | Colombia | Bogota | 12365478965   | 07  | 2028 |
    | Samsung galaxy s6 | Nokia lumia 1520  | Juan Perez  | Colombia | Bogota | 12365478965   | 07  | 2028 |
    | Samsung galaxy s6 | Nokia lumia 1520  | Juan Perez  | Colombia | Bogota | 12365478965   | 07  | 2028 |
    | Samsung galaxy s6 | Nokia lumia 1520  | Juan Perez  | Colombia | Bogota | 12365478965   | 07  | 2028 |
    | Samsung galaxy s6 | Nokia lumia 1520  | Juan Perez  | Colombia | Bogota | 12365478965   | 07  | 2028 |
