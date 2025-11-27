# Clojure API Client Generator

This repository includes a GitHub Actions workflow that automatically generates Clojure clients from OpenAPI specifications and publishes them to individual repositories.

## How It Works

The workflow:

1. **Discovers** all OpenAPI specification files (`.yaml`, `.yml`, `.json`) in the repository by checking for `openapi` or `swagger` keywords
2. **Generates** Clojure clients using the official `openapitools/openapi-generator-cli:latest` Docker image
3. **Creates** target repositories named `clj-<spec-name>-client` under the specified owner
4. **Pushes** the generated code to each client repository
5. **Updates** a meta repository with a `clients.json` file tracking all generated clients

## Setup

### Required Secrets

Add the following secret to your repository:

| Secret | Description |
|--------|-------------|
| `PERSONAL_TOKEN` | A GitHub Personal Access Token (PAT) with `repo` scope. Required for creating repositories and pushing code. |

To create a Personal Access Token:
1. Go to GitHub Settings → Developer settings → Personal access tokens → Tokens (classic)
2. Click "Generate new token (classic)"
3. Select the `repo` scope (full control of private repositories)
4. Copy the token and add it as a repository secret named `PERSONAL_TOKEN`

### Optional Environment Variables

Configure these as repository variables (Settings → Secrets and variables → Actions → Variables):

| Variable | Default | Description |
|----------|---------|-------------|
| `TARGET_OWNER` | `Schmoho` | GitHub username or organization where client repos will be created |
| `META_REPO` | `openbioapi-clients-meta` | Name of the meta repository that tracks all generated clients |
| `PRIVATE_CLIENTS` | `false` | Set to `true` to create private client repositories |

## Workflow Triggers

The workflow runs:

- **On push** to the `main` branch
- **On schedule** daily at midnight UTC
- **Manually** via workflow dispatch (Actions → Generate Clojure Clients → Run workflow)

## Generated Repository Naming

Client repositories are named following this convention:

```
clj-<spec-name>-client
```

Where `<spec-name>` is derived from the spec file:
- `go.yml` → `clj-go-client`
- `ncbi.yaml` → `clj-ncbi-client`
- `uniprot/uniprot.json` → `clj-uniprot-uniprot-client`

## Helper Script

The repository includes a helper script at `.github/scripts/generate_single.sh` that can be used to generate a client locally:

```bash
./.github/scripts/generate_single.sh <spec_path> <output_dir>
```

This script:
- Uses the official `openapitools/openapi-generator-cli:latest` Docker image
- Passes `--skip-validate-spec` to handle specs with minor validation issues
- Ensures generated files are writable

## Meta Repository

The workflow creates/updates a meta repository containing a `clients.json` file with entries for each generated client:

```json
{
  "generated_at": "2024-01-01T00:00:00.000Z",
  "source_repository": "Schmoho/openbioapi",
  "clients": [
    {
      "source_repo": "Schmoho/openbioapi",
      "spec_path": "./go.yml",
      "client_repo": "https://github.com/Schmoho/clj-go-client",
      "updated_at": "2024-01-01T00:00:00.000Z"
    }
  ]
}
```

## Troubleshooting

### Common Issues

1. **"PERSONAL_TOKEN secret is not set"**
   - Ensure you've added the `PERSONAL_TOKEN` secret to your repository settings

2. **"Failed to create repository"**
   - Verify the Personal Access Token has the `repo` scope
   - Check if you have permission to create repositories in the target organization

3. **"Failed to generate client"**
   - The OpenAPI spec may have issues; check the workflow logs for details
   - The `--skip-validate-spec` flag helps with minor validation issues

4. **Docker errors**
   - Ensure the workflow runner has Docker available (ubuntu-latest includes Docker)

## Local Development

To generate clients locally:

1. Install Docker
2. Run the helper script:
   ```bash
   chmod +x .github/scripts/generate_single.sh
   ./.github/scripts/generate_single.sh go.yml ./output/clj-go-client
   ```
