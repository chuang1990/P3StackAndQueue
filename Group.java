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
 **/
public class Group
{
    
    private Stack<Hiker> group; //creating the Stack of Hiker
    private Hiker hikerTemp;
    private int numbHikers;
    private int maxHikers;
    
    /**
     * constructor
     **/
    public Group(int maxHikers)
    {
        hikerTemp = new Hiker();
        group = new Stack<Hiker>(); //initializing the Strack 
        this.maxHikers = maxHikers;
        
    }
    
    /**
     * put auto-generated hikers into the stack.
     *
     * @param hikers list of string
     **/
    public void setHikers(String[] hikers)
    {
        //set the hiker value
        hikerTemp.setHiker(hikers);
        //add the hiker to the group
        group.push(hikerTemp);
    }
    
    /**
     * get the number of hikers in a group
     * 
     * @return hikers int
     */
    public int getGroupNum()
    {
        return numbHikers;
    }
    
    /**
     * check if the group is full
     * 
     * @return boolean
     **/
    public boolean isGroupFull()
    {
        boolean full = false;
        
        if(group.size()==maxHikers)
        {
            full = true;
        }
        return full; 
    }
    
    /**
     * add hiker to the group
     **/
    public void addHiker(Hiker hiker)
    {
       group.push(hiker);
    }
    
    /**
     * toString method
     *
     * @return String
     *//
    @Override
    public String toString()
    {
        return "";
    }
}
