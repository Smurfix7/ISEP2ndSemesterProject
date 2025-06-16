package pt.ipp.isep.dei.esoft.project.domain;

import java.io.Serializable;
import java.util.Objects;
import org.apache.commons.lang3.StringUtils;
import pt.ipp.isep.dei.esoft.project.repository.RoleRepository;

public class Role implements Serializable {
    private String roleID;
    private String roleDescription;
    private final String ID_BY_DEFAULT = "[NO STREET]";
    private final String DESCRIPTION_BY_DEFAULT = "[NO CITY]";

    /**
     * This method creates the Role object with default attributes
     */
    public Role() {
        this.roleID = ID_BY_DEFAULT;
        this.roleDescription = DESCRIPTION_BY_DEFAULT;
    }

    /**
     * Creates the Role object
     * @param roleID
     * @param roleDescription
     */
    public Role(String roleID, String roleDescription) {
        if (!StringUtils.isBlank(roleID) && !StringUtils.isBlank(roleDescription)) {
            this.roleID = this.extractId(roleID);
            this.roleDescription = roleDescription;
        } else {
            throw new IllegalArgumentException("UserRole id and/or description cannot be blank!");
        }
    }

    /**
     * Creates the Role object
     * @param role
     */
    public Role(Role role) {
        this.roleID = role.getRoleID();
        this.roleDescription = role.getRoleDescription();
    }

    /**
     * Add the new roleID to the repository
     *
     * @param roleName to get
     * @return roleID
     */
    public static String addNewRoleID(String roleName) {
        String roleID = null;
        roleID = String.valueOf(RoleRepository.getLastRoleID(roleName) + 1);
        return roleID;
    }

    private String extractId(String id) {
        return id.trim().toUpperCase();
    }

    /**
     * This method returns the id of the Role
     * @return
     */
    public String getRoleID() {
        return this.roleID;
    }

    /**
     * This method returns the description od the Role
     * @return
     */
    public String getRoleDescription() {
        return this.roleDescription;
    }

    /**
     * This method change the description of the Role
     * @param newDescription
     * @return boolean
     */
    public boolean changeDescription(String newDescription) {
        if (StringUtils.isBlank(newDescription)) {
            return false;
        } else {
            this.roleDescription = newDescription;
            return true;
        }
    }

    public boolean hasId(String id) {
        return StringUtils.isBlank(id) ? false : this.roleID.equals(this.extractId(id));
    }

    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.roleID.hashCode();
        return hash;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o == null) {
            return false;
        } else if (this.getClass() != o.getClass()) {
            return false;
        } else {
            Role obj = (Role)o;
            return Objects.equals(this.roleID, obj.roleID);
        }
    }

    public String toString() {
        return String.format("#" + "%s - %s", this.roleID, this.roleDescription);
    }
}
