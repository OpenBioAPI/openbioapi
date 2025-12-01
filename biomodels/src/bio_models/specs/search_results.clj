(ns bio-models.specs.search-results
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [bio-models.specs.model-summary :refer :all]
            [bio-models.specs.query-parameters :refer :all]
            )
  (:import (java.io File)))


(def search-results-data
  {
   (ds/opt :matches) int?
   (ds/opt :models) (s/coll-of model-summary-spec)
   (ds/opt :queryParameters) query-parameters-spec
   })

(def search-results-spec
  (ds/spec
    {:name ::search-results
     :spec search-results-data}))
