(def coins [1 5 10 25 50])

(defn coin-change
  ([amount coins] (coin-change amount coins 0))
  ([amount coins index]
   (cond
    (< amount 0) 0
    (>= index (dec (count coins))) (do (println index) 1)
    :default (+
     (let [first-coin (first coins)
           rest-coins (vec (rest coins))
           left (- amount (nth coins index))]
       (coin-change amount coins (inc index))
       (coin-change left coins index))))))

(coin-change 5 coins)

(nth coins 2)
(dec (count coins))
