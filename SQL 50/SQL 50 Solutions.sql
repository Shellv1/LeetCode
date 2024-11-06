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
