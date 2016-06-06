DROP TABLE emails;
DROP TABLE telephone_numbers;
DROP TABLE address;
DROP TABLE contact;

CREATE TABLE contact(
  user_id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  user_firstName VARCHAR(30) NOT NULL,
  user_lastName VARCHAR(20) NOT NULL,
  address_id INTEGER NOT NULL,
  telephone_number_id INTEGER NOT NULL,
  email_id VARCHAR(100) NOT NULL,
  birthday DATE NOT NULL,
  PRIMARY KEY (user_id)
);

CREATE TABLE address(
  address_id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  user_id INTEGER UNSIGNED NOT NULL,
  country VARCHAR(30) NOT NULL,
  city VARCHAR(20) NOT NULL,
  street VARCHAR(250) NOT NULL,
  house_number INTEGER NOT NULL,
  house_suffix VARCHAR(20) NOT NULL,
  appartment INTEGER NOT NULL,
  post_code INTEGER NOT NULL,
  PRIMARY KEY (address_id),
  FOREIGN KEY (user_id) REFERENCES contact(user_id)
    ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE telephone_numbers(
  telephone_number_id INTEGER NOT NULL AUTO_INCREMENT,
  user_id INTEGER UNSIGNED NOT NULL,
  tel_number VARCHAR(20) NOT NULL,
  PRIMARY KEY (telephone_number_id),
  FOREIGN KEY (user_id) REFERENCES contact(user_id)
    ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE emails(
  email_id INTEGER NOT NULL AUTO_INCREMENT,
  user_id INTEGER UNSIGNED NOT NULL,
  email VARCHAR(100) NOT NULL,
  PRIMARY KEY (email_id),
  FOREIGN KEY (user_id) REFERENCES contact(user_id)
    ON DELETE CASCADE ON UPDATE CASCADE
);