INSERT INTO deliveries (type, status) VALUES ('Medium Priority', 'PENDING');
INSERT INTO deliveries (type, status) VALUES ('Low Priority', 'DELIVERED');
INSERT INTO deliveries (type, status) VALUES ('High Priority','CANCELLED');

INSERT INTO categories (name, type) VALUES ('Electronics', 'ELECTRONICS');
INSERT INTO categories (name, type) VALUES ('Clothing', 'CLOTHING');
INSERT INTO categories (name, type) VALUES ('Food', 'FOOD');


INSERT INTO products (category_id, name) VALUES (1, 'Smartphone');
INSERT INTO products (category_id, name) VALUES (1, 'Laptop');
INSERT INTO products (category_id, name) VALUES (2, 'T-shirt');
INSERT INTO products (category_id, name) VALUES (2, 'Jeans');
INSERT INTO products (category_id, name) VALUES (3, 'Chicken Breast');
INSERT INTO products (category_id, name) VALUES (3, 'Apple');

INSERT INTO customers (address, email, name) VALUES ('123 Main St', 'john.doe@example.com', 'John Doe');
INSERT INTO customers (address, email, name) VALUES ('456 Elm St', 'jane.smith@example.com', 'Jane Smith');

INSERT INTO orders (customer_id, delivery_id, order_date) VALUES (1, 1, '2024-08-23 10:00:00');
INSERT INTO orders (customer_id, delivery_id, order_date) VALUES (2, 2, '2024-08-23 11:00:00');
INSERT INTO orders (customer_id, delivery_id, order_date) VALUES (1, 3, '2024-08-23 12:00:00');

INSERT INTO order_products (order_id, product_id) VALUES (1, 1);
INSERT INTO order_products (order_id, product_id) VALUES (1, 3);
INSERT INTO order_products (order_id, product_id) VALUES (2, 2);
INSERT INTO order_products (order_id, product_id) VALUES (2, 4);
INSERT INTO order_products (order_id, product_id) VALUES (3, 5);
INSERT INTO order_products (order_id, product_id) VALUES (3, 6);