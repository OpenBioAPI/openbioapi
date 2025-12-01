(ns bio-models.specs.model-files
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [bio-models.specs.model-file :refer :all]
            [bio-models.specs.model-file :refer :all]
            )
  (:import (java.io File)))


(def model-files-data
  {
   (ds/opt :main) (s/coll-of model-file-spec)
   (ds/opt :additional) (s/coll-of model-file-spec)
   })

(def model-files-spec
  (ds/spec
    {:name ::model-files
     :spec model-files-data}))
