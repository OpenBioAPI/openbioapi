(ns bio-models.specs.model-summary
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def model-summary-data
  {
   (ds/opt :id) string?
   (ds/opt :url) string?
   (ds/opt :name) string?
   (ds/opt :format) string?
   (ds/opt :submitter) string?
   (ds/opt :submissionDate) inst?
   (ds/opt :lastModified) inst?
   })

(def model-summary-spec
  (ds/spec
    {:name ::model-summary
     :spec model-summary-data}))
