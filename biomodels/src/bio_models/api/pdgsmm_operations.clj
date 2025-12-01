(ns bio-models.api.pdgsmm-operations
  (:require [bio-models.core :refer [call-api check-required-params with-collection-format *api-context*]]
            [clojure.spec.alpha :as s]
            [spec-tools.core :as st]
            [orchestra.core :refer [defn-spec]]
            )
  (:import (java.io File)))


(defn-spec pdgsmm-missing-get-with-http-info any?
  "Retrieve the identifiers of all PDGSMM entries that are no longer directly accessible
  Retrieve all models in PDGSMM that are now only available indirectly, through the representative model for the corresponding disease"
  [UNKNOWN_PARAMETER_NAME ]
  (check-required-params UNKNOWN_PARAMETER_NAME)
  (call-api "/pdgsmm/missing" :get
            {:path-params   {"format" UNKNOWN_PARAMETER_NAME }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       []
             :auth-names    []}))

(defn-spec pdgsmm-missing-get any?
  "Retrieve the identifiers of all PDGSMM entries that are no longer directly accessible
  Retrieve all models in PDGSMM that are now only available indirectly, through the representative model for the corresponding disease"
  [UNKNOWN_PARAMETER_NAME ]
  (let [res (:data (pdgsmm-missing-get-with-http-info UNKNOWN_PARAMETER_NAME))]
    (if (:decode-models *api-context*)
       (st/decode any? res st/string-transformer)
       res)))


(defn-spec pdgsmm-representative-get-with-http-info any?
  "Retrieve a representative model in PDGSMM
  Get the representative model identifier for a given missing model in PDGSMM. This endpoint accepts as parameters a mandatory model identifier and an optional response format"
  ([UNKNOWN_PARAMETER_NAME , ] (pdgsmm-representative-get-with-http-info UNKNOWN_PARAMETER_NAME nil))
  ([UNKNOWN_PARAMETER_NAME , {:keys [UNKNOWN_PARAMETER_NAME2]} (s/map-of keyword? any?)]
   (check-required-params UNKNOWN_PARAMETER_NAME)
   (call-api "/pdgsmm/representative" :get
             {:path-params   {}
              :header-params {}
              :query-params  {"model" UNKNOWN_PARAMETER_NAME "format" UNKNOWN_PARAMETER_NAME2 }
              :form-params   {}
              :content-types []
              :accepts       []
              :auth-names    []})))

(defn-spec pdgsmm-representative-get any?
  "Retrieve a representative model in PDGSMM
  Get the representative model identifier for a given missing model in PDGSMM. This endpoint accepts as parameters a mandatory model identifier and an optional response format"
  ([UNKNOWN_PARAMETER_NAME , ] (pdgsmm-representative-get UNKNOWN_PARAMETER_NAME nil))
  ([UNKNOWN_PARAMETER_NAME , optional-params any?]
   (let [res (:data (pdgsmm-representative-get-with-http-info UNKNOWN_PARAMETER_NAME optional-params))]
     (if (:decode-models *api-context*)
        (st/decode any? res st/string-transformer)
        res))))


(defn-spec pdgsmm-representatives-get-with-http-info any?
  "Find the replacement accessions for a set of PDGSMM
  Get the representative model identifiers of a set of given missing models in PDGSMM. This end point expects a comma-separated list of model identifiers (without any surrounding whitespace) and an optional response format. Examples: MODEL1707110145,MODEL1707112456,MODEL1707115900"
  ([UNKNOWN_PARAMETER_NAME , ] (pdgsmm-representatives-get-with-http-info UNKNOWN_PARAMETER_NAME nil))
  ([UNKNOWN_PARAMETER_NAME , {:keys [UNKNOWN_PARAMETER_NAME2]} (s/map-of keyword? any?)]
   (check-required-params UNKNOWN_PARAMETER_NAME)
   (call-api "/pdgsmm/representatives" :get
             {:path-params   {}
              :header-params {}
              :query-params  {"modelIds" UNKNOWN_PARAMETER_NAME "format" UNKNOWN_PARAMETER_NAME2 }
              :form-params   {}
              :content-types []
              :accepts       []
              :auth-names    []})))

(defn-spec pdgsmm-representatives-get any?
  "Find the replacement accessions for a set of PDGSMM
  Get the representative model identifiers of a set of given missing models in PDGSMM. This end point expects a comma-separated list of model identifiers (without any surrounding whitespace) and an optional response format. Examples: MODEL1707110145,MODEL1707112456,MODEL1707115900"
  ([UNKNOWN_PARAMETER_NAME , ] (pdgsmm-representatives-get UNKNOWN_PARAMETER_NAME nil))
  ([UNKNOWN_PARAMETER_NAME , optional-params any?]
   (let [res (:data (pdgsmm-representatives-get-with-http-info UNKNOWN_PARAMETER_NAME optional-params))]
     (if (:decode-models *api-context*)
        (st/decode any? res st/string-transformer)
        res))))


