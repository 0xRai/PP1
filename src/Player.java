/*
Name: Robert Hardy
Project Name: Programming Project 1 - CMIS 215
Date: 28 Oct 2023
Class Description: Class 'Player' stores a player's: name, height, and age. Class contains one constructor, one utility
    method and 3 getters/0 setters.
*/

public class Player {
    private final String name;
    private final Height height;
    private final int age;

    public Player(String name, Height height, int age){
        this.name = name;
        this.height = height;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public Height getHeight() {
        return this.height;
    }

    public int getAge() {
        return this.age;
    }

    public String toString(){
        return String.format("- Name:\t%s\n- Age:\t%d\n- Height:\t%s\n", this.getName(), this.getAge(), this.getHeight().toString());
    }

}
