(defn coin-change [coins amount]
  (if (= (apply + coins) amount)
    coins
    '()
    ))

; need to return all coins
(= (coin-change '(1) 1) '(1))

; not enough coins
(= (coin-change '(1) 2) '())
