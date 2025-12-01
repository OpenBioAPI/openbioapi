(ns bio-models.api.model-related-operations
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


(defn-spec get-model-download-modelid-with-http-info any?
  "Download a particular file associated with a given model or all its files as a COMBINE archive. The Content disposition and MIME type response headers contain the file name and type."
  ([modelId string?, ] (get-model-download-modelid-with-http-info modelId nil))
  ([modelId string?, {:keys [filename]} (s/map-of keyword? any?)]
   (check-required-params modelId)
   (call-api "/model/download/{modelId}" :get
             {:path-params   {"modelId" modelId }
              :header-params {}
              :query-params  {"filename" filename }
              :form-params   {}
              :content-types []
              :accepts       ["application/octet-stream"]
              :auth-names    []})))

(defn-spec get-model-download-modelid any?
  "Download a particular file associated with a given model or all its files as a COMBINE archive. The Content disposition and MIME type response headers contain the file name and type."
  ([modelId string?, ] (get-model-download-modelid modelId nil))
  ([modelId string?, optional-params any?]
   (let [res (:data (get-model-download-modelid-with-http-info modelId optional-params))]
     (if (:decode-models *api-context*)
        (st/decode any? res st/string-transformer)
        res))))


(defn-spec get-model-files-modelid-with-http-info any?
  "Extract metadata information of model files of a particular model"
  ([modelId string?, ] (get-model-files-modelid-with-http-info modelId nil))
  ([modelId string?, {:keys [format]} (s/map-of keyword? any?)]
   (check-required-params modelId)
   (call-api "/model/files/{modelId}" :get
             {:path-params   {"modelId" modelId }
              :header-params {}
              :query-params  {"format" format }
              :form-params   {}
              :content-types []
              :accepts       ["application/json" "application/xml"]
              :auth-names    []})))

(defn-spec get-model-files-modelid model-files-spec
  "Extract metadata information of model files of a particular model"
  ([modelId string?, ] (get-model-files-modelid modelId nil))
  ([modelId string?, optional-params any?]
   (let [res (:data (get-model-files-modelid-with-http-info modelId optional-params))]
     (if (:decode-models *api-context*)
        (st/decode model-files-spec res st/string-transformer)
        res))))


(defn-spec get-model-identifiers-with-http-info any?
  "Fetch all model identifiers
  Fetch all publicly available model identifiers"
  ([] (get-model-identifiers-with-http-info nil))
  ([{:keys [format]} (s/map-of keyword? any?)]
   (call-api "/model/identifiers" :get
             {:path-params   {}
              :header-params {}
              :query-params  {"format" format }
              :form-params   {}
              :content-types []
              :accepts       ["application/json" "application/xml" "text/html"]
              :auth-names    []})))

(defn-spec get-model-identifiers model-identifiers-spec
  "Fetch all model identifiers
  Fetch all publicly available model identifiers"
  ([] (get-model-identifiers nil))
  ([optional-params any?]
   (let [res (:data (get-model-identifiers-with-http-info optional-params))]
     (if (:decode-models *api-context*)
        (st/decode model-identifiers-spec res st/string-transformer)
        res))))


(defn-spec get-modelid-with-http-info any?
  "Fetch information about a given model at a particular revision."
  ([modelId string?, ] (get-modelid-with-http-info modelId nil))
  ([modelId string?, {:keys [format]} (s/map-of keyword? any?)]
   (check-required-params modelId)
   (call-api "/{modelId}" :get
             {:path-params   {"modelId" modelId }
              :header-params {}
              :query-params  {"format" format }
              :form-params   {}
              :content-types []
              :accepts       ["application/json" "application/xml" "text/html"]
              :auth-names    []})))

(defn-spec get-modelid model-spec
  "Fetch information about a given model at a particular revision."
  ([modelId string?, ] (get-modelid modelId nil))
  ([modelId string?, optional-params any?]
   (let [res (:data (get-modelid-with-http-info modelId optional-params))]
     (if (:decode-models *api-context*)
        (st/decode model-spec res st/string-transformer)
        res))))


