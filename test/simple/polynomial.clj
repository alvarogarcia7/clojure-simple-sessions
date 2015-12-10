(defn replace-single-variable [symbol- value part]
  (if (= symbol- part)
    value
    part))

(defn simplifiable? [polynomial]
  (every? number? polynomial))

(defn eva [polynomial x]
  (let [replace-single-variable (partial replace-single-variable :x x)
         replaced-values (map replace-single-variable polynomial)]
    (if (simplifiable? replaced-values)
      (reduce + replaced-values)
      replaced-values)))

(defn all-truthy? [& elements]
  (every? identity elements))

(defn facts []
  (all-truthy?
    (= 0 (eva [0] 1))
    (= 1 (eva [:x] 1))
    (= [:y] (eva [:y] 1))
  ))