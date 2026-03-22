# desktop-tutorial

A Spring Boot web application with a fully automated CI and security scanning pipeline.

## Stack

- **Java 17** / **Spring Boot 3.2.5**
- **Maven** (build & dependency management)
- Spring Web, Spring Boot Actuator, Spring Boot Test

## CI/CD & Security Workflows

### Build
| Workflow | Trigger | Description |
|---|---|---|
| Java CI with Maven | push / PR → `main` | Builds the project with Maven and uploads the dependency graph to GitHub |

### SAST (Static Analysis)
| Workflow | Trigger | Description |
|---|---|---|
| CodeQL | push / PR → `main` | GitHub's semantic code analysis for vulnerability detection |
| Codacy | push / PR → `main` | Code quality and security analysis |
| OSV-Scanner | push / PR → `main` | Open-source vulnerability scanning against the OSV database |
| OWASP Dependency Check | push / PR → `main` | Checks dependencies against known CVEs |
| Poutine | push / PR → `main` | Supply-chain security analysis for GitHub Actions |

### DAST (Dynamic Analysis)
| Workflow | Trigger | Description |
|---|---|---|
| Checkmarx ZAP | push | Builds and starts the Spring Boot app, then runs a full ZAP scan against `http://localhost:8080` |
| Dastardly | push / PR → `main` | Lightweight DAST scan using Burp Suite's Dastardly |

## Custom Action

A reusable local action is defined in [.github/actions/my-action/](.github/actions/my-action/) (Node 20 runtime).

## Badges

[![DAST (Checkmarx ZAP)](https://github.com/jlralph/desktop-tutorial/actions/workflows/dast-zap.yml/badge.svg)](https://github.com/jlralph/desktop-tutorial/actions/workflows/dast-zap.yml)

[![DAST (Dastardly)](https://github.com/jlralph/desktop-tutorial/actions/workflows/dast-dastardly.yml/badge.svg)](https://github.com/jlralph/desktop-tutorial/actions/workflows/dast-dastardly.yml)

[![SAST (Codacy)](https://github.com/jlralph/desktop-tutorial/actions/workflows/sast-codacy.yml/badge.svg)](https://github.com/jlralph/desktop-tutorial/actions/workflows/sast-codacy.yml)

[![SAST (CodeQL)](https://github.com/jlralph/desktop-tutorial/actions/workflows/sast-codeql.yml/badge.svg)](https://github.com/jlralph/desktop-tutorial/actions/workflows/sast-codeql.yml)

[![SAST (OSV-Scanner)](https://github.com/jlralph/desktop-tutorial/actions/workflows/sast-osv-scanner.yml/badge.svg)](https://github.com/jlralph/desktop-tutorial/actions/workflows/sast-osv-scanner.yml)

[![SAST (OWASP Dependency Check)](https://github.com/jlralph/desktop-tutorial/actions/workflows/sast-dependencyCheck.yml/badge.svg)](https://github.com/jlralph/desktop-tutorial/actions/workflows/sast-dependencyCheck.yml)

[![SAST (Poutine)](https://github.com/jlralph/desktop-tutorial/actions/workflows/sast-poutine.yml/badge.svg)](https://github.com/jlralph/desktop-tutorial/actions/workflows/sast-poutine.yml)

[![Java CI with Maven](https://github.com/jlralph/desktop-tutorial/actions/workflows/maven.yml/badge.svg)](https://github.com/jlralph/desktop-tutorial/actions/workflows/maven.yml)
