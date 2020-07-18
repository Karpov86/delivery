INSERT INTO personal_info(id, email, first_name, last_name, phone_number)
VALUES
       (1, 'bob@.gmail.com', 'Bob', 'Marley', '+555-555'),
       (2, 'eva@.gmail.com', 'Eva', 'Green', '+555-666'),
       (3, 'groot@.gmail.com', 'Groot', 'Groot', '+555-777');

INSERT INTO addresses(id, city, entrance_number, flat_number, house_number, stage_number, street, personal_info_id)
VALUES
       (1, 'Minsk', '1', '1', '1', '1', 'Masherova', 1),
       (2, 'Moscow', '2', '2', '2', '2', 'Lomonosova', 2),
       (3, 'Kiev', '3', '3', '3', '3', 'Svetlaya', 3);

INSERT INTO credit_cards(id, data, number, vcc, personal_info_id)
VALUES
       (1, '07/2022', '1111 1111 1111 1111', '123', 1),
       (2, '07/2022', '2222 2222 2222 2222', '123', 2),
       (3, '07/2022', '3333 3333 3333 3333', '123', 3);

INSERT INTO users(id, login, password, role, personal_info_id)
VALUES
       (1, 'Bob', '123', 'USER', 1),
       (2, 'Eva', '123', 'ADMIN', 2),
       (3, 'Groot', '123', 'USER', 3);

INSERT INTO orders(id, data)
VALUES
       (1, '2020-07-20 18:30:00'),
       (2, '2020-07-20 19:00:00'),
       (3, '2020-07-20 23:50:50');

INSERT INTO dishes(id, category, description, sale, price, title, order_id)
VALUES
       (1, 'PIZZA', '', false, 12.05, 'Italian', 1),
       (2, 'PIZZA', '', false, 15.05, 'Chicago', 1),
       (3, 'SUSHI', '', false, 10.05, 'Philadelphia', 2),
       (4, 'SUSHI', '', false, 12.05, 'Black dragon', 2),
       (5, 'VEGETARIAN', '', false, 22.05, 'Seeds', 3),
       (6, 'VEGETARIAN', '', false, 22.05, 'Grass', 3),
       (7, 'VEGETARIAN', '', false, 22.05, 'Some without taste', 3);