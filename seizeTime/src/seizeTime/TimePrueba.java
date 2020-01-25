package seizeTime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TimePrueba {
	
	public static LocalDateTime locaDate = LocalDateTime.now();
	public static int seconds = locaDate.getSecond();
	public static int minutes = locaDate.getMinute();
	public static int hours = locaDate.getHour();
	public static String secondString = "";
	public static String minuteString = "";
	public static String hourString = "";
	
	
	
	public static void main(String[] args) {
		
		Runnable runnable = new Runnable() {
		      public void run() {
		        // task to run goes here
		    	  seconds++;
		    	  if(seconds<10) {
		    		  secondString = "0"+seconds;
		    	  }else {
		    		  secondString = Integer.toString(seconds);
		    	  }
		    	  if (seconds>58) {
		    		  seconds = 0;
		    		  minutes++;
		    	  }
		    	  
		    	  if(minutes<10) {
		    		  minuteString = "0"+minutes;
		    	  }else {
		    		  minuteString = Integer.toString(minutes);
		    	  }
		    	  
		    	  if(minutes>58) {
		    		  minutes=0;
		    		  hours++;
		    	  }
		    	  
		    	  if(hours<10) {
		    		  hourString = "0"+hours;
		    	  }else {
		    		  hourString = Integer.toString(hours);
		    	  }
		    	  if (hours>23) {
		    		  hours = 0;
		    	  }
		    	  
		    	  System.out.println(hourString+":"+minuteString+":"+secondString);
		    	  
		      }
		    };
		    
		    ScheduledExecutorService service = Executors
		                    .newSingleThreadScheduledExecutor();
		    service.scheduleAtFixedRate(runnable, 0, 1, TimeUnit.SECONDS);
	}

}
