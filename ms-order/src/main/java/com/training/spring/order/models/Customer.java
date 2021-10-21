package com.training.spring.order.models;


public class Customer {

    private String name;
    private String nurname;
    private String phone;
    private String address;

    public String getName() {
        return this.name;
    }

    public void setName(final String nameParam) {
        this.name = nameParam;
    }

    public String getNurname() {
        return this.nurname;
    }

    public void setNurname(final String nurnameParam) {
        this.nurname = nurnameParam;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(final String phoneParam) {
        this.phone = phoneParam;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(final String addressParam) {
        this.address = addressParam;
    }


}
