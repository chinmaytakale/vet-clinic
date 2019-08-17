package serenitylabs.tutorials.vetclinic.domain;

import java.time.LocalDateTime;

public class Dog {
    private final String name;
    private final String breed;
    private final String colour;
    private final String favoriteFood;
    private final LocalDateTime birthday;

    public Dog(String name, String breed, String favoriteFood, String colour, LocalDateTime birthday) {

        this.name = name;
        this.breed = breed;
        this.colour = colour;
        this.favoriteFood = favoriteFood;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public String getColour() {
        return colour;
    }
	public LocalDateTime getBirthday() {
		return birthday;
	}

	public String getfavouriteFood() {
		return favoriteFood;
	}
	@Override
	public String toString(){
		return (name+" the "+colour+" "+breed); 
	}

    public static DogBuilder called(String name) {
        return new DogBuilder(name);
    }

    public static class DogBuilder {
        private final String name;
        private String breed;

        public DogBuilder(String name) {
            this.name = name;
        }

        public DogBuilder ofBreed(String breed) {
            this.breed = breed;
            return this;
        }

        public Dog andOfColour(String colour) {
            return new Dog(name, breed, colour,null,null);
        }
    }


}
