(ns bio-models.specs.format
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def format-data
  {
   (ds/opt :name) string?
   (ds/opt :version) string?
   })

(def format-spec
  (ds/spec
    {:name ::format
     :spec format-data}))
