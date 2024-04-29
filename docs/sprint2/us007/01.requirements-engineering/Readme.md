# US007 - Register Vehicle´s Check-up


## 1. Requirements Engineering

### 1.1. User Story Description

As a VFM, I wish to register a vehicle’s maintenance.

### 1.2. Customer Specifications and Clarifications 

**From the specifications document:**

>	A Fleet Manager is a person who manages the fleet park, the machines, equipment and vehicles, ensuring their good condition and assigning them to the tasks to be carried out.

**From the client clarifications:**

> **Question:** What are the validation requirements for the vehicle ID?
>
> **Answer:** After 2020: AA-00-AA between 2005-2020 00-AA-00 between 1992-2005 00-00-XX.

> **Question:** Can a vehicle have more than one check-up?
>
> **Answer:** Yes.

> **Question:** Which attributes will you need for the vehicle's check-up?
>
> **Answer:** Plate number, date, kms at checkup

> **Question:** What is the unit of measurement used to estimate the check-up frequency (Kms, months, etc.)?
>
> **Answer:** In real context all could be considered, in the scope of this project just kms will be considered.

### 1.3. Acceptance Criteria

* **AC1:** The vehicle plate.
* **AC2:** The information of the check-up.

### 1.4. Found out Dependencies

* There is a dependency on "US06-As an Fleet Manager,I wish to register a vehicle including Brand, Model, Type, Tare, Gross Weight, Current Km, Register Date, Acquisition Date, Maintenance/Check up Frequency (in Kms)." as there must be at least one vehicle which can be assigned to a check-up.

### 1.5 Input and Output Data

**Input Data:**

* Typed data:
    * The vehicle
    * The information about the check-up
	
* Selected data:
  * The vehicle
  * The information about the check-up

**Output Data:**

* List of registered vehicle check-up's
* (In)Success of the operation

### 1.6. System Sequence Diagram (SSD)

![System Sequence Diagram - Alternative One](svg/us007-system-sequence-diagram-alternative-one.svg)

### 1.7 Other Relevant Remarks

* None.