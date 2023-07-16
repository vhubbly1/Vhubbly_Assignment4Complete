/*
 * Class: CMSC203 
 * Instructor: Grinberg
 * Description: The plot class represents land with coordinate and dimensions. It checks if one plot overlaps or is encompassed by another plot.
 * Due: 07/13/2023
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here:Vivek Hubbly
*/

public class Plot {

    private int x;
    private int y;
    private int width;
    private int depth;
    
    public Plot() {
        this(0, 0, 1, 1);
    }
    
    public Plot(int x, int y, int width, int depth) {
        // Initialize the plot with the provided values
        this.x = x;
        this.y = y;
        this.width = width;
        this.depth = depth;
    }
    
    public boolean overlaps(Plot plot) {
        // Check if the current plot overlaps with the provided plot
        
        // Get the coordinates of the current plot's corners
        int x1 = x;
        int y1 = y;
        int x2 = x + width;
        int y2 = y + depth;
        
        // Get the coordinates of the provided plot's corners
        int x3 = plot.getX();
        int y3 = plot.getY();
        int x4 = plot.getX() + plot.getWidth();
        int y4 = plot.getY() + plot.getDepth();
        
        // Check if the plots do not overlap in either the x or y direction
        if (x2 < x3 || x4 < x1)
            return false;
        if (y2 < y3 || y4 < y1)
            return false;
        
        // Plots overlap
        return true;
    }
    
    public boolean encompasses(Plot plot) {
        // Check if the current plot encompasses the provided plot
        
        // Get the coordinates of the current plot's corners
        int x1 = x;
        int y1 = y;
        int x2 = x + width;
        int y2 = y + depth;
        
        // Get the coordinates of the provided plot's corners
        int x3 = plot.getX();
        int y3 = plot.getY();
        int x4 = plot.getX() + plot.getWidth();
        int y4 = plot.getY() + plot.getDepth();
        
        // Checks if the current plot's boundaries enclose the provided plot's boundaries
        if (x1 <= x3 && y1 <= y3 && x2 >= x4 && y2 >= y4)
            return true;
        
        // Current plot does not encompass given plot
        return false;
    }
    
    public int getX() {
        return x; 
        // Returns x-coordinate of the plot
    }
    
    public void setX(int x) {
        this.x = x; // Sets x-coordinate of the plot
    }
    
    public int getY() {
        return y; // Returns y-coordinate of the plot
    }
    
    public void setY(int y) {
        this.y = y; // Sets y-coordinate of the plot
    }
    
    public int getWidth() {
        return width; // Returns width of the plot
    }
    
    public void setWidth(int width) {
        this.width = width; // Sets width of the plot
    }
    
    public int getDepth() {
        return depth; // Returns depth of the plot
    }
    
    public void setDepth(int depth) {
        this.depth = depth; // Sets depth of the plot
    }
    
    @Override
    public String toString() {
        return x + "," + y + "," + width + "," + depth;
    }
}

