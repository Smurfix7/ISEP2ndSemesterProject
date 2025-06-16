# US 002 - To publish a sales announcement 

## 1. Requirements Engineering


### 1.1. User Story Description


As an agent, I can publish any sale announcement on the system, for
example received through a phone call.



### 1.2. Customer Specifications and Clarifications 


**From the specifications document:**

>	The agent should be able to review advertisement requests and register them in the system. 


>	The agent should be able to publish previously registered requests so they are visible to all clients in the app. 



**From the client clarifications:**

> **Question:** Which is the unit of measurement used to estimate duration?
>  
> **Answer:** Duration is estimated in days.


> **Question:** Monetary data is expressed in any particular currency?
>  
> **Answer:** Monetary data (e.g. estimated cost of a task) is indicated in POTs (virtual currency internal to the platform).


### 1.3. Acceptance Criteria


* **AC1:** All required property listing characteristics must be filled in.
* **AC2:** All property attributes must be a correct value.
* **AC3:** When publishing the agent assigned to the property must be an existing agent.


### 1.4. Found out Dependencies


* There exists a dependeny to US004 and US003, in regard to US003 employees need to have been created in order to be published as the agent assigned to a certain property.
* When it comes to US004, the attributes listed with a property need to be correct so that the advertisement listing is also correct.


### 1.5 Input and Output Data


**Input Data:**

* Typed data:
	* assigned agent
	
* Selected data:
	* Classifying task category 
    * The type of property (apartment, house or land);
    * The area in m2;
    * The location;
    * The distance from the city centre;
    * The request price;
    * Photographs;
    * The number of bathrooms;
    * The number of parking spaces;
    * The available equipment;
    * Central heating and/or air conditioning;
    * The existence of a basement;
    * The existence of an inhabitable loft;
    * The sun exposure;


**Output Data:**

* All the relevant selected Data must be pushed out to the list of viewable properties
* The agent responsible for the sales

### 1.6. System Sequence Diagram (SSD)

**Other alternatives might exist.**

![System Sequence Diagram - Alternative One](svg\us002-system-sequence-diagram-Agent_Sequence_Diagram__SSD.svg)
2

### 1.7 Other Relevant Remarks

* The necessary characteristics of a property needed for listing may vary with property type.