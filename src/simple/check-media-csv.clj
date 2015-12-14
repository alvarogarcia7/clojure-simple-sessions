(require '[clojure.data.csv :as csv]
         '[clojure.java.io :as io])

(def filename "c:/tmp/full.csv")


(with-open [in-file (io/reader filename)]
  (defn parse-int [s]
    (Integer/parseInt (re-find #"\A-?\d+" s)))
  (defn printnums [& nums] (println nums))
  (defn sum-selection [selector set-]
    (reduce + (map #(parse-int (selector %)) set-)))

    (let [contents (doall (csv/read-csv in-file))
           ca (filter #(re-find #"CA" (first %)) contents)
           es (filter #(re-matches #"ES*" (first %)) contents)
         
           val1 (sum-selection second ca)
           val2 (sum-selection #(nth % 3) ca)
           val3 (sum-selection second es)]

           	(printnums val1 val2 val3)
           	(= val1 val2 val3)))