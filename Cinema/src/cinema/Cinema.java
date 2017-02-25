package cinema;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Cinema{
	private Scanner sc=new Scanner(System.in);
	private TreeMap <Day,Shedule> cinema;
	private Set <String> movies;
	private Time open;
	private Time close;
	public Cinema( Time open, Time close) {
		this.cinema = new TreeMap<Day,Shedule>();
		for(Day day:Day.values()){
			cinema.put(day, new Shedule(open,close));
		}
		this.open = open;
		this.close = close;
	}
	
	public void addMovie(){
		System.out.print("�������� ����� ������: ");
		String title = sc.next();
		System.out.print("�������� ��������� ������ � ��������: ");
		Time duration = new Time(sc.nextInt());
		int i=0;
		while(i<2){
			Movie movie = new Movie(title, duration);
			cinema.get(ChoseDay.choseDay()).addSeanse(movie,duration);
			System.out.println("������ �������� �� ���� ����� � ��� �������?\n1)���.\n2)ͳ.");
			i = sc.nextInt();	
		}
	}
	
	public void removeMovie(){
		System.out.print("�������� ����� ������ ����� ������ ��������: ");
		String title = sc.next();
		cinema.forEach((k,v)-> {
			Set <Seanse> list=new TreeSet<Seanse>();
			v.getSeanses().forEach((e)->{
				if(!e.getMovie().getTitle().equals(title)){
					list.add(e);
				}
			});
			v.getSeanses().clear();
			v.getSeanses().addAll(list);
		});
	}
	
	public void addSeanse(){
		System.out.print("�������� ����� ������: ");
		String title = sc.next();
		System.out.println("�������� ��������� ������ � ��������: ");
		Time duration = new Time(sc.nextInt());
		Movie movie = new Movie(title, duration);
		cinema.get(ChoseDay.choseDay()).addSeanse(movie,duration);
	}
	
	public void removeSeanse(){
		cinema.get(ChoseDay.choseDay()).removeSeanse();
	}
	
	public void showWeek(){
		cinema.forEach((k,v)-> v.showShedule(k));
	}
	
	public void showDay(){
		Day day=ChoseDay.choseDay();
		cinema.get(day).showShedule(day);
	}
	
}
