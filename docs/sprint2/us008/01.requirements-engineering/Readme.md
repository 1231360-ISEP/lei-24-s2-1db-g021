# US008 - List Vehicles Need Check-up 


## 1. Requirements Engineering

### 1.1. User Story Description

As a Fleet Manager, I want to list the vehicles needing the check-up.

### 1.2. Customer Specifications and Clarifications 

**From the specifications document:**

> The Vehicle and Equipment Fleet Manager manages the machines, equipment, and vehicles, ensuring their good condition.

**From the client clarifications:**

> **Question:** What are the requests/ input data to list the vehicles needing the check-up? Type of vehicle, Current Km and Maintenance/Check-up Frequency (in Kms) are sufficient?
>
> **Answer:** Current Km and Maintenance/Check-up Frequency (in Kms) are sufficient, yes.

> **Question:** Are there acceptance criteria when asking for the list?
>
> **Answer:** The list must contain all vehicles that have already exceeded the number of km required for the inspection or those that are close to it.
>The list must clearly identify the vehicles through: plate number, brand, model and the that justified the checkup need.

>  **Question:** "The list must clearly identify the vehicles through: plate number, brand, model and the [?] that justified the checkup need."
Did you mean the reason for the check-up need?
>
> **Answer:** [?] DATA
current kms, frequency, last checkup kms, next checkup (optimal) kms

> **Question:** Can the vehicles get placed automatically on a list or the one listing has to be the FM?
>
> **Answer:** The list of vehicles is automatically created but the creation is triggered by the FM.

> **Question:** What information will appear on the final list regarding the vehicle,besides the needing for check-up?
>
> **Answer:** Data that allow to identify the vehicle like Plate, brand and modle, as well as, the data that allowed to select/insert te vehicle in the list, number of kms, frequecny of checkup and the last checkup.

> **Question:** I'm not sure if I understood everything about US08. In this US we should only list the vehicles that need a check up (surpass the check up frequency in KM) or that will shortly need a check up (5% to the check up frequency *already said in another post*), correct? If so, the information about the checkup frequency for each vehicle should be asked in US07?
>
> **Answer:** No; the Maintenance/Check-up Frequency (in km) is registered in US06.

### 1.3. Acceptance Criteria

* **AC1:** The report should have the data concerning the vehicle description (Plate, Brand, Model and Current Kms) and the Checkup related data, like the following example: 

### 1.4. Found out Dependencies

* There is a dependency on "US006 - As an FM, I wish to register a vehicle including Brand, Model, Type, Tare,
  Gross Weight, Current Km, Register Date, Acquisition Date, Maintenance/Check-up Frequency (in Kms)" as there must at least one vehicle.
* There is another dependency on "US007 - As an FM, I wish to register a vehicle’s check-up." as there must be at least one vehicle with check-up registered.

### 1.5 Input and Output Data

**Input Data:**
None

**Output Data:**

* List of the vehicles needing or almost needing a check-up.
* (In)success of the operation.

### 1.6. System Sequence Diagram (SSD)

![System Sequence Diagram - Alternative One](svg/us008-system-sequence-diagram-alternative-one.svg)

### 1.7 Other Relevant Remarks

* None.