(+ 1 1)

(+ 2 1)

'()
(conj '() 1)
(conj '(3) 1)
(conj '(1) 2)
(second [1 2 3])
(def listt '(1 2 3))
(cons 4 listt)
(map dec '(650000000000000000000000000000 2 3))

(fizBuzz 3)



(defn fizBuzz[n] (map convertToFizz (range 1 (+ 1 n))))
(defn convertToFizz[n] (if (= (rem n 3) 0) 'Fizz n))
(fizBuzz 4)

(map inc (range 1 15))
(if (= (rem 10 3) 0) true false)
(if false true false)

(rem 10 3)
(= 0 0)

(= 0 1)
