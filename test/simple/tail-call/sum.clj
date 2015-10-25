(ns simple.tail-call
  (:gen-class))

(defn sum_ [higher-bound]
  (loop [sum 0 i higher-bound]
    (if (< i 0)
      sum
      (recur (+ sum i) (dec i)))))
