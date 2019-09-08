package entite;

import java.sql.Date;
import java.time.LocalDate;

@SuppressWarnings("serial")
public class Dates extends Date{

	@SuppressWarnings("deprecation")
	public Dates(int arg0, int arg1, int arg2) {
		super(arg0, arg1, arg2);
	}
	@SuppressWarnings("deprecation")
	public Dates() {
		super(1,1,1900);
	}
	@SuppressWarnings("deprecation")
	public void setDateMonthYear(int date,int month,int year) {
		this.setDate(date);
		this.setMonth(month);
		this.setYear(year);
	}
	@SuppressWarnings("deprecation")
	public String getDates() {
		String jour=""+this.getDate();
		String mois=""+this.getMonth();
		if(jour.length()==1) {
			jour="0"+jour;
		}
		if(mois.length()==1) {
			mois="0"+mois;
		}
		return jour+"-"+mois+"-"+this.getYear();
	}
	@SuppressWarnings("unused")
	public void setDates(String longDate) {
		String date="";
		int count=longDate.length();
		String []slash=longDate.split("/");
		if(slash[0].length()==count) {
			String []tirer=longDate.split("-");
			String []l=tirer[2].split(" ");
			if(tirer[0].length()<=2) {
				setDateMonthYear(Integer.parseInt(tirer[0]),Integer.parseInt(tirer[1]),Integer.parseInt(l[0]));
			}else {
				setDateMonthYear(Integer.parseInt(l[0]),Integer.parseInt(tirer[1]),Integer.parseInt(tirer[0]));
			}
		}else {
			String []l=slash[2].split(" ");
			if(slash[0].length()<=2) {
				setDateMonthYear(Integer.parseInt(slash[0]),Integer.parseInt(slash[1]),Integer.parseInt(l[0]));
			}else {
				setDateMonthYear(Integer.parseInt(l[0]),Integer.parseInt(slash[1]),Integer.parseInt(slash[0]));
			}

		}
	}
	@SuppressWarnings({ "static-access", "deprecation" })
	public String getNow() {
		Dates dates=new Dates();
		LocalDate lo=dates.toLocalDate();
		dates.setDates(lo.now().toString());
		this.setDate(dates.getDate());this.setMonth(dates.getMonth());this.setYear(dates.getYear());
		return this.getDate()+"-"+(this.getMonth())+"-"+this.getYear();
	}
	@SuppressWarnings({ "static-access", "deprecation" })
	public void getNowDate() {
		Dates dates=new Dates();
		LocalDate lo=dates.toLocalDate();
		dates.setDates(lo.now().toString());
		this.setDate(dates.getDate());this.setMonth(dates.getMonth());this.setYear(dates.getYear());
	}
}
