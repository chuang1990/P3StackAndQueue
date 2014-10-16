//Java
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Swing
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;

//JavaFX
import javafx.scene.text.Text;


/**
 * GUI class
 **/
public class GUI{

    //instance variables
    private JFrame frame;
    private JPanel mainPanel;
    private JPanel btnPanel;
    private JButton startBtn;
    private JButton checkBtn;
    private JButton openBtn;
    private JTextField textArea;
    private final TrailEntrance trails;
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
        
        
    }
    
    /**
     * create the buttons
     **/
    public void makeButton(){
        btnPanel = new JPanel(new BorderLayout());
        
        JLabel label = new JLabel("Purple Mountain Trail");
        label.setFont(new Font("Serif", Font.BOLD+ITALIC, 20));
        
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
    }
    
    /**
     * create the textArea
     **/
    public void makeTextArea(){
        textArea = new JTextField();
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
