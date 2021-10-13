(ns project-euler.problem4)

;; Find the largest palindrome made from the product of two 3-digit numbers.
;;
;; https://projecteuler.net/problem=4

(defn is-palindrome?
  [n]
  (= (str n) (apply str (reverse (str n)))))

(def result (->> (for [x (range 1000)
                       y (range 1000)
                       :let [prod (* x y)]
                       :when (is-palindrome? prod)]
                   prod)
                 (reduce max)))
