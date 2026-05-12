package models.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationBodyLombokModel {

  Integer id;
  String userName;
  String firstName;
  String lastName;
  String email;
  String remoteAddr;

}


