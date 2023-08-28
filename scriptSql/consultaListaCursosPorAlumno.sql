SELECT c.id AS course_id, c.name_course AS name_course
FROM courses c
JOIN student_course sc ON c.id = sc.course_id
WHERE sc.student_id = 1;