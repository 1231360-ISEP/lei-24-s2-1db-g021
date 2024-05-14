# US006 - List Vehicles Need Check-up

## 3. Design - User Story Realization 

### 3.1. Rationale

_**Note that SSD - Alternative One is adopted.**_

| Interaction ID | Question: Which class is responsible for...             | Answer                        | Justification (with patterns)                                                                                 |
|:-------------  |:--------------------------------------------------------|:------------------------------|:--------------------------------------------------------------------------------------------------------------|
| Step 1  		 | 	... interacting with the actor?                        | ListVehiclesCheckupUI         | Pure Fabrication: there is no reason to assign this responsibility to any existing class in the Domain Model. |
| 			  		 | 	... coordinating the US?                               | ListVehiclesCheckupController | Controller                                                                                                    |
| 			  		 | 	... instantiating a new ListVehiclesCheckupController? | ListVehiclesCheckupUI         | Creator (Rule 3): ListVehiclesCheckupUI closely uses ListVehiclesCheckupController.                           |
| 			  		 | ... knowing the user using the system?                  | UserSession                   | IE: cf. A&A component documentation.                                                                          |
| 			  		 | 							                                                 | VehiclesRepository            | IE: knows/has its own Vehicle                                                                                 |
| 			  		 | 							                                                 | Vehicle                       | IE: knows its own data (e.g. currentKm)                                                                       |
| Step 2  		 | 							                                                 |                               |                                                                                                               |
| Step 4  		 | 	...knowing the vehicles to show?                       | Vehicle                       | IE: the object respo .                                                                                        |
| Step 5  		 | 	... saving the selected category?                      | Task                          | IE: object created in step 1 is classified in one Category.                                                   |
| Step 6  		 | 							                                                 |                               |                                                                                                               |              
| Step 7  		 | 	... validating all data (local validation)?            | Task                          | IE: owns its data.                                                                                            | 
| 			  		 | 	... validating all data (global validation)?           | Organization                  | IE: knows all its tasks.                                                                                      | 
| 			  		 | 	... saving the created task?                           | Organization                  | IE: owns all its tasks.                                                                                       | 
| Step 8  		 | 	... informing operation success?                       | CreateTaskUI                  | IE: is responsible for user interactions.                                                                     | 

### Systematization ##

According to the taken rationale, the conceptual classes promoted to software classes are: 

* Organization
* Task

Other software classes (i.e. Pure Fabrication) identified: 

* CreateTaskUI  
* CreateTaskController


## 3.2. Sequence Diagram (SD)

_**Note that SSD - Alternative One is adopted.**_

### Full Diagram

This diagram shows the full sequence of interactions between the classes involved in the realization of this user story.

![Sequence Diagram - Full](svg/us008-sequence-diagram-full.svg)

## 3.3. Class Diagram (CD)

![Class Diagram](svg/us008-class-diagram.svg)