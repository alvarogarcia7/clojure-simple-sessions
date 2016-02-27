;; source = https://www.hackerrank.com/challenges/funny-string/submissions/code/17858583

(use '[clojure.string :only (split triml)])

(defn- is-funny?
  [inp]
  (->> inp
    (map int)
    (#(map vector % (drop 1 %)))
    (map (fn [[a b]] (Math/abs (- a b))))
    (#(= % (reverse %)))))
    
(defn- print-result [b]
  (-> (if b 
         "Funny"
         "Not Funny")
    (println)))

(let [n (Integer/parseInt (read-line) )
      lines (for [i (range n)] (read-line))]
      (->> lines
        (map is-funny?)
        (map print-result)
        doall))