# Support

This page states what support the Fluxnova project provides, which releases are supported, and the project's policies for dependency updates and vulnerability remediation. These policies apply to all finos/fluxnova-* repositories.

## Getting help

Support is provided by the community on a best-effort basis. There is no service-level agreement.

- **Questions and usage help:** Open a [Discussion](https://github.com/finos/fluxnova-bpm-platform/discussions) on GitHub, or join the monthly Fluxnova public meeting (registration link in the [README](README.md#get-involved)).
- **Bugs:** Open an issue in the relevant repository.
- **Feature requests:** Open an issue or discuss in the [FINOS project board](https://github.com/orgs/finos/projects/116).
- **Security vulnerabilities:** Do not open a public issue. Follow [SECURITY.md](SECURITY.md).
- **Documentation:** https://docs.fluxnova.finos.org
- **Maintainers:** See [MAINTAINERS.md](MAINTAINERS.md) for the current roster.

## Supported releases

**Only the latest published release of each component is supported.** Bug fixes and security fixes are delivered by publishing a new release, not by patching older versions.

### Maven Central artifacts

| Component | Group ID | Supported |
|---|---|---|
| BPM Platform | `org.finos.fluxnova.bpm` | Latest release |
| FEEL Engine | `org.finos.fluxnova.feel` | Latest release |
| Engine Plugins | `org.finos.fluxnova.bpm.plugins` | Latest release |
| Testing Framework | `org.finos.fluxnova.bpm.test` | Latest release |

Earlier versions stay available on Maven Central but receive no further updates.

### Docker images

| Component | Registry | Supported |
|---|---|---|
| Fluxnova Run | Docker Hub `finos/fluxnova-bpm-platform` | Latest tag and the tag for the latest release version |
| Fluxnova Run (pre-release) | GHCR `ghcr.io/finos/fluxnova-bpm-platform` | Latest build from main (no support commitment) |

### Desktop applications

| Component | Distribution | Supported |
|---|---|---|
| Fluxnova Modeler | GitHub Releases | Latest release |

### Documentation and websites

| Component | URL | Supported |
|---|---|---|
| Documentation | https://docs.fluxnova.finos.org | The deployed version |
| Project website | https://fluxnova.finos.org | The deployed version |

## When a release stops receiving security updates

A release stops receiving security updates **at the moment a newer release of the same component is published**. Security fixes are always released as a new version. If you are on an older version, upgrade to the latest release to receive the fix.

Pre-releases (for example `-SNAPSHOT`, `-RC`, or `-beta` versions) are not supported and receive no security updates.

## Versioning

The project follows [Semantic Versioning](https://semver.org/):

- **Major** releases (`X.0.0`) may contain breaking changes. Breaking changes are documented in the release notes.
- **Minor** releases (`x.Y.0`) add functionality in a backward-compatible manner.
- **Patch** releases (`x.y.Z`) contain backward-compatible bug fixes.

See [RELEASE.md](RELEASE.md) for release procedures for the BPM Platform. Other repositories follow similar procedures documented in their respective READMEs.

## Dependency update policy

The project maintains its dependencies according to the following policy. See `.github/workflows/` in each repository for workflow implementations.

| Dependency type | Update frequency | Tooling |
|---|---|---|
| Security updates (all ecosystems) | As soon as practical after disclosure | Dependabot security updates (grouped), Dependency Review on PRs |
| GitHub Actions | On Dependabot PRs | Dependabot |
| Maven dependencies (non-security) | Periodically, at maintainer discretion | Dependabot PRs, manual review |
| npm dependencies (non-security) | Periodically, at maintainer discretion | Dependabot PRs, manual review |

### Security update SLA

| Severity | Target remediation time |
|---|---|
| Critical (CVSS 9.0+) | 7 days |
| High (CVSS 7.0–8.9) | 30 days |
| Medium (CVSS 4.0–6.9) | 90 days |
| Low (CVSS < 4.0) | Next regular release |

**Note:** These targets are goals, not guarantees. Actual remediation time depends on fix availability, testing requirements, and maintainer capacity.

### Dependency scanning

The following tools scan dependencies automatically across all fluxnova-* repositories:

- **Dependabot alerts and security updates**: Enabled via FINOS org security configuration.
- **Dependency Review**: Per-repo workflows block PRs that introduce dependencies with known high-severity vulnerabilities.
- **License Scanning**: Per-repo workflows validate dependencies against the FINOS Category A approved license list.

## Vulnerability remediation policy

This section describes how the project handles reported security vulnerabilities. See [SECURITY.md](SECURITY.md) for reporting instructions.

### Triage and response

1. **Acknowledgment:** Maintainers acknowledge receipt within 3 business days.
2. **Triage:** Maintainers assess severity (CVSS), exploitability, and affected components.
3. **CRA escalation:** For actively exploited vulnerabilities or severe incidents, maintainers escalate to the Linux Foundation CRA steward per [SECURITY.md](SECURITY.md).
4. **Fix development:** A fix is developed privately if the vulnerability is not yet public.
5. **Release:** A new version is released containing the fix.
6. **Disclosure:** The vulnerability is disclosed per the [FINOS Responsible Disclosure Policy](https://community.finos.org/docs/governance/Software-Projects/cve-responsible-disclosure).

### Coordinated disclosure timeline

| Milestone | Target |
|---|---|
| Acknowledge report | 3 business days |
| Severity assessment | 5 business days |
| Fix available | Per severity SLA above |
| Public disclosure | After fix is released, coordinated with reporter |

### What we fix

- Vulnerabilities in Fluxnova code across all repositories.
- Vulnerabilities in direct dependencies, by updating to a patched version.
- Vulnerabilities in transitive dependencies, by updating direct dependencies or applying overrides.

### What we do not fix

- Vulnerabilities in code that adopters write (process definitions, scripts, custom plugins).
- Vulnerabilities in infrastructure that adopters operate (databases, identity providers, container runtimes).
- Vulnerabilities in dependencies where no fix is available (these are documented and tracked).

## Contact

- **Security issues:** See [SECURITY.md](SECURITY.md)
- **Maintainers:** See [MAINTAINERS.md](MAINTAINERS.md)
- **General questions:** [GitHub Discussions](https://github.com/finos/fluxnova-bpm-platform/discussions)
- **Mailing list:** fluxnova@lists.finos.org (email [help@finos.org](mailto:help@finos.org) to subscribe)
- **FINOS help:** help@finos.org
