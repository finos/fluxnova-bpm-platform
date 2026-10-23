# Threat Model and Attack Surface Analysis

This is the project's security self-assessment: a threat model and attack surface analysis for all software released from the Fluxnova project (finos/fluxnova-* repositories). It satisfies OSPS Baseline controls OSPS-SA-03.01 and OSPS-SA-03.02 and is declared in [`security-insights.yml`](security-insights.yml). It is reviewed when a component gains a new external interface, a new trust boundary, or a new distribution channel, and at least once a year.

Last reviewed: 2026-10-16.

## What is Fluxnova?

Fluxnova is an open-source BPMN 2.0 and DMN process automation platform, forked from Camunda 7 and maintained under FINOS governance. See the [README](README.md) and [project website](https://fluxnova.finos.org/) for details.

## Scope

This threat model covers all finos/fluxnova-* repositories. Components are grouped by trust boundary.

### Embeddable libraries (adopter's JVM)

| Component | Repository | Description |
|---|---|---|
| Process Engine | fluxnova-bpm-platform | Core BPMN 2.0 engine; executes process definitions, scripts, and expressions |
| DMN Engine | fluxnova-bpm-platform | Evaluates DMN decisions |
| FEEL Engine | fluxnova-feel-scala | FEEL expression parser and interpreter |
| Engine Plugins | fluxnova-plugins | Backward-compatibility, agentic/MCP integration plugins |
| Testing Framework | fluxnova-testing-framework | Framework for testing BPMN models |
| Spring Boot Starter | fluxnova-bpm-platform | Auto-configuration for Spring Boot applications |
| Quarkus Extension | fluxnova-bpm-platform | Integration for Quarkus applications |

### Server-side applications (adopter's deployment)

| Component | Repository | Description |
|---|---|---|
| REST API | fluxnova-bpm-platform | HTTP API for engine operations; authentication left to deployer |
| Web Applications | fluxnova-bpm-platform | Monitoring, Admin, and Tasklist UIs; authentication left to deployer |
| Control Center | fluxnova-control-center | Angular/NestJS web app for engine monitoring |
| Tomcat Distribution | fluxnova-bpm-platform | Pre-packaged Tomcat deployment |
| Run Distribution | fluxnova-bpm-platform | Standalone Spring Boot application |
| Docker Image | fluxnova-bpm-platform | Containerized Run distribution |

### Desktop application (user's workstation)

| Component | Repository | Description |
|---|---|---|
| Fluxnova Modeler | fluxnova-modeler | Electron desktop app for modeling BPMN/DMN/Forms |
| Modeler Plugins | fluxnova-modeler-plugins | Installable plugins for the Modeler |

### Documentation and websites (static hosting)

| Component | Repository | Description |
|---|---|---|
| Documentation site | fluxnova-docs-manual | docs.fluxnova.finos.org (Hugo) |
| Project website | fluxnova-website | fluxnova.finos.org |
| Docs theme | fluxnova-docs-theme | Shared Hugo theme |

### Build and release pipelines (GitHub Actions)

All repositories use GitHub Actions for CI/CD. Release artifacts are produced by automated workflows.

## Assets to protect

1. **Integrity of released artifacts**: Maven Central JARs, Docker images, npm packages, desktop application binaries, and distribution archives.
2. **Repository and publishing credentials**: Maven Central (with GPG signing key), Docker Hub, npm (if applicable), the GitHub Actions tokens, and maintainer accounts.
3. **Adopters' process data**: Process instances, variables, and task data handled at runtime (protection is the adopter's responsibility).
4. **The CI/CD pipeline**: Prevents unauthorized code from entering releases.

## Attack surface and threats

### Supply chain and build pipeline (all repos)

| Entry point | Threat | Mitigation | Residual risk |
|---|---|---|---|
| Pull requests from forks | Malicious workflow changes or code execution with repository secrets | Workflows use explicit least-privilege `permissions:` blocks. Repository secrets are not exposed to workflows triggered from forks. | Low |
| Third-party GitHub Actions | A compromised action exfiltrates tokens or injects malicious code | TODO: Pin all actions to commit SHAs. Dependabot raises update PRs for actions. | Medium until SHA pinning is complete |
| Dependencies (Maven, npm, Cargo) | Known vulnerabilities or malicious packages enter the tree | Dependency Review blocks PRs introducing high-severity vulnerabilities. Dependabot raises update PRs. License scanning validates against FINOS Category A list. | Low |
| Publishing credentials | An attacker with stolen credentials publishes a rogue version | Maven Central artifacts are GPG-signed. Secret scanning with push protection is enabled. CycloneDX SBOMs and build provenance attestations are generated on release. | Low |
| Repository access | Direct pushes or unreviewed merges to `main` | Branch rulesets require PR review and passing status checks before merge. | Low |

### CI/CD and GitHub Actions token abuse (all repos)

| Entry point | Threat | Mitigation | Residual risk |
|---|---|---|---|
| Workflow `GITHUB_TOKEN` permissions | Overly permissive tokens allow lateral movement or artifact tampering | All workflows declare explicit least-privilege `permissions:` blocks. | Low |
| Workflow secrets | Secrets leaked via logs or exfiltrated by malicious steps | Secrets are marked as secrets in GitHub. Secret scanning is enabled. Manual review of workflow changes. | Low |
| Release workflows | Unauthorized release or release of untested code | Release workflows run only on designated branches via manual `workflow_dispatch`. License scanning is a required job. | Low |

### Compromised maintainer account

| Entry point | Threat | Mitigation | Residual risk |
|---|---|---|---|
| GitHub account compromise | Attacker pushes malicious code or merges without review | FINOS requires 2FA for all org members. Multiple maintainers from different organizations provide oversight. Branch rulesets require review. | Low |
| GPG signing key compromise | Attacker signs malicious releases | Key is stored as a GitHub secret, accessible only to release workflows. | Medium |
| Maven Central / Docker Hub / npm credentials | Attacker publishes rogue artifacts | Credentials are GitHub secrets. Provenance attestations allow verification of build origin. | Low |

### BPM Platform runtime threats (for embedders and deployers)

| Entry point | Threat | Mitigation | Residual risk |
|---|---|---|---|
| Script execution in BPMN/DMN | Process definitions execute Groovy, JavaScript, or JUEL scripts with engine permissions | By design: the engine trusts deployed process definitions. Deployers must treat them as code. No sandbox. | High if untrusted definitions are deployed |
| FEEL expressions in DMN | Expression injection or resource exhaustion | FEEL evaluator parses and evaluates expressions. No sandbox. Deployers must review DMN models. | Medium |
| REST API authentication | Unauthenticated access to engine operations | Authentication is left to the deployer. Documentation states this clearly. | High if deployed without authentication |
| REST API authorization | Unauthorized access to processes or tasks | Authorization is configurable but not enforced by default. Deployers must configure. | High if deployed without authorization |
| XXE in BPMN/DMN/CMMN parsing | XML External Entity attack via crafted process definition | XML parsers disable external entities and DTD processing by default. | Low |
| Deserialization of process variables | Deserialization of untrusted data leads to RCE | Java serialization is used for some variable types. Deployers should configure serialization restrictions. | Medium |
| Web application XSS | Cross-site scripting through process variable values | Web applications escape output. | Low |

### Fluxnova Modeler (desktop application)

| Entry point | Threat | Mitigation | Residual risk |
|---|---|---|---|
| Opening untrusted BPMN/DMN/Form files | Malicious file exploits parser or renderer | Files are parsed as XML/JSON; no script execution on open. Electron context isolation is enabled. | Low |
| Modeler plugins | Malicious plugin runs arbitrary code | Plugins are installed manually by the user. No plugin store or signature verification. | Medium. Users must trust plugin sources. |

### Control Center (web application)

| Entry point | Threat | Mitigation | Residual risk |
|---|---|---|---|
| Authentication | Unauthorized access to monitoring data | Authentication is configurable; see repository documentation. Deployers must configure. | High if deployed without authentication |
| BFF API | Injection or SSRF through API endpoints | NestJS backend validates inputs. Standard security middleware. | Low |

### Documentation and websites (static sites)

| Entry point | Threat | Mitigation | Residual risk |
|---|---|---|---|
| Site compromise | Attacker serves malicious content | Sites are deployed from protected branches via automated workflows. | Low |
| Third-party scripts | Compromised CDN or script serves malicious code | Sites use minimal third-party scripts; dependencies are reviewed. | Low |

## Out of scope

- Security of infrastructure adopters use to run Fluxnova components.
- Security of process definitions, DMN models, or scripts written by adopters.
- Security of third-party tools that integrate with Fluxnova.

## Review

Changes to this document are proposed by pull request. Any pull request that adds an external interface, a new storage backend, a new authentication mode, or a new distribution channel must update the relevant table.
