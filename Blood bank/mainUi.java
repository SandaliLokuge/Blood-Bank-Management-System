package client.ijse.rmi.bloodbank.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DateFormat;

public class mainUi extends JFrame{
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
	private JLabel bloodbankLabel;
	private JLabel dateLabel;
	private JLabel newdonorLabel;
	private JLabel timeLabel;
	private JLabel viewbloodsampleLabel;
	private JLabel searchdonorsLabel;
	private JLabel issuedlistLabel;
	private JLabel issueLabel;
	private JLabel imageLabel;

	
	//----------separators
	private JSeparator Separator1;
	private JSeparator Separator2;
	
	public mainUi(){
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
		bloodbankLabel=new JLabel();
		dateLabel=new JLabel();
		newdonorLabel=new JLabel();
		timeLabel=new JLabel();
		viewbloodsampleLabel=new JLabel();
		searchdonorsLabel=new JLabel();
		issuedlistLabel=new JLabel();
		issueLabel=new JLabel();
		imageLabel=new JLabel();
		
	
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
        
        //set image to the label
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        imageLabel.setIcon(new ImageIcon("images/bloodbankImage2.png"));
        
        //-----------set panelLayouts
		   
		 //grayPanel1Layout
		grayPanel1.setLayout(new FlowLayout(FlowLayout.RIGHT));	
		grayPanel1.add(redtitlePanel);
		grayPanel1.add(bloodbankLabel);

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
                .addComponent(grayPanel1, GroupLayout.DEFAULT_SIZE,400, Short.MAX_VALUE)
            )
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup()
                    .addComponent(grayPanel2,GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(orangePanel,GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(blackPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                )
				.addGap(20,20,20)
				.addComponent(imageLabel,GroupLayout.PREFERRED_SIZE, 370, GroupLayout.PREFERRED_SIZE)
				
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
						.addGap(6,6,6)
						.addComponent(grayPanel2,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
					)
					.addGroup(mainPanelLayout.createSequentialGroup()
						.addGap(10,10,10)
                        .addComponent(imageLabel, GroupLayout.PREFERRED_SIZE, 520,GroupLayout.PREFERRED_SIZE)
					)					
				)

				.addGap(35,35,35)
			)
		);
		
		final mainUi main;
		main=this;
		
		//addMouseListeners for labels
		newdonorLabel.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				new addDonorUi1().setVisible(true);
			}
			
		});
		addbloodsampleLabel.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				new addBloodSample().setVisible(true);
				
			}
		});
		
		viewbloodsampleLabel.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				new viewBloodsamples().setVisible(true);
			}	
		});
		issueLabel.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				new selectBloodSample().setVisible(true);
			}
		});
		issuedlistLabel.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				new viewIssuedList().setVisible(true);
			}
		});
		searchdonorsLabel.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				new viewDonors().setVisible(true);
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
		new mainUi().setVisible(true);
	}
	
}
