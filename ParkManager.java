import java.util.Random;
/**
 * Class ParkManager
 * 
 * Creates the Hikers and adds them to the groups, when they are in the groups they get add to the queue
 * 
 * @author (Catherine Huang, Hannah Riggs, Maria del Mar Moncaleano) 
 * @version 10/18/2014
 */
public class ParkManager
{
    // array of entrances, so that we may access each entrance with index
    private TrailEntrance[] entrances;
    
    // number of trails in the park
    private int trailsNumber; 
    
    // maximum number of hikers allowed in one day
    private int hikersAllowed; 
    
    // the maximum number of hikers that can be in a group
    private int groupSize;
    
    // enforces sequence of method calls
    private int state;
    
    //stores the string of hiker's info tempurarily
    private String hikerInfo = "";
    private String fullGroupInfo = "";
    private String partialGroupInfo = "";

    /**
     * Constructor for objects of class ParkManager
     */
    public ParkManager(int trailsNumber, int hikersAllowed, int groupSize)
    {
        this.trailsNumber = trailsNumber; 
        this.hikersAllowed = hikersAllowed; 
        this.groupSize = groupSize;
        
        // can only call createHikersInTrails() method first
        state = 1; 

        // initialize entrances array of size equal to trailsNumber
        entrances = new TrailEntrance[trailsNumber]; 

        // create as many trail entrances as are trails and add to array
        for (int i = 0; i < trailsNumber; i++)
        {
            entrances[i] = new TrailEntrance(); 
        }
    }

    /**
     * Randomly generates some number of hikers, adds them to groups and then adds groups to entrance queues. 
     */
    public void createHikersInTrails()
    {
        // must call this method first
        if (state != 1)
        {
            return; 
        }
        
        // generate a random number. 
        Random random = new Random(); 
        // need plus 1 to make sure nextInt argument is positive
        int hikersToAdd = random.nextInt(hikersAllowed + 1);
        //System.out.println(hikersToAdd);

        // create a new group because there will always be at least 1 group
        Group currentGroup = new Group(groupSize);

        // declare index, so can cycle through entrances
        int entranceNum = 0; 

        // while there are still hikers not in groups
        while (hikersToAdd > 0)
        {
            Hiker hikerNew = new Hiker();

            currentGroup.addHiker(hikerNew);
            // System.out.println(currentGroup.isGroupFull());
            // write hiker's info to file here-- represented with system.out.println here
            //System.out.println(hikerNew.getHikerId());
            //store each new hiker into a string
            for(int h = hikersToAdd; h == hikersToAdd; h--)
            {
                hikerInfo += hikerNew.getHikerId() + "\n";
                hikersInfo();
            }

            // if the group is full 
            if (currentGroup.isGroupFull())
            {
                // add group to queue at current entrance number
                entrances[entranceNum].addGroupToQ(currentGroup);
                fullGroupInfo += "\n"+ "Group is Full (10 Hikers on it) \n This group will go to: " + entranceNum + "\n";
                
                //System.out.println("group added to stack");
                //System.out.println("This stack will go to: " + entranceNum);

                // increment index and once reaches last trail wrap around to beginning again
                entranceNum++;
                entranceNum %= trailsNumber; 
                currentGroup = new Group(10); 
            }
            // one hiker added, so remove from number to add
            hikersToAdd--; 
        }

        // if there is still a group left that is not full, add to queue
        if (currentGroup.getGroupNum() > 0)
        {
            // increment index and once reaches last trail wrap around to beginning again
            entrances[entranceNum].addGroupToQ(currentGroup);
            partialGroupInfo =  "\n"+ currentGroup.getGroupNum() 
                              +" Hikers join in a group"+ "\n" + "This group will go :" + entranceNum + "\n"+"\n maxium capacity had reached.\n ";
            //System.out.println("group added to stack");
            //System.out.println("This stack will go to: " + entranceNum);
        }  
        state++; 
    }

    /**
     * Removes all hikers in full groups from queues and returns String of hiker's info.
     * 
     * @return    info of all hikers in group
     */
    public String removeFullGroups()
    {
        // must call this method second
        if (state != 2)
        {
            return ""; 
        } 
        String hikerInfo = "TRAILS WITH FULL GROUPS:\n\n"; 

        Group currentGroup; 

        // iterate over every trail entrance
        for (int i = 0; i < trailsNumber; i++)
        {
            hikerInfo += "\n"+">TRAIL " + i + ":\n";

            // iterate over every group at an entrance
            while (entrances[i].getNumberGroups() > 0) 
            {

                // if the first group in the entrance is full, remove and add info
                if (entrances[i].getFirstGroup().isGroupFull())
                {
                    currentGroup = entrances[i].removeGroup(); 
                    hikerInfo += currentGroup.toString(); 
                }
                else 
                {
                    // otherwise, break out of loop (partially full groups always at end)
                    break; 
                }
            }
            hikerInfo += "\n";
        }

        // to take out-- for testing
        //System.out.println(hikerInfo);  
        state++; 
        
        return hikerInfo+"\n"; 
    }

    /**
     * Removes remaining hikers in the remaining partial group from queue
     * and returns String of hiker's info.
     * 
     * @return    info of all hikers in group
     */
    public String removePartialGroups()
    {
        // must call this method third
        if (state != 3)
        {
            return "";
        }
        String hikerInfo ="TRAILS WITH PARTIAL GROUPS:\n"; 
        Group currentGroup; 

        // iterate over every trail entrance
        for (int i = 0; i < trailsNumber; i++)
        {
            hikerInfo += "\n"+">Trail " + i + ":\n";

            // iterate over every group at an entrance
            while (entrances[i].getNumberGroups() > 0) 
            {
                // remove remaining hikers from groups and append their info
                currentGroup = entrances[i].removeGroup(); 
                hikerInfo += currentGroup.toString(); 
            }
            hikerInfo += "\n";
        }

        // to take out-- for testing
        System.out.println(hikerInfo);
        
        // resets
        state = 1; 
        
        return hikerInfo+"\n"; 
    }
    
    /**
     * Returns String of all the hikers that has been created
     * 
     * @return      all the hikers created.
     */
    public String hikersInfo()
    { 
        return hikerInfo;
    }
    
    /**
     * Returns String of all the full groups that're add to the a queue.
     * 
     * @return    info of all hikers in group
     */
    public String fullGroupInfo()
    {
        return fullGroupInfo;
    }
    
    /**
     * Returns String of all the partial group that is add to the queue.
     * 
     * @return    info of all hikers in group
     */
    public String partialGroupInfo()
    {
        return partialGroupInfo;
    }
}
