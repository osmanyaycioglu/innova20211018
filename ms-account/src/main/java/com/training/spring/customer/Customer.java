package com.training.spring.customer;


public class Customer {

    private String name;
    private String surname;
    private String phone;
    private String address;

    public String getName() {
        return this.name;
    }

    public Customer setName(final String nameParam) {
        this.name = nameParam;
        return this;
    }

    public String getSurname() {
        return this.surname;
    }

    public Customer setSurname(final String nurnameParam) {
        this.surname = nurnameParam;
        return this;
    }

    public String getPhone() {
        return this.phone;
    }

    public Customer setPhone(final String phoneParam) {
        this.phone = phoneParam;
        return this;
    }

    public String getAddress() {
        return this.address;
    }

    public Customer setAddress(final String addressParam) {
        this.address = addressParam;
        return this;
    }


}
