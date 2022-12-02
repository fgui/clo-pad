;; hy 0.20.0

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
       [10000]]
      )

(defn solve-first-part [data]
  (->> data
       (map (fn[x] (reduce + x)))
       max))

(solve-first-part sample-data)

(defn sort-big-first [l]
  (.sort l :reverse True)
  l)

(defn solve-second-part [data]
  (->> data
       (map (fn [x] (reduce +  x)))
       (list)
       (sort-big-first)
       (take 3)
       (reduce +)
       ))

(solve-second-part sample-data)
