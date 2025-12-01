(ns bio-models.specs.model-file
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def model-file-data
  {
   (ds/opt :name) string?
   (ds/opt :fileSize) int?
   })

(def model-file-spec
  (ds/spec
    {:name ::model-file
     :spec model-file-data}))
