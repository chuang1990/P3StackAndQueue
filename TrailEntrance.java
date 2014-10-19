import java.util.*;
/**
 * TrailEntrance class
 * 
 * The TrailEntrance Class acts as te Queue data structure that holds Group objects. 
 * The linkedLIst is used as the queue as it extends the queue interface and can behave as a queue.
 * Each trailEntrance has a number. It has methods that can add and remove Group objects to the queue,
 * get the TrailEntrance number and get the information about the trail entrance.
 * 
 * @author (Catherine Huang, Hannah Riggs, Maria del Mar Moncaleano) 
 * @version 10/18/2014
 **/
public class TrailEntrance 
{
    // the linked list will be treated as a queue
    private Queue<Group> trail;
    // number of groups in the queue
    private int numberGroups; 
    /**
     * Constructor of TrailEntrance object. 
     **/
    public TrailEntrance()
    {
        trail = new LinkedList();
        numberGroups = 0; 
    }

    /**
     * Add a groups of hikers to the queue. 
     * 
     * @param  group    the group of hikers to add to the queue
     **/
    public void addGroupToQ(Group group) 
    {
        trail.offer(group); 
        numberGroups++; 
    }

    /**
     * Remove and return a group from the queue. 
     * 
     * @return    the group to be returned and removed
     */
    public Group removeGroup()
    {
        numberGroups--;
        return trail.remove(); 
    }

    /**
     * Returns (but does not remove) first group in queue. 
     * 
     * @return    the group to "peek" at 
     */
    public Group getFirstGroup()
    {
        return trail.peek(); 
    }

    /**
     * Returns the number of groups in the queue
     * 
     * @return    number of groups in the queue
     */
    public int getNumberGroups()
    {
        return numberGroups; 
    }
}
