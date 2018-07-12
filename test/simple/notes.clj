(ns simple.notes
  (:use midje.sweet))

(defn group-in-notes-best-effort [amount notes]
  (let [result
        (loop [set []
               amount amount
               notes notes]
          (let [amount-left (- amount (reduce + set))
                candidates (filter #(<= % amount-left) notes)
                selected-note (first candidates)]
            (if (not-empty candidates)
              (recur (conj set selected-note)
                     amount
                     notes)
              set)))
        is-complete (= (reduce + result) amount)
        ]
    {:result      result
     :is-complete is-complete}))

(facts "withdrawing notes, grouping them in a best effort fashion"
  (fact "grouping correctly"
    (group-in-notes-best-effort 50 [50 20]) => {:result [50] :is-complete true}
    (group-in-notes-best-effort 150 [50 20]) => {:result [50 50 50] :is-complete true}
  )
  (fact "grouping when it is not possible with this algorithm"
    (group-in-notes-best-effort 80 [50 20]) => {:result [50 20] :is-complete false}
  )
  (fact "grouping when below the smallest denomination note" 
    (group-in-notes-best-effort 10 [50 20]) => {:result [] :is-complete false}
  )
)

