# US001 - Register Skills to Collaborators 


## 1. Requirements Engineering

### 1.1. User Story Description

As an organization employee (HRM), I want to register skills that may be appointed to a collaborator.

### 1.2. Customer Specifications and Clarifications 

**From the specifications document:**

> An employee has a main occupation (job) and a set of skills that enable him to perform/take on certain tasks/responsibilities, for example, driving vehicles of different types (e.g. light, or heavy), operating machines such as backhoes or tractors; tree pruning; application of phytopharmaceuticals.

**From the client clarifications:**

> **Question:** Que criterios sao necessarios para registar uma skill? Que tipo de informação uma skill tem?
> 
> **Answer:** O nome da skill, por exemplo: podador, condutor de veiculos pesados e aplicador de fito-farmacos.

> **Question:** Quando é criado uma skill que ja existe o que sistema devera fazer?
> 
> **Answer:** Por definição não é possível ter valores duplicados num conjunto. A verificação de duplicados não é uma regra de negócio é do nível tecnológico.

> **Question:** Which information can be introduced to create a new skill?
> 
> **Answer:** The skill name.

> **Question:** Which information is mandatory for creating a new skill?
>
> **Answer:** The skill name.

> **Question:** Which are the skills accepted? Or should we enable the HRM to introduce anything as a skill?
>
> **Answer:** All, it's up to HRM to decide. (special characters or algarisms should not be allowed in the skill name).

> **Question:**  Do I need to add skills  by writing them or can I just give a file with all of the skills?
> 
> **Answer:** Both are acceptable since the business the same the crucial difference resides in the UX.

> **Question:** Does the HRM need to see the confirmation of the sucess of the operation and the skills added or just the sucess of the operation?
>
> **Answer:** It will depends if you opt to insert one skil or a set of skils in a batch. Maybe some adaptation needed.

> **Question:** Is there any other possible outcome like if the HMR does not put the requested data, do I need to ask the user to to register a diferent competence?
>
> **Answer:** This US is quite simple, atm a skill is simply a name.

> **Question:** Should the system able the HRM to insert multiple collaborators in one interaction before saving them.
>
> **Answer:** It's not required to do so.

> **Question:** Dear client, which is the difference between collaborator and employ? And employ could have skills? HRM, VFM, GSM and GSU are employers?
>
> **Answer:** Employee and collaborator are synonyms.

> **Question:** The indentificator of the skill will be the name, or the system will generate authomatically and Id when the manager insert the name?
>
> **Answer:** A skill is just a name, can be a composition os words like "Light Vehicle Driving Licence". I have no knowledge about systems IDs.

> **Question:** Are the skills(input) typed or selected? Does the output show the team members with or without their skills?
>
> **Answer:** The ux/ui is up to the dev team.


### 1.3. Acceptance Criteria

* **AC1:** A skill name can’t have special characters or digits.

### 1.4. Found out Dependencies

* This User Storie doesn't have any dependencie.

### 1.5 Input and Output Data

**Input Data:**

* Typed data:
    * The name of the skill.
	
* Selected data:
    * The name of the skill.

**Output Data:**

* List of existing skills

### 1.6. System Sequence Diagram (SSD)

![System Sequence Diagram - Alternative One](svg/us001-system-sequence-diagram.svg)

### 1.7 Other Relevant Remarks

*