package models.login;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)   // ← очень важно!
public record LoginBodyModel(String username, String password) {}
