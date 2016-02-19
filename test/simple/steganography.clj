(ns simple.steganography
  (:use midje.sweet))

(defn decrypt-message
  [message]
    (->> message
         (map #(apply + %))
         (map char )
         (apply str)))

(defn encrypt-message
  [plaintext]
    (->> plaintext
         (map int)
         (map #(-> [(- % 2) 2]))))

(facts "decrypting messages"
       (fact "a single-letter message"
             (decrypt-message '([115 0])) => "s")
       (fact "a multiple-letter message"
             (decrypt-message '([115 0] [101 0] [99 0] [114 0] [101 0] [116 0] [32 0] [109 0] [101 0] [115 0] [115 0] [97 0] [103 0] [101 0])) => "secret message"))

(facts "encrypting messages"
       (fact "a single-letter message"
             (encrypt-message "s") => '([113 2])))