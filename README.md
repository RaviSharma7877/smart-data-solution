# Task 1: Java Programming Aptitude Test

## Scenario
A client has provided us with a file, "Members.txt," containing basic information about their current membership. They've requested us to convert this file into a comma-separated-values (CSV) format and send it to one of their business partners. The file is in a fixed-column format with fields in the following order and length:
- id (12 characters)
- last name (25 characters)
- first name (25 characters)
- address (30 characters)
- city (20 characters)
- state (4 characters)
- zip (5 characters)

After a discussion with the business partner, they've specified the following additional requirements:
- The CSV file must be split by state, with each split file having a state prefix (e.g., 'NY_outputFile.csv', 'MN_outputFile.csv').
- Duplicate member records in the file are not acceptable.
- The fields in the CSV file(s) should be in the following order: [id, first name, last name, address, city, zip]

## Task
Complete the Main class to perform the conversion described above. You may need to work on the incomplete code in other classes as well.

## Notes
- Use the classes MemberExporterImpl and MemberImporterImpl to avoid code duplication.
- Do not modify the input files.
- Do not add any additional classes (except for utility functions).
- You may use Internet resources as required.

# Task 2: DBMS Aptitude Test

## Scenario
Given the following two tables:
- batch : { id, customer_id, type, received_date, status, completed_date }
- document : { id, batch_id, status, insured_name, insured_address, claimed_charge }

## Steps
1. Open the site http://sqlfiddle.com/ on your browser and copy the content of dbtest.sql to the Schema Panel (Left Panel).
2. Click "Build Schema" at the bottom of the Schema Panel.
3. Write the queries for the questions below on the Right Panel on the SQL Fiddle site.
4. Click "Run SQL" to test your queries.
5. Save the queries you wrote to dbtest-queries.sql.

## Questions
1. Find the total claimed_charge of the exported documents.
2. Find insured_name, insured_address, and claimed_charge for the documents with status "TO_REPRICE" and customer IDs 1 and 2.
