package com.demidov.springsberminibank.web.dto;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotEmpty;

import com.demidov.springsberminibank.constraint.FieldMatch;

@FieldMatch.List({
        @FieldMatch(first = "password", second = "confirmPassword", message = "Поля Пароль должны совпадать"),
        @FieldMatch(first = "username", second = "confirmUsername", message = "Поля Имя пользователя должны совпадать")
})
public class UserRegistrationDto {

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @NotEmpty
    private String password;

    @NotEmpty
    private String confirmPassword;

    @NotEmpty
    private String username;

    @NotEmpty
    private String confirmUsername;

    @AssertTrue
    private Boolean terms;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getConfirmUsername() {
        return confirmUsername;
    }

    public void setConfirmUsername(String confirmUsername) {
        this.confirmUsername = confirmUsername;
    }
}
