# = = = = = = = = = = = = = = = #
#   BASIC JOINS                 #
# = = = = = = = = = = = = = = = #

# PROBLEM 06
SELECT unique_id, name
FROM Employees Emp
    LEFT JOIN EmployeeUNI EmpUNI
    ON Emp.id = EmpUNI.id
ORDER BY EmpUNI.unique_id

# = = = = = = = = = = = = = = = #

# PROBLEM 07
SELECT product_name, year, price
FROM Sales s
    JOIN Product p
    ON s.product_id = p.product_id
ORDER BY s.product_id

# = = = = = = = = = = = = = = = #

# PROBLEM 08
SELECT 
    customer_id,
    COUNT(customer_id) AS count_no_trans
FROM Visits v
    LEFT JOIN Transactions t
    ON v.visit_id = t.visit_id
WHERE transaction_id IS NULL
GROUP BY customer_id

# = = = = = = = = = = = = = = = #

# PROBLEM 09
SELECT w1.id
FROM Weather w1
    LEFT JOIN (
        SELECT
            DATE_ADD(recordDate, INTERVAL 1 DAY) recordDate,
            temperature
        FROM Weather
    ) w2
    ON w1.recordDate = w2.recordDate
WHERE w1.temperature > w2.temperature

# = = = = = = = = = = = = = = = #

# PROBLEM 10
SELECT
    a1.machine_id,
    ROUND( AVG( a2.timestamp - a1.timestamp), 3 ) processing_time
FROM (
    SELECT machine_id, timestamp
    FROM Activity a
    WHERE a.activity_type = 'start'
    ORDER BY machine_id, process_id
) a1
    JOIN (
        SELECT machine_id, timestamp
        FROM Activity a
        WHERE a.activity_type = 'end'
        ORDER BY machine_id, process_id
    ) a2
    ON a1.machine_id = a2.machine_id
GROUP BY machine_id

# = = = = = = = = = = = = = = = #

# PROBLEM 11
SELECT e.name, b.bonus
FROM Employee e
    LEFT JOIN Bonus b
    ON e.empId = b.empId
WHERE
    b.bonus < 1000 OR
    b.bonus IS NULL

# = = = = = = = = = = = = = = = #

# PROBLEM 12
SELECT
    stu.student_id,
    stu.student_name,
    sub.subject_name,
    COUNT(exam.subject_name) attended_exams
FROM Students stu
    CROSS JOIN Subjects sub
    LEFT JOIN Examinations exam
    ON
        stu.student_id = exam.student_id AND
        sub.subject_name = exam.subject_name
GROUP BY student_id, subject_name
ORDER BY student_id, subject_name

# = = = = = = = = = = = = = = = #

# PROBLEM 13
