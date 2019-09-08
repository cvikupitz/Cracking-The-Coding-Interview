/*
 * 14-7.sql
 *
 * Book solution to exercise 14-7 from Cracking the Coding Interview, 6th Edition.
 *
 */

DECLARE @GPACutOff float;

SET @GPACutOff = (SELECT MIN(GPA) AS 'GPAMin' FROM (
  SELECT TOP 10 PERCENT AVG(CourseEnrollment.Grade) AS GPA
  FROM CourseEnrollment
  GROUP BY CourseEnrollment.StudentID
  ORDER BY GPA DESC
) Grades);

SELECT StudentName, GPA
  FROM (SELECT AVG(CourseEnrollment.Grade) AS GPA, CourseEnrollment.StudentID
  FROM CourseEnrollment
  GROUP BY CourseEnrollment.StudentID
  HAVING AVG(CourseEnrollment.Grade) >= @GPACutOff) Honors
INNER JOIN Students ON Honors.StudentID = Students.StudentID;
