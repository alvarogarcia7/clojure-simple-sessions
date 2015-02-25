; factorial
; formal definition
; f(0) = 1
; f(n) = n * f(n-1) ; n > 0

; http://stackoverflow.com/questions/8767627/how-do-i-avoid-arithmeticexception-integer-overflow-in-clojure
; use one of the auto-promoting math functions:+', -', *', /', inc', dec'
(defn fact [x]
    (loop [n x f 1]
        (if (= n 1)
            f
            (recur (dec n) (* f n)))))

(def factorial [x]
  (fact x) )

(= (factorial 0) 1)
(= (factorial 1) 1)
(= (factorial 2) 2)
(= (factorial 3) 6)
(= (factorial 25) 15511210043330985984000000N)

; a number bigger than the stack
(factorial 10000)
