Feature: Como usuario de petstore
  deseo poder consumir las APIS de mascotas
  para crear, consultar y actualizar los datos de las mascotas

  @petstore
  Scenario Outline: Realizar el consumo de las APIS de la tienda petstore
    #Given realizo la creacion de la mascota "<idMascota>" "<idCategoria>" "<nombre>" "<status>"
    #When consulto la mascota creada "<idMascota>"
    #And actualizo el nombre y el estatus de la mascota "<idMascota>" "<nombreActualizado>" "<statusActualizado>"
    Then Valido la mascota modificada por status "<statusActualizado>"
    Examples:
    | idMascota   | idCategoria | nombre   | status    | nombreActualizado | statusActualizado |
    | 64566454    | -20476978   | Manchas  | available | Motas             | sold              |