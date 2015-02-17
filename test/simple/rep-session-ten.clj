(defn coin-change [coins amount]
  (if (= (apply + coins) amount)
    coins
    (if (= (some #(= amount %) coins))
      (filter #(= amount %) coins)
      '()
      )))

; need to return all coins
(= (coin-change '(1) 1) '(1))

; not enough coins
(= (coin-change '(1) 2) '())

; a single coin is enough to change but there are other coins available
(= (coin-change '(2 1) 2) '(2))


