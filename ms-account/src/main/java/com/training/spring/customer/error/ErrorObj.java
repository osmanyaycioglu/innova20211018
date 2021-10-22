package com.training.spring.customer.error;

import java.util.ArrayList;
import java.util.List;

public class ErrorObj {

    private List<ErrorObj> subErrors;
    private String         domain;
    private String         subdomain;
    private String         boundedContext;
    private String         microservice;
    private int            errorCause;
    private String         desc;

    public ErrorObj addSubError(final ErrorObj errorObjParam) {
        if (this.subErrors == null) {
            this.subErrors = new ArrayList<>();
        }
        this.subErrors.add(errorObjParam);
        return this;
    }

    public String getDomain() {
        return this.domain;
    }

    public ErrorObj setDomain(final String domainParam) {
        this.domain = domainParam;
        return this;
    }

    public String getSubdomain() {
        return this.subdomain;
    }

    public ErrorObj setSubdomain(final String subdomainParam) {
        this.subdomain = subdomainParam;
        return this;
    }

    public String getBoundedContext() {
        return this.boundedContext;
    }

    public ErrorObj setBoundedContext(final String boundedContextParam) {
        this.boundedContext = boundedContextParam;
        return this;
    }

    public String getMicroservice() {
        return this.microservice;
    }

    public ErrorObj setMicroservice(final String microserviceParam) {
        this.microservice = microserviceParam;
        return this;
    }

    public int getErrorCause() {
        return this.errorCause;
    }

    public ErrorObj setErrorCause(final int errorCauseParam) {
        this.errorCause = errorCauseParam;
        return this;
    }

    public String getDesc() {
        return this.desc;
    }

    public ErrorObj setDesc(final String descParam) {
        this.desc = descParam;
        return this;
    }

    public List<ErrorObj> getSubErrors() {
        return this.subErrors;
    }

    public ErrorObj setSubErrors(final List<ErrorObj> subErrorsParam) {
        this.subErrors = subErrorsParam;
        return this;
    }


}
