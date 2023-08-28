SELECT s.id AS student_id, s.first_name AS first_name, s.last_name AS last_name
FROM students s
JOIN student_course sc ON s.id = sc.student_id
WHERE sc.course_id = 2;