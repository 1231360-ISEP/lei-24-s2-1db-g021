# US005 - Generate Team Proposal 

## 3. Design - User Story Realization 

### 3.1. Rationale

_**Note that SSD is adopted.**_

| Interaction ID | Question: Which class is responsible for...         | Answer                         | Justification (with patterns)                                                                                 |
|:---------------|:----------------------------------------------------|:-------------------------------|:--------------------------------------------------------------------------------------------------------------|
| Step 1  		  | 	... interacting with the actor?                 | GenerateTeamProposalUI         | Pure Fabrication: there is no reason to assign this responsibility to any existing class in the Domain Model. |
| 			  	  | 	... coordinating the US?                        | GenerateTeamProposalController | Controller                                                                                                    |
| 			  	  | 	... instantiating a new Team?                   | TeamRepository                 | TeamRepository has a Team.                                                                                    |
| Step 2  		  | 	                                                |                                |                                                                                                               |
| Step 3  		  | 	...saving the inputted data?                    | Repositories                   | IE: Repositories saves the inputed data.                                                                      |
| Step 4  		  | 	...knowing the task categories to show?         | System                         | IE: Task Categories are defined by the Administrators.                                                        |
| Step 5  		  | 	... saving the selected category?               | Team                           | IE: object created in step 1 is classified in one Category.                                                   |
| Step 6  		  | 						                            |                                |                                                                                                               |
| Step 7  		  | 	... validating all data (local validation)?     | Team                           | IE: owns its data.                                                                                            |
| 			  	  | 	... validating all data (global validation)?    | TeamRepository                 | IE: knows all its teams.                                                                                      |
| 			  	  | 	... saving the created team?                    | TeamRepository                 | IE: owns all its teams.                                                                                       |
| Step 8  		  | 	... informing operation success?                | GenerateTeamProposalUI         | IE: is responsible for user interactions.                                                                     |

### Systematization ##

According to the taken rationale, the conceptual classes promoted to software classes are: 

* Collaborator
* Skill
* Team

Other software classes (i.e. Pure Fabrication) identified: 

* GenerateTeamProposalUI  
* GenerateTeamProposalController
* Repositories
* SkillsRepository
* CollaboratorsRepository
* TeamRepository

## 3.2. Sequence Diagram (SD)

_**Note that SSD - Alternative Two is adopted.**_

### Full Diagram

This diagram shows the full sequence of interactions between the classes involved in the realization of this user story.

![Sequence Diagram - Full](svg/us005-sequence-diagram-full.svg)

### Split Diagrams

The following diagram shows the same sequence of interactions between the classes involved in the realization of this user story, but it is split in partial diagrams to better illustrate the interactions between the classes.

It uses Interaction Occurrence (a.k.a. Interaction Use).

![Sequence Diagram - split](svg/us005-sequence-diagram-split.svg)

**Get Registed Skills List Partial SD**

![Sequence Diagram - Partial - Get Task Category List](svg/us005-sequence-diagram-partial-skills-list.svg)

**Get Collaborators By Skills List Partial SD**

![Sequence Diagram - Partial - Get Task Category Object](svg/us005-sequence-diagram-partial-collaborators-list.svg)

**Get Proposal Team Partial SD**

![Sequence Diagram - Partial - Get Employee](svg/us005-sequence-diagram-partial-proposal-team.svg)


## 3.3. Class Diagram (CD)

![Class Diagram](svg/us005-class-diagram.svg)