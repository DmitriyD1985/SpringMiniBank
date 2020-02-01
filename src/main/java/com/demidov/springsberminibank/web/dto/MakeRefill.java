package com.demidov.springsberminibank.web.dto;

import javax.validation.constraints.NotEmpty;

public class MakeRefill {

        @NotEmpty
        private String operationSum;

        public String getOperationSum() {
            return operationSum;
        }

        public void setOperationSum(String operationSum) {
            this.operationSum = operationSum;
        }

    }
