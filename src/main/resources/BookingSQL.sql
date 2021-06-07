drop database if exists bookingdb;

CREATE DATABASE IF NOT EXISTS bookingdb;

USE bookingdb;

DROP TABLE IF EXISTS reservation;
DROP TABLE IF EXISTS room;
DROP TABLE IF EXISTS review;
DROP TABLE IF EXISTS amenity;
DROP TABLE IF EXISTS hotel;
DROP TABLE IF EXISTS customer;

CREATE TABLE IF NOT EXISTS customer
(
    cus_id INT NOT NULL AUTO_INCREMENT,
    cus_name VARCHAR(50) NOT NULL,
    cus_gender VARCHAR(25) NOT NULL,
    cus_dob DATE NOT NULL,
    cus_bio VARCHAR(200) NOT NULL,
    PRIMARY KEY (cus_id)
)ENGINE=InnoDB AUTO_INCREMENT=1;

CREATE TABLE IF NOT EXISTS hotel
(
    hot_id INT NOT NULL AUTO_INCREMENT,
    hot_name VARCHAR(50) NOT NULL,
    hot_email VARCHAR(100) NOT NULL,
    hot_address VARCHAR(200) NOT NULL,
    hot_city VARCHAR(200) NOT NULL,
    hot_rating INT,
    CHECK (hot_rating BETWEEN 0 AND 5),
    PRIMARY KEY (hot_id)
)ENGINE=InnoDB AUTO_INCREMENT=1;

CREATE TABLE IF NOT EXISTS amenity
(
    hot_id INT NOT NULL,
    ame_wifi BOOLEAN NOT NULL,
    ame_restaurant BOOLEAN NOT NULL,
    ame_ac BOOLEAN NOT NULL,
    ame_breakfast BOOLEAN NOT NULL,
    ame_pool BOOLEAN NOT NULL,
    ame_gym BOOLEAN NOT NULL,
    PRIMARY KEY (hot_id),
    FOREIGN KEY (hot_id) REFERENCES hotel(hot_id)
)ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS review
(
    rev_id INT NOT NULL AUTO_INCREMENT,
    rev_comment VARCHAR(200) NOT NULL,
    rev_rating INT NOT NULL,
    cus_id INT NOT NULL,
    hot_id INT NOT NULL,
    PRIMARY KEY (rev_id),
    CHECK (rev_rating BETWEEN 0 AND 10),
    FOREIGN KEY (cus_id) REFERENCES customer(cus_id),
    FOREIGN KEY (hot_id) REFERENCES hotel(hot_id)
)ENGINE=InnoDB AUTO_INCREMENT=1;

CREATE TABLE IF NOT EXISTS room
(
    roo_id INT NOT NULL AUTO_INCREMENT,
    roo_type VARCHAR(50) NOT NULL,
    roo_price NUMERIC(10,2) NOT NULL,
    hot_id INT NOT NULL,
    PRIMARY KEY (roo_id),
    FOREIGN KEY (hot_id) REFERENCES hotel(hot_id)
)ENGINE=InnoDB AUTO_INCREMENT=1;

CREATE TABLE IF NOT EXISTS reservation
(
    res_id INT NOT NULL AUTO_INCREMENT,
    res_date DATE NOT NULL,
    res_checkin DATE NOT NULL,
    res_checkout DATE NOT NULL,
    cus_id INT NOT NULL,
    roo_id INT NOT NULL,
    CHECK (res_checkin <= res_checkout),
    PRIMARY KEY (res_id),
    FOREIGN KEY (cus_id) REFERENCES customer(cus_id),
    FOREIGN KEY (roo_id) REFERENCES room(roo_id)
)ENGINE=InnoDB AUTO_INCREMENT=1;


INSERT INTO `bookingdb`.`customer` (`cus_name`, `cus_gender`, `cus_dob`, `cus_bio`) VALUES ( 'Arun', 'Male', '2019-12-21', 'Enjoying  Vacation');
INSERT INTO `bookingdb`.`customer` (`cus_name`, `cus_gender`, `cus_dob`, `cus_bio`) VALUES ( 'Sharadha', 'Female', '1995-05-11', 'Books Enthusiast');
INSERT INTO `bookingdb`.`customer` (`cus_name`, `cus_gender`, `cus_dob`, `cus_bio`) VALUES ('Sahil', 'Male','1995-07-15', 'The person you wanna meet');
INSERT INTO `bookingdb`.`customer` (`cus_name`, `cus_gender`, `cus_dob`, `cus_bio`) VALUES ('Khush', 'Female', '1998-02-22', 'Shayarana');

INSERT INTO `bookingdb`.`hotel` ( `hot_name`, `hot_email`, `hot_address`,`hot_city`,`hot_rating`) VALUES ('Ambians', 'ambians@gmail.com','', 'delhi',5);
INSERT INTO `bookingdb`.`hotel` (`hot_name`, `hot_email`, `hot_address`,`hot_city`,`hot_rating`) VALUES ('Clarks suits', 'clarkssuits@gmail.com','', 'gurgaon',4);
INSERT INTO `bookingdb`.`hotel` (`hot_name`, `hot_email`, `hot_address`,`hot_city`,`hot_rating`) VALUES ('Radiant', 'radiant@gmail.com','', 'delhi',4);
INSERT INTO `bookingdb`.`hotel` (`hot_name`, `hot_email`, `hot_address`,`hot_city`,`hot_rating`) VALUES ('Golden grand', 'goldengrand@gmail.com', '','delhi',3);

INSERT INTO `bookingdb`.`amenity` (`hot_id`, `ame_wifi`, `ame_restaurant`, `ame_ac`, `ame_breakfast`, `ame_pool`, `ame_gym`) VALUES (1,true, true,true,true, true, true);
INSERT INTO `bookingdb`.`amenity` (`hot_id`, `ame_wifi`, `ame_restaurant`, `ame_ac`, `ame_breakfast`, `ame_pool`, `ame_gym`) VALUES (2,true, false,true,true, true, false);
INSERT INTO `bookingdb`.`amenity` (`hot_id`, `ame_wifi`, `ame_restaurant`, `ame_ac`, `ame_breakfast`, `ame_pool`, `ame_gym`) VALUES (4,true, true,false,true, false, true);
INSERT INTO `bookingdb`.`amenity` (`hot_id`, `ame_wifi`, `ame_restaurant`, `ame_ac`, `ame_breakfast`, `ame_pool`, `ame_gym`) VALUES (3,true, true,true,false, true, true);

INSERT INTO `bookingdb`.`review` (`rev_comment`, `rev_rating`, `cus_id`, `hot_id`) VALUES ('Best Hotel',  8, 1, 1);
INSERT INTO `bookingdb`.`review` ( `rev_comment`, `rev_rating`, `cus_id`, `hot_id`) VALUES ('Good Hotel',  7, 3, 2);
INSERT INTO `bookingdb`.`review` (`rev_comment`, `rev_rating`, `cus_id`, `hot_id`) VALUES ('Average Hotel', 6,2,3);
INSERT INTO `bookingdb`.`review` (`rev_comment`, `rev_rating`, `cus_id`, `hot_id`) VALUES ('Not recormended', 5,4,4);

INSERT INTO `bookingdb`.`room` ( `roo_type`, `roo_price`, `hot_id`) VALUES ('Deluxe', 15000, 1);
INSERT INTO `bookingdb`.`room` (`roo_type`, `roo_price`, `hot_id`) VALUES ('HoneyMoonSweet', 15000, 1);
INSERT INTO `bookingdb`.`room` (`roo_type`, `roo_price`, `hot_id`) VALUES ('Queen', 15000, 3);
INSERT INTO `bookingdb`.`room` ( `roo_type`, `roo_price`, `hot_id`) VALUES ('Deluxe', 15000, 1);
INSERT INTO `bookingdb`.`room` (`roo_type`, `roo_price`, `hot_id`) VALUES ('HoneyMoonSweet', 10000, 2);
INSERT INTO `bookingdb`.`room` (`roo_type`, `roo_price`, `hot_id`) VALUES ('Queen', 10000, 2);
INSERT INTO `bookingdb`.`room` ( `roo_type`, `roo_price`, `hot_id`) VALUES ('Deluxe', 10000, 1);
INSERT INTO `bookingdb`.`room` (`roo_type`, `roo_price`, `hot_id`) VALUES ('HoneyMoonSweet', 5000, 2);
INSERT INTO `bookingdb`.`room` (`roo_type`, `roo_price`, `hot_id`) VALUES ( 'Queen', 5000, 3);

INSERT INTO `bookingdb`.`reservation` ( `res_date`, `res_checkin`, `res_checkout`,`cus_id`,`roo_id`) VALUES ('2021-07-06' ,'2021-07-10','2021-07-14',3,2);
INSERT INTO `bookingdb`.`reservation` ( `res_date`, `res_checkin`, `res_checkout`,`cus_id`,`roo_id`) VALUES ('2021-07-07' ,'2021-07-11','2021-07-15',4,3);
INSERT INTO `bookingdb`.`reservation` ( `res_date`, `res_checkin`, `res_checkout`,`cus_id`,`roo_id`) VALUES ('2021-07-08' ,'2021-07-12','2021-07-16',1,1);
INSERT INTO `bookingdb`.`reservation` ( `res_date`, `res_checkin`, `res_checkout`,`cus_id`,`roo_id`) VALUES ('2021-07-09' ,'2021-07-13','2021-07-17',2,1);


