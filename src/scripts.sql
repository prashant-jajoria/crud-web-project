use sampledb;

CREATE TABLE product
(
	id INT(10) AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(20) NOT NULL,
	price INT(5) UNSIGNED NOT NULL,
	brand VARCHAR(20) NOT NULL,
	description VARCHAR(20) NOT NULL
);

INSERT INTO product(name,price,brand,description) VALUES ( "product1" , 1000, "Brand1", "desciption1" );
INSERT INTO product(name,price,brand,description) VALUES ( "product2" , 2000, "Brand2", "desciption2" );
INSERT INTO product(name,price,brand,description) VALUES ( "product3" , 3000, "Brand3", "desciption3" );
INSERT INTO product(name,price,brand,description) VALUES ( "product4" , 4000, "Brand4", "desciption4" );

truncate product; 

select * from product;