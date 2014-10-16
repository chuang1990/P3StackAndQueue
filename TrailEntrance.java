import java.util.LinkedList;
import java.util.Random;

/**
 * TrailEntrance class
 **/
public class TrailEntrance{

    //instance variables
    private LinkedList<Group> trail1;
    private LinkedList<Group> trail2;
    private LinkedList<Group> trail3;
    private LinkedList<Group> trail4;
    private int trailNum;
    private int hikerNum;
    private Random randomTrail;
    private Random randomHikers;
    
    /**
     * constructor
     **/
    public TrailEntrance(){
        //initialize queues
        trail1 = new LinkedList();
        trail2 = new LinkedList();
        trail3 = new LinkedList();
        trail4 = new LinkedList();
        
    }
    
    /**
     * check if the group is full
     *
     * @return boolean
     **/
    //public boolean isGroupFull(){     //not needed
    //    boolean full = false;
    //    for(int i = 0; i < queue.size(); i++){
            //need to add more
            }
    //    return full;
    //}
    
    /**
     * Pass the number of hikers to Group
     **/
    public void addHikers(){
        //need implementation
    }
    
    
    /**
     * add groups of hiker to the queue
     **/
    public void addGroupToQ(int trail, Group group){
         //get random generated trail number for each group to be add on
         //while there are group left, check if it's full
         //if group is full, put it on a trail
         //if group isn't full, leave the group unassigned
    }
    
    /**
     * Generate a random trail number for the group to go into
     * 
     * @return int
     **/
    public void trailNumbGenerator(){
        randomTrail = new Random();
        trailNum = randomTrail.nextInt(5)+1;
    }
    
    /**
     * Generate a random number of hikers.
     **/
    public void hikerGenerator(){
        randomHikers = new Random();
        hikerNum = randomHikers.nextInt(201)+1;
    }
    
    /**
     * set the trail number
     **/
    public void setTrailNum(int trail){
        this.trailNum = trail;
    }
    
    /**
     * get the trail number
     *
     * @return int
     **/
    public int getTrailNum(){
        return trailNum;
    }
    
    /**
     * get the hikers information in the groups.
     *
     * @return String
     **/
    public String getTrailInfo(){
        //need more work
        return "";
    }
}
