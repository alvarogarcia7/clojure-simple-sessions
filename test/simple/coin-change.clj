(comment
  (defn coin-change
    ([amount coins] (coin-change amount coins 0))
    ([amount coins index]
     (cond
       (<= amount 0) 0
       (>= index (dec (count coins))) (do (println index) 1)
       :default (+
                  (let [first-coin (first coins)
                        rest-coins (vec (rest coins))
                        left (- amount (nth coins index))]
                    (coin-change amount coins (inc index))
                    (coin-change left coins index)))))))
 
(defn coins [])
(defn add-coin [state]
  (let [remaining (:rem state)]
    (->> coins
         (filter #(>= remaining %))
         (map #(-> {:coins (conj (:coins state) %)
                    :rem   (- remaining %)})))))
 
(def results (atom []))
 
(defn s [state]
  (->> state
       (map add-coin)
       flatten
       (group-by #(= 0 (:rem %)))
       ((fn [{matching true not-matching false}]
          (do (if matching
                (swap! results conj matching))
              not-matching)))))
 
(defn coin-change [amount coins]
  (def results (atom []))
  (def coins coins)
  (loop [state (list {:rem amount :coins []})]
    (let [x (s state)]
      (if (not (empty? x))
        (recur x)
        nil)))
  (->> @results
       flatten
       (map :coins)))
 
 
  (coin-change 6 [1 5 10])
