package cinema;

import java.util.Scanner;

public class Menu {
	Scanner sc =new Scanner(System.in);
	private Cinema cinema;

	public Menu(Cinema cinema) {
		super();
		this.cinema = cinema;
	}
	
	public void menu(){
		other:while(true){
			System.out.println("\n-------------------------------\n"
					+ "1)Добавити фільм.\n2)Добавити сеанс з фільмом.\n3)Видалити фільм.\n4)Видалити сеанс.\n"
					+ "5)Показати тижневий графік.\n6)Показати графік дня.\n"
					+ "-------------------------------\n");
			int c=sc.nextInt();
			switch(c){
			case 1:cinema.addMovie();
			break;
			case 2:cinema.addSeanse();;
			break;
			case 3:cinema.removeMovie();
			break;
			case 4:cinema.removeSeanse();
			break;
			case 5:cinema.showWeek();
			break;
			case 6:cinema.showDay();
			break;
			default:break other;
			}
		}
	}
}
