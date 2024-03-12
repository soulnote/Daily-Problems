SELECT e.name
FROM Employee AS e 
INNER JOIN Employee m ON e.id = m.managerId 
GROUP BY m.managerId 
HAVING COUNT(m.managerId) >= 5