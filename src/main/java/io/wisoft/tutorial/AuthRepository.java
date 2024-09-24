package io.wisoft.tutorial;

import io.wisoft.tutorial.db.DBConnection;
import io.wisoft.tutorial.domain.User;

import java.sql.*;

public class AuthRepository {

  public User findByEmailAndPassword(String email, String password) {
    String sql = "SELECT * FROM users WHERE email = ? AND password = ?";


    try (Connection connection = DBConnection.connect()){

      assert connection != null;
      PreparedStatement preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1, email);
      preparedStatement.setString(2, password);

      ResultSet resultSet = preparedStatement.executeQuery();

      if (resultSet.next()) {
        User user = new User();
        user.setEmail(resultSet.getString("email"));
        user.setPassword(resultSet.getString("password"));
        return user;
      }else {
        return null;
      }

    }catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }

}
