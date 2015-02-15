; project euler - 35
; https://projecteuler.net/problem=35

(rem 5 4)
; remainder => 1

(quot 2 4)
; 0
(quot 10 5)

; multiples of 2 from 2..6
(filter #(= (rem % 2) 0) (range 2 7))

; divisors of 6
(filter #(= (rem 6 %) 0) (range 1 7))

(defn divisors-of [m]
  (filter #(= (rem m %) 0) (range 1 (inc m))))

(divisors-of 8)

(defn is-prime [n]
  (=
   (count (divisors-of n))
   2))

(= (is-prime 1) false)
(= (is-prime 2) true)

; (permutations 1)
; look into http://clojure.github.io/math.combinatorics/


