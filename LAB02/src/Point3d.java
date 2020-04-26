/*
    Source file: Poin3d.java
    Class: Poin3d
    Appointment: The class for representing points in three-dimensional Euclidean space

    Class members: private Сoordinate X, Y, Z;

    Сonstructor:
                сonstructor with default values ​​(0.0d)
                overloading сonstructor with 3 values (double)

    Open access methods:
                          public double getN () for getting value
                          public void setN (double val) for setting value

    Member function:
                     public boolean equals (Point3d obj2) to compare the values ​​of two objects
                     public double distanceTo (Point3d Point2) to calculate the distance between 2 points


    Author: Bezuglova O.V. BST-1751
    Organization: MTUSI
    Last modification: 25.04.2020
 */


public class Point3d
{
    // Class members
    private double xCoord;  // coordinate X
    private double yCoord; // coordinate Y
    private double zCoord; // coordinate Z

    // Сonstructor
    public Point3d ()
        { this(0, 0, 0); }

    // Open access methods

        // Initialization
        public Point3d(double x, double y, double z)
        {
            xCoord = x;
            yCoord = y;
            zCoord = z;
        }

        // Getting value

        public double getX ()
                    { return xCoord; }

        public double getY ()
                    { return yCoord; }

        public double getZ ()
                    { return zCoord; }

        // Set value

        public void setX ( double val)
                    { xCoord = val; }

        public void  setY ( double val)
                    { yCoord = val; }

        public void  setZ ( double val)
                    { zCoord = val; }

    // Member function

    public boolean equals (Point3d obj2)
    {
        return ( (this.xCoord == obj2.xCoord) && (this.yCoord == obj2.yCoord) && (this.zCoord == obj2.zCoord) );
    }

    public double distanceTo (Point3d Point2)
    {
        return Math.sqrt(Math.pow((Point2.xCoord - this.xCoord), 2)
                        + Math.pow((Point2.yCoord - this.yCoord), 2)
                        + Math.pow((Point2.zCoord - this.zCoord), 2));
    }

}
