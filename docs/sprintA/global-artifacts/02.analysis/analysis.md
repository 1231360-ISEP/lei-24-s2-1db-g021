# OO Analysis

The construction process of the domain model is based on the client specifications, especially the nouns (for _concepts_) and verbs (for _relations_) used.

## Rationale to identify domain conceptual classes
To identify domain conceptual classes, start by making a list of candidate conceptual classes inspired by the list of categories suggested in the book "Applying UML and Patterns: An Introduction to Object-Oriented Analysis and Design and Iterative Development".


### _Conceptual Class Category List_

**Business Transactions**

* Tasks

---

**Transaction Line Items**

* Skills
* Jobs
* Vehicles

---

**Product/Service related to a Transaction or Transaction Line Item**

* Characteristics

---

**Transaction Records**

* 

---  

**Roles of People or Organizations**

* Human Resources Manager (HRM)
* Fleet Manager (FM)
* Collaborator
* Green Spaces Manager (GSM)
* Green Spaces User (GSU)

---

**Places**

* Garden
* Medium-sized park
* Large-sized park

---

**Noteworthy Events**

* 

---

**Physical Objects**

* 

---

**Descriptions of Things**

* Register skills, jobs and vehicles
* Assign 1 or more skills to a Collaborator
* List the vehicles needing the check-up

---

**Catalogs**

* 

---

**Containers**

* 

---

**Elements of Containers**

* 

---

**Organizations**

* MusgoSublime (MS)

---

**Other External/Collaborating Systems**

* 

---

**Records of finance, work, contracts, legal matters**

* 

---

**Financial Instruments**

* 

---

**Documents mentioned/used to perform some work/**

* 

---


## Rationale to identify associations between conceptual classes

An association is a relationship between instances of objects that indicates a relevant connection and that is worth of remembering, or it is derivable from the List of Common Associations:

- **_A_** is physically or logically part of **_B_**
- **_A_** is physically or logically contained in/on **_B_**
- **_A_** is a description for **_B_**
- **_A_** known/logged/recorded/reported/captured in **_B_**
- **_A_** uses or manages or owns **_B_**
- **_A_** is related with a transaction (item) of **_B_**
- etc.


| Concept (A) 		  |      Association   	       |                                                    Concept (B) |
|-----------------|:--------------------------:|---------------------------------------------------------------:|
| MusgoSublime  	 |        has    		 	         |          Human Resources Manager (HRM)<br/> Fleet Manager (FM) |
| Human Resources Manager (HRM)  	          | regists <br/>assigns  		 	 |          Jobs,Skils,Collaborator <br/>Skills to a Collaborator |
| Fleet Manager (FM) 	          | regists<br/>lists    		 	  | Vehicles,Vehicle’s check-up<br/>Vehicles needing the check-up. |



## Domain Model

**Do NOT forget to identify concept atributes too.**

**Insert below the Domain Model Diagram in a SVG format**

![Domain Model](svg/project-domain-model.svg)