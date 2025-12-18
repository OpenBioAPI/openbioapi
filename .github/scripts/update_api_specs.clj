#!/usr/bin/env bb 

(ns openbioapi.update-api-specs
  (:require [babashka.curl :as curl]
            [clojure.java.io :as io]
            [cheshire.core :as json]
            [babashka.fs :as fs]
            [clojure.edn :as edn]))

(defonce fetch-errors (atom {}))

(defn fetch-spec [url]
  (try
    (let [response (curl/get url {:throw false})]
      (if (= 200 (:status response))
        (:body response)
        (do
          (println (str "Failed to fetch " url ". HTTP " (:status response)))
          (swap! fetch-errors assoc url response)
          nil)))
    (catch Exception e
      (println "Exception while fetching spec:" (.getMessage e))
      (swap! fetch-errors assoc url (Throwable->map e))
      nil)))

(defn compare-specs [local-filename remote-content]
  (if (.exists (io/file local-filename))
    (let [local-content (slurp local-filename)]
      (= local-content remote-content))
    false))

(defn update-spec [filename content]
  (spit filename content)
  (println (str "Updated " filename)))

(defn process-spec [{:openbioapi.spec/keys [id url file active] :as spec}]
  (when active
    (println (str "Processing API: " id))
    (let [remote-content (fetch-spec url)]
      (if remote-content
        (if (compare-specs file remote-content)
          (println (str "No changes detected for " file))
          (do
            (println (str "Changes detected for " file ". Updating..."))
            (update-spec file remote-content)))
        (println (str "Skipping " id " due to fetch failure."))))))

(defn -main []
  (let [config (edn/read-string (slurp ".github/scripts/update-config.edn"))](doall
    (pmap (fn [spec]
            (process-spec spec))
          (:openbioapi.update-config/specs config)))))


(-main)

#_ (io/file (fs/file (nth (iterate fs/parent (fs/cwd)) 2)) local-filename)
