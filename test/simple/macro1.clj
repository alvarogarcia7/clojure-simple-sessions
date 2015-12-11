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
  `(~@(println expression)
    ~@expression))

(defn value-of [expression]
  (:value expression))

; simple.core=> (evaluate (+ 1 1))
; (+ 1 1)
; 2