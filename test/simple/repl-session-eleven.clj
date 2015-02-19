; factorial
; formal definition
; f(0) = 1
; f(n) = n * f(n-1) ; n > 0

(defn factorial [n]
  (if (<= n 1)
    1
    n))

(= (factorial 0) 1)
(= (factorial 2) 2)
