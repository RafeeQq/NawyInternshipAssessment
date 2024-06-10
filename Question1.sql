SELECT c.name AS college_name, MIN(r.ranking) AS best_ranking, COUNT(r.studentId) AS student_count
FROM
    colleges c
    JOIN students s ON c.id = s.collegeId
    JOIN rankings r ON s.id = r.studentId
WHERE r.year = 2015 AND r.ranking BETWEEN 1 AND 3
GROUP BY c.name
HAVING COUNT(r.studentId) > 0;
