package com.hopital.utility;
import java.sql.Date;
public class DateUtil {
public static Date getDate(String date){
	String[] v;
	int year=0000;
	int month=00;
	int day=00;
	v=date.split("/");
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
	}
Date date1=new Date(year, month, day);
	return date1;
	
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
}
