/**
 * Hiker class
 *
 * The Hiker Class is part of the implementation of "Hiker Program"
 *
 * The Hiker Class is in charge to create a Hiker Object which has a hikerId
 * This class provide the setters and getters for the HikerId and also the toString method
 * that prints the state of the object
 * 
 * @author (your name) 
 * @version 1/17/14
 **/
public class Hiker
{
    // id of hiker as String (HikerNum) 
    private String hikerId;
    
    // id number that is incremented for each hiker
    private static int idNum = 0; 
    
    /**
     * Constructor for Hiker using class variable idNum that increments with each new Hiker created. 
     */
    public Hiker()
    {
        idNum++; 
        hikerId = "Hiker" + idNum; 
    }

    /**
     * Gets the hiker's id string.
     * Represented as HikerNum (Hiker1, Hiker2, etc). 
     * 
     * @return     the hiker's id
     */
    public String getHikerId()
    {
        return hikerId;
    }

    /**
     * Returns the hiker's info.
     * 
     * @return    string representation of hiker
     */
    public String toString()
    {
        return ("Hiker info: " + hikerId);
    }
}
