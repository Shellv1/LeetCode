# = = = = = = = = = = = = = = = #
#   SELECT                      #
# = = = = = = = = = = = = = = = #

# PROBLEM 01
SELECT product_id
FROM Products
WHERE (low_fats = 'Y' AND recyclable = 'Y');

# = = = = = = = = = = = = = = = #

# PROBLEM 02
SELECT name
FROM Customer
WHERE (referee_id <> 2) is not false;
# OR  COALESCE(referee_id, '') <> 2;

# = = = = = = = = = = = = = = = #

# PROBLEM 03
SELECT name, population, area
FROM World
WHERE (area >= 3000000) OR (population >= 25000000);

# = = = = = = = = = = = = = = = #

# PROBLEM 04
SELECT DISTINCT author_id AS id
FROM Views
WHERE author_id = viewer_id
ORDER BY author_id;

# = = = = = = = = = = = = = = = #

# PROBLEM 05
SELECT tweet_id
FROM Tweets
WHERE (char_length(content) > 15);

# = = = = = = = = = = = = = = = #
#   BASIC JOINS                 #
# = = = = = = = = = = = = = = = #

# PROBLEM 06
SELECT unique_id, name
FROM Employees Emp
  LEFT JOIN EmployeeUNI EmpUNI ON Emp.id = EmpUNI.id
ORDER BY EmpUNI.unique_id

# = = = = = = = = = = = = = = = #

# PROBLEM 07
SELECT product_name, year, price
FROM Sales s
  JOIN Product p ON s.product_id = p.product_id
ORDER BY s.product_id

# = = = = = = = = = = = = = = = #

# PROBLEM 08
SELECT customer_id, COUNT(customer_id) AS count_no_trans
FROM Visits v
  LEFT JOIN Transactions t ON v.visit_id = t.visit_id
WHERE transaction_id IS NULL
GROUP BY customer_id

# = = = = = = = = = = = = = = = #

# PROBLEM 09
SELECT w1.id
FROM Weather w1
    LEFT JOIN (
        SELECT DATE_ADD(recordDate, INTERVAL 1 DAY) recordDate, temperature FROM Weather
    ) w2 ON w1.recordDate = w2.recordDate
WHERE w1.temperature > w2.temperature

# = = = = = = = = = = = = = = = #

# PROBLEM 10
