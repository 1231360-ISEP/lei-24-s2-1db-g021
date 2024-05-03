# US004 - Assign one or more skills to a collaborator 

## 3. Design - User Story Realization

### 3.1. Rationale

_**Note that SSD - Alternative One is adopted.**_

| Interaction ID | Question: Which class is responsible for...   | Answer                | Justification (with patterns)                                                                                 |
|:-------------  |:----------------------------------------------|:----------------------|:--------------------------------------------------------------------------------------------------------------|
| Step 1  		 | 	... interacting with the actor?              | AssignSkillUI         | Pure Fabrication: there is no reason to assign this responsibility to any existing class in the Domain Model. |
| 			  		 | 	... coordinating the US?                     | AssignSkillController | Controller                                                                                                    |
| 			  		 | 	... instantiating a new CollaboratorList?               | AssignSkillController          | Creator (Rule 1): AssignSkillController closely uses CollaboratorList.                                                        |
| 			  		 | ... knowing the user using the system?        | UserSession           | IE: cf. A&A component documentation.                                                                          |
| 			  		 | 							                                       | CollaboratorList          | IE: knows/has its own Collaborators                                                                           |
| 			  		 | 							                                       | Collaborator              | IE: knows its own data (e.g. email)                                                                           |
| Step 2  		 | 							                                       |                       |                                                                                                               |
| Step 3  		 | 	...saving the inputted data?                 | Task                  | IE: object created in step 1 has its own data.                                                                |
| Step 4  		 | 	...knowing the task categories to show?      | System                | IE: Task Categories are defined by the Administrators.                                                        |
| Step 5  		 | 	... saving the selected category?            | Task                  | IE: object created in step 1 is classified in one Category.                                                   |
| Step 6  		 | 							                                       |                       |                                                                                                               |              
| Step 7  		 | 	... validating all data (local validation)?  | Task                  | IE: owns its data.                                                                                            | 
| 			  		 | 	... validating all data (global validation)? | Organization          | IE: knows all its tasks.                                                                                      | 
| 			  		 | 	... saving the created task?                 | Organization          | IE: owns all its tasks.                                                                                       | 
| Step 8  		 | 	... informing operation success?             | AssignSkillUI         | IE: is responsible for user interactions.                                                                     | 

### Systematization ##

According to the taken rationale, the conceptual classes promoted to software classes are: 

* Collaborator

Other software classes (i.e. Pure Fabrication) identified: 

* AssignSkillUI  
* AssignSkillController


## 3.2. Sequence Diagram (SD)

_**Note that SSD - Alternative One is adopted.**_

### Full Diagram

This diagram shows the full sequence of interactions between the classes involved in the realization of this user story.

![Sequence Diagram - Full](svg/us004-sequence-diagram-full.svg)

## 3.3. Class Diagram (CD)

![Class Diagram](svg/us004-class-diagram.svg)