import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    private TextPanel textPanel;
    private Toolbar toolbar;
    private FormPanel formPanel;

    public MainFrame(){
        super ("Hello World");

        setLayout(new BorderLayout());

        toolbar = new Toolbar();
        textPanel = new TextPanel();
        formPanel = new FormPanel();

        toolbar.setStringListener(new StringListener() {
            public void textEmitted(String text) {
                System.out.println(text);
                textPanel.appendText(text);
            }
        });

        formPanel.setFormListener(new FormListener(){
            public void formEventOcurred(FormEvent e) {
                String name = e.getName();
                String occupation = e.getOccupation();
                int ageCat = e.getAgeCategory();
                String empCat = e.getEmploymentCategory();

                textPanel.appendText(name + ": " + occupation + ": " + ageCat
                        + ", " + empCat +  "\n");

            }
        });



        add(toolbar, BorderLayout.NORTH);
        add(textPanel, BorderLayout.CENTER);
        add(formPanel, BorderLayout.WEST);


        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
