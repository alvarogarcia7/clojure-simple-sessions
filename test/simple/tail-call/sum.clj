(ns simple.tail-call
  (:gen-class))

;; loop/recur
(defn sum_ [higher-bound]
  (loop [sum 0 i higher-bound]
    (if (< i 0)
      sum
      (recur (+ sum i) (dec i)))))

;; immersion method for tail-call recursive
(defn sum-rec2[sum i]
  (if (< i 0)
    sum
    (sum-rec2 (+ sum i) (dec i))))

;; tail-call recursive function
(defn sum-rec [higher-bound]
  (sum-rec2 0 higher-bound))

;; non-tail-recursive function
;; notice the + operation at the end
(defn sum-notc[i]
  (if (< i 0)
    0
    (+ (sum-notc (dec i)) i)))
