package com.hopital.utility;

public class Hour {
	String heure;
	int hour;
	public static int getHour(String heure) {
		String h=heure.substring(0, heure.indexOf("h"));
		int hour=Integer.parseInt(h);
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public static int getMinute(String heure) {
		String m=heure.substring(heure.indexOf("h")+1,heure.indexOf("m"));
		int min=Integer.parseInt(m);
		return min;
	}
	public void setMinute(int minute) {
		this.minute = minute;
	}
	int minute;
	
}
