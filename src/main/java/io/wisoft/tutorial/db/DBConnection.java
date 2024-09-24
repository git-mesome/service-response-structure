package io.wisoft.tutorial.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
  public static Connection connect() throws SQLException {

    try {
      String url = "jdbc:postgresql://localhost:54323/service_response";
      String user = "minseo";
      String password = "minseo";

      return DriverManager.getConnection(url, user, password);

    } catch (SQLException e) {
      System.err.println(e.getMessage());
      return null;
    }

  }


}
