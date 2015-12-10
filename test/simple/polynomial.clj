(defn eva [polynomial x]
  (reduce + (map #(if (= :x %) x %) polynomial)))

(defn all-truthy? [& elements]
  (every? identity elements))

(defn facts []
  (all-truthy?
    (= 0 (eva [0] 1))
    (= 1 (eva [:x] 1))
  ))