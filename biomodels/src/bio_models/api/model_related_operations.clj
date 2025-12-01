(ns bio-models.api.model-related-operations
  (:require [bio-models.core :refer [call-api check-required-params with-collection-format *api-context*]]
            [clojure.spec.alpha :as s]
            [spec-tools.core :as st]
            [orchestra.core :refer [defn-spec]]
            )
  (:import (java.io File)))


(defn-spec model-download-model-id-get-with-http-info any?
  "Download a particular file associated with a given model or all its files as a COMBINE archive. The Content disposition and MIME type response headers contain the file name and type."
  ([UNKNOWN_PARAMETER_NAME , ] (model-download-model-id-get-with-http-info UNKNOWN_PARAMETER_NAME nil))
  ([UNKNOWN_PARAMETER_NAME , {:keys [UNKNOWN_PARAMETER_NAME2]} (s/map-of keyword? any?)]
   (check-required-params UNKNOWN_PARAMETER_NAME)
   (call-api "/model/download/{modelId}" :get
             {:path-params   {"modelId" UNKNOWN_PARAMETER_NAME }
              :header-params {}
              :query-params  {"filename" UNKNOWN_PARAMETER_NAME2 }
              :form-params   {}
              :content-types []
              :accepts       []
              :auth-names    []})))

(defn-spec model-download-model-id-get any?
  "Download a particular file associated with a given model or all its files as a COMBINE archive. The Content disposition and MIME type response headers contain the file name and type."
  ([UNKNOWN_PARAMETER_NAME , ] (model-download-model-id-get UNKNOWN_PARAMETER_NAME nil))
  ([UNKNOWN_PARAMETER_NAME , optional-params any?]
   (let [res (:data (model-download-model-id-get-with-http-info UNKNOWN_PARAMETER_NAME optional-params))]
     (if (:decode-models *api-context*)
        (st/decode any? res st/string-transformer)
        res))))


(defn-spec model-files-model-id-get-with-http-info any?
  "Extract metadata information of model files of a particular model"
  ([UNKNOWN_PARAMETER_NAME , ] (model-files-model-id-get-with-http-info UNKNOWN_PARAMETER_NAME nil))
  ([UNKNOWN_PARAMETER_NAME , {:keys [UNKNOWN_PARAMETER_NAME2]} (s/map-of keyword? any?)]
   (check-required-params UNKNOWN_PARAMETER_NAME)
   (call-api "/model/files/{modelId}" :get
             {:path-params   {"modelId" UNKNOWN_PARAMETER_NAME }
              :header-params {}
              :query-params  {"format" UNKNOWN_PARAMETER_NAME2 }
              :form-params   {}
              :content-types []
              :accepts       []
              :auth-names    []})))

(defn-spec model-files-model-id-get any?
  "Extract metadata information of model files of a particular model"
  ([UNKNOWN_PARAMETER_NAME , ] (model-files-model-id-get UNKNOWN_PARAMETER_NAME nil))
  ([UNKNOWN_PARAMETER_NAME , optional-params any?]
   (let [res (:data (model-files-model-id-get-with-http-info UNKNOWN_PARAMETER_NAME optional-params))]
     (if (:decode-models *api-context*)
        (st/decode any? res st/string-transformer)
        res))))


(defn-spec model-id-get-with-http-info any?
  "Fetch information about a given model at a particular revision."
  ([UNKNOWN_PARAMETER_NAME , ] (model-id-get-with-http-info UNKNOWN_PARAMETER_NAME nil))
  ([UNKNOWN_PARAMETER_NAME , {:keys [UNKNOWN_PARAMETER_NAME2]} (s/map-of keyword? any?)]
   (check-required-params UNKNOWN_PARAMETER_NAME)
   (call-api "/{modelId}" :get
             {:path-params   {"modelId" UNKNOWN_PARAMETER_NAME }
              :header-params {}
              :query-params  {"format" UNKNOWN_PARAMETER_NAME2 }
              :form-params   {}
              :content-types []
              :accepts       []
              :auth-names    []})))

(defn-spec model-id-get any?
  "Fetch information about a given model at a particular revision."
  ([UNKNOWN_PARAMETER_NAME , ] (model-id-get UNKNOWN_PARAMETER_NAME nil))
  ([UNKNOWN_PARAMETER_NAME , optional-params any?]
   (let [res (:data (model-id-get-with-http-info UNKNOWN_PARAMETER_NAME optional-params))]
     (if (:decode-models *api-context*)
        (st/decode any? res st/string-transformer)
        res))))


(defn-spec model-identifiers-get-with-http-info any?
  "Fetch all model identifiers
  Fetch all publicly available model identifiers"
  ([] (model-identifiers-get-with-http-info nil))
  ([{:keys [UNKNOWN_PARAMETER_NAME]} (s/map-of keyword? any?)]
   (call-api "/model/identifiers" :get
             {:path-params   {}
              :header-params {}
              :query-params  {"format" UNKNOWN_PARAMETER_NAME }
              :form-params   {}
              :content-types []
              :accepts       []
              :auth-names    []})))

(defn-spec model-identifiers-get any?
  "Fetch all model identifiers
  Fetch all publicly available model identifiers"
  ([] (model-identifiers-get nil))
  ([optional-params any?]
   (let [res (:data (model-identifiers-get-with-http-info optional-params))]
     (if (:decode-models *api-context*)
        (st/decode any? res st/string-transformer)
        res))))


