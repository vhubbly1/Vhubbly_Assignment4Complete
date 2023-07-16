/*
 * Class: CMSC203 
 * Instructor: Grinberg
 * Description: The Property class represents a real estate property. It stores information such as property name the city and rental amount with its owner.
 * Due: 07/13/2023
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here:Vivek Hubbly
*/

public class Property {
    private String propertyName;
    private String city;
    private double rentAmount;
    private String owner;
    private Plot plot;

    public Property() {
        this("", "", 0.0, "");
    }

    public Property(String propertyName, String city, double rentAmount, String owner) {
        // Sets the property with the provided values
        this.propertyName = propertyName;
        this.city = city;
        this.rentAmount = rentAmount;
        this.owner = owner;
        this.plot = new Plot();
    }

    public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth) {
        // Sets the property with the provided values for the plot
        this.propertyName = propertyName;
        this.city = city;
        this.rentAmount = rentAmount;
        this.owner = owner;
        this.plot = new Plot(x, y, width, depth);
    }

    public Property(Property otherProperty) {
        // Copies the values from the otherProperty to create a new Property instance
        this.propertyName = otherProperty.propertyName;
        this.city = otherProperty.city;
        this.rentAmount = otherProperty.rentAmount;
        this.owner = otherProperty.owner;
        this.plot = new Plot(otherProperty.getPlot());
    }

    public Plot getPlot() {
        return plot; 
        // Returns the plot of the property
    }

    public String getPropertyName() {
        return propertyName; 
        // Returns the property name
    }

    public String getCity() {
        return city; 
        // Returns the city
    }

    public double getRentAmount() {
        return rentAmount; 
        // Returns the rent amount
    }

    public String getOwner() {
        return owner; 
        // Returns the owner
    }

    @Override
    public String toString() {
        return propertyName + "," + city + "," + owner + "," + rentAmount;
    }
}


