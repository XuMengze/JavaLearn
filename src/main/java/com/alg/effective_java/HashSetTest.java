package com.alg.effective_java;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest {
    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student();
        Student s3 = new Student();
        s1.name = "Zhangsan";
        s1.setAge(21);
        s2.name = "Zhangsan";
        s2.setAge(22);
        s3.name = "Wangwu";
        s3.setAge(23);

        Set<Student> set = new HashSet<>();
        set.add(s1);
        set.add(s2);
        set.add(s3);
//        System.out.println(s1.hashCode());

        s1.setAge(22);

//        System.out.println(s1.hashCode());
//        set.remove(s1);

        for (Student s : set) {
            System.out.println(s.toString());
        }
        Set<Student> set2 = new HashSet<>();
        set2.add(s1);
        set2.add(s2);
        set2.add(s3);
        System.out.println();

        for (Student s : set2) {
            System.out.println(s.toString());
        }

    }
}

class Student {
    String name;
    private int age;

    Student() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Student)) {
            return false;
        }
        Student compareStudent = (Student) obj;
        if (compareStudent.age == this.age && compareStudent.name.equals(this.name)) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + Integer.hashCode(this.age);
    }
}