import java.util.Stack;
import java.util.Date;
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
    private String hikerInfo;
    //get local time for hiker info and timer
    private Date date;
    //stores the arrival time of the hiker
    private String time;
    
    /**
     * constructor
     **/
    public Group(int maxHikers)
    {
        numbHikers = 0;
        group = new Stack<Hiker>(); //initializing the Strack 
        
    }
    /**
     * defult Constructor
     **/
    public Group()
    {
        this(maxHikers);
        maxHikers = 10;
    }
    
    /**
     * set up the hiker information
     */
    public void createHiker(int h){
        //get the time
        this.date = new Date();
        this.time = date.toString();
        String hiker = "Hiker"+h;
        hikerInfo= hiker + " "+ time;
    }
    
    /**
     * put auto-generated hikers into the stack.
     *
     * @param hikers list of string
     **/
    public void addHikers(int n)
    {
        //int count = 0;
        for(int a = 0; a < n; a++){
            //create a tempurary hiker 
            createHiker(a);
            hikerTemp = new Hiker(hikerInfo);
            //check if the grouop is full
            if(numbHikers = maxHikers){
                System.out.println("Sorry, this stack is full");
            }
            else{
                group.push(hikerTemp);
                numbHikers++;
            }
        }
        
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
        
        if(group.empty() == true)
            return false;
        else
            return true; 
    }
    
    /**
     * remove hiker from the group
     **/
    public Hiker removeHiker()
    {
        if(group.empty() == true)
            return null;
        else{
            hikerTemp = group.peek();
            group.pop();
            return hikerTemp;
        }
    }
    
    /**
     * toString method, prints all the hiker information in the group.
     * 
     *
     * @return String
     **/
    @Override
    public String toString()
    {
        while(numbHikers > 0){
            String hikerInfo = group.peek().toString();
            for(int i = 0; i < numbHikers; i++){
                
                group.pop();
                numbHikers--;
                return "" + hikerInfo;
            }
        }
        return "Unable to retrieve Hikers' information";
    }
}
