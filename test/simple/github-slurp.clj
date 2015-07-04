(ns github-slurp
    (:require [clojure.java.io :as io]))
(def file "/Users/alvaro/Documents/sandbox/clojure/simple/test/simple/RegistryShould.txt")
(def contents '())
(with-open [rdr (io/reader file)]
    (doseq [line (line-seq rdr)]
      (->>
       (def contents (conj contents line))
      (println line))))

; (def contents (conj contents "aa" "bb"))

contents

; index map, if needed
(map-indexed
 (fn [index content] [index content])
   contents)

(defn code [contents & [{lines :lines}]]
   (map #(nth contents %) lines))

(code contents {:lines (range 1 4)})

(doseq #(-> %) (vec contents))

(def foo (map println [1 2 3]))
(def foo (doall (map println [1 2 3])))

(map-indexed (fn [idx itm] [idx itm]) '(:f :o))
