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

> **Question:** In how many ways can the agent publish a sales announcement?
>
> **Answer:** "As an agent, I can publish any sale announcement on the system, for example received through a phone call"

> **Question:** Are there any acceptance criteria for the agent to accept/reject an order for sale? When the agent asks to open a list of orders for sale (in the system) are these separated by some criteria, for example, the type of property, or all orders are together?
>
> **Answer:** In the beginning of Sprint C we will introduce new requirements that will clarify your questions.


> **Question:** What is the range of the commission value? Is there a default limit, like a maximum of 50% in commission?
>
> **Answer:** I already answered this question.

> **Question:** Is it mandatory for the agent to input the commission value before publishing an announcement?
>
> **Answer:** Yes.

> **Question:** Is there any limit for the commission chosen by the agent? Are those limits defined by the Administrator?
>
> **Answer:** I already answered this question.

> **Question:** Are there only 2 types of commission or can the Administrator define more types of commission?
>
> **Answer:** For now we only have two types of commissions.

> **Question:** In one of the previous questions you have stated that for now the only way that a agent can receive the request to publish an announcement is through a phone call, however in the primary data necessary to create an announcement it's said that it's necessary to upload at least one photo of the property. Taking that into consideration, the announcement can't be fully made by only communicating with the owner through a phone call, how is it possible for an agent to publish an announcement without all the necessary data?
>
> **Answer:** The owner can send the photograph by e-mail or any other means. The owner can even deliver the photograph to the store.

> **Question:** Another doubt that has emmerged is related to the identification of the owner of the property, isn't it required that the owner identifies themselves in the announcement ?
>
> **Answer:** Info about the owner is not published.

> **Question:** Monetary data is expressed in any particular currency?
>  
> **Answer:** Monetary data (e.g. estimated cost of a task) is indicated in POTs (virtual currency internal to the platform).

> **Question:** In one of the previous questions you have stated that for now the only way that an agent can receive the sale announcement request is through a phone call. However, US004 states that "As an owner, I intend to submit a request for listing a property sale or rent, choosing the responsible agent". Isn't submitting a request for listing a property the same as a sale announcement request? If not, can you clarify?
>
> **Answer:** In my previous answer, when I said "...the only way that an agent can receive the sale announcement..." I was talking about the agent as an actor of the system that introduces in the system property data.

> **Question:**: Also, since the only way that an agent can receive sale announcement request is through a phone call, wouldn't that contradict what was stated in the project description: "Owners go to one of the company's branches and meet with a real estate agent to sell or rent one or more properties, or they can use the company's application for the same purposes."?
>
> **Answer:** US2: As an agent, I can publish any sale announcement on the system, for example received through a phone call. For example...

> **Question:**: Is the comission an attribute of a sale or of an announcement?
>
> **Answer:** From my previous answers and from knowledge that the students obtained in the ESOFT course, each team should know the answer to this question.
Moreover, this type of question should not be put to the client. Typically the client is not an expert in software modeling and has a lot to do beyond the project.

> **Question:**: [...] when the request arrives at the agent, are all the essential characteristics of the property in question already present?
>
> **Answer:** Yes.

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

![System Sequence Diagram - Alternative One](svg\us002-system-sequence-diagram-System_Sequence_Diagram__SSD_.svg)


### 1.7 Other Relevant Remarks

* The necessary characteristics of a property needed for listing may vary with property type.