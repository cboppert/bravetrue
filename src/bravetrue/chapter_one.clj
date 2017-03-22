(ns bravetrue.chapter-one)

(comment
  "Use the str function"
)

(defn use-str
  "Takes in the argument and says hello to it"
  [input]
  (prn (str "Hello " input)))

(defn use-vector
  "Use the vector function"
  []
  (let [vec (vector 12 "x" "y" {:something "1"})]
    (prn vec)
    (prn (str "This is the 3rd element " (get vec 3))))
  (prn (str "Using the vector function yo")))

(defn use-list
  "Use the list function"
  []
  (let [l (list "a" "b" 12 13 {:darn "one"} (vector "x" "y"))]
    (prn l)
    (prn (str "This is the 5th element of the list " (nth l 5))))
  (prn (str "Using the list function yo")))

(defn use-hash-map
  "Uses the hash-map function"
  []
  (let [hm (hash-map :boy "wonder" :golden "throne" :silly "susy" :ding (str "dong" "-ditch"))]
    (prn hm)
    (prn (str "This is the value of ding " (get hm :ding))))
  (prn (str "Using the hashmap function yo")))

(defn use-hash-set
  "Uses the hash set function"
  []
  (let [kurty "Kurt Wantsagut" hs #{"A Hash set" kurty}]
    (prn hs))
  (prn (str "Using the hashset function yo")))

(defn adds-100
  "Adds one hundred to a number"
  [number]
  (+ 100 number))

(defn dec-maker
  "Makes a deccer"
  [number]
  #(- % number))

(defn map-set
  "Works like hashmap but returns a set"
  [h & t]
  (if (empty? t)
    (hash-set h)
    (hash-set h (map-set (first t) (rest t)))))
