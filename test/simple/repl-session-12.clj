;; obtains longest path in a tree
(defn longest-path-length [& edges]
  0)
(= (longest-path-length "1-2" "1-2") 2)

(defn parse-edges [& edges]
  (map #(.values %) edges))

(parse-edges {:1 :2} {:1 :2})

(defn parse-edges2 [& edges]
  (map #(merge-with + %) edges))

(parse-edges2 {:1 2} {:1 22})

