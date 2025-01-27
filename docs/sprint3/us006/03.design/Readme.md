# US006 - Register Vehicle

## 3. Design - User Story Realization 

### 3.1. Rationale

_**Note that SSD - Alternative One is adopted.**_

| Interaction ID | Question: Which class is responsible for...   | Answer                                                | Justification (with patterns)                                                                                 |
|:---------------|:----------------------------------------------|:------------------------------------------------------|:--------------------------------------------------------------------------------------------------------------|
| Step 1  		     | 	... interacting with the actor?              | RegisterVehicleUI                                     | Pure Fabrication: there is no reason to assign this responsibility to any existing class in the Domain Model. |
| 			  	         | 	... coordinating the US?                     | RegisterVehicleController                             | Controller                                                                                                    |
| 			  	         | 	... instantiating a new Vehicle?             | Repositories                                          | VehiclesRepository and PlateCertificationsRepository contain a vehicle.                                       |
| Step 2  		     | 	                                             |                                                       |                                                                                                               |
| Step 3  		     | 	...saving the inputted data?                 | Vehicle <br> PlateCertification                       | IE: object created in step 1 has its own data.                                                                |
| Step 4  		     | 	...knowing the task categories to show?      | System                                                | IE: Task Categories are defined by the Administrators.                                                        |
| 		             | 	... saving the selected category?            | Vehicle <br> PlateCertification                       | IE: object created in step 1 is classified in one Category.                                                   |
| Step 5  		     | 	... validating all data (local validation)?  | Vehicle <br> PlateCertification                       | IE: owns its data.                                                                                            |
| 			  	         | 	... validating all data (global validation)? | VehiclesRepository <br> PlateCertificationsRepository | IE: knows all its vehicles.                                                                                   |
| 			  	         | 	... saving the created vehicle?              | VehiclesRepository <br> PlateCertificationsRepository | IE: owns all its vehicles.                                                                                    |
| Step 6  		     | 	... informing operation success?             | RegisterVehicleUI                                     | IE: responsible for user interactions.                                                                        |

### Systematization ##

According to the taken rationale, the conceptual classes promoted to software classes are: 

* Collaborator
* Vehicle
* PlateCertification

Other software classes (i.e. Pure Fabrication) identified: 

* RegisterVehicleUI
* RegisterVehicleController
* Repositories
* VehiclesRepository
* PlateCertificationsRepository


## 3.2. Sequence Diagram (SD)

_**Note that SSD - Alternative Two is adopted.**_

### Full Diagram

This diagram shows the full sequence of interactions between the classes involved in the realization of this user story.

![Sequence Diagram - Full](svg/us006-sequence-diagram-full.svg)

### Split Diagrams

The following diagram shows the same sequence of interactions between the classes involved in the realization of this user story, but it is split in partial diagrams to better illustrate the interactions between the classes.

It uses Interaction Occurrence (a.k.a. Interaction Use).

![Sequence Diagram - split](svg/us006-sequence-diagram-split.svg)

**Get Vehicles Repository**

![Sequence Diagram - Partial - Get Task Category List](svg/us006-sequence-diagram-partial-get-vehicles-repository.svg)

**Create Vehicle**

![Sequence Diagram - Partial - Create Task](svg/us006-sequence-diagram-partial-create-vehicle.svg)

## 3.3. Class Diagram (CD)

![Class Diagram](svg/us006-class-diagram.svg)