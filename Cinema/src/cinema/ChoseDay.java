package cinema;

import java.util.Scanner;

public class ChoseDay {
	
	static public Day choseDay(){
		System.out.println("���� ����?\n1)��������.\n2)³������.\n3)������.\n4)������.\n5)�'������.\n6)�������.\n7)�����.");
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
