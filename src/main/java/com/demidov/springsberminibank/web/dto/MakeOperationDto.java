package com.demidov.springsberminibank.web.dto;

import javax.validation.constraints.NotEmpty;

public class MakeOperationDto {

    @NotEmpty
    private String operationSum;

    @NotEmpty
    private String usernameOne;

    public String getOperationSum() {
        return operationSum;
    }

    public void setOperationSum(String operationSum) {
        this.operationSum = operationSum;
    }

    public String getUsernameOne() {
        return usernameOne;
    }

    public void setUsernameOne(String usernameOne) {
        this.usernameOne = usernameOne;
    }
}
