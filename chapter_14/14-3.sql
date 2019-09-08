/*
 * 14-3.sql
 *
 * Book solution to exercise 14-3 from Cracking the Coding Interview, 6th Edition.
 *
 */

UPDATE Requests
SET Status = 'Closed'
WHERE AptID IN (SELECT AptID FROM Apartments WHERE BuildingId = 11);
