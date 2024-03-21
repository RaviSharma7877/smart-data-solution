-- Problem 1: Calculate the total claimed charge for documents that are exported.
SELECT SUM(claimed_charge) AS total_claimed_charge
FROM document
WHERE status = 'EXPORTED';

-- Problem 2: Retrieve insured name, insured address, and claimed charge for documents in the TO_REPRICE status,
-- for batches belonging to customers with IDs 1 or 2.
SELECT insured_name, insured_address, claimed_charge
FROM document d
JOIN batch b ON d.batch_id = b.id
WHERE d.status = 'TO_REPRICE'
AND b.customer_id IN (1, 2);

