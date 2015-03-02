(defn join-by [begin end separator]
  (reduce #(str % separator %2) (map #(str %) (range begin end))))

(join-by 1 10 "/")
; "1/2/3/4/5/6/7/8/9"

(join-by 1 24 "/")
; "1/2/3/4/5/6/7/8/9/10/11/12/13/14/15/16/17/18/19/20/21/22/23"
