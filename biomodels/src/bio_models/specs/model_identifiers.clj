(ns bio-models.specs.model-identifiers
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def model-identifiers-data
  {
   (ds/opt :hits) int?
   (ds/opt :models) (s/coll-of string?)
   })

(def model-identifiers-spec
  (ds/spec
    {:name ::model-identifiers
     :spec model-identifiers-data}))
