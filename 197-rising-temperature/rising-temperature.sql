SELECT w2.id
FROM Weather w1
JOIN Weather w2
  ON DATEDIFF(w2.recordDate, w1.recordDate) = 1
WHERE w2.temperature > w1.temperature;

-- OR


-- SELECT w1.id 
-- FROM Weather w1 INNER JOIN Weather w2
-- WHERE DATEDIFF(w1.recordDate, w2.recordDate) = 1
-- AND w1.temperature > w2.temperature

-- -- OR

-- SELECT w1.id
-- FROM Weather w1, Weather w2
-- WHERE w1.temperature > w2.temperature
-- AND SUBDATE(w1.recordDate, 1) = w2.recordDate