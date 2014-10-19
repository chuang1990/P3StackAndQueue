//Action
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
//Swing
import javax.swing.*;
import javax.swing.border.EtchedBorder;
/**
 * GUI class
 * 
 * The GUI class is in charge of displaying the program to the user and allows user interaction.
 * This class has methods to make the window, buttons, labels with directions to the user and a text area 
 * This methods involve event handling
 * 
 * @author (Catherine Huang, Hannah Riggs, Maria del Mar Moncaleano) 
 * @version 10/18/2014
 **/
public class GUI
{  
    //instance variables
    private JFrame frame;

    //buttons
    private JPanel btnPanel;
   
    private JButton startBtn;
    private JButton checkBtn;
    private JButton openBtn;

    //text area
    private JPanel textPanel;
    private JTextArea textArea;

     //labelPnael
    private JPanel hintPanel;

    //other variables
    private FileEditor fileEditor;
    private ParkManager manager;
    private Font font;
    /**
     * constructor
     **/
    public GUI()
    {
        this.makeWindow();
    }

    /**
     * create the frame
     **/
    public void makeWindow()
    {
        frame = new JFrame("The Purple Mountain National Forest");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

        setContent(frame);

        frame.pack();
        frame.setSize(800,680);
        frame.setVisible(true);
    }

    /**
     * put the contents together in the container
     **/
    public void setContent(JFrame frame)
    {
        Container contentPane = frame.getContentPane();
        
        makeButton();
        makeTextArea();
        makeTextFields();

        contentPane.add(btnPanel,BorderLayout.EAST);
        contentPane.add(hintPanel, BorderLayout.SOUTH);
        contentPane.add(textPanel, BorderLayout.CENTER);
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
    public void makeButton()
    { 
        btnPanel = new JPanel(new GridLayout(15,0, 10, 10));
        btnPanel.setBackground(new Color(28, 94, 161));

        JLabel optionLabel = new JLabel("  Options: ");
        font = new Font("Serif", Font.ITALIC, 20);
        optionLabel.setFont(font);
        optionLabel.setForeground(Color.WHITE);

        createStartButton();
        createOpenButton();
        createCheckButton();

        btnPanel.add(optionLabel);
        btnPanel.add(startBtn);
        btnPanel.add(openBtn);
        btnPanel.add(checkBtn);
    }

    /**
     * creates the button start, with its action listener 
     * by creating hikers, writing their information on a file
     * placing them in stacks and adding the filled stacks in the queue.
     **/
    public void createStartButton()
    {
        //Start button
        startBtn = new JButton("Start");
        font = new Font("Serif", Font.ITALIC, 20);
        startBtn.setFont(font);
        startBtn.setForeground(new Color(28, 94, 161));
        startBtn.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    //initialize the program
                    textArea.setText("");
                    manager = new ParkManager(4, 500, 10);
                    manager.createHikersInTrails();
                    fileEditor = new FileEditor(manager.hikersInfo());
                    textArea.setText(manager.fullGroupInfo()+manager.partialGroupInfo());

                }
            });
    }

    /**
     * creates the button open, with its action listener 
     * will remove the stacks (groups) out of the queue (manger)
     * and prints the hikers’ names on the text area 
     **/
    public void createOpenButton()
    {
        //open button 
        openBtn = new JButton("Open");
        font = new Font("Serif", Font.ITALIC, 20);
        openBtn.setFont(font);
        openBtn.setForeground(new Color(28, 94, 161));
        openBtn.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    textArea.setText(manager.removeFullGroups());
                }
            });
    }

    /**
     * creates the button Check, with its action listener 
     * checks from the trails (1 to 4) and removes from the queue (manager) 
     * the partialGroups which are the groups that are not full
     * and prints the hikers names on the text area 
     **/
    public void createCheckButton()
    {
        checkBtn = new JButton("Check");
        font = new Font("Serif", Font.ITALIC, 20);
        checkBtn.setFont(font);
        checkBtn.setForeground(new Color(28, 94, 161));
        checkBtn.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    textArea.setText(manager.removePartialGroups());
                }
            });
    }

    /**
     * create the textArea
     **/
    public void makeTextArea()
    {
        textPanel = new JPanel(new BorderLayout());

        textPanel = new JPanel();
        textPanel.setBackground(new Color(145,174,203));

        textPanel.setBorder(new EtchedBorder(20,Color.WHITE, Color.BLACK));
        //JLabel welcome = new JLabel("Welcome");
        textArea = new JTextArea(30, 30);
        //set textArea to non-editable
        textArea.setEditable(false);

        //create a scroller for the textArea
        JScrollPane textScroller = new JScrollPane(textArea);

        //set scroller to always be vertical
        textScroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        textPanel.add(textScroller);
    }

    /**
     * create the labels
     **/
    public void makeTextFields()
    {
        hintPanel = new JPanel(new GridLayout(5,2));
        hintPanel.setBackground(new Color(28, 94, 161));
        
        JLabel noneLabel = new JLabel(" ");

        JLabel hintLabel = new JLabel("  Instructions: ");
        font = new Font("Serif", Font.ITALIC, 25);
        hintLabel.setFont(font);
        hintLabel.setForeground(new Color(145,174,203));

        JLabel startLabel = new JLabel("  Press Start to allow Hikers to line up in the entrances");
        font = new Font("Serif", Font.ITALIC, 20);
        startLabel.setFont(font);
        startLabel.setForeground(Color.WHITE);

        JLabel openLabel = new JLabel("  Press Open to let the full group of hikers into the trails");
        font = new Font("Serif", Font.ITALIC, 20);
        openLabel.setFont(font);
        openLabel.setForeground(Color.WHITE);

        JLabel checkLabel = new JLabel("  Press check to let the hikers who are in partial group into the trials");
        font = new Font("Serif", Font.ITALIC, 20);
        checkLabel.setFont(font);
        checkLabel.setForeground(Color.WHITE);

        hintPanel.add(noneLabel);
        hintPanel.add(hintLabel);
        hintPanel.add(startLabel);
        hintPanel.add(openLabel);
        hintPanel.add(checkLabel);
    }

}
