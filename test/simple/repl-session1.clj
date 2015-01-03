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


(conj '(:a :b :c :d) :e)

(subvec [:peanut :butter :and :jelly] 1 3)


(defn square[n] (* n n))

(square 4)

((fn [f2] (f2 5))
          (fn [n] (* n n)))

(filter (fn [x] (< x 31)) [10 20 30 40 50 60 70 80])

(count "ab")

(take 100 (iterate repeat :foo))


(take 4 (iterate #(+ 1 %) 0))

(take 12 (iterate #(keyword %) :foo))

(for [x (range 6)]
       x)

(for [row [:top :middle :bottom]
           column [:left :middle :right]]
       )

(vec (for [row [:top :middle :bottom]]
       #(println-str %)))

(let [not-a-symbol? (complement symbol?)]
                  (map not-a-symbol? [:a 'b "c"]))

(let [not-nil? (complement nil?)]
         (filter not-nil? [nil :wheat nil "wheat" nil 'wheat nil]))

(let [not-nil? (complement nil?)]
  not-nil? 'a)

(nil? "a")

((comp #(* 2 %) inc) 4)

(dec 10)
