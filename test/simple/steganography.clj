(ns simple.steganography
  (:use midje.sweet))

(defn decrypt-message
  [message]
    (apply str
           (map char (map #(apply + %) message))))

(facts "decrypting messages"
       (fact "a single-letter message"
             (decrypt-message '([115 0])) => "s")
       (fact "a multiple-letter message"
             (decrypt-message '([115 0] [101 0] [99 0] [114 0] [101 0] [116 0] [32 0] [109 0] [101 0] [115 0] [115 0] [97 0] [103 0] [101 0])) => "secret message"))