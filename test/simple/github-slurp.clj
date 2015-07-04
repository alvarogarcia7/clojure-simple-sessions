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

(defn get-contents-by-line-number [contents lines]
  (map #(nth contents %) lines))

(defn code [contents & [{lines :lines}]]
  (map #(get-contents-by-line-number contents %) lines))

(def extractedLines (code contents {:lines [(range 1 1) (range 1 1)]}))
extractedLines
(assert (= 2 (count extractedLines)))

(code contents {:lines ['(1) '(2) '(3)]})

(def foo (map println [1 2 3]))
(def foo (doall (map println [1 2 3])))

(map-indexed (fn [idx itm] [idx itm]) '(:f :o))
