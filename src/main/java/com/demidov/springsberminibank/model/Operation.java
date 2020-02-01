package com.demidov.springsberminibank.model;

import javax.persistence.*;

@Entity
@Table(name = "operations")
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long operationid;
    @Column(name = "operationName")
    private String operationName;
    @Column(name = "operationSum")
    private String operationSum;
    @Column(name = "usernameOne")
    private String usernameOne;

    @Column(name = "username")
    private String username;

    public Operation() {
    }

    public Operation(String operationName, String operationSum, String popeationContr, String userLogin, int operationId) {
        this.operationName = operationName;
        this.operationSum = operationSum;
        this.usernameOne = popeationContr;
        this.username = userLogin;
        this.operationid = operationId;
    }

    public long getOperationId() {
        return operationid;
    }

    public void setOperationId(int operationId) {
        this.operationid = operationId;
    }

    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "UserOperation{" +
                "operationName='" + operationName + '\'' +
                ", operationSum='" + operationSum + '\'' +
                ", popeationContr='" + usernameOne + '\'' +
                ", userLogin='" + username + '\'' +
                ", operationId=" + operationid +
                '}';
    }
}
