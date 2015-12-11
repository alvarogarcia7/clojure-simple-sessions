; copied, modified from http://www.braveclojure.com/writing-macros/

(defn print-and-evaluate
  [code]
  `(println (str (quote ~code) ": " (~@code))))

(defmacro preval
  [& expressions]
  `(do ~@(->>
                 expressions
                 (map criticize-code))))

; usage
; simple.core=> (code-critic (+ 1 1) (1 + 1))
; Sweet lion of Zion, this is bad code: (1 + 1)
; Great cow of Moscow, this is good code: (+ 1 1)
; nil
