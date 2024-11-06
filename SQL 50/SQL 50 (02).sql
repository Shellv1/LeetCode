SELECT name
FROM Customer
WHERE (referee_id <> 2) is not false;
# OR  COALESCE(referee_id, '') <> 2;
