(ns simple.tail-call
  (:gen-class))

(defn sum_ [higher-bound]
  (loop [sum 0 i higher-bound]
    (if (< i 0)
      sum
      (recur (+ sum i) (dec i)))))

(defn sum-rec2[sum i]
  (if (< i 0)
    sum
    (sum-rec2 (+ sum i) (dec i))))

(defn sum-rec [higher-bound]
  (sum-rec2 0 higher-bound))

(defn sum-notc[i]
  (if (< i 0)
    0
    (+ (sum-notc (dec i)) i)))
