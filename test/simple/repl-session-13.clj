(def graph-1-node '([1 :R, 2 :G]))

(nth (nth graph-1-node 0) 1)

(def tree-numbers (tree-seq seq? identity '(1 (2))))

(def seq-letters                     '(:A
                                 (:B
                            (:D) (:E))     (:C
                                                (:F))))

(def tree-letters (tree-seq next rest seq-letters))

(map first tree-letters)

(map last tree-letters)

(map first tree-letters)

; symbols or nodes
(def symbols (map #(first %) tree-letters))

symbols

(map identity tree-letters)
; preorder A->B, A->C, B->D => A B D C
(map first (tree-seq next rest '([1 :R] ([2 :G]) ([3 :G]))))

(tree-seq
   first
   nnext seq-letters)
; ((:A (:B (:D) (:E)) (:C (:F))) (:C (:F)))


(tree-seq
   last
   next seq-letters)
; ((:A (:B (:D) (:E)) (:C (:F)))
;  (:B (:D) (:E))
;  (:D)
;  (:E)
;  (:C (:F))
;  (:F))

; OLD SESSION 13

(defn join-by [begin end separator]
  (reduce #(str % separator %2) (map #(str %) (range begin end))))

(join-by 1 10 "/")
; "1/2/3/4/5/6/7/8/9"

(join-by 1 24 "/")
; "1/2/3/4/5/6/7/8/9/10/11/12/13/14/15/16/17/18/19/20/21/22/23"
