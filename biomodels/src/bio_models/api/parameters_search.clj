(ns bio-models.api.parameters-search
  (:require [bio-models.core :refer [call-api check-required-params with-collection-format *api-context*]]
            [clojure.spec.alpha :as s]
            [spec-tools.core :as st]
            [orchestra.core :refer [defn-spec]]
            )
  (:import (java.io File)))


(defn-spec parameter-search-search-get-with-http-info any?
  "Search for parameters of a model"
  ([] (parameter-search-search-get-with-http-info nil))
  ([{:keys [UNKNOWN_PARAMETER_NAME UNKNOWN_PARAMETER_NAME2 UNKNOWN_PARAMETER_NAME3 UNKNOWN_PARAMETER_NAME4 UNKNOWN_PARAMETER_NAME5]} (s/map-of keyword? any?)]
   (call-api "/parameterSearch/search" :get
             {:path-params   {}
              :header-params {}
              :query-params  {"query" UNKNOWN_PARAMETER_NAME "start" UNKNOWN_PARAMETER_NAME2 "size" UNKNOWN_PARAMETER_NAME3 "sort" UNKNOWN_PARAMETER_NAME4 "format" UNKNOWN_PARAMETER_NAME5 }
              :form-params   {}
              :content-types []
              :accepts       []
              :auth-names    []})))

(defn-spec parameter-search-search-get any?
  "Search for parameters of a model"
  ([] (parameter-search-search-get nil))
  ([optional-params any?]
   (let [res (:data (parameter-search-search-get-with-http-info optional-params))]
     (if (:decode-models *api-context*)
        (st/decode any? res st/string-transformer)
        res))))


