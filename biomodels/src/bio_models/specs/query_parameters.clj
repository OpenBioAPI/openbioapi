(ns bio-models.specs.query-parameters
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def query-parameters-data
  {
   (ds/opt :sortBy) string?
   (ds/opt :sortDirection) string?
   (ds/opt :offset) int?
   (ds/opt :numResults) int?
   })

(def query-parameters-spec
  (ds/spec
    {:name ::query-parameters
     :spec query-parameters-data}))
