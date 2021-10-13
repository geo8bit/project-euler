(ns project-euler.problem7
  (:require [project-euler.problem3 :refer [prime-numbers]]))

;; What is the 10001st prime number?
;;
;; https://projecteuler.net/problem=7

(def result (future (nth prime-numbers 10000)))
