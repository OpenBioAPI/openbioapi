(ns bio-models.api.pdgsmm-operations
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


(defn-spec get-pdgsmm-missing-with-http-info any?
  "Retrieve the identifiers of all PDGSMM entries that are no longer directly accessible
  Retrieve all models in PDGSMM that are now only available indirectly, through the representative model for the corresponding disease"
  ([] (get-pdgsmm-missing-with-http-info nil))
  ([{:keys [format]} (s/map-of keyword? any?)]
   (call-api "/pdgsmm/missing" :get
             {:path-params   {}
              :header-params {}
              :query-params  {"format" format }
              :form-params   {}
              :content-types []
              :accepts       ["application/json" "application/xml" "text/html"]
              :auth-names    []})))

(defn-spec get-pdgsmm-missing any?
  "Retrieve the identifiers of all PDGSMM entries that are no longer directly accessible
  Retrieve all models in PDGSMM that are now only available indirectly, through the representative model for the corresponding disease"
  ([] (get-pdgsmm-missing nil))
  ([optional-params any?]
   (let [res (:data (get-pdgsmm-missing-with-http-info optional-params))]
     (if (:decode-models *api-context*)
        (st/decode any? res st/string-transformer)
        res))))


(defn-spec get-pdgsmm-representative-with-http-info any?
  "Retrieve a representative model in PDGSMM
  Get the representative model identifier for a given missing model in PDGSMM. This endpoint accepts as parameters a mandatory model identifier and an optional response format"
  ([model string?, ] (get-pdgsmm-representative-with-http-info model nil))
  ([model string?, {:keys [format]} (s/map-of keyword? any?)]
   (check-required-params model)
   (call-api "/pdgsmm/representative" :get
             {:path-params   {}
              :header-params {}
              :query-params  {"model" model "format" format }
              :form-params   {}
              :content-types []
              :accepts       ["application/json" "application/xml" "text/html"]
              :auth-names    []})))

(defn-spec get-pdgsmm-representative any?
  "Retrieve a representative model in PDGSMM
  Get the representative model identifier for a given missing model in PDGSMM. This endpoint accepts as parameters a mandatory model identifier and an optional response format"
  ([model string?, ] (get-pdgsmm-representative model nil))
  ([model string?, optional-params any?]
   (let [res (:data (get-pdgsmm-representative-with-http-info model optional-params))]
     (if (:decode-models *api-context*)
        (st/decode any? res st/string-transformer)
        res))))


(defn-spec get-pdgsmm-representatives-with-http-info any?
  "Find the replacement accessions for a set of PDGSMM
  Get the representative model identifiers of a set of given missing models in PDGSMM. This end point expects a comma-separated list of model identifiers (without any surrounding whitespace) and an optional response format. Examples: MODEL1707110145,MODEL1707112456,MODEL1707115900"
  ([modelIds (s/coll-of string?), ] (get-pdgsmm-representatives-with-http-info modelIds nil))
  ([modelIds (s/coll-of string?), {:keys [format]} (s/map-of keyword? any?)]
   (check-required-params modelIds)
   (call-api "/pdgsmm/representatives" :get
             {:path-params   {}
              :header-params {}
              :query-params  {"modelIds" (with-collection-format modelIds :csv) "format" format }
              :form-params   {}
              :content-types []
              :accepts       ["application/json" "application/xml" "text/html"]
              :auth-names    []})))

(defn-spec get-pdgsmm-representatives any?
  "Find the replacement accessions for a set of PDGSMM
  Get the representative model identifiers of a set of given missing models in PDGSMM. This end point expects a comma-separated list of model identifiers (without any surrounding whitespace) and an optional response format. Examples: MODEL1707110145,MODEL1707112456,MODEL1707115900"
  ([modelIds (s/coll-of string?), ] (get-pdgsmm-representatives modelIds nil))
  ([modelIds (s/coll-of string?), optional-params any?]
   (let [res (:data (get-pdgsmm-representatives-with-http-info modelIds optional-params))]
     (if (:decode-models *api-context*)
        (st/decode any? res st/string-transformer)
        res))))


