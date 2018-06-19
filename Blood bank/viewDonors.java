package client.ijse.rmi.bloodbank.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DateFormat;
import javax.swing.table.*;

import javax.swing.JOptionPane;

public class viewDonors extends JFrame{
	
	//----------panels
	private JPanel mainPanel;
	private JPanel blackPanel;
	private JPanel redPanel;
	private JPanel orangePanel;
	private JPanel grayPanel1;
	private JPanel grayPanel2;
	private JPanel redtitlePanel;
	private JPanel titlePanel;
	private JPanel greenPanel1;
	private JPanel greenPanel2;
	private JPanel Panel;

	
	
	//----------labels
	private JLabel newdonorLabel;
	private JLabel addbloodsampleLabel;
	private JLabel viewbloodsampleLabel;
	private JLabel issueLabel;
	private JLabel issuedlistLabel;
	private JLabel searchdonorsLabel;
	private JLabel bloodbankLabel;
	private JLabel dateLabel;	
	private JLabel timeLabel;
	private JLabel titleLabel;
	private JLabel bloodgroupLabel;
	private JLabel donoridLabel;
	private JLabel dLabel;

	//----------textfields
	private JTextField donoridText;
	
	//----------comboboxes
	private JComboBox bloodgroupCombo;
	
	//----------tables
	private JTable donorTable;
	
	//----------buttons
	private JButton updateButton;
	private JButton viewButton;
	private JButton viewallButton;
	private JButton cancelButton;
	private JButton reloadButton;
	
	//----------separators
	private JSeparator Separator1;
	
	public viewDonors(){
		//----------panels
		mainPanel=new JPanel();
		blackPanel=new JPanel() ;
		redPanel=new JPanel();
		orangePanel=new JPanel() ;
		grayPanel1=new JPanel();
		grayPanel2=new JPanel();
		redtitlePanel=new JPanel();
		titlePanel=new JPanel();
		greenPanel1=new JPanel();
		greenPanel2=new JPanel();
		Panel=new JPanel();


		//----------labels
		newdonorLabel=new JLabel();
		addbloodsampleLabel=new JLabel();
		viewbloodsampleLabel=new JLabel();
		issueLabel=new JLabel();
		issuedlistLabel=new JLabel();
		searchdonorsLabel=new JLabel();
		bloodbankLabel=new JLabel();
		dateLabel=new JLabel();
		timeLabel=new JLabel();
		titleLabel=new JLabel();
		bloodgroupLabel=new JLabel();
		donoridLabel=new JLabel();
		dLabel=new JLabel();

		//----------textfields
		donoridText=new JTextField(18);

		//----------comboboxes
		bloodgroupCombo=new JComboBox ();

		//----------buttons
		updateButton=new JButton();
		viewButton=new JButton();
		viewallButton=new JButton();
		cancelButton=new JButton();
		reloadButton=new JButton();
		
		//----------separators
		Separator1=new JSeparator ();

		
		
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
		titlePanel.setPreferredSize(new Dimension(730, 30));
		
		greenPanel1.setBackground(new Color(180,180,158));
		greenPanel1.setPreferredSize(new Dimension(730, 60));
		
		greenPanel2.setBackground(new Color(180,180,158));
		greenPanel2.setPreferredSize(new Dimension(684, 84));
		
		

				
		//-----------set main title	
		bloodbankLabel.setBackground(new Color(255, 255, 255));
        bloodbankLabel.setFont(new Font("Segoe UI", 1, 18)); 
        bloodbankLabel.setText("BLOOD BANK");
        
        //-----------set name of the application
        titleLabel.setFont(new Font("Segoe UI", 1, 14));
        titleLabel.setForeground(new Color(153, 153, 153));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setText("View Donors");
        
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
        
        //----------set labels,textfields and comboboxes		
        bloodgroupLabel.setFont(new Font("Arial", 1, 12)); 
        bloodgroupLabel.setText("Reqiured Blood Group :");
        
        bloodgroupCombo.setFont(new Font("Segoe UI Light", 1, 12));
        bloodgroupCombo.setModel(new DefaultComboBoxModel(new String[] { "A+","A-","B+","B-","O+","O-","AB+","AB-" }));
        bloodgroupCombo.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        
        donoridLabel.setFont(new Font("Arial", 1, 12));
        donoridLabel.setText("Donor ID :");
        
        donoridText.setFont(new Font("Arial", 0, 12));  
        donoridText.setPreferredSize(new Dimension(6, 20));    
		     
        dLabel.setFont(new Font("Arial UI", 1, 14));
        dLabel.setText("D");      
        
        //-----------buttons
		viewButton.setBackground(new Color(255,255,255));
        viewButton.setFont(new Font("Segoe UI", 1, 12));
        viewButton.setText("View");
        viewButton.setBorder(BorderFactory.createLineBorder(new Color(102,102,102)));
        
        viewallButton.setBackground(new Color(255,255,255));
        viewallButton.setFont(new Font("Segoe UI", 1, 12));
        viewallButton.setText("View All");
        viewallButton.setBorder(BorderFactory.createLineBorder(new Color(102,102,102)));
        viewallButton.setPreferredSize(new Dimension(47, 19));
        
        reloadButton.setBackground(new Color(204,204,204));
        reloadButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); 
        reloadButton.setText("Reload");
        reloadButton.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
                
        updateButton.setBackground(new Color(255,255,255));
        updateButton.setFont(new Font("Segoe UI", 1, 12));
        updateButton.setText("Update");
        updateButton.setBorder(BorderFactory.createLineBorder(new Color(102,102,102)));

		cancelButton.setBackground(new Color(204,204,204));
        cancelButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); 
        cancelButton.setText("Cancel");
        cancelButton.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        
        //Separators
		Separator1.setForeground(new Color(0,0,0));

        
        //----------Table
        DefaultTableModel model=new DefaultTableModel(columnNames,10);
        donorTable=new JTable(model);
        JScrollPane tablepane=new JScrollPane(donorTable);
        tablepane.setPreferredSize(new Dimension(460, 402));
        donorTable.setRowHeight(30);

        
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
		
		//greenPanel1Layout
		
		GroupLayout greenPanel1Layout=new GroupLayout(greenPanel1);
		greenPanel1.setLayout(greenPanel1Layout);
		greenPanel1Layout.setHorizontalGroup(
			greenPanel1Layout.createParallelGroup()
			.addGroup(greenPanel1Layout.createSequentialGroup()
				.addGap(60,60,60)
				.addComponent(bloodgroupLabel,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
				.addGap(18,18,18)
				.addComponent(bloodgroupCombo,GroupLayout.PREFERRED_SIZE,70,GroupLayout.PREFERRED_SIZE)
				.addGap(200,200,200)
				.addComponent(viewallButton,GroupLayout.PREFERRED_SIZE,90,GroupLayout.PREFERRED_SIZE)
				.addGap(150,150,150)
			)
		);
		greenPanel1Layout.setVerticalGroup(
			greenPanel1Layout.createParallelGroup()
			.addGroup(greenPanel1Layout.createSequentialGroup()
				.addGap(12,12,12)
				.addGroup(greenPanel1Layout.createParallelGroup()
					.addComponent(bloodgroupLabel,GroupLayout.PREFERRED_SIZE,30,GroupLayout.PREFERRED_SIZE)
					.addComponent(bloodgroupCombo,GroupLayout.PREFERRED_SIZE,30,GroupLayout.PREFERRED_SIZE)
					.addComponent(viewallButton,GroupLayout.PREFERRED_SIZE,30,GroupLayout.PREFERRED_SIZE)
				)
			)
		);

		
		//greenPanel2Layout
		GroupLayout greenPanel2Layout=new GroupLayout(greenPanel2);
		greenPanel2.setLayout(greenPanel2Layout);
		greenPanel2Layout.setHorizontalGroup(
			greenPanel2Layout.createParallelGroup()				
			.addGroup(greenPanel2Layout.createSequentialGroup()
				.addGap(60,60,60)
				.addComponent(donoridLabel,GroupLayout.PREFERRED_SIZE,60,GroupLayout.PREFERRED_SIZE)
				.addGap(5,5,5)
				.addComponent(dLabel,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
				.addGap(5,5,5)
				.addComponent(donoridText,GroupLayout.PREFERRED_SIZE,150,GroupLayout.PREFERRED_SIZE)
				.addGap(100,100,100)
				.addComponent(updateButton,GroupLayout.PREFERRED_SIZE,90,GroupLayout.PREFERRED_SIZE)
				.addGap(25,25,25)
				.addComponent(viewButton,GroupLayout.PREFERRED_SIZE,90,GroupLayout.PREFERRED_SIZE)
				.addGap(25,25,25)
			)
		);
		greenPanel2Layout.setVerticalGroup(
			greenPanel2Layout.createParallelGroup()
			.addGroup(greenPanel2Layout.createSequentialGroup()
				.addGap(15,15,15)
				.addGroup(greenPanel2Layout.createParallelGroup()
					.addComponent(donoridLabel,GroupLayout.PREFERRED_SIZE,30,GroupLayout.PREFERRED_SIZE)
					.addComponent(dLabel,GroupLayout.PREFERRED_SIZE,30,GroupLayout.PREFERRED_SIZE)
					.addComponent(donoridText,GroupLayout.PREFERRED_SIZE,30,GroupLayout.PREFERRED_SIZE)
					.addComponent(updateButton,GroupLayout.PREFERRED_SIZE,30,GroupLayout.PREFERRED_SIZE)
					.addComponent(viewButton,GroupLayout.PREFERRED_SIZE,30,GroupLayout.PREFERRED_SIZE)
				)
			)
		);

		

		//mainPanelLayout
		GroupLayout mainPanelLayout=new GroupLayout(mainPanel);
		mainPanel.setLayout(mainPanelLayout);
		
		mainPanelLayout.setHorizontalGroup(
			mainPanelLayout.createParallelGroup()
				.addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(redPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(grayPanel1, GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
            )
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup()
                    .addComponent(grayPanel2,GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(orangePanel,GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(blackPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                )
				.addGroup(mainPanelLayout.createParallelGroup()
					.addGroup(mainPanelLayout.createSequentialGroup()
						.addGap(10,10,10)
                        .addGroup(mainPanelLayout.createParallelGroup()
                            .addComponent(titlePanel, GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(greenPanel1, GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(Separator1, GroupLayout.PREFERRED_SIZE, 730, GroupLayout.PREFERRED_SIZE)      
                        )
                    )
                    
					.addGroup(mainPanelLayout.createSequentialGroup()
						.addGap(15,15,15)
                        .addComponent(tablepane,GroupLayout.PREFERRED_SIZE, 720,GroupLayout.PREFERRED_SIZE)
                    )
                    .addGroup(mainPanelLayout.createSequentialGroup()
						.addGap(15,15,15)
						.addComponent(greenPanel2,GroupLayout.PREFERRED_SIZE,720,GroupLayout.PREFERRED_SIZE)
                    )
                    .addGroup(mainPanelLayout.createSequentialGroup()
						.addGap(300,300,300)
						.addComponent(reloadButton,GroupLayout.PREFERRED_SIZE,165,GroupLayout.PREFERRED_SIZE)
						.addGap(75,75,75)
						.addComponent(cancelButton,GroupLayout.PREFERRED_SIZE,165,GroupLayout.PREFERRED_SIZE)
                    )
                )
            )
		);
		mainPanelLayout.setVerticalGroup(
			mainPanelLayout.createParallelGroup()
			.addGroup(mainPanelLayout.createSequentialGroup()
				.addGroup(mainPanelLayout.createParallelGroup()
					.addComponent(redPanel,GroupLayout.PREFERRED_SIZE,40,GroupLayout.PREFERRED_SIZE)
					.addComponent(grayPanel1,GroupLayout.PREFERRED_SIZE,40,GroupLayout.PREFERRED_SIZE)
				)
				.addGap(10,10,10)
				.addGroup(mainPanelLayout.createParallelGroup()
					.addGroup(mainPanelLayout.createSequentialGroup()
						.addComponent(orangePanel,GroupLayout.PREFERRED_SIZE,90,GroupLayout.PREFERRED_SIZE)
						.addGap(2,2,2)
						.addComponent(blackPanel,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
					)
					.addGroup(mainPanelLayout.createSequentialGroup()
						.addComponent(titlePanel,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
						.addGap(10,10,10)
						.addComponent(greenPanel1,GroupLayout.PREFERRED_SIZE,GroupLayout.PREFERRED_SIZE,GroupLayout.PREFERRED_SIZE)
					)					
				)
				.addGroup(mainPanelLayout.createParallelGroup()
					.addGroup(mainPanelLayout.createSequentialGroup()
						.addGap(10,10,10)
						.addComponent(grayPanel2,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
					)
					.addGroup(mainPanelLayout.createSequentialGroup()
						.addGap(8,8,8)
						.addComponent(Separator1,GroupLayout.PREFERRED_SIZE,10,GroupLayout.PREFERRED_SIZE)
						.addGap(10,10,10)
						.addComponent(tablepane,GroupLayout.PREFERRED_SIZE,250,GroupLayout.PREFERRED_SIZE)
						.addGap(15,15,15)
						.addComponent(greenPanel2,GroupLayout.PREFERRED_SIZE,65,GroupLayout.PREFERRED_SIZE)
						.addGap(15,15,15)
						.addGroup(mainPanelLayout.createParallelGroup()
							.addComponent(reloadButton,GroupLayout.PREFERRED_SIZE,30,GroupLayout.PREFERRED_SIZE)
							.addGap(5,5,5)
							.addComponent(cancelButton,GroupLayout.PREFERRED_SIZE,30,GroupLayout.PREFERRED_SIZE)
							.addGap(10,10,10)
						)
					)				
				)
				.addGap(35,35,35)
			)
		);
		
		final viewDonors vd;
		vd=this;
		
		//addMouseListeners for labels
		newdonorLabel.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				new addDonorUi1().setVisible(true);
				vd.dispose();
			}
		});
		addbloodsampleLabel.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				new addBloodSample().setVisible(true);
				vd.dispose();
				
			}
		});
		
		viewbloodsampleLabel.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				new viewBloodsamples().setVisible(true);
				vd.dispose();
				
			}
		});
		issueLabel.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				new selectBloodSample().setVisible(true);
				vd.dispose();
			}
		});
		issuedlistLabel.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				new viewIssuedList().setVisible(true);
				vd.dispose();
			}
		});
		searchdonorsLabel.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				new viewDonors().setVisible(true);
				vd.dispose();
			}
		});
		
		//addActionListeners for buttons
		
		cancelButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				vd.dispose();
			}
		});
        updateButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				new updateDonor().setVisible(true);
			}
		});
		viewButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				new viewspecificDonor().setVisible(true);
			}
		});
		
        
        setDate();
		setTime();
		add(mainPanel);
		pack();

		
 
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
	
	//-----------setMessage
	public void setMessage(String message){
		JOptionPane.showMessageDialog(this, message);
        reloadButton.doClick();
	}
	
	private String[] columnNames={
		"Donor ID", "First name", "Last name", "NIC", "Gender", "Blood Group", "RH Factor", "Mobile", "Tel", "Address", "Reg.Date"
	};
	public static void main(String args[]){
		new viewDonors().setVisible(true);
	}
	

}
