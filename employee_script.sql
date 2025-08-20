-- Création de la base de données (si elle n'existe pas)
CREATE DATABASE IF NOT EXISTS employee_db;
USE employee_db;

-- Création de la table employee
CREATE TABLE IF NOT EXISTS employee (
    id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Insertion de données d'exemple
INSERT INTO employee (first_name, last_name, email) VALUES
('John', 'Doe', 'john.doe@example.com'),
('Jane', 'Smith', 'jane.smith@example.com'),
('Robert', 'Johnson', 'robert.j@example.com'),
('Sarah', 'Wilson', 'sarah.wilson@example.com'),
('Michael', 'Brown', 'michael.brown@example.com');

-- Vérification des données insérées
SELECT * FROM employee;