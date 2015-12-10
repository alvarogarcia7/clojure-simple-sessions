(defn replace-single-variable [symbol- value part]
  (if (= symbol- part)
    value
    part))

(defn eva [polynomial x]
  (let [replace-single-variable (partial replace-single-variable :x x)
         replaced-values (map replace-single-variable polynomial)]
    (reduce + replaced-values)))

(defn all-truthy? [& elements]
  (every? identity elements))

(defn facts []
  (all-truthy?
    (= 0 (eva [0] 1))
    (= 1 (eva [:x] 1))
  ))