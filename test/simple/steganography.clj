(ns simple.steganography
  (:use midje.sweet))

(defn reveal-message
  [message]
    (->> message
         (map #(apply + %))
         (map char )
         (apply str)))

(defn conceal-message
  [plaintext]
    (->> plaintext
         (map int)
         (map #(-> [(- % 2) 2]))))

(facts "decrypting messages"
       (fact "a single-letter message"
             (reveal-message '([115 0])) => "s")
       (fact "a multiple-letter message"
             (reveal-message '([115 0] [101 0] [99 0] [114 0] [101 0] [116 0] [32 0] [109 0] [101 0] [115 0] [115 0] [97 0] [103 0] [101 0])) => "secret message")
       (fact "symbols"
             (reveal-message '([45 2] [45 2] [45 2])) => "///"))

(facts "encrypting messages"
       (fact "a single-letter message"
             (conceal-message "s") => '([113 2]))
       (fact "a multiple-letter message"
             (conceal-message "sss") => '([113 2] [113 2] [113 2])))