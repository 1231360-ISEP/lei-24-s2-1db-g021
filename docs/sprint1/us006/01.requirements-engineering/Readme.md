# US006 - Register Vehicle


## 1. Requirements Engineering

### 1.1. User Story Description

As an FM, I wish to register a vehicle including Brand, Model, Type, Tare,
Gross Weight, Current Km, Register Date, Acquisition Date, Maintenance/Checkup Frequency (in Kms).

### 1.2. Customer Specifications and Clarifications 

**From the specifications document:**

> Vehicles are needed to carry out the tasks assigned to the teams as well as to transport
machines and equipment. This type of vehicle can be only for passengers or mixed,
light or heavy, open box or closed vans or trucks. 
> As for machines, MS has tractors, backhoe loaders and rotating machines, lawnmowers, among others. The equipment can be greatly diverse, such as sprayers, lifting
platforms, chainsaws, brush cutters, blowers, ladders, cisterns and the various elements
that can be attached to tractors, such as disc harrows, weeders, aerators and scarifiers.

**From the client clarifications:**

> **Question:** For the application to work does the FM need to fill all the attributes of the vehicle?
>
> **Answer:** Yes, besides the vehicle plate that by mistake doesn't appear on the text.

> **Question:** Should the application identify a registered vehicle by a serial number or other attribute? Should the application a group the vehicles by their brand, serial number or other attribute? If the FM inserts the same vehicle by mistake, should it inform the user of the mistake and give him the option to add another vehicle?
>
> **Answer:** - By plate id. No requirements were set concerning groups of vehicles. Again, duplication of data is not a business rule is technical one, since by definition in a set you can't have duplicates.

> **Question:** When a vehicle is registered, are there specific requirements for accepting the brand? 
> For example, does the system need to check if the brand is on a predetermined list? Does this also apply to the model or any other characteristics?
>
> **Answer:** No; one can consider a list os brands and a list of models previsously inserted in the system, no need to go through validations.

> **Question:** Can a fm register no vehicles or does he have to regsiter at least one?
>
> **Answer:** The VFM is a role or system user profile that has the rights to perform some system actions (like the ones described by the US06, US07 and US08).
In theory If there is no need to register a vehicle, no vehicles will be registered but that would be rather odd.

### 1.3. Acceptance Criteria

* **AC1:** Provide the set of attributes necessary for the correct registration of a given vehicle.
* **AC2:** All attributes must be validated, there must be no negative values, no duplicate names or number plates and the date of purchase must not be more recent than the vehicle's registration date.

### 1.4. Found out Dependencies

* This User Storie doesn't have any dependencies.

### 1.5 Input and Output Data

**Input Data:**

* Typed data:
    * Brand
    * Model
    * Type 
    * Tare
    * Gross Weight
    * Current Km
    * Register Date
    * Acquisition Date
    * Maintenance/Checkup Frequency (in Kms)
    * Vehicle plate
	
* Selected data:
  * Brand
  * Model
  * Type
  * Tare
  * Gross Weight
  * Current Km
  * Register Date
  * Acquisition Date
  * Maintenance/Checkup Frequency (in Kms)
  * Vehicle plate

**Output Data:**

* Successful registration alert about the information on previously registered attributes for a particular vehicle.

### 1.6. System Sequence Diagram (SSD)

![System Sequence Diagram - Alternative One](svg/us006-system-sequence-diagram-alternative-one.svg)

### 1.7 Other Relevant Remarks

* 