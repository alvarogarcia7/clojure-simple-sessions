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
