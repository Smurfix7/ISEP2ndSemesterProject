# US 004 - Creating a property listing 

## 1. Requirements Engineering


### 1.1. User Story Description


As an owner, I intend to submit a request for listing a property sale or rent, choosing the responsible agent.



### 1.2. Customer Specifications and Clarifications 


**From the specifications document:**

>	Among these operations are the publication of rental
and sale advertisements, the registration of a business (lease or sale) and the scheduling and
registration of visits to the property

> From time to time, property owners contact Real Estate USA with the aim of selling or renting their
properties. Owners go to one of the company's branches and meet with a real estate agent to sell or
rent one or more properties, or they can use the company's application for the same purposes. The
owner provides property characteristics and the requested price and sends the request to an agent.

>In the case of a request for the sale of a
property, the owner must provide information on: the type of property (apartment, house or land),
the area in m2, the location, the distance from the city centre, the requested price and one or more
photographs. If the property is an apartment or a house, the owner also provides: the number of
bedrooms, the number of bathrooms, the number of parking spaces and the available equipment,
such as central heating and/or air conditioning. In case the property is a house, the existence of a
basement, an inhabitable loft, and sun exposure must be registered as well.

>After consulting a list of properties, the client can request to schedule a visit to the real estate agent
for a specific property to verify its conditions. The agent receives the request, checks the
availability and sends the response. If the customer accepts the order, it is automatically scheduled
in the system. 

**From the client clarifications:**

> **Question:** When assigning an agent to a property listing, are the available agents shown by the system for the owner to pick? Or does the owner need to provide the agent's information (name, agency,etc)?
>  
> **Answer:** The owner should select one agent from a list of agents that work in the selected agency. The owner should select the agency before selecting the agent.


> **Question:**  Does an owner need to be registered in the system to submit a request for a property listing?
>  
> **Answer:** No. When making the request to list a property, the owner should introduce his own data. The Owner attributes are: the name, the citizen's card number, the tax number, the address, the email address and the telephone number.


> **Question:**   Is there a designated currency for this business, or should we use USD?
>
> **Answer:**  Please use USD.


> **Question:**  Should we consider that, until the request is reviewed and posted, the request stays in a "not published" state?
>
> **Answer:** This is an implementation detail. For me, as a client, I want the feature implemented as I already described in the project description.


> **Question:**  When publishing a property, if the owner leaves the listing unfinished, can it be saved or stay as as a sketch to be finished later ?
>
> **Answer:** No.

### 1.3. Acceptance Criteria


* **AC1:** All required fields must be filled in and valid.
* **AC2:** Owner must choose an agency and then one agent from the available list.
* **AC3:** Depending on the type of property certain extra fields have to be filled.

### 1.4. Found out Dependencies


* There is a dependency with US002 because the agent must accept the request of the owner to publish the property listing.


### 1.5 Input and Output Data


**Input Data:**

* Typed data:
	* the owner's name, 
	* the citizenship card of said owner, 
	* the owner's tax number,
	* the owner's address,
	* the owner's email address,
	* the owner's telephone number,
    * the type of property (apartment, house or land),
    * the area in m2,
    * the location,
    * the distance from the city centre,
    * the requested price,
    * one or more photographs,
    * If the property is an apartment or a house:
      * the number of bedrooms,
      * the number of bathrooms,
      * the number of parking spaces
      * the available equipment (such as central heating and/or air conditioning),
    * In case the property is a house:
      * the existence of a basement,
      * an inhabitable loft,
      * the sun exposure.
	
* Selected data:
	* the agency,
    * the agent.


**Output Data:**

* A confirmation that a request has been sent.

### 1.6. System Sequence Diagram (SSD)

**Other alternatives might exist.**

#### Alternative One : House

![System Sequence Diagram - Alternative One](svg/us004-system-sequence-diagram-property-type-house.svg)

#### Alternative Two : Apartment

![System Sequence Diagram - Alternative Two](svg/us004-system-sequence-diagram-property-type-apartment.svg)

#### Alternative Three : Land

![System Sequence Diagram - Alternative Three](svg/us004-system-sequence-diagram-property-type-land.svg)

### 1.7 Other Relevant Remarks

* The created listing stays in a "not published" state in order to distinguish from "published" tasks.