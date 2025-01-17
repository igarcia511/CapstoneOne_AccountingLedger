CREATE DATABASE Accounting_Ledger;

create table transactions (
    transaction_id INT NOT NULL AUTO_INCREMENT,
    Description VARCHAR(50),
    Vendor VARCHAR(50),
    Amount FLOAT,
    Date DATE,
    Time TIME,
    PRIMARY KEY (transaction_id)
);

insert into transactions (Description, Vendor, Amount, Date, Time) values 
('ergonomic keyboard', 'amazon', -89.50, '2023-04-15', '10:13:25'),
('Invoice 1001 paid', 'Joe', 1500.00, '2023-04-15', '11:15:00'),
('gaming headset', 'amazon', -250.0, '2023-09-20', '09:20:20'),
('electronic power washer', 'amazon', -500.0, '2023-09-27', '09:22:00'),
('Gaming chair', 'amazon', -250.0, '2024-09-28', '10:09:00'),
('GTA 6', 'steam', -65.0, '2024-09-12', '12:34:00'),
('gas power washer', 'amazon', -345.0, '2024-08-12', '12:22:22'),
('Costume', 'amazon', -150.0, '2023-04-20', '12:12:12'),
('employer payment', 'employer', 2500.0, '2024-10-14', '12:12:12'),
('freelance payment', 'joseph', 5000.0, '2024-10-11', '12:12:12'),
('microphone', 'amazon', 115.0, '2024-10-08', '12:12:12'),
('microphone2', 'amazon', -150.0, '2024-10-08', '12:12:12')
