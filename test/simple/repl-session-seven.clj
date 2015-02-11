;; password-kata by @trikitrok
; kata description: https://gist.github.com/trikitrok/9ac2974010b3b32edbe9
; examples: https://gist.github.com/trikitrok/18310b22d0c0add5afe0
(def password-no-upper "aa")

(def password-upper "aA")

(defn contains-uppercase [password-no-upper]

(> (count (filter #(< (int %) (int \a)) (map #(-> %) (str password-no-upper)))) 0))

(contains-uppercase "aA")

