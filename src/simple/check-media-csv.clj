(require '[clojure.data.csv :as csv]
         '[clojure.java.io :as io])

(def filename "c:/tmp/full.csv")


(with-open [in-file (io/reader filename)]
  (defn parse-int [s]
    (Integer/parseInt (re-find #"\A-?\d+" s)))
  (defn printnums [& nums] (println nums))
  (defn sum-selection [set- selector]
    (reduce + (map #(parse-int (selector %)) set-)))

    (let [contents (doall (csv/read-csv in-file))
           ca (filter #(re-find #"CA" (first %)) contents)
           es (filter #(re-matches #"ES*" (first %)) contents)
         
           val1 (sum-selection ca second)
           val2 (sum-selection ca #(nth % 3))
           val3 (sum-selection es second)]

           	(printnums val1 val2 val3)
           	(= val1 val2 val3)))