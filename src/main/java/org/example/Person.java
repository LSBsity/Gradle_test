package org.example;

import java.io.Serializable;

public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    private String name;
    //private String fullName;
    private int age;
    private double height;
    private boolean married;

    //  💡 transient : 직렬화에서 제외
    transient private String bloodType;
    transient private double weight;

    private Career career;

    public Person(
            String name, int age, double height, boolean married,
            String bloodType, double weight, Career career
    ) {
        this.name = name;
        //this.fullName = name;
        this.age = age;
        this.height = height;
        this.married = married;
        this.bloodType = bloodType;
        this.weight = weight;
        this.career = career;
    }
}
