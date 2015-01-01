;http://macromancy.com/2014/01/16/data-structures-clojure-singly-linked-list.html
; http://macromancy.com/2014/04/09/data-structures-clojure-trees.html
(definterface INode
  (getLeft [])
  (getRight [])
  (toString []))

(deftype Node
  [key
   val
   ^:volatile-mutable ^INode left
   ^:volatile-mutable ^INode right]

  INode
  (getLeft [_] left)
  (getRight [_] right)
  (toString [_] (str
                 (if (not (is-null? left)) (.toString left))
                 " "
                 (default-string-on-nil val "")
                 " "
                 (if (not (is-null? right)) (.toString right))
            )))

(defn bst [& [k v]] (Node. k v nil "b"))

(def tree (bst (bst :foo 1 2) :bar))

(.getRight tree)

(print (.toString tree))

(str
 "a" "b")

(defn is-null? [value]
  (>= 0 (compare value nil)))

(defn default-string-on-nil [value default]
  (if (is-null? value) default value))

(default-string-on-nil nil "default")


(compare "a"
         nil)
