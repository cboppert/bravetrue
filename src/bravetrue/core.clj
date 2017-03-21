(ns bravetrue.core
  (:gen-class)
  (:require [bravetrue.chapter-one :as one]))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (one/use-str "Claurice")
  (println "Hello, World!"))
