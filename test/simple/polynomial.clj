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
    
;; study this ===========================>
;; (defn eva [polynomial x]
;; 	(let [replace-single-variable (partial replace-single-variable :x x)
;; 		replaced-values (map replace-single-variable polynomial)]
;; 		(reduce + replaced-values)))
;; 
;; (defn eva [polynomial x]
;; 	(let [substitute-variable (partial replace-single-variable :x x)]
;; 		(->> 
;; 			polynomial
;; 			(map substitute-variable)
;; 			(reduce +))))

(defn evaluate [expression]
  {:expression expression
   :value (eval (macroexpand expression))})

(defn value-of [expression]
  (:value expression))

(defn all-truthy? [& elements]
  (let [exprs (map evaluate elements)]
         (if-let [all-correct (->> exprs (every? (comp identity value-of)))] 
           {:message "OK"}
           (let [wrong (->> exprs (filter (comp false? value-of)))]
             {:message (str "KO - " (count wrong)) :failing wrong}))))

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
