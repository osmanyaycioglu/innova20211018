package com.training.spring.rest;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import com.training.spring.validation.StartWith;

@XmlRootElement
public class Person {

    @StartWith("is:")
    @NotEmpty(message = "name boş olamaz")
    @Size(min = 2, max = 20, message = "name 2 ile 20 arasında olmalı")
    private String  name;
    @StartWith("soy:")
    @NotEmpty(message = "surname boş olamaz")
    @Size(min = 3, max = 30, message = "surname {min} ile {max} arasında olmalı")
    private String  surname;
    @NotNull
    @Max(value = 300, message = "Height 300 den büyük olamaz")
    @Min(80)
    private Integer height;
    @NotNull
    @Max(500)
    @Min(10)
    private Integer weight;

    public String getName() {
        return this.name;
    }

    public Person setName(final String nameParam) {
        this.name = nameParam;
        return this;
    }

    public String getSurname() {
        return this.surname;
    }

    public Person setSurname(final String surnameParam) {
        this.surname = surnameParam;
        return this;
    }

    public Integer getHeight() {
        return this.height;
    }

    public Person setHeight(final Integer heightParam) {
        this.height = heightParam;
        return this;
    }

    public Integer getWeight() {
        return this.weight;
    }

    public Person setWeight(final Integer weightParam) {
        this.weight = weightParam;
        return this;
    }


}
