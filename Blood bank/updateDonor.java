package client.ijse.rmi.bloodbank.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DateFormat;


public class updateDonor extends JFrame{
	//----------panels
	private JPanel mainPanel;
	private JPanel blackPanel;
	private JPanel redPanel;
	private JPanel orangePanel;
	private JPanel grayPanel1;
	private JPanel grayPanel2;
	private JPanel redtitlePanel;
	private JPanel titlePanel;
	private JPanel Panel;
	
	//----------labels
	private JLabel addbloodsampleLabel;
	private JLabel addressLabel;
	private JLabel ageLabel;
	private JLabel bloodbankLabel;
	private JLabel dateLabel;
	private JLabel regdateLabel;
	private JLabel didLabel;
	private JLabel dobLabel;
	private JLabel firstnameLabel;
	private JLabel genderLabel;
	private JLabel lastnameLabel;
	private JLabel mobileLabel;
	private JLabel newdonorLabel;
	private JLabel nicLabel;
	private JLabel occupationLabel;
	private JLabel otelLabel;
	private JLabel pinfoLabel;
	private JLabel issueLabel;
	private JLabel telhLabel;
	private JLabel timeLabel;
	private JLabel titleLabel;
	private JLabel vLabel;
	private JLabel viewbloodsampleLabel;
	private JLabel searchdonorsLabel;
	private JLabel issuedlistLabel;
	private JLabel workplaceLabel;
	private JLabel yrsLabel;
	
	
	
	//----------textfields
	private JTextField addressText;
	private JTextField ageText;
	private JTextField regdateText;
	private JTextField didText;
	private JTextField firstnameText;
	private JTextField lastnameText;
	private JTextField mobileText;
	private JTextField nicText;
	private JTextField occupationText;
	private JTextField otelText;
	private JTextField telhText;
	private JTextField workplaceText;
	private JTextField yearText;
	
	
	
	//----------comboboxes
	private JComboBox Combobox;
	private JComboBox daysCombo;
	private JComboBox genderCombo;
	private JComboBox monthCombo;
	
	
	//----------buttons

	private JButton updateButton;
	private JButton cancelButton;
	
	//----------separators
	private JSeparator Separator1;
	private JSeparator Separator2;

	
	public updateDonor(){
		//----------panels
		mainPanel=new JPanel();
		blackPanel=new JPanel();
		redPanel=new JPanel();
		orangePanel=new JPanel();
		grayPanel1=new JPanel();
		grayPanel2=new JPanel();
		redtitlePanel=new JPanel();
		titlePanel=new JPanel();
		Panel=new JPanel();
		
		//----------labels
		addbloodsampleLabel=new JLabel();
		addressLabel=new JLabel();
		ageLabel=new JLabel();
		bloodbankLabel=new JLabel();
		dateLabel=new JLabel();
		regdateLabel=new JLabel();
		didLabel=new JLabel();
		dobLabel=new JLabel();
		firstnameLabel=new JLabel();
		genderLabel=new JLabel();
		lastnameLabel=new JLabel();
		mobileLabel=new JLabel();
		newdonorLabel=new JLabel();
		nicLabel=new JLabel();
		occupationLabel=new JLabel();
		otelLabel=new JLabel();
		pinfoLabel=new JLabel();
		issueLabel=new JLabel();
		telhLabel=new JLabel();
		timeLabel=new JLabel();
		titleLabel=new JLabel();
		vLabel=new JLabel();
		viewbloodsampleLabel=new JLabel();
		searchdonorsLabel=new JLabel();
		issuedlistLabel=new JLabel();
		workplaceLabel=new JLabel();
		yrsLabel=new JLabel();
		
		//-----------textfields
		addressText=new JTextField();
		ageText=new JTextField();
		regdateText=new JTextField();
		didText=new JTextField();
		firstnameText=new JTextField();
		lastnameText=new JTextField();
		mobileText=new JTextField();
		nicText=new JTextField();
		occupationText=new JTextField();
		otelText=new JTextField();
		telhText=new JTextField();
		workplaceText=new JTextField();
		yearText=new JTextField();
		
		//----------comboboxes
		Combobox=new JComboBox ();
		daysCombo=new JComboBox ();
		genderCombo=new JComboBox ();
		monthCombo=new JComboBox ();
		
		//----------buttons
		updateButton=new JButton();
		cancelButton=new JButton();
	
		//----------separators
		Separator1=new JSeparator ();
		Separator2=new JSeparator ();

		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);		
		
		//----------set panels
		mainPanel.setBackground(new Color(255, 255, 255));
				
		grayPanel1.setBackground(new Color(153, 153, 153));
        grayPanel1.setPreferredSize(new Dimension(700, 36));
        
        Panel.setBackground(new Color(153, 153, 153));
		
		grayPanel2.setBackground(new Color(153, 153, 153));
		grayPanel2.setPreferredSize(new Dimension(230, 420));
		
		redPanel.setBackground(new Color(153, 0, 51));
        redPanel.setPreferredSize(new Dimension(230, 36));
		
		orangePanel.setBackground(new Color(204, 132, 50));
        orangePanel.setPreferredSize(new Dimension(230, 36));
        	
		blackPanel.setBackground(new Color(0, 0, 0));
		blackPanel.setPreferredSize(new Dimension(230, 10));

		redtitlePanel.setBackground(new Color(153, 0, 51));
		redtitlePanel.setPreferredSize(new Dimension(20,20));
		
		titlePanel.setBackground(new Color(240,240,240));
		titlePanel.setPreferredSize(new Dimension(690, 30));
		
		//-----------set main title	
		bloodbankLabel.setBackground(new Color(255, 255, 255));
        bloodbankLabel.setFont(new Font("Segoe UI", 1, 18)); 
        bloodbankLabel.setText("BLOOD BANK");
               
        //-----------set name of the application
        titleLabel.setFont(new Font("Segoe UI", 1, 14));
        titleLabel.setForeground(new Color(153, 153, 153));
        titleLabel.setText("Update Donor");
        
        //-----------set date and time
        timeLabel.setFont(new Font("Segoe UI", 1, 14));
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        timeLabel.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));

        dateLabel.setFont(new Font("Segoe UI", 1, 14));
        dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
        dateLabel.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        
		//----------set links
		        
        newdonorLabel.setFont(new Font("Segoe UI", 1, 14)); 
        newdonorLabel.setForeground(new Color(255, 255, 255));
        newdonorLabel.setHorizontalAlignment(SwingConstants.CENTER);
        newdonorLabel.setText("New Donor");
        newdonorLabel.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));

               
        addbloodsampleLabel.setFont(new Font("Segoe UI", 1, 14));
        addbloodsampleLabel.setForeground(new Color(255, 255, 255));
        addbloodsampleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        addbloodsampleLabel.setText("Add Blood Sample");
        addbloodsampleLabel.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
    
		viewbloodsampleLabel.setFont(new Font("Segoe UI", 1, 14));
        viewbloodsampleLabel.setForeground(new Color(255, 255, 255));
        viewbloodsampleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        viewbloodsampleLabel.setText("View blood sample details");
        viewbloodsampleLabel.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
       
	    issueLabel.setFont(new Font("Segoe UI", 1, 14));
        issueLabel.setForeground(new Color(255, 255, 255));
        issueLabel.setHorizontalAlignment(SwingConstants.CENTER);
        issueLabel.setText("Issue blood sample");
        issueLabel.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
           
        issuedlistLabel.setFont(new Font("Segoe UI", 1, 14)); 
        issuedlistLabel.setForeground(new Color(255, 255, 255));
        issuedlistLabel.setHorizontalAlignment(SwingConstants.CENTER);
        issuedlistLabel.setText("Issued blood sample details");
        issuedlistLabel.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
                           
        searchdonorsLabel.setFont(new Font("Segoe UI", 1, 14));
        searchdonorsLabel.setForeground(new Color(255, 255, 255));
        searchdonorsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        searchdonorsLabel.setText("Search Donors");
        searchdonorsLabel.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
        searchdonorsLabel.setOpaque(true);
        searchdonorsLabel.setBackground(new Color(0,0,0));
               
        		
		//----------set labels ,comboboxes and textfields
				
        didLabel.setFont(new Font("Segoe UI", 0, 12)); 
        didLabel.setText("Donor Id   : ");
        
        didText.setEditable(false);
        didText.setFont(new Font("Arial", 0, 12));        

        regdateLabel.setFont(new Font("Segoe UI", 0, 12)); 
        regdateLabel.setText("Register Date   : ");       

        regdateText.setEditable(false);
        regdateText.setFont(new Font("Arial", 0, 12));
            
        pinfoLabel.setFont(new Font("Segoe UI", 1, 14));
        pinfoLabel.setForeground(new Color(204, 204, 204));
        pinfoLabel.setText("Personal Info");
             
		Combobox.setFont(new Font("Segoe UI Light", 1, 12));
        Combobox.setModel(new DefaultComboBoxModel(new String[] { "Mr.", "Mrs.", "Miss" }));
        Combobox.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
              
		firstnameLabel.setFont(new Font("Segoe UI", 0, 12)); 
        firstnameLabel.setText("First Name : ");
        
		firstnameText.setFont(new Font("Arial", 0, 12)); 
              
        lastnameLabel.setFont(new Font("Segoe UI", 0, 12));
        lastnameLabel.setText("Last Name   : ");
              
        lastnameText.setFont(new Font("Arial", 0, 12));
               
        genderLabel.setFont(new Font("Segoe UI", 0, 12));
        genderLabel.setText("Gender      : ");      
        
        genderCombo.setFont(new Font("Segoe UI Light", 1, 12));
        genderCombo.setModel(new DefaultComboBoxModel(new String[] { "Male", "Female" }));        
        
        nicLabel.setFont(new Font("Segoe UI", 0, 12));
        nicLabel.setText("NIC           :");      
       
        nicText.setFont(new Font("Arial", 0, 12)); 
             
        vLabel.setFont(new Font("Segoe UI Light", 1, 12));
        vLabel.setText("V");     

        telhLabel.setFont(new java.awt.Font("Segoe UI", 0, 12));
        telhLabel.setText("Tel .(Home)  : ");    

        telhText.setFont(new Font("Arial", 0, 12));
        
        mobileLabel.setFont(new Font("Segoe UI", 0, 12));
        mobileLabel.setText("Mobile      : ");

        mobileText.setFont(new Font("Arial", 0, 12));
  
        addressLabel.setFont(new Font("Segoe UI", 0, 12)); 
        addressLabel.setText("Address :");

        addressText.setFont(new Font("Arial", 0, 12)); 
     
        occupationLabel.setFont(new Font("Segoe UI", 0, 12));
        occupationLabel.setText("Occupation  : ");
      
        occupationText.setFont(new Font("Arial", 0, 12)); 
    
        dobLabel.setFont(new Font("Segoe UI", 0, 12));
        dobLabel.setText("Date of birth : ");    
		
		yearText.setFont(new Font("Arial", 0, 12)); 
	
        monthCombo.setModel(new DefaultComboBoxModel(
			new String[] { "Jan", "Feb", "March", "Apr", "May", "June", "July", "Aug", "Sept", "Oct", "Nov", "Dec'" }));
 
        daysCombo.setModel(new DefaultComboBoxModel(
			new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        otelLabel.setFont(new Font("Segoe UI", 0, 12));
        otelLabel.setText("Office  Tel :");

        otelText.setFont(new Font("Arial", 0, 12)); 
     
        ageLabel.setFont(new Font("Segoe UI", 0, 12)); 
        ageLabel.setText("Age            : ");  
        
        ageText.setFont(new Font("Arial", 0, 12)); 
  
        yrsLabel.setFont(new Font("Segoe UI Light", 1, 12)); 
        yrsLabel.setText("Yrs.");    

        workplaceLabel.setFont(new Font("Segoe UI", 0, 12)); 
        workplaceLabel.setText("Work Place :");

        workplaceText.setFont(new Font("Arial", 0, 12)); 

		//-----------buttons

        updateButton.setBackground(new Color(153, 153, 153));
        updateButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); 
        updateButton.setText("Update");
        updateButton.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        
        cancelButton.setBackground(new Color(153, 153, 153));
        cancelButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); 
        cancelButton.setText("Cancel");
        cancelButton.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));


		//-----------set panelLayouts
		   
		 //grayPanel1Layout
		grayPanel1.setLayout(new FlowLayout(FlowLayout.RIGHT));	
		grayPanel1.add(redtitlePanel);
		grayPanel1.add(bloodbankLabel);

		//titlePanelLayout
		titlePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		titlePanel.add(titleLabel);
			
		
		//orangePanelLayout
		orangePanel.setLayout(new GridLayout(2,1,2,2));
		orangePanel.add(dateLabel);
		orangePanel.add(timeLabel);
		
		//grayPanel2Layout  
		grayPanel2.setLayout(new GridLayout(8,1,3,10));
		grayPanel2.add(newdonorLabel);
		grayPanel2.add(addbloodsampleLabel);
		grayPanel2.add(viewbloodsampleLabel);
		grayPanel2.add(issueLabel);
		grayPanel2.add(issuedlistLabel);
		grayPanel2.add(searchdonorsLabel);
		grayPanel2.add(Panel);
		grayPanel2.add(Panel);


        //mainPanelLayout
		GroupLayout mainPanelLayout = new GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup()
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(redPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(grayPanel1,GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            )
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(orangePanel, GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(mainPanelLayout.createParallelGroup()
                    .addComponent(titlePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(didLabel)
                        .addGap(29, 29, 29)
                        .addComponent(didText, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
                        .addGap(110, 110, 110)
                        .addComponent(regdateLabel)
                        .addGap(15, 15, 15)
                        .addComponent(regdateText, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
                    )                       
                )      
		    )
            
            .addGroup(mainPanelLayout.createSequentialGroup()
				.addGroup(mainPanelLayout.createParallelGroup()
					.addComponent(blackPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
					.addComponent(grayPanel2, GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
				)
                .addGap(10, 10, 10)
                .addGroup(mainPanelLayout.createParallelGroup()					
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(pinfoLabel,GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(Separator1,GroupLayout.PREFERRED_SIZE, 580, GroupLayout.PREFERRED_SIZE)
                    )
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(Combobox, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                    )
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(firstnameLabel)
                        .addGap(18, 18, 18)
                        .addComponent(firstnameText, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(lastnameLabel)
                        .addGap(29, 29, 29)
                        .addComponent(lastnameText, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
                    )
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(genderLabel)
                        .addGap(18, 18, 18)
                        .addComponent(genderCombo, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(nicLabel, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(nicText, GroupLayout.PREFERRED_SIZE, 190,GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(vLabel, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                    )
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(telhLabel, GroupLayout.PREFERRED_SIZE, 80,GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(telhText, GroupLayout.PREFERRED_SIZE, 210,GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(mobileLabel,GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(mobileText, GroupLayout.PREFERRED_SIZE, 210,GroupLayout.PREFERRED_SIZE)
                    )
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(addressLabel, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(addressText, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(occupationLabel, GroupLayout.PREFERRED_SIZE, 80,GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(occupationText, GroupLayout.PREFERRED_SIZE, 210,GroupLayout.PREFERRED_SIZE)
                     )
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(dobLabel)
                        .addGap(5, 5, 5)
                        .addComponent(yearText,GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(monthCombo, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(daysCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(otelLabel,GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(otelText,GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
                     )
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(ageLabel,GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(ageText,GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(yrsLabel,GroupLayout.PREFERRED_SIZE, 30,GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(workplaceLabel, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(workplaceText, GroupLayout.PREFERRED_SIZE, 210,GroupLayout.PREFERRED_SIZE)
                    )
                    .addComponent(Separator2,GroupLayout.PREFERRED_SIZE, 700,GroupLayout.PREFERRED_SIZE)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(300,300,300)
                        .addComponent(updateButton, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
                        .addGap(50,50,50)
                        .addComponent(cancelButton,GroupLayout.PREFERRED_SIZE,140,GroupLayout.PREFERRED_SIZE)
                    )             
                )
            )
        );
		mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup()
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup()
                    .addComponent(redPanel,GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                    .addComponent(grayPanel1,GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                )
                .addGap(10, 10, 10)
                .addGroup(mainPanelLayout.createParallelGroup()
                    .addComponent(orangePanel,GroupLayout.PREFERRED_SIZE, 90,GroupLayout.PREFERRED_SIZE)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(titlePanel, GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addGroup(mainPanelLayout.createParallelGroup()
                            .addComponent(didText,GroupLayout.PREFERRED_SIZE, 30,GroupLayout.PREFERRED_SIZE)
                            .addComponent(regdateText, GroupLayout.PREFERRED_SIZE, 30,GroupLayout.PREFERRED_SIZE)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(mainPanelLayout.createParallelGroup()
                                    .addComponent(didLabel,GroupLayout.PREFERRED_SIZE, 20,GroupLayout.PREFERRED_SIZE)
                                    .addComponent(regdateLabel, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                )
                            )
                        )
                    )
                )
                .addGap(2,2,2)
                .addComponent(blackPanel,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(10,10,10)
                .addGroup(mainPanelLayout.createParallelGroup()
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup()
                            .addComponent(pinfoLabel)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(Separator1,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                            )
                        )
                        .addGap(10, 10, 10)
                        .addComponent(Combobox,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(mainPanelLayout.createParallelGroup()
                            .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(firstnameLabel, GroupLayout.PREFERRED_SIZE, 30,GroupLayout.PREFERRED_SIZE)
                                .addComponent(firstnameText, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                            )
                            .addComponent(lastnameLabel,GroupLayout.PREFERRED_SIZE, 30,GroupLayout.PREFERRED_SIZE)
                            .addComponent(lastnameText,GroupLayout.PREFERRED_SIZE, 30,GroupLayout.PREFERRED_SIZE)
                        )
                        .addGap(19, 19, 19)
                        .addGroup(mainPanelLayout.createParallelGroup()
                            .addComponent(genderLabel, GroupLayout.PREFERRED_SIZE, 30,GroupLayout.PREFERRED_SIZE)
                            .addComponent(genderCombo,GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                            .addComponent(nicLabel, GroupLayout.PREFERRED_SIZE, 30,GroupLayout.PREFERRED_SIZE)
                            .addComponent(nicText, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                            .addComponent(vLabel,GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        )
                        .addGap(20, 20, 20)
                        .addGroup(mainPanelLayout.createParallelGroup()
                            .addComponent(telhLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                            .addComponent(telhText, GroupLayout.PREFERRED_SIZE, 30,GroupLayout.PREFERRED_SIZE)
                            .addComponent(mobileLabel, GroupLayout.PREFERRED_SIZE, 30,GroupLayout.PREFERRED_SIZE)
                            .addComponent(mobileText, GroupLayout.PREFERRED_SIZE, 30,GroupLayout.PREFERRED_SIZE)
                        )
                        .addGap(20, 20, 20)
                        .addGroup(mainPanelLayout.createParallelGroup()
                            .addComponent(addressLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                            .addComponent(addressText, GroupLayout.PREFERRED_SIZE, 30,GroupLayout.PREFERRED_SIZE)
                            .addComponent(occupationLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                            .addComponent(occupationText, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        )
                        .addGap(20, 20, 20)
                        .addGroup(mainPanelLayout.createParallelGroup()
                            .addComponent(dobLabel,GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                            .addComponent(yearText, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                            .addComponent(monthCombo,GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                            .addComponent(daysCombo, GroupLayout.PREFERRED_SIZE, 30,GroupLayout.PREFERRED_SIZE)
                            .addComponent(otelLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                            .addComponent(otelText,GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        )
                        .addGap(20, 20, 20)
                        .addGroup(mainPanelLayout.createParallelGroup()
                            .addComponent(ageLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                            .addComponent(ageText, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                            .addComponent(yrsLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                            .addComponent(workplaceLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                            .addComponent(workplaceText, GroupLayout.PREFERRED_SIZE, 30,GroupLayout.PREFERRED_SIZE)
                        )
                        .addGap(40, 40, 40)
                        .addComponent(Separator2, GroupLayout.PREFERRED_SIZE, 10,GroupLayout.PREFERRED_SIZE)
                        .addGap(15,15,15)
                        .addGroup(mainPanelLayout.createParallelGroup()
                            .addComponent(updateButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                            .addComponent(cancelButton,GroupLayout.PREFERRED_SIZE,30,GroupLayout.PREFERRED_SIZE)
                        )
                    )
                    .addComponent(grayPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    
                )
				.addGap(20,20,20)
			)
        );
		final updateDonor ud;
		ud=this;
		//addMouseListeners for labels
		newdonorLabel.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				new addDonorUi1().setVisible(true);
				//ud.dispose();
			}
			
		});
		addbloodsampleLabel.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				new addBloodSample().setVisible(true);
				//ud.dispose();
				
			}
		});
		
		viewbloodsampleLabel.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				new viewBloodsamples().setVisible(true);
				//ud.dispose();
			}	
		});
		issueLabel.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				new selectBloodSample().setVisible(true);
				//ud.dispose();
			}
		});
		issuedlistLabel.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				new viewIssuedList().setVisible(true);
				//ud.dispose();
			}
		});
		searchdonorsLabel.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				new viewDonors().setVisible(true);
				//ud.dispose();
			}
		});
		
		//addActionListeners for buttons
		
		updateButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JOptionPane.showMessageDialog(ud,"Donor information is updated successfully");
				ud.dispose();
			}
		});
		
		cancelButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				ud.dispose();
			}
		});
		
		
		add(mainPanel);
		pack();
		setDate();
		setTime();
				   	
	}
	
	//---------set Date
    private void setDate(){
		new Thread() {
			public void run(){
				while(true){
					SimpleDateFormat dateformat=new SimpleDateFormat("EEEEEEE , yyyy/MM/dd");
					dateLabel.setText(dateformat.format(new Date()));
				}
			}
		}.start();
	}
	
	//--------set Time
	private void setTime(){
		new Thread(){
			public void run(){
				while(true){
					SimpleDateFormat timeformat=new SimpleDateFormat("hh : mm");
					timeLabel.setText(timeformat.format(new Date()));
				}
			}
		}.start();
	}
	
	
	public static void main(String args[]){
		new updateDonor().setVisible(true);
	}
	
}
