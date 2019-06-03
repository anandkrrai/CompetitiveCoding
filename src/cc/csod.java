package cc;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class csod {

	public static String fixTime(String start) {
		start = start.substring(0, 10) + "T" + start.substring(11);
		return start;
	}
	
	public static boolean isRaining(String rainStart ,String tripStart , String tripStop) {
		LocalDateTime rStart = LocalDateTime.parse(fixTime(rainStart));
		LocalDateTime tStart = LocalDateTime.parse(fixTime(rainStart));
		LocalDateTime tStop = LocalDateTime.parse(fixTime(rainStart));
		LocalDateTime rStop = rStart.plusHours(3);
		
		if(rStart.compareTo(tStart)<=0 && rStop.compareTo(tStart)>=0) {
			return true;
		}
		
		if(rStart.compareTo(tStop)<=0 && rStop.compareTo(tStop)>=0) {
			return true;
		}
		
		return false;
		
	}

//12.9762,77.6033,,
//2019-06-01 12:00:00
//2019-06-02 09:00:00
//2019-06-02 12:00:00
//2019-06-02 15:00:00
//2019-06-02 18:00:00
//2019-06-03 09:00:00
//2019-06-03 12:00:00
//2019-06-03 15:00:00
//2019-06-03 18:00:00
//2019-06-03 21:00:00
//2019-06-04 00:00:00
//2019-06-04 09:00:00
//2019-06-04 12:00:00
//2019-06-04 21:00:00
//2019-06-05 00:00:00
//2019-06-05 18:00:00


	public static boolean isRaining(String rainStart ,LocalDateTime tStart , LocalDateTime tStop) {
	    LocalDateTime rStart = LocalDateTime.parse(fixTime(rainStart));
	    LocalDateTime rStop = rStart.plusHours(3);

	    if(rStart.compareTo(tStart)<=0 && rStop.compareTo(tStart)>=0) {
	      return true;
	    }

	    if(rStart.compareTo(tStop)<=0 && rStop.compareTo(tStop)>=0) {
	      return true;
	    }

	    return false;

	  }
	

	public static void main(String[] args) {
		String str = "01/06/2019 00:00";
		str=str.replace('/', '-');
		System.out.println(str);
	    DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
  	  LocalDateTime tripStartsAt1 = LocalDateTime.parse(str, dateTimeFormatter1);
  	  System.out.println(tripStartsAt1);


		String start = "2019-06-23 08:15" + ":00", stop = "2019-05-24 09:15" + ":00";
	    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

		  LocalDateTime tripStartsAt = LocalDateTime.parse("2019-05-23 08:15", dateTimeFormatter);
		    LocalDateTime tripEndsAt = LocalDateTime.parse("2019-05-24 09:15", dateTimeFormatter);
		    
		    System.out.println(isRaining(start, tripStartsAt, tripEndsAt));

//		System.out.println(start);
//		start = fixTime(start);
//		System.out.println(start);
//		
//		LocalDateTime fromDateAndTime = LocalDateTime.parse(start);
//		System.out.println(fromDateAndTime);
//		fromDateAndTime = fromDateAndTime.plusHours(3);
//		System.out.println(fromDateAndTime);
		
//		fromDateAndTime.co
	}

}
