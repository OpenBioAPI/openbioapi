(ns bio-models.specs.publication
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [bio-models.specs.publication-author :refer :all]
            )
  (:import (java.io File)))


(def publication-data
  {
   (ds/opt :journal) string?
   (ds/opt :title) string?
   (ds/opt :affiliation) string?
   (ds/opt :synopsis) string?
   (ds/opt :year) int?
   (ds/opt :month) string?
   (ds/opt :day) int?
   (ds/opt :volume) string?
   (ds/opt :issue) string?
   (ds/opt :pages) string?
   (ds/opt :link) string?
   (ds/opt :authors) (s/coll-of publication-author-spec)
   })

(def publication-spec
  (ds/spec
    {:name ::publication
     :spec publication-data}))
