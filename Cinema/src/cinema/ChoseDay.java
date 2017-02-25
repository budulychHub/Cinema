package cinema;

import java.util.Scanner;

public class ChoseDay {
	
	static public Day choseDay(){
		System.out.println("Який день?\n1)Понеділок.\n2)Вівторок.\n3)Середа.\n4)Четвер.\n5)П'ятниця.\n6)Суббота.\n7)Неділя.");
		Scanner sc = new Scanner(System.in);
		int day = sc.nextInt();
		Day d = Day.Friday;
		switch(day){
		case 1:d=Day.Monday;break;
		case 2:d=Day.Tuesday;break;
		case 3:d=Day.Wednesday;break;
		case 4:d=Day.Thursday;break;
		case 5:d=Day.Friday;break;
		case 6:d=Day.Saturday;break;
		case 7:d=Day.Sunday;break;
		}
		return d;
	}
}
