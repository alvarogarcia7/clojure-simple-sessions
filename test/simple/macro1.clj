; copied, modified from http://www.braveclojure.com/writing-macros/

(defn print-and-evaluate
  [code]
  `(println (str `code ": " (~@code))))

(defmacro preval
  [& expressions]
  `(do ~@(->>
                 expressions
                 (map print-and-evaluate))))

; usage
; simple.core=> (preval (+ 1 1) (* 1 3))
; (+ 1 1): 2
; (* 1 3): 3
; nil

(defmacro evaluate [expression]
  `(do ~{:expression expression
         :value      expression}))

; (evaluate (= false true))
;=> {:expression "(= false true)", :value false}

(defn value-of [expression]
  (:value expression))

; simple.core=> (evaluate (+ 1 1))
; {:expression "(+ 1 1)", :value 2}

(defmacro all-truthy2? [& elements]
  (let [exprs (map #(evaluate %) elements)]
         (if-let [all-correct (->> exprs (every? (comp identity value-of)))] 
           {:message "OK"}
           (let [wrong (->> exprs (filter (comp false? value-of)))]
             {:message (str "KO - " (count wrong)) :failing wrong}))))

(defmacro is-truthy? [element]
  `(do
     ~{:expression (str element)
       :value      element}))

(defmacro all-truthy? [& elements]
  (map #(is-truthy? %) elements))


;(defmacro all-truthy? [& elements]
;(map #(is-truthy? %) elements))

(println (is-truthy? (= 1 1)))

(println (macroexpand '(all-truthy?
                        (= false true)
                        (= 1 1)
                        )))

(println (all-truthy?
               (= false true)
               (= 1 1)
               ))

; (defn test-library-facts []
;   (all-truthy?
;     (= false true)
;     (= 1 1)
;   ))

(println
  (macroexpand-1
    '(all-truthy? (= false true)
                  (= 1 2))))

(print (all-truthy?
         (= false true)
         (= 1 1)
         ))
