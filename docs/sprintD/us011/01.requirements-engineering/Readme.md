# US 011 - To accept or decline a purchase order for a property

## 1. Requirements Engineering


### 1.1. User Story Description


As an agent, I want to list real estate purchase orders to accept or decline a
purchase order for a property. After accepting or declining, an email notification
should be sent to the customer.


### 1.2. Customer Specifications and Clarifications


**From the specifications document:**

>   "When the client decides to buy/rent the property, he sends a request for the purchase/lease of the
property to the agent. After being appreciated by the agent, he accepts or rejects the order. If the
request is accepted, the offer will not be shown again to clients using the application."

**From the client clarifications:**

> **Question:**  Regarding US011 should we provide all the property characteristics to assist agents in choosing the appropriate purchase order? If so, is it required to display the amount established by the property owner? 
>
> **Answer:** Yes. Yes.

> **Question:** However, it is unclear whether the agent should be asked to accept or decline each offer individually or whether all the offers should be presented at once, with the agent choosing only one. Asking the agent to accept or decline each offer separately would not allow for easy comparison between the offers. In light of this, should we present all the offers together and ask the agent to choose only one, automatically declining the others?
>
> **Answer:** I already answered this question.

> **Question:** When the agent wants to list real estate purchase orders, does he/she list all of them at once or can a property be chosen to list the purchase orders that are related to that specific property?
>
> **Answer:** The properties should be sorted from the oldest to the most recent one. For each property, the list of purchase orders should be sorted by the amount offered, the highest offer must appear first.

> **Question:** When the agent declines an order, she has to be removed from the list and system?
>
> **Answer:** The order should be removed from the list but not from the system.

> **Question:** The notification should be sent to the client, but we need to consider this client the owner or the potential buyer?
> 
> **Answer:** The client is the registered user that placed the order (in US10).

> **Question:** Assuming the previous anwser is the potential buyer, should the owner be informed about the sale success?
> 
> **Answer:** The owner will be contacted by means of a phone call. This is not a feature of the system.

### 1.3. Acceptance Criteria


* **AC1:** The list of purchase orders should be grouped by property. The properties
  should be sorted from the oldest to the most recent one. For each property, the
  list of purchase orders should be sorted by the amount offered, the highest offer
  must appear first.
* **AC2:** For each offer, the agent must be able to accept or decline it. The action of
  accepting or declining an offer should trigger an email notification to the client.
* **AC3:** When a purchase order is accepted, all the other orders should be declined,
  and a message sent to the client.
* **AC4:** If a property does not contain any offers, the system should show an empty
  list of offers.

### 1.4. Found out Dependencies

* (US002) There is a dependency on "As an agent, I can publish any sale announcement on the system, for
  example received through a phone call." as it creates a new announcement that will be the "target" to a purchase order.
* (US003) There is a dependency on "As a system administrator, I want to register a new employee." as it creates the agent that will handle the purchase orders.
* (US004) There is a dependency on "As an owner, I intend to submit a request for listing a property sale or rent,
  choosing the responsible agent." as it creates the request that will then be accepted and be the "target" of a future purchase order.
* (US010) There is a dependency on "As a client, I place an order to purchase the property, submitting the order
  amount" because the agent needs the customer to place the order to buy a property and decide whether to accept or reject it.

### 1.5 Input and Output Data


**Input Data:**

* Typed data:
  * None

**Selected Data:**
  * The property
  * Purchase order to be accepted

**Output Data:**
* (un)successful operation.

### 1.6. System Sequence Diagram (SSD)

![System Sequence Diagram](svg/us011-System-Sequence-Diagram.svg)

### 1.7 Other Relevant Remarks

* There is no other relevant remarks at the moment.