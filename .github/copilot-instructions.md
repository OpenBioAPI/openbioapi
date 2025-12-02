# Copilot Instructions for OpenBioAPI

This repository serves as a collection of OpenAPI specifications for the public APIs of important Bioinformatics data resources.

## Repository Structure

- If a resource has multiple specs, they are contained in a folder named after the resource (e.g., `uniprot/`)
- Single-spec resources have a top-level spec file (JSON or YAML)
- **YAML is preferred** for new specifications

## Key Guidelines

### Reading Documentation

- Thoroughly read the API documentation provided by the data resource
- This may require multiple web requests depending on the documentation layout
- Ensure you understand all endpoints, parameters, and response schemas before writing specs

### OpenAPI Specification Standards

- **Use the latest version of OpenAPI (3.1.x)** for newly written specifications
- Include comprehensive type definitions in `components/schemas`
- Provide meaningful descriptions for:
  - The API itself (`info.description`)
  - Each endpoint/operation
  - Parameters and request bodies
  - Response schemas
- Include examples where helpful
- Use appropriate HTTP status codes and document error responses

### Specification Quality

- Ensure specifications are syntactically correct and valid
- Use proper OpenAPI schema references (`$ref`)
- Include `servers` array with the base URL(s)
- Tag endpoints appropriately for grouping
- Include `operationId` for each operation

### File Naming Conventions

- Use lowercase names matching the resource name
- Use `.yml` extension for YAML files (preferred)
- Use `.json` extension for JSON files

## Good Contributions

A good addition to this repository includes:

1. **Full, functional OpenAPI specifications** that are syntactically correct and validated
2. **Infrastructure improvements** for:
   - Keeping specifications up to date
   - Validating specifications
   - Generating clients or servers via integration workflows

## Client Generation

This repository includes a GitHub Actions workflow that generates Clojure clients from OpenAPI specs. See `README_CLIENT_GEN.md` for details.
