SELECT c.id AS course_id, c.name_course AS name_course, n.note AS note
FROM courses c
JOIN student_course sc ON c.id = sc.course_id
LEFT JOIN notes n ON c.id = n.course_id AND sc.student_id = n.student_id
WHERE sc.student_id = 1;