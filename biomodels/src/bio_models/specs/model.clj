(ns bio-models.specs.model
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [bio-models.specs.publication :refer :all]
            [bio-models.specs.format :refer :all]
            [bio-models.specs.history :refer :all]
            [bio-models.specs.model-files :refer :all]
            )
  (:import (java.io File)))


(def model-data
  {
   (ds/opt :name) string?
   (ds/opt :description) string?
   (ds/opt :publication) publication-spec
   (ds/opt :submissionId) string?
   (ds/opt :publicationId) string?
   (ds/opt :firstPublished) int?
   (ds/opt :format) format-spec
   (ds/opt :history) history-spec
   (ds/opt :files) model-files-spec
   })

(def model-spec
  (ds/spec
    {:name ::model
     :spec model-data}))
