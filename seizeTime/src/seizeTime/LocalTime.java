package seizeTime;


import java.time.LocalDateTime;


public class LocalTime {
	
	LocalDateTime locaDate = LocalDateTime.now();
	
	public int hours = 0;
	public int minutes = 0;
	public int seconds = 0;
	public String secondString = "";
	public String minuteString = "";
	public String hourString = "";
	
	public LocalTime(int timeZone) {
		this.hours = locaDate.getHour() + timeZone;
		this.minutes = locaDate.getMinute();
		this.seconds = locaDate.getSecond()+1;
	}
	
	public String showCompleteTime() {
		
	  if(seconds<10) {
		  secondString = "0"+seconds;
	  }else {
		  secondString = Integer.toString(seconds);
	  }
	    	  
	  if(minutes<10) {
		  minuteString = "0"+minutes;
	  }else {
		  minuteString = Integer.toString(minutes);
	  }
	  
	  if(hours<10) {
		  hourString = "0"+hours;
	  }else {
		  hourString = Integer.toString(hours);
	  }
	  
	  seconds++;
	  
	  if (seconds>59) {
		  seconds = 0;
		  minutes++;
	  }
	  
	  if(minutes>59) {
		  minutes=0;
		  hours++;
	  }
	  
	  if (hours>24) {
		  hours = 0;
	  }
	  
	  return (hourString+":"+minuteString+":"+secondString);
	}	
	
	
}
