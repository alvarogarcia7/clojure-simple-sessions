(defn coin-change [coins amount]
  (if (= (apply + coins) amount)
    coins
    (let [is-amount #(= amount %)]
      (if (= (some is-amount coins))
        (filter is-amount coins)
        '()
        ))))

; need to return all coins
(= (coin-change '(1) 1) '(1))

; not enough coins
(= (coin-change '(1) 2) '())

; a single coin is enough to change but there are other coins available
(= (coin-change '(2 1) 2) '(2))

; two coins needed, but not the sum of them all
(= (coin-change '(2 1 1) 3) '(2 1))

; remaining examples:
; 3 ; 2 1 1 => (2, 1)
; 3 ; 1 1 => ()
; 6 ; 2 2 => ()

