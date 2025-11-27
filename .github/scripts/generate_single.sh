#!/usr/bin/env bash
#
# generate_single.sh
#
# Generates a Clojure client for a single OpenAPI spec using the openapi-generator-cli Docker image.
#
# Usage:
#   ./generate_single.sh <spec_path> <output_dir>
#
# Arguments:
#   spec_path  - Path to the OpenAPI spec file (yaml, yml, or json)
#   output_dir - Directory where generated client will be placed
#
# Features:
#   - Uses --skip-validate-spec to handle specs that may have minor validation issues
#   - Ensures generated files are writable
#

set -euo pipefail

if [ $# -lt 2 ]; then
  echo "Usage: $0 <spec_path> <output_dir>"
  exit 1
fi

SPEC_PATH="$1"
OUTPUT_DIR="$2"

# Ensure output directory exists
mkdir -p "$OUTPUT_DIR"

# Get absolute paths for Docker volume mounting
SPEC_ABS_PATH=$(realpath "$SPEC_PATH")
OUTPUT_ABS_PATH=$(realpath "$OUTPUT_DIR")
SPEC_DIR=$(dirname "$SPEC_ABS_PATH")
SPEC_FILE=$(basename "$SPEC_ABS_PATH")

echo "Generating Clojure client for: $SPEC_PATH"
echo "Output directory: $OUTPUT_DIR"

# Run openapi-generator-cli via Docker
docker run --rm \
  -v "${SPEC_DIR}:/spec:ro" \
  -v "${OUTPUT_ABS_PATH}:/output" \
  openapitools/openapi-generator-cli:latest generate \
  -i "/spec/${SPEC_FILE}" \
  -g clojure \
  -o /output \
  --skip-validate-spec

# Ensure generated files are writable
chmod -R u+w "$OUTPUT_ABS_PATH" || true

echo "Successfully generated Clojure client in: $OUTPUT_DIR"
