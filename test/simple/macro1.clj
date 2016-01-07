; copied, modified from http://www.braveclojure.com/writing-macros/

(defn print-and-evaluate
  [code]
  `(println (str `code ": " (~@code))))

(defmacro preval
  [& expressions]
  `(do ~@(->>
           expressions
           (map print-and-evaluate))))

; usage
; simple.core=> (preval (+ 1 1) (* 1 3))
; (+ 1 1): 2
; (* 1 3): 3
; nil

(defmacro evaluate [expression]
  {:expression (str `(~@expression))
   :value      expression})

; (evaluate (= false true))
;=> {:expression "(= false true)", :value false}

(defn value-of [expression]
  (:value expression))

; simple.core=> (evaluate (+ 1 1))
; {:expression "(+ 1 1)", :value 2}

;(defmacro all-truthy2? [& elements]
;  (let [exprs (map #(evaluate %) elements)]
;         (if-let [all-correct (->> exprs (every? (comp identity value-of)))]
;           {:message "OK"}
;           (let [wrong (->> exprs (filter (comp false? value-of)))]
;             {:message (str "KO - " (count wrong)) :failing wrong}))))

;(defmacro all-truthy? [& elements]
;  (map #(evaluate %) elements))


(defmacro report
  [to-try]
  `(let [result# ~to-try]
     (if result#
       {:ok (quote ~to-try) :r result#}
       {:ko (quote ~to-try) :r result#})))

(defmacro doseq-macro
  [macroname & args]
  `(do
     [~@(map (fn [arg] (list macroname arg)) args)]))

;(defmacro report-all
;  [& args]
;  `(do
;     [~@(map #(report %) args)]))
;(macroexpand '(report-all (= 1 1) (= 1 2)))
;=> (do [{:r (= 1 1), :ok p1__7447#} {:r (= 1 2), :ok p1__7447#}])

(report (= 1 1))
(doseq-macro report (= 1 1) (= 1 2))

(macroexpand '(doseq-macro report (= 1 1) (= 1 2)))