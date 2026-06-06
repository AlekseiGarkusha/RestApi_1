package models.pojo;

public class RegistrationBodyPojoModel {

  String username;
  String password;

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String userName) {
    this.username = userName;
  }

  @Override
  public String toString() {
    return "{\"username\": \"" + this.username + "\", \"password\": \"" + this.password + "\"}";

  }
}


