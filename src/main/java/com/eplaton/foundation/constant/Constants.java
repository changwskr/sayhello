package com.eplaton.foundation.constant;

import org.springframework.http.HttpStatus.Series;

public class Constants {

    public enum ExceptionClass {

        PRODUCT("Product"), SIGN("Sign"), PROVIDER("Provider"), EPLATON("ePlaton"), OK("OK"),;

        private String exceptionClass;

        ExceptionClass(String exceptionClass) {
            this.exceptionClass = exceptionClass;
        }

        public String getExceptionClass() {
            return exceptionClass;
        }

        @Override
        public String toString() {
            return getExceptionClass() + " Exception. ";
        }

    }

}
