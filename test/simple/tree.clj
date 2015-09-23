(defn mktree
  ([label l r] (cons label (cons l r)))
  ([leaf] (cons leaf (cons nil nil))))
(defn getlabel [t] (first t))
(defn getchildren [t] (rest t))
(defn getleft [t] (first (getchildren t)))
(defn getright [t] (rest (getchildren t)))
(defn find_ [t node]
  (let [root (getlabel t)]
    (cond
      (nil? t) []
      (== root node) node
      (<  root node) (find_ (getleft t) node)
      (>  root node) (find_ (getright t) node))))

(def t123
  (mktree 1 (mktree 2) (mktree 3)))

t123

(find_ t123 5)
t123
(def t1234 (add t123 3 4))
t1234

(defn sum [tree]
  (if (empty? tree) 0
  (reduce +
          [(first tree)
           (sum (getleft tree))
           (sum (getright tree))]
          )))
(sum t123)

(spit "test/simple/persisted-tree.t.clj" t123)
(def t (read-string (slurp "test/simple/persisted-tree.t.clj")))

(sum t)
(= t t123)
