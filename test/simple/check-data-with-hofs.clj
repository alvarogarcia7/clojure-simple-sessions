(def data [
           ["total" 6 8 13]
           ["0"     1 2 3]
           ["0"     2 0 4]
           ["0"     3 0 6]
          ])

(defn sum-eq-total [selector dataset]
  (letfn [(total-and-rest [coll]
             [(first coll) (rest coll)])]
  (let [[total rest-dataset] (total-and-rest dataset)
        selected-total (selector total)
        selected-column (map selector rest-dataset)
        sum-of-column (reduce + selected-column)]
        (= selected-total sum-of-column))))

(defn validate-columns [indices data]
  (let [generate-selector #(fn [dataset] (nth dataset %))
         selectors (map generate-selector indices)
         check-selector #(sum-eq-total % data)]
         (map check-selector selectors)))

; usage (validate-columns [1 3] data)
