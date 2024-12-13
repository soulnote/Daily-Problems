# Write your MySQL query statement below
-- select w1.id
-- from Weather w1 
-- left join Weather w2
-- on w1.recordDate- interval 1 day= w2.recordDate
-- where w1.temperature > w2.temperature;
-- OR

SELECT w1.id 
FROM Weather w1 INNER JOIN Weather w2
WHERE DATEDIFF(w1.recordDate, w2.recordDate) = 1
AND w1.temperature > w2.temperature

-- -- OR

-- SELECT w1.id
-- FROM Weather w1, Weather w2
-- WHERE w1.temperature > w2.temperature
-- AND SUBDATE(w1.recordDate, 1) = w2.recordDate