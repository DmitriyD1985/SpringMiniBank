package com.demidov.springsberminibank.web.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class MakeOperationDto {

        @Size(min=1, message= "whatever")
        private long operationSum;

        @NotEmpty
        private String username;

        @NotEmpty
        private String usernameOne;

        @NotEmpty
        private String operationName;

        public long getOperationSum() {
                return operationSum;
        }

        public void setOperationSum(long operationSum) {
                this.operationSum = operationSum;
        }

        public String getUsernameOne() {
                return usernameOne;
        }

        public void setUsernameOne(String usernameOne) {
                this.usernameOne = usernameOne;
        }

        public String getOperationName() {
                return operationName;
        }

        public void setOperationName(String operationName) {
                this.operationName = operationName;
        }

        public String getUsername() {
                return username;
        }

        public void setUsername(String username) {
                this.username = username;
        }
}
