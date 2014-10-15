/**
 * Hiker class
 * 
 * The Hiker Class is part of the implementation of "Hiker Program"
 * 
 * The Hiker Class is in charge to create a Hiker Object which has a hikerId 
 * This class provide the setters and getters for the HikerId and also the toString methodo 
 * that prints the state of the object
 * 
 **/
public class Hiker
{

    //instance variables
    private String hikerId;
    
    /**
     * constructor
     *
     * @param hikerid String
     */
    public Hiker(String hikerid)
    {
        this.hikerId = hikerid;
        
    }
    
    /**
     * set hiker's id
     * 
     * @return name String
     */
    public void setHikerId(String name)
    {
        this.hikerId = name;
    }
    
    /**
     * get the hiker's id
     */
    public String getHikerId()
    {
        return hikerId;
    }
    
    /**
     * returns the state of the object in a string
     */
    public String toString()
    {
        return ("hiker is: " + hikerId);
    }
     
