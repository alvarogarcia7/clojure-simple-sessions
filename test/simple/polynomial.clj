(defn eva [polynomial x]
  (let [replaced-values (map #(if (= :x %) x %) polynomial)]
    (reduce + replaced-values)))

(defn all-truthy? [& elements]
  (every? identity elements))

(defn facts []
  (all-truthy?
    (= 0 (eva [0] 1))
    (= 1 (eva [:x] 1))
  ))