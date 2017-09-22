import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

/**
 * Provide a GUI interface for the job submission system.
 * Only shows a selection of possible functions: add job, list jobs 
 * waiting record job done.
 * 
 * @author SRN: 15065017
 * @version 29/12/16
 */
public class JobsGUI 
{
    private Manager mmm = new Branch("Watford");
    private JFrame myFrame = new JFrame("Jobs GUI");
    private Container contentPane = myFrame.getContentPane();
    
    private JButton quitButton = new JButton("Quit");
    private JButton addJobButton = new JButton("Add Job");
    private JButton clearListButton = new JButton("Clear List");
    
    private JTextArea textArea = new JTextArea(10, 20);
    
    private JLabel label = new JLabel("Enter Customer Name:");
    private JTextField textField = new JTextField(20);
    
    private JLabel label3 = new JLabel("Job Requirements");
    private JCheckBox siteCheckBox = new JCheckBox("On site");
    private JCheckBox shortHandCheckBox = new JCheckBox("Shorthand");
    private JCheckBox transCheckBox = new JCheckBox("Translation");
    
    
    private JPanel eastPanel = new JPanel();
    private JPanel westPanel = new JPanel(); 
    private JPanel centerPanel = new JPanel();
    private JPanel northPanel = new JPanel();
    private JPanel southPanel = new JPanel();
    
    public JobsGUI()
    {
        addAllStaff();
        makeFrame();
        makeMenus(myFrame);        
    }
    
    /**
     * Adds staff members
     */
    private void addAllStaff()
    {
        mmm.addStaff("CL1", "Ann");
        mmm.addStaff("CL2", "Bob");
        mmm.addStaff("TY1", "Che", true, true);
        mmm.addStaff("TY2", "Dan", true, false);
        mmm.addStaff("TY3", "Eve", false, true);
        mmm.addStaff("TY4", "Fez", false, false);
        mmm.addStaff("TR1", "Gil", true, true, "French", 18);
        mmm.addStaff("TR2", "Han", true, false, "French", 11);
        mmm.addStaff("TR3", "Kit", false, true, "German", 20);
        mmm.addStaff("TR4", "Lil", false, false, "German", 22);
    }
    
    /**
     * Create the main frame's menu bar.
     */
    private void makeMenus(JFrame frame)
    {
        JMenuBar menubar = new JMenuBar();
        frame.setJMenuBar(menubar);
        
        // create the File menu
        JMenu fileMenu = new JMenu("Jobs");
        menubar.add(fileMenu);
        
        JMenuItem doneItem = new JMenuItem("Job Done");
        doneItem.addActionListener(new DoneHandler());
        fileMenu.add(doneItem);
        
        JMenuItem addJob = new JMenuItem("Add Job");
        addJob.addActionListener(new AddJobPageHandler());
        fileMenu.add(addJob);
        
        JMenuItem listWaiting = new JMenuItem("List Waiting");
        listWaiting.addActionListener(new ListWaitingHandler());
        fileMenu.add(listWaiting);
              
    }

    /**
     * Create the Swing frame and its content.
     */
    private void makeFrame()
    {    
        contentPane.setLayout(new BorderLayout());
        contentPane.add(eastPanel, BorderLayout.EAST);
        contentPane.add(southPanel, BorderLayout.SOUTH);
        contentPane.add(westPanel, BorderLayout.WEST);
        contentPane.add(centerPanel, BorderLayout.CENTER);
        contentPane.add(northPanel, BorderLayout.NORTH);
        // set panel layout and add components

        southPanel.add(quitButton);
        quitButton.setVisible(true);
        quitButton.addActionListener(new QuitButtonHandler());
        
        eastPanel.setLayout(new GridLayout(4, 1));        
        
        centerPanel.add(textArea);
        centerPanel.setVisible(false);
                                               
        westPanel.setLayout(new BoxLayout(westPanel, BoxLayout.Y_AXIS));
        westPanel.add(label3);
        westPanel.add(siteCheckBox);
        westPanel.add(shortHandCheckBox);
        westPanel.add(transCheckBox);
        westPanel.setVisible(false);
        
        eastPanel.add(addJobButton);
        addJobButton.addActionListener(new AddJobButtonHandler());
        eastPanel.add(clearListButton);
        clearListButton.addActionListener(new ClearListHandler());
        eastPanel.setVisible(false);
        
        northPanel.add(label);
        northPanel.add(textField);
        northPanel.setVisible(false);
                                                        
        // building is done - arrange the components and show        
        myFrame.pack();
        myFrame.setVisible(true);
    }

    private void makeTypes()
    {
        westPanel.setVisible(false);
        centerPanel.setVisible(false);
        northPanel.setVisible(false);
        contentPane.add(westPanel, BorderLayout.WEST);
        contentPane.add(centerPanel, BorderLayout.CENTER);
        contentPane.add(northPanel, BorderLayout.NORTH);
        // set panel layout and add components
        centerPanel.setLayout(new FlowLayout());
        northPanel.setLayout(new GridLayout(4,1));

                
                       
    }
    

    private class DoneHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        { 
            String result = "";
            String inputValue = JOptionPane.showInputDialog("Job No ?");
            int jNo = Integer.parseInt(inputValue);
            String hrsValue = JOptionPane.showInputDialog("Hours ?: ");
            int hrs = Integer.parseInt(hrsValue);
            if(mmm.setJobDone(jNo,hrs)== -1)
            {
                result = "No such job";
            }
            else
            {
                result = "Job Done.Cost of job is :£" + 
                            (mmm.getJobCost(jNo));
            }
           
            JOptionPane.showMessageDialog(myFrame,result);    
        }
    }
    
    private class AddJobPageHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            westPanel.setVisible(true);
            eastPanel.setVisible(true);
            addJobButton.setVisible(true);
            northPanel.setVisible(true);

            clearListButton.setVisible(false);
            centerPanel.setVisible(false);
            
        }
    }
    
    private class ListWaitingHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            centerPanel.setVisible(true);
            eastPanel.setVisible(true);
            clearListButton.setVisible(true);
            addJobButton.setVisible(false);
            westPanel.setVisible(false);
            northPanel.setVisible(false);
            textArea.setText(mmm.getJobsWaiting());
        }
    }
    
    private class ClearListHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            centerPanel.setVisible(false);
        }
    }
    
    private class AddJobButtonHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String cust = textField.getText();
            boolean onSite = false;
            boolean sHand = false;
            String lang = "";
            if(siteCheckBox.isSelected())
            {
                onSite = true;
            }
            
            if(shortHandCheckBox.isSelected())
            {
                sHand = true;
            }
            
            if(transCheckBox.isSelected())
            {
                lang = JOptionPane.showInputDialog(myFrame, "Language required?");
            }
            else
            {
                lang = "English";
            }
            
            
            
            String result = mmm.addJob(cust, onSite, sHand, lang);
            JOptionPane.showMessageDialog(myFrame, result); 
        }
    }
    

    private class QuitButtonHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        { 
            int answer = JOptionPane.showConfirmDialog(myFrame,
                "Are you sure you want to quit?","Finish",
                JOptionPane.YES_NO_OPTION);
            // closes the application
            if (answer == JOptionPane.YES_OPTION)
            {
                System.exit(0); //closes the application
            }              
        }
    }
}
   
