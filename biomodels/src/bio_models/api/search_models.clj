(ns bio-models.api.search-models
  (:require [bio-models.core :refer [call-api check-required-params with-collection-format *api-context*]]
            [clojure.spec.alpha :as s]
            [spec-tools.core :as st]
            [orchestra.core :refer [defn-spec]]
            )
  (:import (java.io File)))


(defn-spec search-download-get-with-http-info any?
  "Download a single or multiple models
  Download the main file of a given single model or multiple models via their model identifiers."
  [UNKNOWN_PARAMETER_NAME ]
  (check-required-params UNKNOWN_PARAMETER_NAME)
  (call-api "/search/download" :get
            {:path-params   {}
             :header-params {}
             :query-params  {"models" UNKNOWN_PARAMETER_NAME }
             :form-params   {}
             :content-types []
             :accepts       []
             :auth-names    []}))

(defn-spec search-download-get any?
  "Download a single or multiple models
  Download the main file of a given single model or multiple models via their model identifiers."
  [UNKNOWN_PARAMETER_NAME ]
  (let [res (:data (search-download-get-with-http-info UNKNOWN_PARAMETER_NAME))]
    (if (:decode-models *api-context*)
       (st/decode any? res st/string-transformer)
       res)))


(defn-spec search-get-with-http-info any?
  "Download search results
  Search models of interest via keywords. Examples: PUBMED:\"27869123\" to search models associated with the PubMed record identified by 27869123. See [Model search](https://www.ebi.ac.uk/biomodels-static/user-guide/model_search.html) page to know more about search syntax, options and examples."
  ([UNKNOWN_PARAMETER_NAME , ] (search-get-with-http-info UNKNOWN_PARAMETER_NAME nil))
  ([UNKNOWN_PARAMETER_NAME , {:keys [UNKNOWN_PARAMETER_NAME2 UNKNOWN_PARAMETER_NAME3 UNKNOWN_PARAMETER_NAME4 UNKNOWN_PARAMETER_NAME5]} (s/map-of keyword? any?)]
   (check-required-params UNKNOWN_PARAMETER_NAME)
   (call-api "/search" :get
             {:path-params   {}
              :header-params {}
              :query-params  {"query" UNKNOWN_PARAMETER_NAME "offset" UNKNOWN_PARAMETER_NAME2 "numResults" UNKNOWN_PARAMETER_NAME3 "sort" UNKNOWN_PARAMETER_NAME4 "format" UNKNOWN_PARAMETER_NAME5 }
              :form-params   {}
              :content-types []
              :accepts       []
              :auth-names    []})))

(defn-spec search-get any?
  "Download search results
  Search models of interest via keywords. Examples: PUBMED:\"27869123\" to search models associated with the PubMed record identified by 27869123. See [Model search](https://www.ebi.ac.uk/biomodels-static/user-guide/model_search.html) page to know more about search syntax, options and examples."
  ([UNKNOWN_PARAMETER_NAME , ] (search-get UNKNOWN_PARAMETER_NAME nil))
  ([UNKNOWN_PARAMETER_NAME , optional-params any?]
   (let [res (:data (search-get-with-http-info UNKNOWN_PARAMETER_NAME optional-params))]
     (if (:decode-models *api-context*)
        (st/decode any? res st/string-transformer)
        res))))


