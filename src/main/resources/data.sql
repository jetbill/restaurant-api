INSERT INTO restaurant (address, description, image, name) VALUES ("calle 13", "cerca al centro", "no image", "La tortilla");
INSERT INTO restaurant (address, description, image, name) VALUES ("calle 62", "Castilla", "no image", "Neiva");
INSERT INTO restaurant (address, description, image, name) VALUES ("calle 33", "Manrique", "no image", "La Niña");

INSERT INTO turn  (name, restaurant_id) VALUES ("camila", 1);
INSERT INTO turn  (name, restaurant_id) VALUES ("Mario", 2);
INSERT INTO turn  (name, restaurant_id) VALUES ("Juan", 3);

INSERT INTO board  (capacity , number, restaurant_id) VALUES (3,6,1);
INSERT INTO board  (capacity , number,restaurant_id) VALUES (4, 7,2);
INSERT INTO board  (capacity , number,restaurant_id) VALUES (5, 8,3);

INSERT INTO reservation  (`locator`  , turn , person, date) VALUES (1,2,2,"2024-11-08");