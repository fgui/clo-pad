;; hy 0.25.0
(import hy.pyops [* +]
        functools [reduce]
        cytoolz [take])
(require hyrule [->> -> ap-map])

(setv sample-data
      [[1000
        2000
        3000]
       [4000]
       [5000
        6000]
       [7000
        8000
        9000]
       [10000]])

(defn solve-first-part [data]
  (->> data
       (ap-map (reduce + it))
       max))

(solve-first-part sample-data)

(defn sort-big-first [l]
  (.sort l :reverse True)
  l)

(defn solve-second-part [data]
  (->> data
       (ap-map (reduce + it))
       (list)
       (sort-big-first)
       (take 3)
       (reduce +)))

(solve-second-part sample-data)

(defn get-input[]
  (->>
    (->
      (with [f (open "input-d1.txt" "r")]
        (.read f))
      (.split "\n\n"))
    (ap-map (map int (.split it)))))

(solve-first-part (get-input))
(solve-second-part (get-input))


