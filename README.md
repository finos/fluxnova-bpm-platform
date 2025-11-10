[![FINOS - Forming](https://cdn.jsdelivr.net/gh/finos/contrib-toolbox@master/images/badge-forming.svg)](https://community.finos.org/docs/governance/Software-Projects/project-lifecycle)

# Fluxnova - The open source BPMN platform
[![Build CI](https://github.com/finos/fluxnova-bpm-platform/actions/workflows/build.yaml/badge.svg?branch=main&event=push)](https://github.com/finos/fluxnova-bpm-platform/actions/workflows/build.yaml?query=branch%3Amain) [![Manual latest](https://img.shields.io/badge/manual-latest-brown.svg)](https://docs.fluxnova.finos.org/) [![License](https://img.shields.io/github/license/finos/fluxnova-bpm-platform?color=blue&logo=apache)](https://github.com/finos/fluxnova-bpm-platform/blob/master/LICENSE)

Fluxnova is a flexible framework for workflow and process automation. Its core is a native BPMN 2.0 process engine that runs inside the Java Virtual Machine. It can be embedded inside any Java application and any Runtime Container. It integrates with Java EE 6 and is a perfect match for the Spring Framework. On top of the process engine, you can choose from a stack of tools for human workflow management, operations and monitoring.

- Web Site: https://fluxnova.finos.org/
- Getting Started: https://docs.fluxnova.finos.org/get-started/
- User Forum: https://github.com/finos/fluxnova-bpm-platform/discussions
- Issue Tracker: https://github.com/finos/fluxnova-bpm-platform/issues
- Contribution Guidelines: https://github.com/finos/fluxnova-bpm-platform/blob/main/CONTRIBUTING.md

## Components

Fluxnova Platform provides a rich set of components centered around the BPM lifecycle.

#### Process Implementation and Execution

- Fluxnova Engine - The core component responsible for executing BPMN 2.0 processes.
- REST API - The REST API provides remote access to running processes.
- Spring, CDI Integration - Programming model integration that allows developers to write Java Applications that interact with running processes.

#### Process Design

- Fluxnova Modeler - A [standalone desktop application](https://github.com/finos/fluxnova-modeler) that allows business users and developers to design & configure processes.

#### Process Operations

- Fluxnova Engine - JMX and advanced Runtime Container Integration for process engine monitoring.
- Fluxnova Monitoring - Web application tool for process operations.
- Fluxnova Admin - Web application for managing users, groups, and their access permissions.

#### Human Task Management

- Fluxnova Tasklist - Web application for managing and completing user tasks in the context of processes.

#### And there's more

- [bpmn.io](https://bpmn.io/) - Toolkits for BPMN, CMMN, and DMN in JavaScript (rendering, modeling)

## A Framework

In contrast to other vendor BPM platforms, Fluxnova strives to be highly integrable and embeddable. We seek to deliver a great experience to developers that want to use BPM technology in their projects.

### Highly Integrable

Out of the box, Fluxnova provides infrastructure-level integration with Java EE Application Servers and Servlet Containers.

### Embeddable

Most of the components that make up the platform can even be completely embedded inside an application. For instance, you can add the process engine and the REST API as a library to your application and assemble your custom BPM platform configuration.

## Contributing

Please see our [contribution guidelines](CONTRIBUTING.md) for how to raise issues and how to contribute code to our project.

## Tests

To run the tests in this repository, please see our [testing tips and tricks](TESTING.md).

## Get Involved

Join the Fluxnova public mailing list by sending an email to [fluxnova+subscribe@lists.finos.org](mailto:fluxnova+subscribe@lists.finos.org).

Register for the monthly Fluxnova public meeting [here](https://zoom-lfx.platform.linuxfoundation.org/meeting/98975602417?password=8a1c796a-2eba-4f71-beeb-e3ecb7eb3450&invite=true). The meeting takes place every 3rd Tuesday of the month at 10am EST.

## License

Copyright 2025 FINOS

The source files in this repository are made available under the [Apache License Version 2.0](./LICENSE).

SPDX-License-Identifier: [Apache-2.0](https://spdx.org/licenses/Apache-2.0)

Fluxnova uses and includes third-party dependencies published under various licenses. By downloading and using Fluxnova artifacts, you agree to their terms and conditions.
