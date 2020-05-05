-- Select everything in customers table
SELECT * FROM Customers;

-- Selecting Name from customers

SELECT FirstName FROM Customers;

-- Select name where ID of the customer equals 1
SELECT FirstName FROM Customers WHERE CustomerID = 1;

-- Delete name where ID of the customer equals 2
DELETE FROM Customers WHERE CustomerID = 2;

--Counting unique status
SELECT COUNT(DISTINCT status) From Orders;

-- Returning max price from payments
SELECT MAX(Amount) FROM Payments;

--Selecting all and ordering by country
SELECT * FROM Customers ORDER BY Country;

--

-- Selecting the products of the prices between 100 and 600
SELECT * FROM Products WHERE Amount BETWEEN 100 AND 600;
--results

-- Selecting from customers where country is germany and city is Berlin
SELECT * FROM Customers WHERE Country ='Germany' AND City='Berlin';

-- Selecting from customers where country is city is Cape town or durban
SELECT * FROM Customers WHERE City ='Durban' OR City='Cape Town';

--Select from products where price is greater than 1000
SELECT * FROM Products WHERE Amount > 1000;

--returning the sum of the Price from the payments table
SELECT SUM(Amount) FROM Payments;

--Counting where status of the orders is shipped
SELECT COUNT(status) FROM Orders WHERE status='Shipped';

--Calculated average of price by 12
SELECT AVG(Amount / 12) FROM Products;


-- INNER JOIN create a query that selects all Payments with Customer information.
SELECT Customers.CustomerID, Customers.FirstName, Customers.LastName, Customers.Gender, Customers.Address, Customers.Phone, Customers.Email, Customers.Country, Customers.City FROM Customers
INNER JOIN Payments ON Payments.CustomerID=Customers.CustomerID;

--
SELECT * FROM Products WHERE Desrciption > 'Turnable front wheels steering function';