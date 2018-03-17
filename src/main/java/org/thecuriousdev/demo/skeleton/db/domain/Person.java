package org.thecuriousdev.demo.skeleton.db.domain;

import com.google.common.base.MoreObjects;

public class Person {

    private String name;
    private int age;
    private String favouriteFood;

    public Person() {
        // Empty constructor
    }

    public Person(String name, int age, String favouriteFood) {
        this.name = name;
        this.age = age;
        this.favouriteFood = favouriteFood;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFavouriteFood() {
        return favouriteFood;
    }

    public void setFavouriteFood(String favouriteFood) {
        this.favouriteFood = favouriteFood;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this.getClass())
                .add("name", name)
                .add("age", age)
                .add("favouriteFood", favouriteFood)
                .omitNullValues()
                .toString();
    }
}
