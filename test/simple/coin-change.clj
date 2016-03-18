;; TODO: do not depend on global variables @result / coins
;; TODO: remove duplicated ways of retunrning change

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
