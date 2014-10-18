//Action
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Swing
import javax.swing.*;
import javax.swing.border.EtchedBorder;


/**
 * GUI class
 * 
 * @Catherine Huang
 * @version 10/18/2014
 **/
public class GUI{

    //instance variables
    private JFrame frame;
    private JPanel mainPanel;
    //buttons
    private JPanel btnPanel;
    //text area
    private JPanel textPanel;
    private JTextArea textArea;
    
    //labelPnael
    private JPanel hintPanel;
    //other variables
    private FileEditor fileEditor;
    private ParkManager manager;
    
    /**
     * constructor
     **/
    public GUI(){
        this.makeWindow();
    }
    
    /**
     * create the frame
     **/
    public void makeWindow(){
        frame = new JFrame("Purple Mountain Trail");
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setContent(frame);
        
        frame.pack();
        frame.setVisible(true);
    }
    
    /**
     * put the contents together in the container
     **/
    public void setContent(JFrame frame){
        Container contentPane = frame.getContentPane();
        
        makeButton();
        makeTextArea();
        makeLabels();
        
        contentPane.add(btnPanel, BorderLayout.SOUTH);
        contentPane.add(hintPanel, BorderLayout.CENTER);
        contentPane.add(textPanel, BorderLayout.NORTH);
    }
    
    /**
     * Create the buttons
     * 
     * Start button is responsible for generating hikers, put them into groups,
     * then line them up at the entrance of each trials
     * 
     * Open button is responsible for letting the groups that are full with 10
     * hikers into the Mountain
     * 
     * Check button is responsible for letting in the groups that are not full, but the
     * part has reach it's capacity to allow more users to enter.
     **/
    public void makeButton(){
        btnPanel = new JPanel(new GridLayout(1,3));
        
        //create buttons
        startBtn = new JButton("Start");
        startBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                //initialize the program
                textArea.setText("");
                manager = new ParkManager(4, 888, 10);
                manager.createHikersInTrails();
                fileEditor = new FileEditor(manager.hikersInfo());
                textArea.setText(manager.fullGroupInfo()+manager.partialGroupInfo());
                
            }
        });
        
        openBtn = new JButton("Open");
        openBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                textArea.setText(manager.removeFullGroups());
            }
        });
        
        checkBtn = new JButton("Check");
        checkBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                textArea.setText(manager.removePartialGroups());
            }
        });
        
        //btnPanel.add(label, BorderLayout.NORTH);
        btnPanel.add(startBtn);
        btnPanel.add(openBtn);
        btnPanel.add(checkBtn);
    }
    
    /**
     * create the textArea
     **/
    public void makeTextArea(){
        textPanel = new JPanel();
        textPanel.setBorder(new EtchedBorder(10,Color.BLACK, Color.GRAY));
        
        textArea = new JTextArea(30, 30);
        //set textArea to non-editable
        textArea.setEditable(false);
        
        //create a scroller for the textArea
        JScrollPane textScroller = new JScrollPane(textArea);
        //set scroller to always be vertical
        textScroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);;
        
        textPanel.add(textScroller);
    }
    
    /**
     * create the labels
     **/
    public void makeLabels(){
        hintPanel = new JPanel(new BorderLayout());
        
        JLabel startLabel = new JLabel("Press Start to allow Hikers to line up in the entrances");
        
        JLabel openLabel = new JLabel("Press Open to let the full group of hikers into the trails");
        
        JLabel checkLabel = new JLabel("Press check to let the hikers who are in partial group into the trials");
        
        hintPanel.add(startLabel, BorderLayout.NORTH);
        hintPanel.add(openLabel, BorderLayout.CENTER);
        hintPanel.add(checkLabel, BorderLayout.SOUTH);
    }
    
}
