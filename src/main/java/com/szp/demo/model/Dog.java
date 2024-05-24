package com.szp.demo.model;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("DOG")
public class Dog extends Pet{
    @Override
    public void validate() {
        super.validate();
    }
}
