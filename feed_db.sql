-- Création table users
CREATE TABLE users (
    user_id INTEGER PRIMARY KEY NOT NULL,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    is_admin BIT NOT NULL DEFAULT 0
);

-- Ajout d'entrées d'exemple
INSERT INTO users (user_id, username, password, email, is_admin)
VALUES (1, 'user', '1111', 'user@example.com', 0),
       (2, 'user2', '1111', 'user2@example.com', 0),
       (3, 'admin', '1111', 'admin@example.com', 1);

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
  status BIT NOT NULL DEFAULT 1,
  FOREIGN KEY (seller_id) REFERENCES users(user_id),
  FOREIGN KEY (buyer_id) REFERENCES users(user_id)
);

-- Ajout d'entrées d'exemple
INSERT INTO auctions (item_name, item_description, starting_bid, current_bid, start_time, end_time, seller_id, buyer_id)
VALUES
  ('Vintage record player', 'This vintage record player is in excellent condition and has a beautiful wooden finish.', 50, 50, '2022-12-08 14:00:00', '2022-12-15 14:00:00', 1, null),
  ('Vintage comic book collection', 'This collection includes 100+ vintage comic books from the 1950s and 1960s.', 100, 100, '2022-12-08 14:00:00', '2022-12-15 14:00:00', 2, null),
  ('Vintage camera collection', 'This collection includes 10 vintage cameras, including a Polaroid and a 35mm film camera.', 75, 75, '2022-12-08 14:00:00', '2022-12-15 14:00:00', 2, null);