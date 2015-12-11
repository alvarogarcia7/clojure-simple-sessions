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

; (defmacro evaluate [expression]
;   {:expression `~@(str `(expression))
;    :b `(~@expression)})
; 
; (defn value-of [expression]
;   (:value expression))

; simple.core=> (evaluate (+ 1 1))
; (+ 1 1)
; 2

; (defmacro all-truthy? [& elements]
;   ~@(let [exprs (map evaluate elements)]
;          (if-let [all-correct (->> exprs (every? (comp identity value-of)))] 
;            {:message "OK"}
;            (let [wrong (->> exprs (filter (comp false? value-of)))]
;              {:message (str "KO - " (count wrong)) :failing wrong}))))
; 
; 
; (defn test-library-facts []
;   (all-truthy?
;     (= false true)
;     (= 1 1)
;   ))