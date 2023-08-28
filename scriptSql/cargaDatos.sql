
-- Carga de Datos

-- DATOS PROFESORES
INSERT INTO teachers (document_type, document_number, first_name, last_name, birthdate, current_address, sex, phone, soft_delete)
VALUES ('DNI', '12345678', 'Juan', 'Pérez', '1980-01-15', 'Calle 123', 'MALE', '1234567890',  0);
INSERT INTO teachers (document_type, document_number, first_name, last_name, birthdate, current_address, sex, phone, soft_delete)
VALUES ('DNI', '36984576', 'Cristina', 'Sanchez', '1950-05-06', 'Av. Sarmiento 456', 'FEMALE', '316452987', 0);

-- DATOS CURSOS
INSERT INTO courses (name_course, duration_hours, description_contento, note_approval, soft_delete, teacher_id)
VALUES ('Programación Java', 40, 'Introducción a la programación en Java', 6, 0,1);
INSERT INTO courses (name_course, duration_hours, description_contento, note_approval, soft_delete, teacher_id)
VALUES ('Bases de Datos', 30, 'Conceptos básicos de bases de datos', 5, 0,2);

-- DATOS ESTUDIANTES
INSERT INTO students (document_type, document_number, first_name, last_name, birthdate, current_address, sex, phone, soft_delete)
VALUES ('DNI', '11458965', 'Carolina', 'Gomez', '1990-08-15', 'San Lorenzo 1099','FEMALE', '3814859684', 0);
INSERT INTO students (document_type, document_number, first_name, last_name, birthdate, current_address, sex, phone, soft_delete)
VALUES ('DNI', '33854968', 'Lucia', 'Armas', '1987-02-06', 'Av. 24 Septiembre 456', 'FEMALE', '314859684', 0);

-- Tabla CAPACITACIONES
INSERT INTO trainings (teacher_id, name_trainings)
VALUES (1, 'Desarrollo Web');
INSERT INTO trainings (teacher_id, name_trainings)
VALUES (2, 'Inteligencia Artificial');

-- Tabla TITULO
INSERT INTO titles (teacher_id, name_titles)
VALUES (2, 'Ingenieria Informatica');

-- DATOS NOTAS
INSERT INTO notes (student_id, course_id, note, soft_delete)
VALUES (1, 1, 10, 0);
INSERT INTO notes (student_id, course_id, note, soft_delete)
VALUES (1, 2, 9, 0);
INSERT INTO notes (student_id, course_id, note, soft_delete)
VALUES (2, 2, 7, 0);

-- DATOS STUDIANTES Y CURSOS (Tabla intermedia)
INSERT INTO student_course (student_id, course_id)
VALUES (1, 1);
INSERT INTO student_course (student_id, course_id)
VALUES (1, 2);
INSERT INTO student_course (student_id, course_id)
VALUES (2, 2);
