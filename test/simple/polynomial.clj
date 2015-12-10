(defn eva [polynomial x]
  (let [replace-single-variable (fn [symbol- part value] (if (= symbol- part) value part))
         replaced-values (map #(replace-single-variable :x % x) polynomial)]
    (reduce + replaced-values)))

(defn all-truthy? [& elements]
  (every? identity elements))

(defn facts []
  (all-truthy?
    (= 0 (eva [0] 1))
    (= 1 (eva [:x] 1))
  ))