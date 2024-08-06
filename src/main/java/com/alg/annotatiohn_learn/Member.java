package com.alg.annotatiohn_learn;

@DBTable(name = "MEMBER")
public class Member {
    @SQLString(30)
    String firstName;
    @SQLString(30)
    String lastName;
    @SQLInteger
    Integer age;
    @SQLString(value = 30, constraint = @Constraint(primaryKey = true))
    String reference;
    static int memberCount;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getReference() {
        return reference;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return reference;
    }
}
