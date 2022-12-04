(ns y2022.d04)



(def sample-data-raw
  ["2-4,6-8"
   "2-3,4-5"
   "5-7,7-9"
   "2-8,3-7"
   "6-6,4-6"
   "2-6,4-8"])

(defn get-input []
  (->>
   (clojure.string/split
    (slurp "src/y2022/input-d4.txt")
    #"\n")
   ))


(defn parse-data [lines]
  (->> lines
       (map #(clojure.string/split % #","))
       (map (fn [pair]
              (map #(map read-string (clojure.string/split % #"-")) pair)))))

(def sample-data (parse-data sample-data-raw))
(def input (parse-data (get-input)))

(apply range [1 (inc 4)])

(defn get-range [[a b]]
  (apply range [a (inc b)])
  )

(defn contained [[a b]]
  (or (and (>= (first a) (first b))
           (<= (last a) (last b)))
      (and (>= (first b) (first a))
           (<= (last b) (last a)))
      ))

(contained [[1 2] [2 3]])

(defn sol1 [input]
  (->> input
       (filter contained)
       count))

(sol1 sample-data)
(sol1 input)

(defn overlap [[a b]]
  (or (and (>= (first a) (first b))
           (>= (last b) (first a)))
      (and (>= (first b) (first a))
           (>= (last a) (first b)))
      
      ))

(defn sol2 [input]
  (->> input
       (filter overlap)
       count))

(sol2 sample-data)
(sol2 input)
