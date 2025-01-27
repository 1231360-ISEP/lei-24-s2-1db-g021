# Supplementary Specification (FURPS+)

## Functionality

_Specifies functionalities that:  
&nbsp; &nbsp; (i) are common across several US/UC;  
&nbsp; &nbsp; (ii) are not related to US/UC, namely: Audit, Reporting and Security._

(ii)
Security:
* All those who wish to use the application must be authenticated with a password of seven alphanumeric characters, including three capital letters and two digits.


## Usability

_Evaluates the user interface. It has several subcategories,
among them: error prevention; interface aesthetics and design; help and
documentation; consistency and standards._

### Help and Documentation
* The application documentation must be in English language.

### Standards
* Business rules validation must be respected when recording and updating data.


## Reliability

_Refers to the integrity, compliance and interoperability of the software. The requirements to be considered are: frequency and severity of failure, possibility of recovery, possibility of prediction, accuracy, average time between failures._

* (Waiting for the answer of client)


## Performance

_Evaluates the performance requirements of the software, namely: response time, start-up time, recovery time, memory consumption, CPU usage, load capacity and application availability._



## Supportability

_The supportability requirements gathers several characteristics, such as:
testability, adaptability, maintainability, compatibility,
configurability, installability, scalability and more._

### Maintainability and Adaptability
* The class structure must be designed to allow easy maintenance and the addition of new features, following the best OO practices.
*  In order to increase the solution maintainability, and respect good software development practices, the implementation 
must follow a TDD (Test-Driven Development) approach.



## +

### Design Constraints

_Specifies or constraints the system design process. Examples may include: programming languages, software process, mandatory standards/patterns, use of development tools, class library, etc._

#### Mandatory Standards/Patterns
* Adopt recognized coding standards (e.g., CamelCase).
* Business rules validation must be respected when recording and updating data.

#### Software Process
* The application should use object serialization to ensure data persistence between two runs of the application.
* In order to increase the solution maintainability, and respect good software development practices, the implementation
  must follow a TDD (Test-Driven Development) approach.
* All the images/figures produced during the software development process should be recorded in SVG format.



### Implementation Constraints

_Specifies or constraints the code or construction of a system
such as: mandatory standards/patterns, implementation languages,
database integrity, resource limits, operating system._

#### Implementation Languages
* The application must be developed in Java language using the IntelliJ IDE or NetBeans. 
* The unit tests should be implemented using the JUnit 5 framework. 
* The JaCoCo plugin should be used to generate the coverage report.
* Use Javadoc to generate useful documentation for Java code.
* The JaCoCo plugin should be used to generate the coverage report.
* The application’s graphical interface is to be developed in JavaFX 11.

#### Mandatory Standards/Patterns
* All the images/figures produced during the software development process should be recorded in SVG format.


### Interface Constraints

_Specifies or constraints the features inherent to the interaction of the
system being developed with other external systems._



### Physical Constraints

_Specifies a limitation or physical requirement regarding the hardware used to house the system, as for example: material, shape, size or weight._

* (Waiting for the answer of client)


