-- Seed data (for testing)

INSERT INTO users(full_name, email, password_hash, role) VALUES
('Admin', 'admin@test.com', 'HASH_HERE', 'ADMIN'),
('User One', 'user@test.com', 'HASH_HERE', 'USER');

INSERT INTO routes(from_city, to_city, transport_type) VALUES
('Almaty','Astana','TRAIN'),
('Almaty','Shymkent','BUS'),
('Astana','Almaty','AIRPLANE');

INSERT INTO tickets(route_id, depart_date, depart_time, price, seats_total, seats_left) VALUES
(1,'2026-01-10','09:30:00',12000.00,50,50),
(1,'2026-01-11','18:00:00',14000.00,50,50),
(2,'2026-01-10','08:00:00',6000.00,40,40),
(3,'2026-01-12','12:15:00',35000.00,80,80);
