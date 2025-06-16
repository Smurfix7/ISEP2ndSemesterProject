# US 012 - To import information from a legacy system

## 3. Design - User Story Realization

### 3.1. Rationale

**SSD - Alternative 1 is adopted.**

| Interaction ID                                             | Question: Which class is responsible for...                            | Answer                                                              | Justification (with patterns)                                                                                 |
|:-----------------------------------------------------------|:-----------------------------------------------------------------------|:--------------------------------------------------------------------|:--------------------------------------------------------------------------------------------------------------|
| Step 1: asks to import information from a legacy system 		 | 	...instantiating the class that handles the UI?                       | ImportLegacyFileUI                                                  | Pure Fabrication: there is no reason to assign this responsibility to any existing class in the Domain Model. |
| 			  		                                                    | 	... coordinating the US?                                              | ImportLegacyFileController                                          | Controller                                                                                                    |
| Step 2: requests file name		                               | ...displaying the UI for the actor to input data?						                | ImportLegacyFileUI                                                  | Pure Fabrication                                                                                              |
| Step 3: types file name and submits data                   | ...temporarily keeping input data?                                     | ImportLegacyFileUI                                                  | Pure Fabrication                                                                                              |
| 		                                                         | 	...creating the LegacyFile Object?                                    | LegacyFile                                                          | Creator (Rule: 1/2)                                                                                           | 
| 	                                                          | ...validating the data locally (mandatory data)?                       | LegacyFile                                                          | IE: is responsible for file´s register                                                                        | 
| 		                                                         | 	...adding to a collection and globally validating duplicated records? | LegacyFileRepository<br/>OwnerRepository<br/>AnnouncementRepository | IE: owns all its files                                                                                        |
| Step 4: displays operation success 		                      | 	...informing operation success?                                       | ImportLegacyFileUI                                                  | Pure Fabrication                                                                                              | 

### Systematization ##

According to the taken rationale, the conceptual classes promoted to software classes are:

* LegacyFile

Other software classes (i.e. Pure Fabrication) identified:

* ImportLegacyFileUI
* ImportLegacyFileController
* LegacyFileRepository
* OwnerRepository
* AnnouncementRepository

## 3.2. Sequence Diagram (SD)

### Full Diagram

This diagram shows the full sequence of interactions between the classes involved in the realization of this user story.

![Sequence Diagram - Full](svg/us012-sequence-diagram-full.svg)

## 3.3. Class Diagram (CD)

![Class Diagram](svg/us012-class-diagram.svg)