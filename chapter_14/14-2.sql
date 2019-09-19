/*
 * 14-2.sql
 *
 * Book solution to exercise 14-2 from Cracking the Coding Interview, 6th Edition.
 *
 */

SELECT BuildingName, ISNULL(Count, 0) AS 'Count'
FROM Buildings
LEFT JOIN
  (SELECT Apartments.BuildingID, COUNT(*) AS 'COUNT'
   FROM Requests INNER JOIN Apartments
   ON Requests.AptID = Apartments.AptID
   WHERE Requests.Status = 'OPEN'
   GROUP BY Apartments.BuildingID) ReqCounts
ON ReqCounts.BuildingID = Buildings.BuildingID;
