package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.OwnerRepository;
import pt.ipp.isep.dei.esoft.project.repository.PropertyRepository;
import pt.ipp.isep.dei.esoft.project.repository.PurchaseOrderRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

import java.io.FileNotFoundException;

public class ImportLegacyFileController {
    static Repositories repositories = Repositories.getInstance();
    static PropertyRepository propertyRepository = repositories.getPropertyRepository();
    static PurchaseOrderRepository purchaseOrderRepository = repositories.getPurchaseOrderRepository();
    static OwnerRepository ownerRepository = repositories.getOwnerRepository();

    /**
     Imports a legacy file from the specified file path.
     @param filePath the path of the file to import
     @throws FileNotFoundException if the specified file is not found
     */
    public void importLegacyFile(String filePath) throws FileNotFoundException {
        ImportLegacyFile.importLegacyFile(filePath);
    }

    /**
     Adds a purchase order to the purchase order repository.
     @param purchaseOrder the purchase order to add
     */
    public void addPurchaseOrder(PurchaseOrder purchaseOrder) {
        purchaseOrderRepository.addPurchaseOrder(purchaseOrder);
        purchaseOrderRepository.addAcceptedPurchaseOrder(purchaseOrder);
    }

    /**
     Adds a land property to the property repository.
     @param land the land property to add
     */
    public void addLand(Property land) {
        propertyRepository.addProperty(land);
    }

    /**
     Adds a house property to the property repository.
     @param house the house property to add
     */
    public void addHouse(House house) {
        propertyRepository.addProperty(house);
    }

    /**
     Adds an apartment building to the property repository.
     @param apartment the apartment building to add
     */
    public void addApartment(Building apartment) {
        propertyRepository.addProperty(apartment);
    }

    /**
     Adds an owner to the owner repository.
     @param owner the owner to add
     */
    public void addOwner(Owner owner) {
        ownerRepository.addOwner(owner);
    }
}
