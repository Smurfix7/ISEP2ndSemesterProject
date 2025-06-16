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


> **Question:**  When the owner is going to make the request for listing a property for sale or rent, is he (owner) already registered in the system? If yes, before placing the order, does he need to enter any of his data, for example, email address?
> 
> **Answer:** Yes. The data is available in the system.


> **Question:**   Is there a designated currency for this business, or should we use USD?
>
> **Answer:**  Please use USD.


> **Question:**  Should we consider that, until the request is reviewed and posted, the request stays in a "not published" state?
>
> **Answer:** This is an implementation detail. For me, as a client, I want the feature implemented as I already described in the project description.


> **Question:**  When publishing a property, if the owner leaves the listing unfinished, can it be saved or stay as as a sketch to be finished later ?
>
> **Answer:** No.
 

> **Question:** What should we use to distinguish property requests made by the owner, the location of said property?
>
> **Answer:** Each request is a single order.


> **Question:** Is the owner able to edit an already active listing of a property? If so, do the edits need to be accepted by the agent before being published?
>
> **Answer:** No.


> **Question:** It has been discussed previously that the passport number should be used as person identification, can we assume that everyone has one? If not can we use the social security number instead?
>
> **Answer:** You can assume that everyone has one.


> **Question:** Should a property have a description? Should the Land refer that it’s located in an area that allows construction? If yes, should the Land have an attribute for the allowed area of constrution? t's important for Building to have the atribute "year of the construction"? In a building is it necessary to mention other equipment in addition to those described in the project? (ex: heating floor) Is it important to reference the existence of condominium in an Aparment? If yes, is it necessary have the atribute "Condominium Value" and "Payment Frequency"?
>
> **Answer:** The attributes for a property/land were already defined. I will not introduce additional attributes.


> **Question:** Can it also be unlisted by owner request?
>
> **Answer:** No.


> **Question:** Can the contract duration be defined as double or float, for example, 1.5 months?
>
> **Answer:** The contract duration is an integer number.
 

> **Question:** In the project description it is mentioned that in the case of a request for the sale of a property, the owner must provide "one or more photographs". Taking that into account, is there a maximum number of photos that can be submitted when publishing an announcement? If so, how many?
>
> **Answer:** The maximum number of photos is 30.


> **Question:** According to the statement, the administrator has to clarify the citizen's card number, but what card is it? In the US, there is no identification card, so is it referring to the passport?
>
> **Answer:** You are correct. The citizen card number should be replaced by the passport card number.


> **Question:** It was previously stated that an unregistered user could do a property listing request. However, with the introduction of US007, I want to clarify and make sure that now a user needs to be registered in order to buy, sell or rent properties, or if they can still do it unregistered.
>
> **Answer:** In Sprint B we introduce US7 and now, in US4, the owner needs to be registered in the system to submit a request for listing. You should update all artifacts to include this change.

### 1.3. Acceptance Criteria


* **AC1:** All required fields must be filled in and valid.
* **AC2:** Owner must choose an agency and then one agent from the available list.
* **AC3:** Depending on the type of property certain extra fields have to be filled.

### 1.4. Found out Dependencies


* There is a dependency with US002 because the agent must accept the request of the owner to publish the property listing.
* There is a dependency with US007 because the owner should be registered to buy, sell or lease.


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
![System Sequence Diagram](svg/us004-system-sequence-diagram.svg)
### 1.7 Other Relevant Remarks

* The created listing stays in a "not published" state in order to distinguish from "published" tasks.