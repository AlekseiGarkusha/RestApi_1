package models.registration.model_examples.pojo;

import static java.lang.String.format;

public class RegistrationResponseBodyPojoModel {

  Integer id;
  String username;
  String firstName;
  String lastName;
  String email;
  String remoteAddr;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getUserName() {
    return username;
  }

  public void setUserName(String userName) {
    this.username = userName;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getRemoteAddr() {
    return remoteAddr;
  }

  public void setRemoteAddr(String remoteAddr) {
    this.remoteAddr = remoteAddr;
  }



  @Override
  public  String toString() {
    return format("{\"id\": \"%s\", \"username\": \"%s\", " +
        "\"firstName\": \"%s\", \"lastName\":\"%s\", \"email\":\"%s\", \"remoteAddr\":\"%s\"}",
      this.id,this.username, this.firstName,this.lastName, this.email, this.remoteAddr);
  }

  public String getUsername() {
    return this.username;
  }
}
