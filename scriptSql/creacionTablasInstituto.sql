-- Creación de la base de datos
CREATE DATABASE institute ;

USE institute;

-- Creacion de las tablas

-- Tabla PROFESORES
CREATE TABLE teachers (
    id bigint PRIMARY KEY AUTO_INCREMENT,
    document_type VARCHAR(255),
    document_number VARCHAR(255),
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    birthdate DATE,
    current_address VARCHAR(255),
    sex enum('MALE','FEMALE') ,
    phone VARCHAR(50),
    soft_Delete BOOLEAN 
);

-- Tabla CURSOS
CREATE TABLE courses (
    id bigint PRIMARY KEY AUTO_INCREMENT,
    name_course VARCHAR(255),
    duration_hours INT,
    description_contento TEXT,
    note_approval INT,
    soft_delete BOOLEAN,
    teacher_id bigint,
    FOREIGN KEY (teacher_id) REFERENCES teachers(id)
);

-- Tabla ESTUDIANTES
CREATE TABLE students (
    id bigint PRIMARY KEY AUTO_INCREMENT,
    document_type VARCHAR(255),
    document_number VARCHAR(255),
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    birthdate DATE,
    current_address VARCHAR(255),
    sex enum('MALE','FEMALE') ,
    phone VARCHAR(50),
    soft_Delete BOOLEAN 
);

-- Tabla STUDIANTES Y CURSOS (Tabla intermedia)
CREATE TABLE student_course (
    student_id BIGINT,
    course_id BIGINT,
    PRIMARY KEY (student_id, course_id),
    FOREIGN KEY (student_id) REFERENCES students(id),
    FOREIGN KEY (course_id) REFERENCES courses(id)
);

-- Tabla NOTAS
CREATE TABLE notes (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    student_id BIGINT,
    course_id BIGINT,
    note INT,
    soft_Delete BOOLEAN,
    FOREIGN KEY (student_id) REFERENCES students(id),
    FOREIGN KEY (course_id) REFERENCES courses(id)
);

-- Tabla CAPACITACIONES
CREATE TABLE trainings (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    teacher_id BIGINT,
    name_trainings VARCHAR(100),
    FOREIGN KEY (teacher_id) REFERENCES teachers(id)
);

-- Tabla TITULO
CREATE TABLE titles (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    teacher_id BIGINT,
    name_titles VARCHAR(100),
    FOREIGN KEY (teacher_id) REFERENCES teachers(id)
);