CREATE TABLE IF NOT EXISTS Content (
  id INTEGER AUTO_INCREMENT,
  title varchar(255) NOT NULL,
  desc text,
  status VARCHAR(20) NOT NULL,
  content_type VARCHAR(50) NOT NULL,
  date_created TIMESTAMP NOT NULL,
  date_updated TIMESTAMP,
  url VARCHAR(255),
  primary key (id)
);

INSERT INTO Content(title,desc,status,content_type,date_created)
VALUES ('My Spring Data Blog Post','A post about spring data','IDEA','ARTICLE', CURRENT_TIMESTAMP());

INSERT INTO Content(title,desc,status,content_type,date_created)
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
