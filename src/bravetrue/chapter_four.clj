(ns bravetrue.chapter-four)

(def filepath "resources/suspects.csv")

(def vamp-keys [:name :glitter-index])

(defn str->int
  [str]
  (Integer. str))

(defn has-vampire-property?
  [property vampire]
  (not (nil? (get vampire property))))

(def conversions {:name identity
                  :glitter-index str->int})

(def validations {:name #(has-vampire-property? :name %)
                  :glitter-index #(has-vampire-property? :glitter-index %)})

(defn reduce-map
  "Map in terms of reduce"
  [fnc sequence]
  (reduce #(conj %1 (fnc %2)) [] sequence))


(defn convert
  [vamp-key value]
  ((get conversions vamp-key) value))

(defn parse
  "Convert a CSV into rows of columns"
  [string]
  (map #(clojure.string/split % #",")
       (clojure.string/split string #"\n")))

(defn parse-two
  "Parse strings"
  [string]
  (map #(clojure.string/split % #",") (clojure.string/split-lines string)))

(defn mapify
  "Return a seq of maps like {:name \"Edward Cullen\" :glitter-index 10}"
  [rows]
  (map (fn [unmapped-row]
         (reduce (fn [row-map [vamp-key value]]
                   (assoc row-map vamp-key (convert vamp-key value)))
                 {}
                 (map vector vamp-keys unmapped-row)))
       rows))

(defn glitter-filter
  [minimum-glitter records]
  (filter #(>= (:glitter-index %) minimum-glitter) records))

(defn filtered-names
  [vampires]
  (reduce #(conj %1 (get %2 :name)) [] vampires))

(defn append
  [vampires new-guy]
  (conj vampires new-guy))

(defn bad-vampire?
  [vampire validations]
  (some #(do
           (prn %)
           (some (fn [vamp-key] (nil? (get validations vamp-key vampire))) vamp-keys)
           (true? %)) vamp-keys))

(def validate (complement bad-vampire?))
