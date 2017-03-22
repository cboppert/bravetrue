(ns bravetrue.core
  (:gen-class)
  (:require [bravetrue.chapter-one :as one]))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (one/use-str "Claurice")
  (one/use-vector)
  (one/use-list)
  (one/use-hash-map)
  (one/use-hash-set)
  (prn (str "Adding 100 to 10 " (one/adds-100 10)))
  (let [dec8 (one/dec-maker 8)]
    (prn (str "Using dec8 to dec8 from 98 " (dec8 98))))
  (prn (one/map-set "h"))
  (prn (one/map-set "x" "h"))
  (prn (one/map-set "y" "x" "h"))
  (prn (one/map-set "z" "y" "x" "h"))
  (prn (one/map-set "x" "x" "x"))
  (println "Hello, World!"))
