(ns bio-models.api.parameters-search
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


(defn-spec get-parametersearch-search-with-http-info any?
  "Search for parameters of a model"
  ([] (get-parametersearch-search-with-http-info nil))
  ([{:keys [query start size sort format]} (s/map-of keyword? any?)]
   (call-api "/parameterSearch/search" :get
             {:path-params   {}
              :header-params {}
              :query-params  {"query" query "start" start "size" size "sort" sort "format" format }
              :form-params   {}
              :content-types []
              :accepts       ["application/json" "application/csv"]
              :auth-names    []})))

(defn-spec get-parametersearch-search any?
  "Search for parameters of a model"
  ([] (get-parametersearch-search nil))
  ([optional-params any?]
   (let [res (:data (get-parametersearch-search-with-http-info optional-params))]
     (if (:decode-models *api-context*)
        (st/decode any? res st/string-transformer)
        res))))


