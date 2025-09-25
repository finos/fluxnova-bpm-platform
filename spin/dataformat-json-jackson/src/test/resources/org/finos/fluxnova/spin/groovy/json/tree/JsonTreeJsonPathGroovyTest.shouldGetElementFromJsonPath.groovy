package org.finos.fluxnova.spin.groovy.json.tree

jsonNode = S(input, "application/json");

node = jsonNode.jsonPath('$.orderDetails').element();