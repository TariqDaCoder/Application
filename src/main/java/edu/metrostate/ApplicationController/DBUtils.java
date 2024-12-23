package edu.metrostate.ApplicationController;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import edu.metrostate.PageController.AccountInfo;
import edu.metrostate.PageController.Login;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;


public class DBUtils {

    public static void changeScene(ActionEvent event, String fxmlFile, String title) {

        Parent root = null;

        try {
            root = FXMLLoader.load(DBUtils.class.getResource(fxmlFile));

        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle(title);
        stage.setScene(new Scene(root, 430, 750));
        stage.show();
    }

    private static Session session;
    private static int lport;
    private static String rhost;
    private static int rport;

    // Establish SSH connection
    public static void establishSshConnection() {
        String user = "kxayamongkhon";  // SSH username
        String password = "";   // SSH password
        String host = "76.17.205.230";  // SSH host server db.kxdomain.com  73.62.245.119
        int port = 22;  // SSH port

        // Disconnect existing ssh session if it is active
        if (session != null && session.isConnected()) {
            session.disconnect();
        }

        try {
            // Port forwarding
            JSch jsch = new JSch();
            session = jsch.getSession(user, host, port);
            lport = 4321;   // Local port to forward
            rhost = "localhost";    // Remote database host
            rport = 3306;   // Remote database port

            session.setPassword(password);
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();
            session.setPortForwardingL(lport, rhost, rport);
        } catch (Exception e) {
            System.err.print(e);
        }
    }

    // Method to create a database connection
    public static Connection getDatabaseConnection() throws SQLException {
        String driver = "org.mariadb.jdbc.Driver";  // MariaDB driver
        String url = "jdbc:mariadb://localhost:" + lport + "/"; // Localhost with forwarded port
        String db = "sportsApplicationDataBase";    // Database name
        String dbUser = "kavin1";   // Database username
        String dbPasswd = "";    // Database password

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new SQLException("MariaDB JDBC Driver not found.");
        }

        return DriverManager.getConnection(url + db, dbUser, dbPasswd);
    }

    // Method to log in a user
    public static void logInUser(ActionEvent event, String email, String password) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = getDatabaseConnection();
            preparedStatement = connection.prepareStatement(
                    "SELECT password, email, profilePicture FROM userAccount WHERE email = ?"
            );
            preparedStatement.setString(1, email);
            resultSet = preparedStatement.executeQuery();

            if (!resultSet.isBeforeFirst()) {
                System.out.println("User not found");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Email or Password are Incorrect");
                alert.show();
            } else {
                while (resultSet.next()) {
                    String retrievedPassword = resultSet.getString("password");
                    String retrievedEmail = resultSet.getString("email");

                    if (retrievedPassword.equals(password)) {
                        Login.setLoggedIn(true);
                        FXMLLoader loader = new FXMLLoader(DBUtils.class.getResource("/edu/metrostate/PageView/AccountInfo.fxml"));
                        Parent root = loader.load();

                        AccountInfo controller = loader.getController();
                        controller.setAccountInfo(retrievedEmail, retrievedPassword);

                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        stage.setScene(new Scene(root));
                        stage.setTitle("Account Info");
                        stage.show();
                    } else {
                        System.out.println("Password Invalid");
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("The password entered doesn't match");
                        alert.show();
                    }
                }
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        } finally {
            try { if (resultSet != null) resultSet.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (preparedStatement != null) preparedStatement.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (connection != null) connection.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
    }


    // Method to sign up a user
    public static void signUpUser(ActionEvent event, String email, String password) {
        Connection connection = null;
        PreparedStatement psInsert = null;
        PreparedStatement psCheckUserExist = null;
        ResultSet resultSet = null;

        try {
            connection = getDatabaseConnection();
            psCheckUserExist = connection.prepareStatement("SELECT * FROM userAccount WHERE email = ?");
            psCheckUserExist.setString(1, email);
            resultSet = psCheckUserExist.executeQuery();

            if (resultSet.isBeforeFirst()) {
                System.out.println("User already exists");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("An account for this email already exists");
                alert.show();
            } else {
                psInsert = connection.prepareStatement("INSERT INTO userAccount (email, password) VALUES (?, ?)");
                psInsert.setString(1, email);
                psInsert.setString(2, password);
                psInsert.executeUpdate();

                Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                successAlert.setTitle("Success");
                successAlert.setHeaderText(null);
                successAlert.setContentText("Your account has been created successfully!");
                successAlert.showAndWait();

                changeScene(event, "/edu/metrostate/PageView/Login.fxml", "Login");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try { if (resultSet != null) resultSet.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (psCheckUserExist != null) psCheckUserExist.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (psInsert != null) psInsert.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (connection != null) connection.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
    }



}