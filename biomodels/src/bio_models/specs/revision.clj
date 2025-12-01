(ns bio-models.specs.revision
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def revision-data
  {
   (ds/opt :version) int?
   (ds/opt :submitted) float?
   (ds/opt :submitter) string?
   (ds/opt :comment) string?
   })

(def revision-spec
  (ds/spec
    {:name ::revision
     :spec revision-data}))
