
SELECT s.id AS student_id, s.first_name AS first_name, s.last_name AS last_name, c.id AS course_id, c. name_course AS  name_course, n.note AS note
FROM students s
JOIN student_course sc ON s.id = sc.student_id
JOIN courses c ON sc.course_id = c.id
LEFT JOIN notes n ON s.id = n.student_id AND c.id = n.course_id
WHERE n.note IS NOT NULL;