(ns bio-models.specs.history
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [bio-models.specs.revision :refer :all]
            )
  (:import (java.io File)))


(def history-data
  {
   (ds/opt :revisions) (s/coll-of revision-spec)
   })

(def history-spec
  (ds/spec
    {:name ::history
     :spec history-data}))
