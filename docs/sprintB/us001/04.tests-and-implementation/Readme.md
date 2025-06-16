# US 001 - To Display Listed Properties 

# 4. Tests 

## PropertyListController
**Test 1:** Check that its possible to create SelectedParameters object successfully. (to be done) 

    @Test
    void createSelectedParameters() {
    }

**Test 2:** Check that its possible to display the AnnouncementList with the SelectedParameters. (to be done)

    @Test
    void displayAnnouncementList() {
    }

## SelectedParameters

**Test 1:** Check if its possible to get the selected Business Type parameter.

    @Test
    void getBusinessType() {
        SelectedParameters selectedParameters = new SelectedParameters();

        selectedParameters.setBusinessType("test");
        assertEquals("test",selectedParameters.getBusinessType());
    }

**Test 2:** Check if its possible to change the selected Business Type parameter.

    @Test
    void setBusinessType() {
        SelectedParameters selectedParameters = new SelectedParameters();

        selectedParameters.setBusinessType("test");
        assertEquals("test",selectedParameters.getBusinessType());
    }

**Test 3:** Check if its possible to get the selected Property Type parameter.

    @Test
    void getPropertyType() {
        SelectedParameters selectedParameters = new SelectedParameters();

        selectedParameters.setPropertyType("test");
        assertEquals("test",selectedParameters.getPropertyType());
    }

**Test 4:** Check if its possible to change the selected Property Type parameter.

    @Test
    void setPropertyType() {
        SelectedParameters selectedParameters = new SelectedParameters();

        selectedParameters.setPropertyType("test");
        assertEquals("test",selectedParameters.getPropertyType());
    }

**Test 5:** Check if its possible to get the selected Number Rooms parameter.

    @Test
    void getNumberRooms() {
        SelectedParameters selectedParameters = new SelectedParameters();

        selectedParameters.setNumberRooms(20);
        assertEquals(20,selectedParameters.getNumberRooms());
    }

**Test 6:** Check if its possible to change the selected Number Rooms parameter.

    @Test
    void setNumberRooms() {
        SelectedParameters selectedParameters = new SelectedParameters();

        selectedParameters.setNumberRooms(20);
        assertEquals(20,selectedParameters.getNumberRooms());
    }

**Test 7:** Check if its possible to get the selected Price Sorting parameter.

    @Test
    void getPriceSorting() {
        SelectedParameters selectedParameters = new SelectedParameters();

        selectedParameters.setPriceSorting("Ascending");
        assertEquals("Ascending",selectedParameters.getPriceSorting());
    }

**Test 8:** Check if its possible to change the selected Price Sorting parameter.

    @Test
    void setPriceSorting() {
        SelectedParameters selectedParameters = new SelectedParameters();

        selectedParameters.setPriceSorting("Ascending");
        assertEquals("Ascending",selectedParameters.getPriceSorting());
    }

**Test 9:** Check if its possible to get the selected Address parameter.

    @Test
    void getAddress() {
        SelectedParameters selectedParameters = new SelectedParameters();

        Address ad1 = new Address("a","d","r","e","s");
        selectedParameters.setAddress("a","d","r","e","s");
        assertEquals(ad1,selectedParameters.getAddress());
    }

**Test 10:** Check if its possible to change the selected Address parameter.

    @Test
    void setAddress() {
        SelectedParameters selectedParameters = new SelectedParameters();

        Address ad1 = new Address("a","d","r","e","s");
        selectedParameters.setAddress("a","d","r","e","s");
        assertEquals(ad1,selectedParameters.getAddress());
    }

*It is also recommended to organize this content by subsections.* 

# 5. Construction (Implementation)


## Class PropertyListController (to be updated)

```java
public class PropertyListController {
    public SelectedParameters createSelectedParameters(String businessType, String propertyType, int numberRooms, String priceSorting, String street, String city, String district, String state, String zipCode) {
        return new SelectedParameters(businessType, propertyType, numberRooms, priceSorting, street, city, district, state, zipCode);
    }
    public void displayAnnouncementList(AnnouncementRepository announcements, SelectedParameters selectedParameters){
    }
}
```


## Class SelectedParameters

```java
public class SelectedParameters {
    public SelectedParameters(String businessType, String propertyType, int numberRooms, String priceSorting, String street, String city, String district, String state, String zipCode) {
        this.businessType = businessType;
        this.propertyType = propertyType;
        this.numberRooms = numberRooms;
        this.priceSorting = priceSorting;
        this.address = new Address(street, city, district, state, zipCode);
    }
}
```

# 6. Integration and Demo 

* None at the moment

# 7. Observations

The display of the Property List varies depending on the format in which is presented (console / visual (JavaFX)). 






