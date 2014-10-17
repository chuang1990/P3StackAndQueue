
import java.util.Stack;
/**
 * Class Group
 *
 * The Group Class is part of the implementation of "The Hiker Program"
 *
 * It acts as the Stack data Structure that holds Hiker objects.
 * There is a maximun number of hikers that it can hold. It has methods to add hikers to the group
 * get the number of hikers in the group and check if the group is full o not.
 * It also has a toString methods that returns the state of the object
 *
 * @author (your name) 
 * @version 1/17/14
 **/
public class Group
{
    private Stack<Hiker> group; //creating the Stack of Hiker
    private int numbHikers;
    private int maxHikers;
    // string holds info for all hikers in group
    private String info; 

    /**
     * Constructor for Group objects
     **/
    public Group(int maxHikers)
    {
        this.maxHikers = maxHikers; 
        numbHikers = 0;
        info = ""; 
        group = new Stack<Hiker>(); //initializing the Stack
    }

    /**
     * Pushes a hiker onto the stack and increments number of hikers only if group is not full. 
     * 
     * @param  hiker    the hiker object you wish to add
     */
    public void addHiker(Hiker hiker)
    {
        if (!isGroupFull())
        {
            numbHikers++; 
            info += hiker.getHikerId() + " "; 
            group.push(hiker);
        }
    }

    /**
     * Return the number of hikers in the group. 
     *
     * @return    the number of hikers in the group
     */
    public int getGroupNum()
    {
        return numbHikers;
    }

    /**
     * Check if the group is full. 
     * If number of hikers is equal to maximum number of hikers, group will be full. 
     *
     * @return    true if the group is full, false if it is not
     **/
    public boolean isGroupFull()
    {
        return numbHikers == maxHikers; 
    }

    /**
     * Remove and return a hiker from the group.
     * 
     * @return     the Hiker object to be removed and returned
     */
    public Hiker removeHiker()
    {
        // if group is not empty, remove and return top element
        if (!group.empty())
        {
            return group.pop(); 
        }

        // else return null
        return null; 
    }
    
    /**
     * Returns info of all hikers in the group.
     * 
     * @return    the string representation of all hikers in a group 
     */
    public String toString()
    {
        return info; 
    }
}
