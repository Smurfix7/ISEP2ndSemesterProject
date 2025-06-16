package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Role;

import java.util.ArrayList;
import java.util.List;

public class RoleRepository {

    /**
     * List of roles
     */
    public static List<Role> roles = new ArrayList<>();

    /**
     * List of agency roles
     */
    public static List<Role> agencyRoles = new ArrayList<>();

    /**
     * List of agency role names
     */
    public static List<String> agencyRoleNames = new ArrayList<>();

    /**
     * Size of the repository
     */
    static int size = 0;

    /**
     * Gets the last roleID from the repository
     *
     * @param roleName to get
     * @return the role if it exists
     */
    public static int getLastRoleID(String roleName) {
        int roleID = 0;
        for (int position = 0; position < roles.size(); position++) {
            if (roles.get(position).getRoleDescription() == roleName) {
                roleID = Integer.parseInt(roles.get(position).getRoleID());
            }
        }
        return roleID;
    }

    /**
     * Adds a role to the repository
     *
     * @param role
     */
    public static void addRole(Role role) {
        roles.add(role);
        size++;
    }

    /**
     * Adds a agency role to the repository
     *
     * @param agencyRole
     */
    public static void addAgencyRole(Role agencyRole) {
        agencyRoles.add(agencyRole);
        if (!agencyRoleNames.contains(agencyRole.getRoleDescription())) {
            agencyRoleNames.add(agencyRole.getRoleDescription());
        }
        roles.add(agencyRole);
        size++;
    }

    /**
     * Returns the size of the repository.
     *
     * @return size of the repository
     */
    public static int size() {
        return size;
    }
}
