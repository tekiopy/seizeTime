package seizeTime;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JLabel;

import java.util.ArrayList;
import java.util.Iterator;

import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.SwingConstants;
import java.awt.Font;

import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class SeizeTimeFrame {

	private JFrame frame;
	public static int horas = 0;
	public static int timeZone = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeizeTimeFrame window = new SeizeTimeFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SeizeTimeFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panelClock = new JPanel();
		tabbedPane.addTab("Clock", null, panelClock, null);
		panelClock.setLayout(null);
		
		JLabel panelClockLocalTime = new JLabel();
		panelClock.add(panelClockLocalTime);
		panelClockLocalTime.setHorizontalTextPosition(SwingConstants.CENTER);
		panelClockLocalTime.setHorizontalAlignment(SwingConstants.CENTER);
		panelClockLocalTime.setFont(new Font("Dialog", Font.BOLD, 60));
		panelClockLocalTime.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.LIGHT_GRAY, Color.LIGHT_GRAY));
		panelClockLocalTime.setBounds(12, 12, 415, 130);
		
		JLabel panelClockSecondTimeZone = new JLabel("add new time zone");
		panelClockSecondTimeZone.setHorizontalAlignment(SwingConstants.CENTER);
		panelClockSecondTimeZone.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.LIGHT_GRAY, Color.LIGHT_GRAY));
		panelClockSecondTimeZone.setBounds(234, 171, 193, 40);
		panelClock.add(panelClockSecondTimeZone);
		
		JLabel panelClockFirstTimeZone = new JLabel("add new time zone");
		panelClockFirstTimeZone.setHorizontalAlignment(SwingConstants.CENTER);
		panelClockFirstTimeZone.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.LIGHT_GRAY, Color.LIGHT_GRAY));
		panelClockFirstTimeZone.setBounds(12, 171, 193, 40);
		panelClock.add(panelClockFirstTimeZone);
		
		
		SeizeTimeData timeData = new SeizeTimeData();
		
		JComboBox<String> panelClockListFirstCountry = new JComboBox<String>();
		
		panelClockListFirstCountry.setName("");
		panelClockListFirstCountry.setToolTipText("select a country to show time");
		panelClockListFirstCountry.setFont(new Font("Dialog", Font.BOLD, 10));
		addComboBoxCountry(panelClockListFirstCountry, timeData);
		panelClockListFirstCountry.setBounds(12, 152, 193, 17);
		panelClock.add(panelClockListFirstCountry);
		
		JComboBox<String> panelClockListSecondCountry = new JComboBox<String>();
		panelClockListSecondCountry.setToolTipText("select a country to show time");
		panelClockListSecondCountry.setFont(new Font("Dialog", Font.BOLD, 10));
		addComboBoxCountry(panelClockListSecondCountry, timeData);
		panelClockListSecondCountry.setBounds(234, 152, 193, 17);
		panelClock.add(panelClockListSecondCountry);
		
		
		panelClockListFirstCountry.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
				LocalTime timeZone1 = new LocalTime(SeizeTimeData.getTreeMap().get(panelClockListFirstCountry.getSelectedItem()));
				Runnable runnable1 = new Runnable() {
				      public void run() {
				        // task to run goes here
				    	  panelClockFirstTimeZone.setText(timeZone1.showCompleteTime());
				      }
				    };
				    
				    ScheduledExecutorService service1 = Executors
				                    .newSingleThreadScheduledExecutor();
				    service1.scheduleAtFixedRate(runnable1, 0, 1, TimeUnit.SECONDS);
			}
		});
		
		LocalTime localTime = new LocalTime(0);
		Runnable runnable = new Runnable() {
		      public void run() {
		        // task to run goes here
		    	  panelClockLocalTime.setText(localTime.showCompleteTime());
		      }
		    };
		    ScheduledExecutorService service = Executors
		                    .newSingleThreadScheduledExecutor();
		    service.scheduleAtFixedRate(runnable, 0, 1, TimeUnit.SECONDS);
		  
		
		
		
		
		JPanel panelAlarm = new JPanel();
		tabbedPane.addTab("Alarm", null, panelAlarm, null);
		
		JPanel panelChronometre = new JPanel();
		tabbedPane.addTab("Chronometre", null, panelChronometre, null);
		
		JPanel panelTimer = new JPanel();
		tabbedPane.addTab("Timer", null, panelTimer, null);
		
		JPanel panelAbout = new JPanel();
		tabbedPane.addTab("About", null, panelAbout, null);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu menuFile = new JMenu("File");
		menuBar.add(menuFile);
		
		JMenuItem menuFileLoadProfile = new JMenuItem("Load profile");
		menuFile.add(menuFileLoadProfile);
		
		JMenuItem menuFileSaveProfile = new JMenuItem("Save profile");
		menuFile.add(menuFileSaveProfile);
		
		JMenuItem menuFileSaveProfileAs = new JMenuItem("Save profile as...");
		menuFile.add(menuFileSaveProfileAs);
		
		JMenuItem menuFileExit = new JMenuItem("Exit");
		menuFile.add(menuFileExit);
		
		JMenu menuClock = new JMenu("Clock");
		menuBar.add(menuClock);
		
		JMenuItem menuClockSetTime = new JMenuItem("Set time");
		menuClock.add(menuClockSetTime);
		
		JMenu menuClockMode = new JMenu("Clock mode");
		menuClock.add(menuClockMode);
		
		JRadioButtonMenuItem menuClockModeDigitalRadioButton = new JRadioButtonMenuItem("Digital");
		menuClockModeDigitalRadioButton.setSelected(true);
		menuClockMode.add(menuClockModeDigitalRadioButton);
		
		JRadioButtonMenuItem menuClockModeAnalogRadioButton = new JRadioButtonMenuItem("Analog");
		menuClockMode.add(menuClockModeAnalogRadioButton);
		
		JMenuBar menuBar_1 = new JMenuBar();
		menuClock.add(menuBar_1);
	}
	
	
	public void createCountryDictionary(ArrayList<String> countries) {
		
	}
	
	public void addComboBoxCountry(JComboBox<String> comboBox, SeizeTimeData timeData) {
		Set<String> keys = SeizeTimeData.getTreeMap().keySet();
		String countryString = "";
	    //Obtaining iterator over set entries
	    Iterator<String> itr = keys.iterator();
	 
	    //Displaying Key and value pairs
	    while (itr.hasNext()) { 
	       // Getting Key
	    	countryString = itr.next();
	    	
	       comboBox.addItem(countryString);
	    } 
		
	}
}
