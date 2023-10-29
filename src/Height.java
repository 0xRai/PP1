/*
Name: Robert Hardy
Project Name: Programming Project 1 - CMIS 215
Date: 28 Oct 2023
Class Description: Class 'Height' stores a person's height in two attributes: feet and inches. This is to allow for the
    displaying in imperial format (e.g. 5' 11"). Class has one constructor, two utility methods; however no getters/setters
 */

public class Height {
    private final int feet;
    private final int inches;

    // Constructor ensures that if inches exceeds 11, the extra inches are converted to feet.
    // Example: If Height(0,71): feet = 5, inches = 11.
    public Height(int feet, int inches){
        this.inches = inches % 12;
        this.feet = feet + inches / 12;
    }

    public int toInches(){
        return (feet * 12) + inches;
    }

    public String toString(){
        return String.format("%d'%d\"", this.feet, this.inches);
    }
}
