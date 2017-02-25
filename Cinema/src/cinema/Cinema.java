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
		System.out.print("Напишіть назву фільма: ");
		String title = sc.next();
		System.out.print("Напишіть тривалість фільма в хвилинах: ");
		Time duration = new Time(sc.nextInt());
		int i=0;
		while(i<2){
			Movie movie = new Movie(title, duration);
			cinema.get(ChoseDay.choseDay()).addSeanse(movie,duration);
			System.out.println("Хочете добавити ще один сеанс з цим фільмом?\n1)Так.\n2)Ні.");
			i = sc.nextInt();	
		}
	}
	
	public void removeMovie(){
		System.out.print("Напишіть назву фільма якого хочете видалити: ");
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
		System.out.print("Напишіть назву фільма: ");
		String title = sc.next();
		System.out.println("Напишіть тривалість фільма в хвилинах: ");
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
