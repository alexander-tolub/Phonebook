CREATE TABLE PhoneNumber (
  PhoneId INTEGER IDENTITY PRIMARY KEY,
  PhoneType VARCHAR(30) NOT NULL,
  PhoneNumber VARCHAR(30) NOT NULL,
  Comment VARCHAR(30) NOT NULL
) ;

CREATE TABLE Customer (
  CustomerId INTEGER IDENTITY PRIMARY KEY,
  PhoneId INTEGER NOT NULL,
  FirstName VARCHAR(30) NOT NULL,
  LastName VARCHAR(30) NOT NULL,
  Patronymic VARCHAR(30) NOT NULL,
  CONSTRAINT customer_phone_number FOREIGN KEY (PhoneId)
    REFERENCES PhoneNumber(PhoneId)
  ON DELETE CASCADE
) ;

-- Spring Security Tables
CREATE TABLE User (
  id INTEGER IDENTITY PRIMARY KEY,
  username VARCHAR(25) NOT NULL,
  password VARCHAR(60) NOT NULL
) ;

CREATE TABLE Role (
  id INTEGER IDENTITY PRIMARY KEY,
  name VARCHAR(40) NOT NULL
) ;

CREATE TABLE user_role (
  user_id INT NOT NULL,
  role_id INT NOT NULL,

  FOREIGN KEY (user_id) REFERENCES user(id),
  FOREIGN KEY (role_id) REFERENCES role(id),

  UNIQUE (user_id, role_id)
) ;