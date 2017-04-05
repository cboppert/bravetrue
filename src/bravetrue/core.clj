(ns bravetrue.core
  (:gen-class)
  (:require [bravetrue.chapter-one :as one]
            [bravetrue.chapter-four :as four]))

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
  (prn four/filepath)
  (prn (slurp four/filepath))
  (prn (four/parse (slurp four/filepath)))
  (prn (first (four/mapify (four/parse (slurp four/filepath)))))
  (prn (four/reduce-map #(+ 1 %) '(1 2 3)))
  (prn (four/convert :glitter-index "3"))
  (println "Hello, World!"))
