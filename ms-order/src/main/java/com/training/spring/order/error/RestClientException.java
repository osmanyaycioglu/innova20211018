package com.training.spring.order.error;


public class RestClientException extends Exception {

    private static final long serialVersionUID = -9137227984470679725L;

    private ErrorObj          errorObj;

    public RestClientException() {
    }

    public RestClientException(final ErrorObj errorObjParam) {
        super();
        this.errorObj = errorObjParam;
    }

    public ErrorObj getErrorObj() {
        return this.errorObj;
    }

    public void setErrorObj(final ErrorObj errorObjParam) {
        this.errorObj = errorObjParam;
    }


}
