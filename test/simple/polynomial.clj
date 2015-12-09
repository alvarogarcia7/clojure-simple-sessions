(defn eva [polynomial x]
  (println polynomial)
  (map #(if (= :x %) x %) [:x])
  0)

(defn all-truthy? [& elements]
  (every? identity elements))

(defn facts []
  (all-truthy?
    (= 0 (eva [0] 1)
    (= 1 (eva [:x] 1)))))