$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Ejercicio2.feature");
formatter.feature({
  "line": 1,
  "name": "Segundo ejercicio",
  "description": "Ingresar a la pagina de MercadoLibre y verificar datos de la publicacion",
  "id": "segundo-ejercicio",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 5,
  "name": "Verificar datos de la publicacion",
  "description": "",
  "id": "segundo-ejercicio;verificar-datos-de-la-publicacion",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 4,
      "name": "@SegundoEjercicio"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "Ingresar a la Web de MercadoLibre",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "Ingresar a la \"\u003cCategoria\u003e\" y a su \"\u003cSubCategoria\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "Se filtra por la ubicacion \"\u003cUbicacion\u003e\"",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "Se ingresa a una publicacion y se verifican los datos",
  "keyword": "Then "
});
formatter.examples({
  "line": 11,
  "name": "",
  "description": "",
  "id": "segundo-ejercicio;verificar-datos-de-la-publicacion;",
  "rows": [
    {
      "cells": [
        "Categoria",
        "SubCategoria",
        "Ubicacion"
      ],
      "line": 12,
      "id": "segundo-ejercicio;verificar-datos-de-la-publicacion;;1"
    },
    {
      "cells": [
        "Hogar y Electrodomésticos",
        "Climatización",
        "Capital Federal"
      ],
      "line": 13,
      "id": "segundo-ejercicio;verificar-datos-de-la-publicacion;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 13,
  "name": "Verificar datos de la publicacion",
  "description": "",
  "id": "segundo-ejercicio;verificar-datos-de-la-publicacion;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 4,
      "name": "@SegundoEjercicio"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "Ingresar a la Web de MercadoLibre",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "Ingresar a la \"Hogar y Electrodomésticos\" y a su \"Climatización\"",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "Se filtra por la ubicacion \"Capital Federal\"",
  "matchedColumns": [
    2
  ],
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "Se ingresa a una publicacion y se verifican los datos",
  "keyword": "Then "
});
formatter.match({
  "location": "DefinicionesQuadminds.IngresarWeb()"
});
formatter.result({
  "duration": 15008243168,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Hogar y Electrodomésticos",
      "offset": 15
    },
    {
      "val": "Climatización",
      "offset": 50
    }
  ],
  "location": "DefinicionesQuadminds.SeIngresaAlaSubcategoria(String,String)"
});
formatter.result({
  "duration": 7746735953,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Capital Federal",
      "offset": 28
    }
  ],
  "location": "DefinicionesQuadminds.SeFiltraPorUbicacion(String)"
});
formatter.result({
  "duration": 5266452034,
  "status": "passed"
});
formatter.match({
  "location": "DefinicionesQuadminds.SeVerificaLosDatosDeLaPublicacion()"
});
formatter.result({
  "duration": 19995944858,
  "status": "passed"
});
});