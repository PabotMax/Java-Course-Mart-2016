#DROP TABLE common;
#DROP TABLE emails;
#DROP TABLE telephone_numbers;
#DROP TABLE contact;
# DROP TABLE address;
# DROP TABLE contact_telephone;

/*CREATE TABLE address(
  address_id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  country VARCHAR(30) NOT NULL,
  city VARCHAR(20) NOT NULL,
  street VARCHAR(250) NOT NULL,
  house_number INTEGER NOT NULL,
  house_suffix VARCHAR(20) NOT NULL,
  appartment INTEGER NOT NULL,
  post_code INTEGER NOT NULL,
  PRIMARY KEY (address_id)
);

CREATE TABLE contact(
  user_id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  user_firstName VARCHAR(30) NOT NULL,
  user_lastName VARCHAR(20) NOT NULL,
  address_id INTEGER UNSIGNED,
  birthday DATE NOT NULL,
  PRIMARY KEY (user_id),
  FOREIGN KEY (address_id) REFERENCES address(address_id)
    ON DELETE SET NULL
);

CREATE TABLE emails(
  email_id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  user_id INTEGER UNSIGNED NOT NULL,
  email VARCHAR(100) NOT NULL,
  PRIMARY KEY (email_id),
  FOREIGN KEY (user_id) REFERENCES contact(user_id)
    ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE telephone_numbers(
  telephone_number_id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  tel_number VARCHAR(20) NOT NULL,
  PRIMARY KEY (telephone_number_id)
);

CREATE TABLE contact_telephone(
  user_id INTEGER UNSIGNED NOT NULL,
  telephone_number_id INTEGER UNSIGNED NOT NULL,
  PRIMARY KEY (user_id, telephone_number_id),

  FOREIGN KEY (user_id) REFERENCES contact(user_id)
    ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (telephone_number_id) REFERENCES telephone_numbers(telephone_number_id)
    ON DELETE CASCADE ON UPDATE CASCADE
);*/

INSERT INTO address(
  country, city, street, house_number,
  house_suffix, appartment, post_code
) VALUES ('Country','City', 'Street', 10, 'HouseSuffix', 2, 61000);

INSERT INTO contact (
  user_firstName, user_lastName, address_id, birthday
) VALUE ('Ivan', 'Ivanov', 1, '1987-02-03');

INSERT INTO contact (
  user_firstName, user_lastName, address_id, birthday
) VALUE ('Irina', 'Ivanova', 1, '1992-05-08');

INSERT INTO emails (user_id, email) VALUE (1, 'email@a.a');

INSERT INTO telephone_numbers (tel_number) VALUE ('+380991234567');
INSERT INTO telephone_numbers (tel_number) VALUE ('+380557654321');

INSERT INTO contact_telephone (user_id, telephone_number_id) VALUE (1, 1);
INSERT INTO contact_telephone (user_id, telephone_number_id) VALUE (1, 2);


# # Remove from contact table user with specific id
# DELETE FROM contact WHERE user_id = 1;
#
#
# # Remove telephone from table with specific id
# DELETE FROM telephone_numbers WHERE telephone_number_id = 1;
#
#
# # Remove no one telephones
# CREATE TABLE no_one_telephone AS
#   SELECT (telephone_numbers.telephone_number_id)
#   FROM telephone_numbers LEFT OUTER JOIN contact_telephone
#       ON telephone_numbers.telephone_number_id =
#          contact_telephone.telephone_number_id
#   WHERE user_id IS NULL;
#
# DELETE FROM telephone_numbers WHERE telephone_number_id IN(
#   SELECT * FROM no_one_telephone
# );
#
# DROP TABLE no_one_telephone;
#
#
# # Remove from table address with specific id
# DELETE FROM address WHERE address_id = 1;
#
# # Remove no one Address
# CREATE TABLE no_one_address AS
#   SELECT (address.address_id)
#   FROM address LEFT OUTER JOIN contact
#       ON address.address_id =
#          contact.address_id
#   WHERE contact.address_id IS NULL;
#
# DELETE FROM address WHERE address_id IN(
#   SELECT * FROM no_one_address
# );
#
# DROP TABLE no_one_address;
