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

(defn evaluate [expression]
  {:expression expression
   :value (eval (macroexpand expression))})

(defn all-truthy? [& elements]
  (let [
         value-of #(:value %)
         exprs (map evaluate elements)
         all-correct (every? (comp identity value-of) exprs)
         wrong (filter (comp false? value-of) exprs)]
         (if all-correct
           {:message "OK"}
           {:message (str "KO - " (count wrong)) :failing wrong})))

(defn facts []
  (all-truthy?
    '(= 0 (eva "0" 1))
    '(= 1 (eva "x" 1))
    '(= [0 :y] (eva "y" 1))
  ))

(defn test-library-facts []
  (all-truthy?
    '(= false true)
    '(= 1 1)
  ))