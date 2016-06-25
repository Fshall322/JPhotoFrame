/**
 * Created by Frank Hall on 6/25/2016.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JPhotoFrame extends JFrame implements ItemListener // start class JPhotoFrame that extends JFrame and implements ItemListener
{
    FlowLayout flow = new FlowLayout();// layout control
    ButtonGroup subjects =  new ButtonGroup();// groups the subject check boxes into one group
    ButtonGroup location = new ButtonGroup();// groups the location boxes together in a single group
    JCheckBox singlePerson = new JCheckBox("Single person session");// check box creation// first the label of the checkbox, then if i put a coomma after the text and put true it will check that box on load up ("Single person session", true);
    JCheckBox multiPerson = new JCheckBox("More than one person session");// check box creation
    JCheckBox withPet = new JCheckBox("Session with a pet");// check box creation
    JCheckBox offSiteLocation = new JCheckBox("Off site location");// check box creation
    JTextField subjectCostText = new JTextField(25);//text box for output
    JTextField locationPriceText = new JTextField(25);//text box for output
    JTextField totalPriceText = new JTextField(25);//text box for output
    JLabel subjectLabel = new JLabel("Choose the subjects");// labels to designate the checkbox groups
    JLabel sessionLabel = new JLabel("Check for off site");// labels to designate the checkbox groups
    String msg = "Your Subject cost is: ";// string for the approprite messages
    String msg2 = "Your location Price is: ";// string for the approprite messages
    String msg3 = "Your total cost will be: ";// string for the approprite messages
    String output;// output the above string = msg,msg2, msg3
    double subjectPrice = 0;// variable for the subect price
    double sessionPrice = 0;// variable for the session price
    double totalCost = 0;// variable for the total cost of the pfoto shoot



    public JPhotoFrame()// constructor
    {
        super("Paula's Portraits"); // title
        setDefaultCloseOperation(EXIT_ON_CLOSE);// sets the window exit on close instead of going invisible and running in background
        setLayout(flow);// layout control
        add(subjectLabel);// adds the labels and checkboxes to the frame
        add(singlePerson);// adds the labels and checkboxe to the frame
        add(multiPerson);// adds the labels and checkboxes to the frame
        add(withPet);// adds the labels and checkboxes to the frame
        singlePerson.addItemListener(this);// ItemListener
        multiPerson.addItemListener(this);// ItemListener
        withPet.addItemListener(this);// ItemListener
        subjects.add(singlePerson);// groups the checkboxes into a single group called subjects
        subjects.add(multiPerson);// groups the checkboxes into a single group called subjects
        subjects.add(withPet);// groups the checkboxes into a single group called subjects
        add(sessionLabel);// adds the labels and checkboxes to the frame
        add(offSiteLocation);// adds the labels and checkboxes to the frame
        offSiteLocation.addItemListener(this);//ItemListener
        location.add(offSiteLocation);//groups the offsitelocation to the location group
        add(subjectCostText);// adds the textboxes to the frame
        add(locationPriceText);// adds the textboxes to the frame
        add(totalPriceText);// adds the textboxes to the frame
    }

    public static void main(String[] args)// method main
    {
        JFrame windowFrame = new JPhotoFrame();// creates a new window object
        windowFrame.setSize(350, 250);// sizes window
        windowFrame.setVisible(true);// makes windo visible
    }

    public void itemStateChanged(ItemEvent e)// item event method
    {
        Object source = e.getItem();// creates a source to know which item performed an event

        if(source == singlePerson)
        {
            int select = e.getStateChange();// creates a variable called select and makes it look for item state changes like selec ted and deselected
            if(select == ItemEvent.SELECTED)// checks if item is selected or not
                subjectPrice = 40;
            else if(select == ItemEvent.DESELECTED)// checks if item is selected or not
                subjectPrice = 0;

            String s1 = java.text.NumberFormat.getCurrencyInstance().format(subjectPrice); // currency formatting
            output = msg+ " " + s1;
            subjectCostText.setText(output);
        }
        if(source == multiPerson)
        {
            int select = e.getStateChange();// creates a variable called select and makes it look for item state changes like selec ted and deselected
            if(select == ItemEvent.SELECTED)// checks if item is selected or not
                subjectPrice = 75;
            else if(select == ItemEvent.DESELECTED)// checks if item is selected or not
                subjectPrice = 0;

            String s1 = java.text.NumberFormat.getCurrencyInstance().format(subjectPrice);  // currency formatting
            output = msg+ " " + s1;
            subjectCostText.setText(output);// OUTPUT TO THE APPROPRIATE TEXT BOX
        }
        if(source == withPet)
        {
            int select = e.getStateChange();// creates a variable called select and makes it look for item state changes like selec ted and deselected
            if(select == ItemEvent.SELECTED)// checks if item is selected or not
                subjectPrice = 95;
            else if(select == ItemEvent.DESELECTED)// checks if item is selected or not
                subjectPrice = 0;

            String s1 = java.text.NumberFormat.getCurrencyInstance().format(subjectPrice);  // currency formatting
            output = msg+ " " +s1;
            subjectCostText.setText(output);// OUTPUT TO THE APPROPRIATE TEXT BOX
        }
        if(source == offSiteLocation)
        {
            int select = e.getStateChange();// creates a variable called select and makes it look for item state changes like selec ted and deselected
            if(select == ItemEvent.SELECTED)// checks if item is selected or not
                sessionPrice = 90;
            else if(select == ItemEvent.DESELECTED)// checks if item is selected or not
                sessionPrice = 0;

            String s2 = java.text.NumberFormat.getCurrencyInstance().format(sessionPrice);
            output = msg2+ " " + s2;
            locationPriceText.setText(output);// OUTPUT TO THE APPROPRIATE TEXT BOX
        }

        totalCost = subjectPrice + sessionPrice;
        String s3 = java.text.NumberFormat.getCurrencyInstance().format(totalCost);
        output = msg3+ " " +s3;
        totalPriceText.setText(output);// OUTPUT TO THE APPROPRIATE TEXT BOX
    }
} 
