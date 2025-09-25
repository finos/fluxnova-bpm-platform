package org.finos.fluxnova.spin.groovy.xml.dom

if (input != null) {
    element = S(input)
}

if (child2 == null) {
    element.remove(child)
}
else {
    element.remove(child, child2)
}
