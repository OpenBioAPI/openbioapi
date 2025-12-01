(ns bio-models.specs.publication-author
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def publication-author-data
  {
   (ds/opt :name) string?
   (ds/opt :institution) string?
   (ds/opt :orcid) string?
   })

(def publication-author-spec
  (ds/spec
    {:name ::publication-author
     :spec publication-author-data}))
