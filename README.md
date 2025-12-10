# OpenBioAPI

This is a collection of OpenAPI specifications for Bioinformatics Databases. 

Specs so far are either provided by the creators of the resource, or produced using LLMs fed with available API documentation pages.
The goal is to provide a resource for auto-generation of API clients, as well as memoizing proxy servers for development and testing purposes.
Currently, an experimental workflow for the automatic generation of Clojure clients is available and the generated clients can be found in the associated GitHub organization.

The [IBM OpenAPI Validator](https://github.com/IBM/openapi-validator) has been used with the flags `--summary-only` and `--impact-score` using default configuration.

| API                          | Link                                                                                                                                                | Provided by the Creators | [IBM Validator](https://github.com/IBM/openapi-validator) Results |
|------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------|--------------------------|-------------------------------------------------------------------|
| Biomodels                    | [UI](https://www.ebi.ac.uk/biomodels/docs/) [Spec](https://www.ebi.ac.uk/biomodels/docs/biomodels-jummp-swagger.json)                               | ✅                       | errors:  74, warnings:  235, score: 19/100                        |
| Biosimulations               | [UI](https://api.biosimulations.org/) [Spec](https://api.biosimulations.org/openapi.json)                                                           | ✅                       | errors: 357, warnings: 2275, score: 25/100                        |
| Biosimulators                | [UI](https://api.biosimulators.org/) [Spec](https://api.biosimulators.org/openapi.json)                                                             | ✅                       | errors: 172, warnings:  705, score: 27/100                        |
| CellML Repository            | [API Documentation](https://aucklandphysiomerepository.readthedocs.io/en/latest/webservice.html)                                                    | ❌                       | errors:  41, warnings:  278, score: 34/100                        |
| Gene Ontology                | [UI](https://api.geneontology.org/) [Spec](https://api.geneontology.org/openapi.json)                                                               | ✅                       | errors:  74, warnings:  446, score: 45/100                        |
| JWS Online                   | [API Documentation](https://jws-docs.readthedocs.io/8_rest.html)                                                                                    | ❌                       | errors:  10, warnings:   66, score: 23/100                        |
| KEGG                         | [API Documentation](https://www.kegg.jp/kegg/rest/keggapi.html)                                                                                     | ❌                       | errors:   9, warnings:   76, score: 33/100                        |
| NCBI                         | [UI](https://www.ncbi.nlm.nih.gov/datasets/docs/v2/api/rest-api/) [Spec](https://www.ncbi.nlm.nih.gov/datasets/docs/v2/openapi3/openapi3.docs.yaml) | ✅                       | errors: 917, warnings: 4504, score: 37/100                        |
| Physiomeproject              | [API Documentation](https://aucklandphysiomerepository.readthedocs.io/en/latest/webservice.html)                                                    | ❌                       | errors:  41, warnings:  278, score: 34/100                        |
| STRING                       | [API Documentation](https://string-db.org/cgi/help?sessionId=buBYnEcGg5am)                                                                          | ❌                       | errors: 140, warnings:  173, score: 21/100                        |
| Uniparc                      | [UI](https://www.uniprot.org/api-documentation/uniparc) [Spec](https://rest.uniprot.org/uniparc/api/docs)                                           | ✅                       | errors: 168, warnings:  466, score: 13/100                        |
| Uniprot Automatic Annotation | [UI](https://www.uniprot.org/api-documentation/aa) [Spec](https://rest.uniprot.org/aa/api/docs)                                                     | ✅                       | errors: 313, warnings:  828, score: 12/100                        |
| Uniprot KB                   | [UI](https://www.uniprot.org/api-documentation/uniprotkb) [Spec](https://rest.uniprot.org/uniprotkb/api/docs)                                       | ✅                       | errors: 696, warnings: 1696, score: 4/100                         |
| Uniprot ID-Mapping           | [UI](https://www.uniprot.org/api-documentation/idmapping) [Spec](https://rest.uniprot.org/idmapping/api/docs)                                       | ✅                       | errors:  88, warnings:  425, score: 12/100                        |
| Uniprot Proteomes            | [UI](https://www.uniprot.org/api-documentation/proteomes) [Spec](https://rest.uniprot.org/proteomes/api/docs)                                       | ✅                       | errors: 341, warnings:  909, score: 11/100                        |
| Uniprot Supporting Data      | [UI](https://www.uniprot.org/api-documentation/support-data) [Spec](https://rest.uniprot.org/support-data/api/docs)                                 | ✅                       | errors: 221, warnings:  947, score: 11/100                        |
| Uniref                       | [UI](https://www.uniprot.org/api-documentation/uniref) [Spec](https://rest.uniprot.org/uniref/api/docs)                                             | ✅                       | errors: 107, warnings:  343, score: 10/100                        |


## Next Goals

- automate IBM validator runs and versioning of results
- automate periodic re-acquisition/update of specs that are provided by the creators
- add specs for the [Global Core Bioinformatics Resources](https://globalbiodata.org/what-we-do/global-core-biodata-resources/list-of-current-global-core-biodata-resources/)
- add Ensembl spec
- add BiGG spec
- add Python client generation
