(defn replace-single-variable [symbol- value part]
  (if (= symbol- part)
    value
    part))

(defn apply-coefficient [coefficients variable]
  [(* variable (first coefficients))
   (second coefficients)])

(defn simplifiable? [polynomial]
  (every? number? polynomial))

(defn parse- [polynomial-repr variable]
  (cond
    (= "0" polynomial-repr) [0 0]
    (= "x" polynomial-repr) [0 1]
    (= "y" polynomial-repr) [0 :y]))

(defn eva [polynomial-repr x]
  (let [polynomial (parse- polynomial-repr :x)
         replaced-values (apply-coefficient polynomial x)]
    (if (simplifiable? replaced-values)
      (reduce + replaced-values)
      replaced-values)))

(defn decorate-with-name [expression]
  {:expression expression
   :value (eval (macroexpand expression))})

(defn all-truthy? [& elements]
  (let [exprs (map decorate-with-name elements)
         value-of #(:value %)
         all-correct (every? (comp identity value-of) exprs)
         wrong (filter (comp false? value-of) exprs)]
         (if all-correct
           true
           wrong)
         ))

(defn facts []
  (all-truthy?
    '(= 2 (eva "0" 1))
    '(= 1 (eva "x" 1))
    '(= [0 :y] (eva "y" 1))
  ))