CREATE TABLE users (
    user_id INT PRIMARY KEY IDENTITY,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    is_admin BIT NOT NULL DEFAULT 0
);

CREATE TABLE auctions (
  auction_id INT PRIMARY KEY IDENTITY(1001,1),
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

INSERT INTO users (username, password, email) VALUES
('user', '1111', 'LesMis@chansons.fr'),
('JaneAusten', 'Emma', 'Pride@chansons.fr'),
('LeoTolstoy', 'Anna', 'WarPeace@chansons.fr'),
('WilliamShakespeare', 'Ophelia', 'Hamlet@chansons.fr')

INSERT INTO users (username, password, email, is_admin) VALUES
('admin', '1111', 'Hamlet@chansons.fr', 1)

INSERT INTO auctions (item_name, item_description, starting_bid, current_bid, start_time, end_time, seller_id, is_closed)
VALUES ('Veste en cuir noir', 'Ce vêtement est tellement cool quil en devient ennuyant!', 100.00, 100.00, '2022-12-12 12:00:00', '2022-01-31 23:59:59', 1, 0),
       ('Robes de soirée rouge', 'Ces robes sont tellement belles que vous aurez lair triste à côté!', 50.00, 50.00, '2022-12-12 12:00:00', '2022-01-31 23:59:59', 2, 0),
       ('Jeans skinny bleu', 'Ces jeans sont tellement serrés que vous aurez l''air de porter une corde!', 25.00, 25.00, '2022-12-12 12:00:00', '2022-01-31 23:59:59', 1, 2);
