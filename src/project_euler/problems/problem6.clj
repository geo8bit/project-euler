(ns project-euler.problem6)

;; Find the difference between the sum of the squares of the first 
;; one hundred natural numbers and the square of the sum.
;;
;; https://projecteuler.net/problem=6

(defn sum-of-squares
  [n]
  (->> (range n)
       (map inc)
       (map #(* % %))
       (reduce +)))

(defn square-of-sums
  [n]
  (Math/pow (->> (range n)
                 (map inc)
                 (reduce +))
            2))

(def result (biginteger (- (square-of-sums 100) (sum-of-squares 100))))