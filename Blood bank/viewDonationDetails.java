package client.ijse.rmi.bloodbank.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DateFormat;
import javax.swing.table.*;


public class viewDonationDetails extends JFrame{
	
	//----------panels
	private JPanel mainPanel;
	private JPanel blackPanel;
	private JPanel redPanel;
	private JPanel orangePanel;
	private JPanel grayPanel1;
	private JPanel grayPanel2;
	private JPanel redtitlePanel;
	private JPanel titlePanel;
	private JPanel greenPanel;
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
	private JLabel rhfactorLabel;
	private JLabel donornameLabel;

	//----------textfields
	private JTextField bloodgroupText;
	private JTextField rhfactorText;
	private JTextField donornameText;
	

	//----------tables
	private JTable donationsTable;
	
	//----------buttons
	private JButton cancelButton;
	
	//----------separators
	private JSeparator Separator1;
	private JSeparator Separator2;
	
	public viewDonationDetails(){
		//----------panels
		mainPanel=new JPanel();
		blackPanel=new JPanel() ;
		redPanel=new JPanel();
		orangePanel=new JPanel() ;
		grayPanel1=new JPanel();
		grayPanel2=new JPanel();
		redtitlePanel=new JPanel();
		titlePanel=new JPanel();
		greenPanel=new JPanel();
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
		bloodgroupLabel=new JLabel();
		rhfactorLabel=new JLabel();
		donornameLabel=new JLabel();

		//----------textfields
		bloodgroupText =new JTextField();
		rhfactorText=new JTextField();
		donornameText=new JTextField();
		
		//----------buttons
		cancelButton=new JButton();
		
		//----------separators
		Separator1=new JSeparator ();
		Separator2=new JSeparator();


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
		
		greenPanel.setBackground(new Color(180,180,158));
		greenPanel.setPreferredSize(new Dimension(730, 60));
		
		

		//-----------set main title	
		bloodbankLabel.setBackground(new Color(255, 255, 255));
        bloodbankLabel.setFont(new Font("Segoe UI", 1, 18)); 
        bloodbankLabel.setText("BLOOD BANK");
        
        //-----------set name of the application
        titleLabel.setFont(new Font("Segoe UI", 1, 14));
        titleLabel.setForeground(new Color(153, 153, 153));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setText("View Donations ");
        
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
        
        //----------set labels and textfields		
        bloodgroupLabel.setFont(new Font("Arial", 1, 12)); 
        bloodgroupLabel.setText("Donor Blood Group :");
        
        rhfactorLabel.setFont(new Font("Arial", 1, 12)); 
        rhfactorLabel.setText("RH Factor :");
        
        donornameLabel.setFont(new Font("Arial", 1, 12)); 
        donornameLabel.setText("Donor Name :");
        
        bloodgroupText.setEditable(false);
		bloodgroupText.setFont(new Font("Arial", 0, 12));
		
		rhfactorText.setEditable(false);
		rhfactorText.setFont(new Font("Arial", 0, 12));
		
		donornameText.setEditable(false);
		donornameText.setFont(new Font("Arial", 0, 12));

        
        //-----------buttons
       
		cancelButton.setBackground(new Color(204,204,204));
        cancelButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); 
        cancelButton.setText("Cancel");
        cancelButton.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        
        //Separators
		Separator1.setForeground(new Color(0,0,0));
		Separator2.setForeground(new Color(0,0,0));

        
        //----------Table
        DefaultTableModel model=new DefaultTableModel(columnNames,10);
        donationsTable=new JTable(model);
        JScrollPane tablepane=new JScrollPane(donationsTable);
        tablepane.setPreferredSize(new Dimension(460, 450));
        donationsTable.setRowHeight(30);

        
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
		
		//greenPanelLayout
		
		GroupLayout greenPanelLayout=new GroupLayout(greenPanel);
		greenPanel.setLayout(greenPanelLayout);
		greenPanelLayout.setHorizontalGroup(
			greenPanelLayout.createParallelGroup()
			.addGroup(greenPanelLayout.createSequentialGroup()
				.addGap(20,20,20)
				.addComponent(donornameLabel,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
				.addGap(4,4,4)
				.addComponent(donornameText,GroupLayout.PREFERRED_SIZE,200,GroupLayout.PREFERRED_SIZE)
				.addGap(20,20,20)
				.addComponent(bloodgroupLabel,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
				.addGap(4,4,4)	
				.addComponent(bloodgroupText,GroupLayout.PREFERRED_SIZE,70,GroupLayout.PREFERRED_SIZE)
				.addGap(20,20,20)
				.addComponent(rhfactorLabel,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
				.addGap(4,4,4)
				.addComponent(rhfactorText,GroupLayout.PREFERRED_SIZE,100,GroupLayout.PREFERRED_SIZE)
			)
		);
		greenPanelLayout.setVerticalGroup(
			greenPanelLayout.createParallelGroup()
			.addGroup(greenPanelLayout.createSequentialGroup()
				.addGap(12,12,12)
				.addGroup(greenPanelLayout.createParallelGroup()
					.addComponent(donornameLabel,GroupLayout.PREFERRED_SIZE,30,GroupLayout.PREFERRED_SIZE)
					.addComponent(donornameText,GroupLayout.PREFERRED_SIZE,30,GroupLayout.PREFERRED_SIZE)
					.addComponent(bloodgroupLabel,GroupLayout.PREFERRED_SIZE,30,GroupLayout.PREFERRED_SIZE)
					.addComponent(bloodgroupText,GroupLayout.PREFERRED_SIZE,30,GroupLayout.PREFERRED_SIZE)
					.addComponent(rhfactorLabel,GroupLayout.PREFERRED_SIZE,30,GroupLayout.PREFERRED_SIZE)
					.addComponent(rhfactorText,GroupLayout.PREFERRED_SIZE,30,GroupLayout.PREFERRED_SIZE)
				)
			)
		);

		
		
		//addMouseListeners for labels
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
                            .addComponent(greenPanel, GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(Separator1, GroupLayout.PREFERRED_SIZE, 730, GroupLayout.PREFERRED_SIZE)      
                        )
                    )
                    
					.addGroup(mainPanelLayout.createSequentialGroup()
						.addGap(15,15,15)
                        .addComponent(tablepane,GroupLayout.PREFERRED_SIZE, 710,GroupLayout.PREFERRED_SIZE)
                        
                    )
                    .addGroup(mainPanelLayout.createSequentialGroup()
						.addGap(10,10,10)
						.addComponent(Separator2,GroupLayout.PREFERRED_SIZE,730,GroupLayout.PREFERRED_SIZE)
                    )    
                    .addGroup(mainPanelLayout.createSequentialGroup()			
						.addGap(530,530,530)
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
						.addComponent(greenPanel,GroupLayout.PREFERRED_SIZE,GroupLayout.PREFERRED_SIZE,GroupLayout.PREFERRED_SIZE)
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
						.addComponent(tablepane,GroupLayout.PREFERRED_SIZE,320,GroupLayout.PREFERRED_SIZE)
						.addGap(20,20,20)
						.addComponent(Separator2,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
						.addGap(30,30,30)
						.addComponent(cancelButton,GroupLayout.PREFERRED_SIZE,30,GroupLayout.PREFERRED_SIZE)						
					)				
				)
				.addGap(35,35,35)
			)
		);
		
		final viewDonationDetails vd;
		vd=this;
		
		//addMouseListeners
		newdonorLabel.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				new addDonorUi1().setVisible(true);
				//vd.dispose();
			}
		});
		addbloodsampleLabel.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				new addBloodSample().setVisible(true);		
				//vd.dispose();		
			}
		});
	
		viewbloodsampleLabel.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				new viewBloodsamples().setVisible(true);
				//vd.dispose();
			}
		});
		issueLabel.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				new selectBloodSample().setVisible(true);
				//vd.dispose();
			}
		});
		issuedlistLabel.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				new viewIssuedList().setVisible(true);
				//vd.dispose();
			}
		});
		searchdonorsLabel.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				new viewDonors().setVisible(true);
				//vd.dispose();
			}
		});

        //addActionListeners for buttons
		
		cancelButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				vd.dispose();
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
	
	
	private String[] columnNames={
		"Blood Bag", "Donation date", "Donation Type","Volume","Body temp", "Pulse rate", "Blood pressure", "Body weight"
	};
	
	
	public static void main(String args[]){
		new viewDonationDetails().setVisible(true);
	}
	

}

