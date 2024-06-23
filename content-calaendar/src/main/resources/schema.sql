CREATE TABLE IF NOT EXISTS Content (
  id INTEGER AUTO_INCREMENT,
  title varchar(255) NOT NULL,
  description text,
  status VARCHAR(20) NOT NULL,
  content_type VARCHAR(50) NOT NULL,
  date_created TIMESTAMP NOT NULL,
  date_updated TIMESTAMP,
  url VARCHAR(255),
  primary key (id)
);

INSERT INTO Content(title,description,status,content_type,date_created)
VALUES ('My Spring Data Blog Post','A post about spring data','IDEA','ARTICLE', CURRENT_TIMESTAMP());

INSERT INTO Content(title,description,status,content_type,date_created)
VALUES ('My Second Spring Data Blog Post','A post about spring data using JDBC','COMPLETED','VIDEO', CURRENT_TIMESTAMP());

CREATE TABLE IF NOT EXISTS Course (
  course_id INTEGER AUTO_INCREMENT,
  maximum_capacity INTEGER,
  course_status VARCHAR(20) NOT NULL,
  start_time TIME,
  end_time TIME,
  PRIMARY KEY (course_id)
);

INSERT INTO Course(maximum_capacity, course_status, start_time, end_time)
VALUES (25, 'AVAILABLE', '08:30:00', '10:00:00');

CREATE TABLE IF NOT EXISTS Teacher (
  teacher_id INTEGER AUTO_INCREMENT,
  teacher_name VARCHAR(20),
  PRIMARY KEY (teacher_id)
);

INSERT INTO Teacher(teacher_name)
VALUES ('Amadou Oury Barry');

CREATE TABLE IF NOT EXISTS Teaches (
  teacher_id INTEGER,
  course_id INTEGER,
  PRIMARY KEY (teacher_id, course_id),
  FOREIGN KEY (teacher_id) REFERENCES Teacher(teacher_id),
  FOREIGN KEY (course_id) REFERENCES Course(course_id)
);


INSERT INTO Teaches(teacher_id, course_id)
VALUES (1,1);


CREATE TABLE IF NOT EXISTS Attends (
  student_id INTEGER,
  course_id INTEGER,
  PRIMARY KEY (student_id, course_id),
  FOREIGN KEY (student_id) REFERENCES Student(student_id),
  FOREIGN KEY (course_id) REFERENCES Course(course_id)
);