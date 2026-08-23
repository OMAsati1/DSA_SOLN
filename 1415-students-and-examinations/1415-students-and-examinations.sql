SELECT s1.student_id, s1.student_name, s2.subject_name, COUNT(e.subject_name) AS attended_exams
FROM students s1
CROSS JOIN subjects s2
LEFT JOIN Examinations e 
    ON e.student_id = s1.student_id AND e.subject_name = s2.subject_name
GROUP BY s1.student_id, s2.subject_name
ORDER BY s1.student_id, s2.subject_name;

-- Synced seamlessly with LeetHub Pro
-- Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
-- Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna