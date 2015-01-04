;20150103-1817 AGB

(= '(1 2 3)
   (list 1 2 3))


(#(print-str % %2) "a" "b")

(defn square [x] (* x x))

(defn double [function x]
  (function(function x)))

(double #(+ % 3) 7)

(map #(* 3 %)
     (filter even? [1 2 3 4 5]))


(defn sum-of-n-until [n]
  (/
   (*
      n
     (+ n 1))
    2))

(sum-of-n-until 5)

      (+ (sum-of-n-until 10) (* 9 5))


(=
  (->> (range 10) (map inc) (interpose 5) (reduce +))
  (+ (sum-of-n-until 10) (* 9 5)))

(->> '(3 3 6) (reduce +) '(3) (reduce - 0))

; the first five odd numbers, generated as 2*n+1
(->>
   (range)
   (map #(* %1 2))
   (map inc)
   (take 5)
   )

'(0 1 2 3 4)
'(0 2 4 6 8)
'(1 3 5 7 9)

(take 5
    (map inc
     (map #(* % 2)
          (range))))

(inc 3)


(defn oddify [n]
  (+
   (* 2 n)
   1))


(take 5 (map oddify (range))) ;(1 3 5 7 9)

(->>
 (range)
 (map oddify)
 (take 5)) ;(1 3 5 7 9)


(* 2 5)

