package pt.ipp.isep.dei.esoft.project.ui.gui.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import pt.ipp.isep.dei.esoft.project.application.controller.authorization.AuthenticationController;
import pt.ipp.isep.dei.esoft.project.ui.console.menu.*;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;
import pt.ipp.isep.dei.esoft.project.ui.gui.AgentGUI;
import pt.ipp.isep.dei.esoft.project.ui.gui.MainGUI;
import pt.ipp.isep.dei.esoft.project.ui.gui.NetworkManagerGUI;
import pt.ipp.isep.dei.esoft.project.ui.gui.StoreManagerGUI;
import pt.isep.lei.esoft.auth.mappers.dto.UserRoleDTO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class MainController {
    @FXML
    private Label errorText;

    @FXML
    private TextField userEmailTextField;

    @FXML
    private TextField passwordTextField;

    AuthenticationController authenticationController = new AuthenticationController();

    @FXML
    protected void onLogInButtonClick() throws Exception {
        boolean success = doLogin();
        userEmailTextField.setText("");
        passwordTextField.setText("");
        if (success) {
            errorText.setText("");
            List<UserRoleDTO> roles = this.authenticationController.getUserRoles();
            if ((roles == null) || (roles.isEmpty())) {
                System.out.println("No role assigned to user.");
            } else {
                UserRoleDTO role = selectsRole(roles);
                if (!Objects.isNull(role)) {
                    List<MenuItem> rolesUI = getMenuItemForRoles();
                    this.redirectToRoleUI(rolesUI, role);
                } else {
                    System.out.println("No role selected.");
                }
            }
        }
        authenticationController.doLogout();
    }


    private boolean doLogin() {
        boolean success = false;
        String id = userEmailTextField.getText();
        String pwd = passwordTextField.getText();

        success = authenticationController.doLogin(id, pwd);
        if (!success) {
            errorText.setText("Invalid UserID and/or Password.");
        }
        return success;
    }

    private List<MenuItem> getMenuItemForRoles() {
        List<MenuItem> rolesUI = new ArrayList<>();
        rolesUI.add(new MenuItem(AuthenticationController.ROLE_AGENT, new AgentGUI()));
        rolesUI.add(new MenuItem(AuthenticationController.ROLE_STORE_MANAGER, new StoreManagerGUI()));
        rolesUI.add(new MenuItem(AuthenticationController.ROLE_NETWORK_MANAGER, new NetworkManagerGUI()));
        return rolesUI;
    }

    private void redirectToRoleUI(List<MenuItem> rolesUI, UserRoleDTO role) throws Exception {
        boolean found = false;
        Iterator<MenuItem> it = rolesUI.iterator();
        while (it.hasNext() && !found) {
            MenuItem item = it.next();
            found = item.hasDescription(role.getDescription());
            if (found) {
                item.start();
                MainGUI.stage.close();
            }
        }
        if (!found) {
            errorText.setText("There is no GUI for users with role '" + role.getDescription() + "'");
        }
    }

    private UserRoleDTO selectsRole(List<UserRoleDTO> roles) {
        if (roles.size() == 1) {
            return roles.get(0);
        } else {
            return (UserRoleDTO) Utils.showAndSelectOne(roles, "Select the role you want to adopt in this session:");
        }
    }

}