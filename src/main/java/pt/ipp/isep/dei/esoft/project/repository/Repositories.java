package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Network;

public class Repositories {
    private static final Repositories instance = new Repositories();

    AnnouncementRepository announcementRepository = new AnnouncementRepository();
    PurchaseOrderRepository purchaseOrderRepository = new PurchaseOrderRepository();

    RequestsRepository requestsRepository = new RequestsRepository();
    PropertyRepository propertyRepository = new PropertyRepository();
    TaskCategoryRepository taskCategoryRepository = new TaskCategoryRepository();
    OrganizationRepository organizationRepository = new OrganizationRepository();
    AuthenticationRepository authenticationRepository = new AuthenticationRepository();
    PropertyTypeRepository propertyTypeRepository = new PropertyTypeRepository();
    VisitRequestsRepository visitRequestsRepository = new VisitRequestsRepository();
    Network agencyRepository = new Network();
    EmployeeRepository employeeRepository = new EmployeeRepository();

    OwnerRepository ownerRepository = new OwnerRepository();
    RoleRepository roleRepository = new RoleRepository();
    PersonRepository personRepository = new PersonRepository();

    private Repositories() {
    }

    public OwnerRepository getOwnerRepository() {
        return ownerRepository;
    }

    public static Repositories getInstance() {
        return instance;
    }

    public RequestsRepository getRequestsRepository() {
        return requestsRepository;
    }

    public VisitRequestsRepository getVisitRequestsRepository() {
        return visitRequestsRepository;
    }

    public PurchaseOrderRepository getPurchaseOrderRepository() { return purchaseOrderRepository; }



    public AnnouncementRepository getAnnouncementRepository() {
        return announcementRepository;
    }

    public PropertyRepository getPropertyRepository() {
        return propertyRepository;
    }

    public PropertyTypeRepository getPropertyTypeRepository() {
        return propertyTypeRepository;
    }

    public OrganizationRepository getOrganizationRepository() {
        return organizationRepository;
    }

    public TaskCategoryRepository getTaskCategoryRepository() {
        return taskCategoryRepository;
    }

    public AuthenticationRepository getAuthenticationRepository() {
        return authenticationRepository;
    }

    public Network getAgencyRepository() {
        return agencyRepository;
    }

    public EmployeeRepository getAgentRepository() {
        return employeeRepository;
    }

    public RoleRepository getRoleRepository() {
        return roleRepository;
    }

    public PersonRepository getPersonRepository() {
        return personRepository;
    }

}
