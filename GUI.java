//Action
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Swing
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;

//experiment
//JavaFX
//import javafx.scene.text.Text;


/**
 * GUI class
 **/
public class GUI{

    //instance variables
    private JFrame frame;
    private JPanel mainPanel;
    //buttons
    private JPanel btnPanel;
    private JButton startBtn;
    private JButton checkBtn;
    private JButton openBtn;
    //text area
    private JPanel textPanel;
    private JTextArea textArea;
    private JScrollPane textScroller;
    //other variables
    private static TrailEntrance trails;
    private FileEditor fileEditor;
    
    /**
     * constructor
     **/
    public GUI(){
        trails = new TrailEntrance();
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
        contentPane.add(textPanel, BorderLayout.NORTH);
    }
    
    /**
     * create the buttons
     **/
    public void makeButton(){
        btnPanel = new JPanel(new GridLayout(1,3));
        
        //JLabel label = new JLabel("Purple Mountain Trail");
        //label.setFont(new Font("Serif", Font.BOLD+ITALIC, 20));
        
        startBtn = new JButton("Start");
        startBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                //initialize the program
                trails = new TrailEntrance();
            }
        });
        
        openBtn = new JButton("Open");
        openBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //clear the stacks that has more than 10 hikers from the all the queues.
                //prints out the info from the released stacks
                //writes to file
                //throw exemption if startBtn hasn't been pressed
            }
        });
        
        checkBtn = new JButton("Check");
        checkBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                //empty the queues.
                //print out the info of all the stacks that got cleared
                //writes to file
                //throw exemption if startBtn hasn't been pressed
                
            
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
        textScroller = new JScrollPane(textArea);
        //set scroller to always be vertical
        textScroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);;
        
        textPanel.add(textScroller);
    }
    
    /**
     * create the labels
     **/
    public void makeLabels(){
        
    }
    
    /**
     * clear the text box
     **/
    public void clearTextArea(){
    
    }
}
