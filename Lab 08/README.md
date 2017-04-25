 ###Software Construction
#Gradebook
 ####Wed April 19, 2017. Lab 08
##Introduction
The lab was about gradebook which is used to keep track of grade achieved by a
student, in course contents. As a result when modeling a gradebook, courses,
teachers, students, course learning outcomes and the achieved marks, against
some obtained marks are all necessary. The skeleton code provided to you, uses
annotations to provide persistent classes for all of these entities. Also
provided for your convenience are the Data Access Objects (DAOs) for these
entities which will allow you to store an entity or retrieve it.
##Approach
   1. Execute the current system.
   2. Define BOs to allow addition or updating of courses, teachers, students,
      contents, CLOs and Grades.
   3. Store all the available grades from your current courses, along with
      other associated information, available via LMS or CMS.
   4. Allow the user to export the data by printing it on the screen or
      generating a CSV file for it.
   5. Use only HCQL for retrieval operations.
   6. The user should be able to export all the information of a graded item.
7. The user can select graded items for a course, a student, or course content.
 8. Define proper separation of concerns by separating the Executioner (View), BOs, DAOs and using only Models for exchanging data between these layers.
9. Unit tests to evaluate your code.
10.Using a Version Control System (VCS) to manage your solutions.
##Analysis
 Used Maven for lab work.
##Link:
https://github.com/MaryamHashmi/Software-Construction
 
