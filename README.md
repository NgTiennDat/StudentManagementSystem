Write a program to manage student recruitment after graduating from university.

There are 2 types of students including good graduates (GoodStudent) and average graduates (NormalStudent).

Both types of students above must provide the following information when submitting a job application:
Full name (fullName), Date of birth (doB), Gender (sex), Phone number (phoneNumber), School name studied (universityName), Graduation rank (gradeLevel).

Particularly good students must have additional information: average academic score (GPA) on a 10-point scale, name of the highest scholarship (or award) ever won (bestRewardName).

As for average students, they must have additional information: TOEIC score (englishScore), professional entrance test score organized by the testing company (entryTestScore) on a 10-point scale.

Requirement 1:

            Candidates should design and write code to demonstrate how the classes of students and classes of the program comply with the OOP model they have learned, applying 4 properties:
            encapsulation, inheritance.), polymorphism, abstraction.

            Note: Any student needs a method called ShowMyInfor to display that student's information on the console screen. This requirement is mandatory for members who build code for this program. Please pay attention when designing code to satisfy this requirement.

Requirement 2: Check the data binding for the program. The data of input files must comply with the following constraints:

– Student's full name has a maximum length of 50 characters and a minimum length of 10 characters. Students need to create a corresponding Exception named InvalidFullNameException ( 1 point).

– The program must catch errors in the wrong date, month, and year format for the doB field. doB must be in the format dd/MM/YYYY.
  Students need to create a corresponding Exception named InvalidDOBException ( 1 point).

– Phone number: must be a number string with a length of 10 characters and must start with one of the number strings: 090, 098, 091, 031, 035, or 038. Students need to create a corresponding Exception named InvalidPhoneNumberException ( 1 point) .

– In addition, if there is any other exception during program execution, candidates should notify the screen with the content " Input files have unknown errors !!!"  (0.5 points).

Requirement 3: The program needs to have the function of selecting successful candidates to join the company according to the following principles:

The user will enter the number of students to recruit (minimum 11, maximum 15).
The program will automatically select suitable candidates for the company according to the following steps:
-  If the number of candidates who are good students is greater than the number needed, priority will be given based on GPA. 
-  If there are good candidates with the same GPA, priority will be given based on their full name. For example: if their names are Nguyen Van A and Nguyen Van B, then candidate Nguyen Van A is selected. 
(Assume there are never any students with the same last name) .
-  If the number of candidates who are quite good students is less than or equal to the number needed, all good students will be accepted.
    After recruiting all good candidates, if there are still not enough candidates, the program will select average candidates. Average candidates are given priority based on entrance test scores.
-  If entrance test scores are equal, TOEIC scores are considered. If there is an average candidate with the same TOEIC score, priority will be given to them based on their full name.
Requirement 4: The program can display the full name and phone number information of all students entered into the system
(requires using collection sort to sort descending by fullName and ascending by phoneNumber for students). students before showing).
