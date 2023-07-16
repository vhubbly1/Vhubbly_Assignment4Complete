/*
 * Class: CMSC203 
 * Instructor: Grinberg
 * Description: The ManagementCompany class represents a management company. It manages its properties and allows adding and removing of properties, calculating total rent and highest rent property.
 * Due: 07/13/2023
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here:Vivek Hubbly
*/

//class manages properties and allows addition or properties as well as removing properties.
public class ManagementCompany {
    private String companyName;
    private String taxId;
    private double managementFeePercentage;

    //MAX_PROPERTY possible is 5
    private static final int MAX_PROPERTY=5;
    
    //MGMT_WIDTH Is maximum of 10
    private static final int MGMT_WIDTH=10;
    
    //MGMT maximum depth is 10
    private static final int MGMT_DEPTH=10;

    //creates array for storing amount of properties in Property array
    private Property[] properties;
    
    private Plot plot;
    
    //stores total number of properties in the numberOfProperties
    private int numberOfProperties;

    public ManagementCompany() {
        this("", "", 0.0);
    }
	
    public ManagementCompany(String name, String taxID, double mgmFee) {
        // Sets the management company's name
        this.companyName = name;
        
        // Sets the management company's tax ID
        this.taxId = taxID;
        
        // Sets the management fee percentage
        this.managementFeePercentage = mgmFee;
        
        // Sets the properties array with a maximum capacity
        this.properties = new Property[MAX_PROPERTY];
     
        // Sets the plot for the management company's location
        this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
        
        // Sets the number of properties to 0
        this.numberOfProperties = 0;
    }
    
    public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) {
        // Calls previous constructor with the name, taxID, and mgmFee
        this(name, taxID, mgmFee);
        
        // Create a new plot object for the management company's location
        this.plot = new Plot(x, y, width, depth);
    }
    
    public ManagementCompany(ManagementCompany otherCompany) {
        // Create a new ManagementCompany instance using the properties of the otherCompany
        
        this(otherCompany.companyName, otherCompany.taxId, otherCompany.managementFeePercentage,
             otherCompany.plot.getX(), otherCompany.plot.getY(),
             otherCompany.plot.getWidth(), otherCompany.plot.getDepth());
        
        // Copies the number of properties from the otherCompany
        this.numberOfProperties = otherCompany.numberOfProperties;
        
        // Creates a new properties array
        this.properties = new Property[MAX_PROPERTY];
        
        // Copy the properties from the otherCompany
        for (int i = 0; i < numberOfProperties; i++) {
            // Creates a new Property instance using the copy constructor and assign it to the current properties array
            this.properties[i] = new Property(otherCompany.properties[i]);
        }
    }

	
    public int addProperty(String name, String city, double rent, String owner) {
        // Creates Property object using the provided parameters and call the overloaded addProperty method
        return addProperty(new Property(name, city, rent, owner));
    }

    public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
        // Creates Property object with plot details using the provided parameters and call the overloaded addProperty method
        return addProperty(new Property(name, city, rent, owner, x, y, width, depth));
    }

    public int addProperty(Property property) {
        if (property == null) {
            return -2; 
            // Invalid property, return -2
        }
        if (!plot.encompasses(property.getPlot())) {
            return -3; 
            // Property plot is not within management company's plot, return -3
        }
        for (int i = 0; i < numberOfProperties; i++) {
            if (properties[i].getPlot().overlaps(property.getPlot())) {
                return -4; 
                // Property plot overlaps with existing property, return -4
            }
        }
        if (numberOfProperties < MAX_PROPERTY) {
            properties[numberOfProperties] = property; 
            // Add the property to the properties array
            numberOfProperties++;
            return numberOfProperties - 1; 
            // Return the index of the added property
        } else {
            return -1; // Maximum number of properties reached, return -1
        }
    }

    public void removeLastProperty() {
        if (numberOfProperties > 0) {
            properties[numberOfProperties - 1] = null; 
            // Removes last property by setting it to null
            numberOfProperties--;
        }
    }

    public boolean isPropertiesFull() {
        return numberOfProperties == MAX_PROPERTY; 
        // Checks if properties array is full
    }

    public int getPropertiesCount() {
        return numberOfProperties; 
        // Returns number of properties
    }

    public double getTotalRent() {
        double totalRent = 0.0;
        for (int i = 0; i < numberOfProperties; i++) {
            totalRent += properties[i].getRentAmount(); 
            // Sums up the rent amounts of all properties
        }
        return totalRent;
    }

    public Property getHighestRentProperty() {
        if (numberOfProperties > 0) {
            Property highestRentProperty = properties[0];
            for (int i = 1; i < numberOfProperties; i++) {
                if (properties[i].getRentAmount() > highestRentProperty.getRentAmount()) {
                    highestRentProperty = properties[i]; 
                    // Finds the property with the highest rent
                }
            }
            return highestRentProperty;
        }
        return null;
    }

    public boolean isManagementFeeValid() {
        return managementFeePercentage >= 0 && managementFeePercentage <= 100; 
        // Checks if the management fee percentage is within the valid range
    }

    public String getName() {
        return companyName; 
        // Returns the management company's name
    }

    public String getTaxID() {
        return taxId; 
        // Returns the management company's tax ID
    }

    public Property[] getProperties() {
        return properties; 
        // Returns array of properties
    }

    public double getMgmFeePer() {
        return managementFeePercentage; 
        // Returns the management fee percentage
    }

    public Plot getPlot() {
        return plot; 
        // Returns the management company's plot
    }

    @Override
    public String toString() {
        String info = "Management Company: " + companyName + " (Tax ID: " + taxId + ")\n";
        info += "Properties:\n";
        for (int i = 0; i < numberOfProperties; i++) {
            info += properties[i].toString() + "\n"; 
            // Concatenates property information to the string
        }
        return info;
    }
}

