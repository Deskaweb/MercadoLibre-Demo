Feature: Primer ejercicio
  Ingresar a la pagina de MercadoLibre y verificar las categorias con distintas condiciones

  @PrimerEjercicio @Resultados
  Scenario Outline: Verificar la categoria "<Categoria>" y a su subcategoria "<SubCategoria>"
    Given Ingresar a la Web de MercadoLibre
    When Ingresar a la "<Categoria>" y a su "<SubCategoria>"
    Then Se valida la "<SubCategoria>" y la cantidad de resultados

    Examples:
      | Categoria               | SubCategoria          |
      |Hogar y Electrodomésticos|Climatización          |
      |Juguetes y Bebés         |Cuarto del Bebé        |
      |Deportes y Aire Libre    |Paletas                |

  @PrimerEjercicio @Tecnologia
  Scenario Outline: Verificar cantidad de elementos de la categoria y subcategoria cambiando la grilla
    Given Ingresar a la Web de MercadoLibre
    When Ingresar a la "<Categoria>" y a su "<SubCategoria>"
    And Se cambia la vista de la grilla
    Then Se verifica la cantidad de elementos existen
    Then Se valida la "<SubCategoria>" y la cantidad de resultados

    Examples:
      | Categoria| SubCategoria          |
      |Tecnología|Celulares y Smartphones|

  @PrimerEjercicio @LlegaHoy
  Scenario Outline: Verificar 'Lleguen hoy' de los primeros 5 resultados de la categoria y subcategoria
    Given Ingresar a la Web de MercadoLibre
    When Ingresar a la "<Categoria>" y a su "<SubCategoria>"
    And Se marca la opcion 'LLegan hoy'
    Then Se verifica que los primeros 5 resultado lleguen hoy
    Then Se valida la "<SubCategoria>" y la cantidad de resultados

    Examples:
      | Categoria| SubCategoria          |
      |Tecnología|Celulares y Smartphones|

  @PrimerEjercicio @MayorPrecio
  Scenario Outline: Verificar precio del primer y ultimo resultado ordenando por Mayor Precio
    Given Ingresar a la Web de MercadoLibre
    When Ingresar a la "<Categoria>" y a su "<SubCategoria>"
    And Ordenar por 'Mayor Precio'
    Then Se verifica el precio del primer resultado y del ultimo
    Then Se valida la "<SubCategoria>" y la cantidad de resultados

    Examples:
      | Categoria               | SubCategoria          |
      |Herramientas e Industria |Industria Textil       |


