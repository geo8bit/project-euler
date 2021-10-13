(ns project-euler.problems.problem1)

;; Find the sum of all the multiples of 3 or 5 below 1000.
;; 
;; https://projecteuler.net/problem=1

(def multiples-of (fn [n] (iterate (partial + n) n)))

(def multiples-of-3 (take-while (partial > 1000) (multiples-of 3)))
(def multiples-of-5 (take-while (partial > 1000) (multiples-of 5)))

(def result (->> multiples-of-3
                 (concat multiples-of-5)
                 (distinct)
                 (reduce +)))
