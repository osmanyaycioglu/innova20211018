package com.training.spring.order.models;


public class Customer {

    private String name;
    private String surname;
    private String phone;
    private String address;

    public String getName() {
        return this.name;
    }

    public void setName(final String nameParam) {
        this.name = nameParam;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(final String nurnameParam) {
        this.surname = nurnameParam;
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
