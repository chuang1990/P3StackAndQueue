import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;


/**
 * GUI class
 **/
public class GUI{

    //instance variables
    private JFrame frame;
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
    }
    
    /**
     * create the frame
     **/
    public void makeWindeow(){
        frame = new JFrame("Purple Mountain Trail");
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
    }
    
    /**
     * put the contents together in the container
     **/
    public void setContent(JFrame frame){
    
    }
    
    /**
     * create the buttons
     **/
    public void makeButton(){
        startBtn = new JButton("Start");
        startBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
            
            }
        });
        
        openBtn = new JButton("Open");
        openBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                
            }
        });
        
        checkBtn = new JButton("Open");
        checkBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
            
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