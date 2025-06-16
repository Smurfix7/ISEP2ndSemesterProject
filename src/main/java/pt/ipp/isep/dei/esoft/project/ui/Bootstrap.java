package pt.ipp.isep.dei.esoft.project.ui;
import pt.ipp.isep.dei.esoft.project.application.controller.authorization.AuthenticationController;
import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.*;

public class Bootstrap implements Runnable {

    //Add some task categories to the repository as bootstrap
    public void run() {
        Serialization.loadData();
//      addOrganization();
        addUsers();
        addRoles();
//        addAgents();
//        addAgencies();
//        addOwners();
//        addVisitRequests();
//        addListings();
//        addPurchaseOrders();
    }

    private void addPurchaseOrders() {
        Announcement announcement1 = new Announcement(new Request(new Employee(),new Owner(), new Property("land",100,10,new Address()), new Transaction()),"",10);
        Announcement announcement2 = new Announcement(new Request(new Employee(),new Owner(), new Property("land",200,10,new Address()), new Transaction()),"",10);
        Announcement announcement3 = new Announcement(new Request(new Employee(),new Owner(), new Property("land",300,10,new Address()), new Transaction()),"",10);
        Announcement announcement4 = new Announcement(new Request(new Employee(),new Owner(), new Property("land",400,10,new Address()), new Transaction()),"",10);

        PurchaseOrder purchaseOrder1 = new PurchaseOrder("test1@this.app", announcement1, 300);
        PurchaseOrder purchaseOrder2 = new PurchaseOrder("test2@this.app", announcement2, 100);
        PurchaseOrder purchaseOrder3 = new PurchaseOrder("test3@this.app", announcement3, 50);
        PurchaseOrder purchaseOrder4 = new PurchaseOrder("test4@this.app", announcement4, 50);
        PurchaseOrderRepository purchaseOrderRepository = new PurchaseOrderRepository();
        purchaseOrderRepository.addPurchaseOrder(purchaseOrder2);
        purchaseOrderRepository.addPurchaseOrder(purchaseOrder1);
        purchaseOrderRepository.addPurchaseOrder(purchaseOrder4);
        purchaseOrderRepository.addPurchaseOrder(purchaseOrder3);
        purchaseOrderRepository.acceptPurchaseOrder(purchaseOrder2);
        purchaseOrderRepository.acceptPurchaseOrder(purchaseOrder1);
        purchaseOrderRepository.acceptPurchaseOrder(purchaseOrder4);
        purchaseOrderRepository.acceptPurchaseOrder(purchaseOrder3);
    }

    private void addListings() {
        Address address1 = new Address("Lt Jenkins", "Huston", "Texas", "23423");
        Role role1 = new Role("01", "Agent");
        PassportCard passportCard1 = new PassportCard("232424232");
        Agency agency1 = new Agency("TechSupportScammers", "techsupportscammers@gmail.com", "123-123-1234", address1);
        Employee agent1 = new Employee("José", "20202", "agent@this.app", "919191991", address1, role1, passportCard1, agency1);
        Address address2 = new Address("Lt Gambalord", "Illinois City", "Illinois", "23483");
        Role role2 = new Role("01", "Agent");
        PassportCard passportCard2 = new PassportCard("233424232");
        Person owner = new Person("Maria", "20202", "owner2@this.app", "919191991", address2, role2, passportCard2);

        Agency.createRequest("Apartment", null, owner, new Equipment(), agent1, 2000, 1123, "2022-06-01", null, "ST Louis Street", "New York", "Washington DC", "91826", 5, 2, 3, "", "", "", "WHOLESALE", 50000);
        Agency.createRequest("House", null, owner, new Equipment(), agent1, 1500, 123, "2022-06-01", null, "ST Louis Street", "New York", "Washington DC", "91226", 2, 3, 4, "Y", "N", "S", "WHOLESALE", 35000);
        Agency.createRequest("Land", null, owner, new Equipment(), agent1, 4000, 123, "2022-06-01", null, "ST Louis Street", "New York", "Washington DC", "91226", 0, 0, 0, "", "", "", "WHOLESALE", 40000);

    }

    private void addVisitRequests() {
        AnnouncementRepository announcementRepository = new AnnouncementRepository();

        User user1 = new User("Rodrigo", "rodrigo@this.app", "user1", "122-122-1222");
        Address address1 = new Address("Lt Jenkins", "Huston", "Texas", "23423");
        Role role1 = new Role("01", "Agent");
        PassportCard passportCard1 = new PassportCard("232424232");
        Agency agency1 = new Agency("TechSupportScammers", "techsupportscammers@gmail.com", "123-123-1234", address1);
        Employee agent1 = new Employee("José", "20202", "agent@this.app", "919191991", address1, role1, passportCard1, agency1);
        Employee agent2 = new Employee("Miguel", "20202", "miguel@this.app", "919191991", address1, role1, passportCard1, agency1);
        Person owner = new Person("Maria", "20202", "owner2@this.app", "919191991", address1, role1, passportCard1);
        Request request1 = new Request(agent1,owner,new Property("house",100,100,address1),new Transaction());
        Request request2 = new Request(agent2,owner,new Property("house",100,100,address1),new Transaction());

        Announcement announcement = new Announcement(request1,"",1000);
        announcementRepository.addAnnouncement(announcement);
        VisitRequest visitRequest1 = new VisitRequest(user1.getName(), user1.getEmailAddress(), user1.getPassword(), user1.getTelephoneNumber(), announcement, "21-12-2023", "30");
        VisitRequestsRepository.addVisitRequested(visitRequest1);

        User user2 = new User("Alfredo", "alfredo@this.app", "user2", "122-122-1222");
        Announcement announcement2 = new Announcement(request2,"",1000);
        announcementRepository.addAnnouncement(announcement2);
        VisitRequest visitRequest2 = new VisitRequest(user2.getName(), user2.getEmailAddress(), user2.getPassword(), user2.getTelephoneNumber(), announcement2, "21-12-2020", "30");
        VisitRequestsRepository.addVisitRequested(visitRequest2);

        User user3 = new User("Afonso", "afonso@this.app", "user3", "122-122-1222");
        Announcement announcement3 = new Announcement(request1,"",1000);
        announcementRepository.addAnnouncement(announcement3);
        VisitRequest visitRequest3 = new VisitRequest(user3.getName(), user3.getEmailAddress(), user3.getPassword(), user3.getTelephoneNumber(), announcement3, "21-12-2021", "30");
        VisitRequestsRepository.addVisitRequested(visitRequest3);

        User user4 = new User("Ricardo", "ricardo@this.app", "user4", "122-122-1222");
        Announcement announcement4 = new Announcement(request1,"",1000);
        announcementRepository.addAnnouncement(announcement4);
        VisitRequest visitRequest4 = new VisitRequest(user4.getName(), user4.getEmailAddress(), user4.getPassword(), user4.getTelephoneNumber(), announcement4, "21-12-2022", "30");
        VisitRequestsRepository.addVisitRequested(visitRequest4);
    }

    private void addOrganization() {
        //TODO: add organizations bootstrap here
        //get organization repository
        OrganizationRepository organizationRepository = Repositories.getInstance().getOrganizationRepository();
        Organization organization = new Organization("This Company");
        organization.addEmployee(new Employee("admin@this.app"));
        organization.addEmployee(new Employee("employee@this.app"));
        organization.addEmployee(new Employee("user@this.app"));
        organizationRepository.add(organization);
    }

    private void addTaskCategories() {
        //TODO: add bootstrap Task Categories here

        //get task category repository
        TaskCategoryRepository taskCategoryRepository = Repositories.getInstance().getTaskCategoryRepository();
        taskCategoryRepository.add(new TaskCategory("Analysis"));
        taskCategoryRepository.add(new TaskCategory("Design"));
        taskCategoryRepository.add(new TaskCategory("Implementation"));
        taskCategoryRepository.add(new TaskCategory("Development"));
        taskCategoryRepository.add(new TaskCategory("Testing"));
        taskCategoryRepository.add(new TaskCategory("Deployment"));
        taskCategoryRepository.add(new TaskCategory("Maintenance"));
    }

    private void addRoles() {
        Role role1 = new Role("01", "Agent");
        RoleRepository.addAgencyRole(role1);
        Role role2 = new Role("02", "Administrator");
        RoleRepository.addAgencyRole(role2);
    }
    private void addUsers() {
        //TODO: add Authentication users here: should be created for each user in the organization


        AuthenticationRepository authenticationRepository = Repositories.getInstance().getAuthenticationRepository();


        authenticationRepository.addUserRole(AuthenticationController.ROLE_ADMIN,
                AuthenticationController.ROLE_ADMIN);

        authenticationRepository.addUserRole(AuthenticationController.ROLE_EMPLOYEE,
                AuthenticationController.ROLE_EMPLOYEE);

        authenticationRepository.addUserRole(AuthenticationController.ROLE_AGENT,
                AuthenticationController.ROLE_AGENT);

        authenticationRepository.addUserRole(AuthenticationController.ROLE_USER,
                AuthenticationController.ROLE_USER);

        authenticationRepository.addUserRole(AuthenticationController.ROLE_STORE_MANAGER,
                AuthenticationController.ROLE_STORE_MANAGER);

        authenticationRepository.addUserRole(AuthenticationController.ROLE_NETWORK_MANAGER,
                AuthenticationController.ROLE_NETWORK_MANAGER);

        authenticationRepository.addUserWithRole("Main Administrator", "admin@this.app", "admin",
                AuthenticationController.ROLE_ADMIN);

        authenticationRepository.addUserWithRole("Network Manager", "net@this.app", "net",
                AuthenticationController.ROLE_NETWORK_MANAGER);

        authenticationRepository.addUserWithRole("Store Manager", "store@this.app", "store",
                AuthenticationController.ROLE_STORE_MANAGER);

        authenticationRepository.addUserWithRole("Agent", "agent@this.app", "agent",
                AuthenticationController.ROLE_AGENT);

        authenticationRepository.addUserWithRole("Agent José", "jose@this.app", "jose",
                AuthenticationController.ROLE_AGENT);

        authenticationRepository.addUserWithRole("Employee", "employee@this.app", "pwd",
                AuthenticationController.ROLE_EMPLOYEE);

        authenticationRepository.addUserWithRole("User", "user@this.app", "user",
                AuthenticationController.ROLE_USER);

        authenticationRepository.addUserWithRole("User2", "user2@this.app", "user",
                AuthenticationController.ROLE_USER);

        authenticationRepository.addUserWithRole("Agent", "employee@this.app", "01AGEnt",
                AuthenticationController.ROLE_AGENT);

        authenticationRepository.addUserWithRole("Agent", "employee3@this.app", "01AGEnt",
                AuthenticationController.ROLE_AGENT);

        authenticationRepository.addUserWithRole("Client 1", "owner1@this.app", "01CLIen",
                AuthenticationController.ROLE_USER);

    }

    private void addOwners() {
        Owner owner = new Owner("Client1", "123456789",  "123-233-2134","owner1@this.app", new Address("street", "city", "state", "12345"), new Role("04", "OWNER"), new PassportCard("123469"));
        OwnerRepository.addOwner(owner);
        Owner owner1 = new Owner("user",  "123456789","123-233-2134","owner@this.app", new Address("street", "city", "state", "12345"), new Role("04", "OWNER"), new PassportCard("123469"));
        OwnerRepository.addOwner(owner1);
    }

    private void addAgents() {
        Address address1 = new Address("Lt Jenkins", "Huston", "Texas", "23423");
        Role role1 = new Role("1", "AGENT");
        RoleRepository.addAgencyRole(role1);
        PassportCard passportCard1 = new PassportCard("232424232");
        Agency agency1 = new Agency("TechSupportScammers", "techsupportscammers@gmail.com", "123-123-1234", address1);
        Employee agent1 = new Employee("José", "20202", "agent@this.app", "919191991", address1, role1, passportCard1, agency1);

        EmployeeRepository.addAgent(agent1);

        Address address2 = new Address("Lt Gambalord", "Illinois City", "Illinois", "23483");
        Role role2 = new Role("1", "STORE_MANAGER");
        RoleRepository.addAgencyRole(role2);
        PassportCard passportCard2 = new PassportCard("233424232");
        Employee agent2 = new Employee("José", "20202", "agent@this.app", "919191991", address2, role2, passportCard2, agency1);

        EmployeeRepository.addNetworkManager(agent2);

        Address address3 = new Address("Lt Jenkins", "Huston", "Texas", "23423");
        Role role3 = new Role("2", "STORE_MANAGER");
        RoleRepository.addAgencyRole(role3);
        PassportCard passportCard3 = new PassportCard("C12345678");
        Agency agency3 = new Agency("TechSupportScammers", "techsupportscammers@gmail.com", "123-123-1234", address3);
        Employee agent3 = new Employee("Alfredo", "123-12-1234", "alf@this.app", "123-123-1234", address3, role3, passportCard3, agency3);

        EmployeeRepository.addStoreManager(agent3);

        Address address4 = new Address("Lt Jenkins", "Huston", "Texas", "23423");
        Role role4 = new Role("2", "AGENT");
        RoleRepository.addAgencyRole(role4);
        PassportCard passportCard4 = new PassportCard("C87654321");
        Agency agency4 = new Agency("TechSupportScammers", "techsupportscammers@gmail.com", "123-123-1234", address4);
        Employee agent4 = new Employee("Rodrigo", "123-12-2234", "rod@this.app", "123-123-1234", address4, role4, passportCard4, agency4);

        EmployeeRepository.addAgent(agent4);
    }
}
