(defn coin-change
  ([coins amount]
    (if (= (apply + coins) amount)
      coins
      (let [is-amount #(= amount %)]
        (if (some is-amount coins)
          (do
            (println (str coins " " amount))
            (filter is-amount coins))
          (coin-change coins '() amount)
          ))))
  ([remaining-coins used-coins remaining-amount]
   '(2 1)))


; need to return all coins
(= (coin-change '(1) 1) '(1))

; not enough coins
(= (coin-change '(1) 2) '())

; a single coin is enough to change but there are other coins available
(= (coin-change '(2 1) 2) '(2))

; two coins needed, but not the sum of them all
(= (coin-change '(2 1 1) 3) '(2 1))

(coin-change '(2 1 1) '() 3)

; remaining examples:
; 3 ; 2 1 1 => (2, 1)
; 3 ; 1 1 => ()
; 6 ; 2 2 => ()

(filter #(not (even? %)) (range 0 10))
; 1 3 5 7 9
(filter #(even? %) (range 0 10))
; 0 2 4 6 8

; remove first
(filter #(not (= 1 %)) '(1 1 2))

(map char (clojure.string/upper-case "ı vs i."))
(map char (clojure.string/lower-case "İ vs I."))

(map int (clojure.string/upper-case "ıiİI"))
(map int "ıiİI")
(map int (clojure.string/lower-case "İ"))
(map int "İ")

 (clojure.string/lower-case
  (clojure.string/upper-case "ı"))



 (clojure.string/lower-case "ı")
