(ns bio-models.api.search-models
  (:require [bio-models.core :refer [call-api check-required-params with-collection-format *api-context*]]
            [clojure.spec.alpha :as s]
            [spec-tools.core :as st]
            [orchestra.core :refer [defn-spec]]
            [bio-models.specs.model-identifiers :refer :all]
            [bio-models.specs.model-file :refer :all]
            [bio-models.specs.publication :refer :all]
            [bio-models.specs.model-files :refer :all]
            [bio-models.specs.format :refer :all]
            [bio-models.specs.model-summary :refer :all]
            [bio-models.specs.query-parameters :refer :all]
            [bio-models.specs.model :refer :all]
            [bio-models.specs.history :refer :all]
            [bio-models.specs.search-results :refer :all]
            [bio-models.specs.publication-author :refer :all]
            [bio-models.specs.revision :refer :all]
            )
  (:import (java.io File)))


(defn-spec get-search-with-http-info any?
  "Download search results
  Search models of interest via keywords. Examples: PUBMED:\"27869123\" to search models associated with the PubMed record identified by 27869123. See [Model search](https://www.ebi.ac.uk/biomodels-static/user-guide/model_search.html) page to know more about search syntax, options and examples."
  ([query string?, ] (get-search-with-http-info query nil))
  ([query string?, {:keys [offset numResults sort format]} (s/map-of keyword? any?)]
   (check-required-params query)
   (call-api "/search" :get
             {:path-params   {}
              :header-params {}
              :query-params  {"query" query "offset" offset "numResults" numResults "sort" sort "format" format }
              :form-params   {}
              :content-types []
              :accepts       ["application/json" "application/xml" "text/html"]
              :auth-names    []})))

(defn-spec get-search search-results-spec
  "Download search results
  Search models of interest via keywords. Examples: PUBMED:\"27869123\" to search models associated with the PubMed record identified by 27869123. See [Model search](https://www.ebi.ac.uk/biomodels-static/user-guide/model_search.html) page to know more about search syntax, options and examples."
  ([query string?, ] (get-search query nil))
  ([query string?, optional-params any?]
   (let [res (:data (get-search-with-http-info query optional-params))]
     (if (:decode-models *api-context*)
        (st/decode search-results-spec res st/string-transformer)
        res))))


(defn-spec get-search-download-with-http-info any?
  "Download a single or multiple models
  Download the main file of a given single model or multiple models via their model identifiers."
  [models string?]
  (check-required-params models)
  (call-api "/search/download" :get
            {:path-params   {}
             :header-params {}
             :query-params  {"models" models }
             :form-params   {}
             :content-types []
             :accepts       ["application/zip"]
             :auth-names    []}))

(defn-spec get-search-download any?
  "Download a single or multiple models
  Download the main file of a given single model or multiple models via their model identifiers."
  [models string?]
  (let [res (:data (get-search-download-with-http-info models))]
    (if (:decode-models *api-context*)
       (st/decode any? res st/string-transformer)
       res)))


