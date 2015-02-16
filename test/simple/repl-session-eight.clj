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


(defn factorial [n]
  (reduce * (range 1 (inc n))))

; (permutations 1)
; look into http://clojure.github.io/math.combinatorics/
(defn permutation
  ([original] (permutation #{} (factorial (count original)) original))
  ([result expected original]
   (if (= (count result) expected)
     (seq result)
     (recur (conj result (shuffle original)) expected original)
   )))

(permutation #{2 3 1})

(defn split-into-digits
  ([n] (split-into-digits n '()))
  ([n parts]
   (if (= n 0)
     parts
     (recur (quot n 10) (conj parts (rem n 10))))))

(defn join-digits
  ([parts] (join-digits 0 parts))
  ([accumulated parts]
   (if (= (count parts) 0)
     accumulated
     (recur
      (+
       (* accumulated 10)
       (first parts))
      (pop parts)))))

(join-digits '(1 2 3 4 5))
(pop '(1 2 3))
(first '(1 2 3))

(= (split-into-digits 123) '(1 2 3))

(permutation (split-into-digits 123))
(map #(-> (seq %)) (permutation (split-into-digits 123)))
(map #(join-digits %) (seq '(2 3 1) ))

(join-digits '(2 1 3))

(def list-of-lists
  (map #(-> (seq %)) '([1 2 3])))

(seq [1 2 3 ])
(shuffle #{2 3 1})
(conj #{} 2)
(= (count (permutation #{1 2})) 2)
(= (count (permutation #{1 2 3})) 6)


