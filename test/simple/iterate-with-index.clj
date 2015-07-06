; 2015-07-03

;this code has been featured in this blog post: http://alvarogarcia7.github.io/blog/2015/07/04/iterate-with-index-in-clojure/
(map-indexed (fn [idx itm] [idx itm]) (cons "" '("line1" "line2" "hello")))

(def lines (cons "" '("line1" "line2" "hello")))
(defn get-all [lines indexes]
  (map #(nth lines %) indexes))
(get-all lines '(1 1))


(def lines '("line1" "line2" "hello"))
lines
(defn shift-one [lines]
  (cons "" lines))

(def lines (shift-one lines))
(map-indexed (fn [idx itm] [idx itm])
  lines)
