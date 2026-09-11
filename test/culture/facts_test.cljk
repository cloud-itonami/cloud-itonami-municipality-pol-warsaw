(ns culture.facts-test
  (:require [clojure.edn :as edn]
            [kotoba.lang.text :as str]
            [clojure.test :refer [deftest is]]
            [culture.facts :as facts]))

(deftest warsaw-has-culture-basis
  (let [sb (facts/spec-basis "warsaw")]
    (is (= 9 (count sb)))
    (is (= (count sb) (count (set (map :culture/id sb)))))
    (is (every? #(str/starts-with? (:culture/url %) "https://") sb))
    (is (every? #(= "warsaw" (:culture/municipality %)) sb))
    (is (every? #(= "POL" (:culture/country %)) sb))
    (is (every? #(seq (:culture/summary %)) sb))
    (is (every? #(string? (:culture/retrieved-at %)) sb))))

(deftest unknown-municipality-has-no-basis
  (is (nil? (facts/spec-basis "krakow")))
  (is (nil? (facts/spec-basis "zzz"))))

(deftest coverage-is-honest
  (let [c (facts/coverage ["warsaw" "krakow"])]
    (is (= 2 (:requested c)))
    (is (= 1 (:covered c)))
    (is (= ["krakow"] (:missing-municipalities c)))))

(deftest by-kind-filters
  (is (= 3 (count (facts/by-kind "warsaw" :dish))))
  (is (= ["warsaw.beverage.zubrowka"]
         (mapv :culture/id (facts/by-kind "warsaw" :beverage))))
  (is (empty? (facts/by-kind "warsaw" :craft)))
  (is (empty? (facts/by-kind "krakow" :dish))))

(deftest tx-file-matches-catalog
  (let [tx (edn/read-string (slurp "data/culture-tx.edn"))
        flat (mapcat val (sort-by key facts/catalog))]
    (is (= (vec flat) (vec tx)))))
