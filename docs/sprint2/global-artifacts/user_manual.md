# Introduction
## Purpose and Scope

<p style="text-align: justify">
As part of the Integrative Project (IP), namely in the discipline of Laboratory / 
Project II (LAPR2), the purpose of this document is to gather relevant information 
for the User Manual, intended firstly for the collective use of the MusgoSublime 
organisation and finally for users of the urban green spaces. <br>
This User Manual describes an urban green space management application 
for the MusgoSublime organisation, additionally with a section that collects feedback from 
users of the urban green spaces managed by this organisation. In this manual, the 
user can find information related to some business transactions (functionalities), 
which are aimed at MusgoSublime members. Subsequently, the user of the urban green 
space can find details on how the application works, namely how to send feedback on 
the urban green space they have used.<br>
Next, but not less important, there is a section reserved for statistical analysis to 
study some KPIs (key performance indicators) such as: water or energy consumption, the most 
used equipment and the profile of the park's users by age.<br>
Finally, there is also a section on the implementation of efficient irrigation systems created 
using an algorithm that reads the different routes in a park (topographical survey) and 
defines the most efficient and least expensive route.
</p>

# Glossary

**Link to the glossary developed up to and including the 2nd Sprint:**
[Glossary](01.requirements-engineering/glossary.md)

# System Overview

<p style="text-align: justify">
This green space management application aims to speed up and facilitate the entire process of managing a green space, 
being able to register collaborators to be able to generate teams dynamically, and register vehicles to be able to 
manage their check-up's and kilometers. This application works with a small hierarchical system in which the Human 
Resources Manager has the highest permission to register collaborators and generate teams with these same previously 
registered collaborators. The Fleet Manager also has a higher position to register vehicles and record their check-ups.
</p>

![Domain Model](02.analysis/svg/project-domain-model.svg)


# Features

>**Register skills | Human Resource Manager**
>
>This feature is important because skills enable employees to perform well on tasks.
>This feature only enables the registration/creation of them.

>**Register a job | Humans Resource Manager**
>
>This feature is important because employees must have a main occupation.

>**Assign one or more skills to a collaborator | Humans Resource Manager**
>
>This feature is important because skills enable employees to perform well on tasks.
>This feature only enables the assignment of them to a employee.

>**Generate a team proposal automatically | Humans Resource Manager**
>
>This feature creates a team considering the set of skills and number of members.
>A team is a temporary association of employees who will carry out a set of tasks in
one or more green spaces.

>**Register a vehicle | Vehicle and Equipment Fleet Manager**
>
>This feature is important because it registers a vehicle.
>Vehicles are needed to carry out the tasks assigned to the teams as well as to transport
machines and equipment.

>**Register a vehicle’s check-up | Vehicle and Equipment Fleet Manager**
>
>This feature is important because it registers a vehicle's check-up.
>Vehicles need maintenance, because they are machines and machines need check-up's.
>That is due to security, economy and durability.

>**List the vehicles needing the check-up | Vehicle and Equipment Fleet Manager**
>
>This feature is important because it lists vehicles which need a check-up.