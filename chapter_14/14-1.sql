/*
 * 14-1.sql
 *
 * Book solution to exercise 14-1 from Cracking the Coding Interview, 6th Edition.
 *
 */

SELECT TenantName
FROM Tenants
INNER JOIN (SELECT TenantID FROM AptTenants GROUP BY TenantID HAVING COUNT(*) > 1) C
ON Tenants.TenantID = C.TenantID;
