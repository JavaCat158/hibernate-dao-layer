package course.hibernatedaoexample.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class PersonsId implements Serializable {
    private String name;
    private String surName;
    private int age;
}
