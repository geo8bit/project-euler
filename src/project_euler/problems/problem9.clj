(ns project-euler.problem9)

;; There exists exactly one Pythagorean triplet for which a + b + c = 1000.
;; Find the product abc.
;;
;; https://projecteuler.net/problem=9

(def result (first (for [a (range 1000)
                         b (range 1000)
                         c (range 1000)
                         :when (and (< a b c)
                                    (= 1000 (+ a b c))
                                    (= (* c c) (+ (* b b) (* a a))))]
                     (* a b c))))