(ns bio-models.api.path-models-operations
  (:require [bio-models.core :refer [call-api check-required-params with-collection-format *api-context*]]
            [clojure.spec.alpha :as s]
            [spec-tools.core :as st]
            [orchestra.core :refer [defn-spec]]
            )
  (:import (java.io File)))


(defn-spec p2m-missing-get-with-http-info any?
  "Retrieve the identifiers of all Path2Models entries that are no longer directly accessible
  Retrieve all models in Path2Models that are now only available indirectly, through the representative model for the corresponding genus"
  [UNKNOWN_PARAMETER_NAME ]
  (check-required-params UNKNOWN_PARAMETER_NAME)
  (call-api "/p2m/missing" :get
            {:path-params   {"format" UNKNOWN_PARAMETER_NAME }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       []
             :auth-names    []}))

(defn-spec p2m-missing-get any?
  "Retrieve the identifiers of all Path2Models entries that are no longer directly accessible
  Retrieve all models in Path2Models that are now only available indirectly, through the representative model for the corresponding genus"
  [UNKNOWN_PARAMETER_NAME ]
  (let [res (:data (p2m-missing-get-with-http-info UNKNOWN_PARAMETER_NAME))]
    (if (:decode-models *api-context*)
       (st/decode any? res st/string-transformer)
       res)))


(defn-spec p2m-representative-get-with-http-info any?
  "Retrieve a representative model in Path2Models
  Get the representative model identifier for a given missing model in Path2Models. This endpoint accepts as parameters a mandatory model identifier and an optional response format"
  ([UNKNOWN_PARAMETER_NAME , ] (p2m-representative-get-with-http-info UNKNOWN_PARAMETER_NAME nil))
  ([UNKNOWN_PARAMETER_NAME , {:keys [UNKNOWN_PARAMETER_NAME2]} (s/map-of keyword? any?)]
   (check-required-params UNKNOWN_PARAMETER_NAME)
   (call-api "/p2m/representative" :get
             {:path-params   {}
              :header-params {}
              :query-params  {"model" UNKNOWN_PARAMETER_NAME "format" UNKNOWN_PARAMETER_NAME2 }
              :form-params   {}
              :content-types []
              :accepts       []
              :auth-names    []})))

(defn-spec p2m-representative-get any?
  "Retrieve a representative model in Path2Models
  Get the representative model identifier for a given missing model in Path2Models. This endpoint accepts as parameters a mandatory model identifier and an optional response format"
  ([UNKNOWN_PARAMETER_NAME , ] (p2m-representative-get UNKNOWN_PARAMETER_NAME nil))
  ([UNKNOWN_PARAMETER_NAME , optional-params any?]
   (let [res (:data (p2m-representative-get-with-http-info UNKNOWN_PARAMETER_NAME optional-params))]
     (if (:decode-models *api-context*)
        (st/decode any? res st/string-transformer)
        res))))


(defn-spec p2m-representatives-get-with-http-info any?
  "Find the replacement accessions for a set of Path2Models entries
  Get the representative model identifiers of a set of given missing models in Path2Models. This end point expects a comma-separated list of model identifiers (without any surrounding whitespace) and an optional response format. Examples: BMID000000112902,BMID000000009880,BMID000000027397"
  ([UNKNOWN_PARAMETER_NAME , ] (p2m-representatives-get-with-http-info UNKNOWN_PARAMETER_NAME nil))
  ([UNKNOWN_PARAMETER_NAME , {:keys [UNKNOWN_PARAMETER_NAME2]} (s/map-of keyword? any?)]
   (check-required-params UNKNOWN_PARAMETER_NAME)
   (call-api "/p2m/representatives" :get
             {:path-params   {}
              :header-params {}
              :query-params  {"modelIds" UNKNOWN_PARAMETER_NAME "format" UNKNOWN_PARAMETER_NAME2 }
              :form-params   {}
              :content-types []
              :accepts       []
              :auth-names    []})))

(defn-spec p2m-representatives-get any?
  "Find the replacement accessions for a set of Path2Models entries
  Get the representative model identifiers of a set of given missing models in Path2Models. This end point expects a comma-separated list of model identifiers (without any surrounding whitespace) and an optional response format. Examples: BMID000000112902,BMID000000009880,BMID000000027397"
  ([UNKNOWN_PARAMETER_NAME , ] (p2m-representatives-get UNKNOWN_PARAMETER_NAME nil))
  ([UNKNOWN_PARAMETER_NAME , optional-params any?]
   (let [res (:data (p2m-representatives-get-with-http-info UNKNOWN_PARAMETER_NAME optional-params))]
     (if (:decode-models *api-context*)
        (st/decode any? res st/string-transformer)
        res))))


