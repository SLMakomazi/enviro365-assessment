INSERT INTO investor (name, email, age, balance) VALUES 
('John Smith', 'john.smith@example.com', 70, 14860.00),
('Jane Doe', 'jane.doe@example.com', 68, 25000.00),
('Robert Johnson', 'robert.johnson@example.com', 72, 50000.00);

INSERT INTO portfolio (name, total_value) VALUES 
('Growth Portfolio', 98420.00),
('Balanced Portfolio', 45000.00),
('Conservative Portfolio', 30000.00);

INSERT INTO withdrawal (amount, reason, status, requested_at) VALUES 
(1450.00, 'Emergency fund', 'Completed', '2026-05-12 10:30:00'),
(2560.00, 'Medical expenses', 'Pending', '2026-06-01 14:20:00'),
(5000.00, 'Home renovation', 'Approved', '2026-05-20 09:15:00');
