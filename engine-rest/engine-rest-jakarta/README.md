REST API Jakarta
================

A Jakarta JAX-RS-based REST API for Fluxnova Platform.

> This module copies and transforms the `fluxnova-engine-rest-core` module.  
> It contains only implementations for classes where there are breaking changes either in the updated dependencies or due to JakartaEE.

Running Tests
-------------

The REST API is tested against one JAX-RS runtime:

* Resteasy

In order to run the tests against Resteasy, execute `mvn clean install -Presteasy`.

Writing Tests
-------------

See the `fluxnova-engine-rest-core` module's README about writing tests and add your test in that module.

