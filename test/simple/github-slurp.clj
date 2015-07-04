(ns github-slurp
    (:require [clojure.java.io :as io]))
(def file "/Users/alvaro/Documents/sandbox/clojure/simple/test/simple/RegistryShould.txt")
(def file-write "/Users/alvaro/Documents/sandbox/clojure/simple/test/simple/RegistryShould.txt.out")

(defn read-file [file]
  (def contents '())
  (with-open [rdr (io/reader file)]
    (doseq [line (line-seq rdr)]
      (def contents (conj contents line))))
   contents)
(read-file file)

; (def contents (conj contents "aa" "bb"))

contents

; index map, if needed
(map-indexed
 (fn [index content] [index content])
   contents)

(defn lines-cleanup [mess tok]
     (if (empty? tok)
       mess
       (let [removed (map #(clojure.string/replace % (first tok) "") mess)]
        (lines-cleanup removed (rest tok)))))

(defn get-contents-by-line-number [contents lines]
  (map #(nth contents %) lines))

(defn code [contents & [{lines :lines}]]
  (map #(lines-cleanup % '("\t"))
       (map #(get-contents-by-line-number contents %) lines)))
(code contents {:lines [(range 1 4) (range 1 5)]})

(defn write-file [contents filename]
  (with-open [w (clojure.java.io/writer filename :append false)]
    (.write w (clojure.string/join "\n" (flatten contents)))))

(write-file '('(1 2 3 "string") '("hello world!" "lineA" "lineB"))  file-write )

(defn read-slurp-write [file-in config file-out]
  (write-file
   (code (read-file file-in) config) file-out))

(read-slurp-write file {:lines [(range 1 8) (range 2 4)]} file-write)

(take 3 (repeatedly #(->  (rand))))

(def extractedLines (code contents {:lines [(range 1 8) (range 2 4)]}))
extractedLines
(assert (= 2 (count extractedLines)))

; test
(assert
 (=
  (lines-cleanup '("a\taa\t\t\n\n" "bbbb\n\t") ["\t" "\n"])
  '("aaa" "bbbb")))

; (def foo (map println [1 2 3]))
; (def foo (doall (map println [1 2 3])))

(map-indexed (fn [idx itm] [idx itm]) '(:f :o))
