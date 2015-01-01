(def tree
  '(1 2 3 4 5 6))

tree

(first tree)

(first (rest tree))

(def treevector
  (vec tree))

treevector

(defn mysum [ array ]
  (if (empty? array)
    0
    (+ (mysum (rest array)) (first array))))

(mysum [1 2 2 5 10 1])

(empty? '[])

; source: http://stackoverflow.com/questions/24576431/clojure-sum-up-a-bunch-of-numbers
(reduce * tree)

;the output goes to the console, "view->console"
(print 1)

(def tree '(1 '(2)))

(require '[clojure.walk :as w])

;not completed walk
(w/postwalk #(if (number? %) (inc %) %) tree)

(map  #(inc (inc %)) (range 8))

(map  #(inc %) (range 8))

(map  inc (range 8))

(map  #(+ % 4) (range 8))

(map  #(+ % (rand-int 8)) (range 8))

(take 5 (repeatedly #(rand-int 11)))

(defn reduce-random-numbers [amount reduce-operation initial-value]
  (reduce reduce-operation initial-value
          (get-random-numbers amount)))

(defn get-random-numbers [amount]
  (take amount (repeatedly #(rand-int 11))))


(reduce-random-numbers 1 - 1)



