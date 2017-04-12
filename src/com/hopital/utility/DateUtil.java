package com.hopital.utility;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
public class DateUtil {
	public static Date getDate(String date){

		
		String[] v;
		int year=0000;
		int month=00;
		int day=00;
		if(!date.equals("")){
			
		if(date.contains("/")){
		v=date.split("/");
		}
		else{
		v=date.split("-");
		}
		for (int i = 0; i < v.length; i++) {
			String string = v[i];
			if(string.length()==4){
				year=Integer.parseInt(string)-1900;
			}
			else if(i==1){
				month=Integer.parseInt(string)-1;
			}
			else{
				day=Integer.parseInt(string);
			}
		}}
	Date date1=new Date(year, month, day);
		return date1;
	}

	public static String getDateS(String date){

		
		String[] v;
		String dates="";
		if(!date.equals("")){
			
		if(date.contains("/")){
		v=date.split("/");
		}
		else{
		v=date.split("-");
		}
		for (int i =v.length-1; i>= 0; i--) {
			
			 if(i==2){
				dates=dates+"20"+ v[i];
			}
			 else{
				 if(v[i].length()==1){
					 dates+="-0"+v[i];
				 }else{
					 dates+="-"+v[i];
				 }
			 }
			 
			
		}}
		return dates;
	}





public static Date getRDate(String date){
	String[] v;
	int year=0000;
	int month=00;
	int day=00;
	v=date.split("-");
	for (int i = 0; i < v.length; i++) {
		String string = v[i];
		if(string.length()==4){
			year=Integer.parseInt(string)+1900;
		}
		else if(i==1){
			month=Integer.parseInt(string)+1;
		}
		else{
			day=Integer.parseInt(string);
		}
	}
	Date date1=new Date(year, month, day);
	return date1;
}
public static boolean isValidDate(String inDate) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    dateFormat.setLenient(false);
    try {
      dateFormat.parse(inDate.trim());
    } catch (ParseException pe) {
      return false;
    }
    return true;
  }
}
