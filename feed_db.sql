-- Création table users
CREATE TABLE users (
    user_id INT PRIMARY KEY IDENTITY,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    is_admin BIT NOT NULL DEFAULT 0
);

-- Jeu d'essai
INSERT INTO users (username, password, email, is_admin)
VALUES ('user', '1234', 'pikachu@gmail.com', 0),
       ('charmander_fan', 'charmander123', 'charmander@gmail.com', 0),
       ('bulbasaur_fan', 'bulbasaur123', 'bulbasaur@gmail.com', 0),
       ('pokemon_admin', 'pokemon456', 'pokemon_admin@gmail.com', 1);

-- Création table auctions
CREATE TABLE auctions (
  auction_id INT PRIMARY KEY IDENTITY,
  item_name VARCHAR(255) NOT NULL,
  item_description VARCHAR(MAX) NOT NULL,
  starting_bid DECIMAL(18,2) NOT NULL,
  current_bid DECIMAL(18,2) NOT NULL,
  start_time DATETIME NOT NULL,
  end_time DATETIME NOT NULL,
  seller_id INT NOT NULL,
  buyer_id INT,
  is_closed BIT NOT NULL DEFAULT 0,
  FOREIGN KEY (seller_id) REFERENCES users(user_id),
  FOREIGN KEY (buyer_id) REFERENCES users(user_id)
);

-- Jeu d'essai
INSERT INTO auctions (item_name, item_description, starting_bid, current_bid, start_time, end_time, seller_id, buyer_id, is_closed)
VALUES ('Pikachu Plush Toy', 'This is a Pikachu plush toy in excellent condition.', 19.99, 19.99, '2022-12-10 10:00:00', '2022-12-17 10:00:00', 1, NULL, 0),
       ('Charizard Figure', 'This is a Charizard figure from the first edition of the Pokemon card game.', 59.99, 59.99, '2022-12-10 11:00:00', '2022-12-17 11:00:00', 2, NULL, 0),
       ('Pokemon Box Set', 'This box set includes the first three seasons of the Pokemon anime on DVD.', 29.99, 29.99, '2022-12-10 12:00:00', '2022-12-17 12:00:00', 3, NULL, 0);