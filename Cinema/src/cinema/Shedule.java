package cinema;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import org.omg.Messaging.SyncScopeHelper;


public class Shedule {
	Scanner sc=new Scanner(System.in);
	private boolean avoid;
	private Time open;
	private Time close;
	private Set <Seanse> seanses;
	public Shedule(Time open, Time close) {
		seanses=new TreeSet<Seanse>();
		this.open=open;
		this.close=close;
	}
	
	public Set<Seanse> getSeanses() {
		return seanses;
	}

	public void setSeanses(Set<Seanse> seanses) {
		this.seanses = seanses;
	}

	public void addSeanse(Movie movie,Time duration){
		avoid = false;
		showShedule();
		System.out.println("\n���� ��������� �����? ��� ������?");
		int hours = sc.nextInt();
		System.out.println("\n������ ������?");
		int min = sc.nextInt();
		Seanse seanse = new Seanse(movie,new Time((hours*60)+min));
		if(!seanse.getStartTime().audit(open)){
			System.out.println("\n������� �������� �������� � "+open);
			avoid = true;
		}
		if(seanse.getEndTime().auditForEnd(close)){
			System.out.println("\n������� ��� ������� � "+close);
			avoid = true;
		}else{
		seanses.forEach(e-> {
			if(seanse.getStartTime().audit(e.getStartTime())&&e.getEndTime().audit(seanse.getStartTime())||
			seanse.getEndTime().audit(e.getStartTime())&&e.getEndTime().audit(seanse.getEndTime())||
			seanse.getEndTime().audit(e.getEndTime())&&e.getStartTime().audit(seanse.getStartTime())){
				System.out.println("\n������� ���� ������ ������ � ��� ���.");
				avoid=true;
			}
		});
		}
		if(!avoid){
			seanses.add(seanse);
			avoid=false;
		}
	}
	
	public void removeSeanse(){
		int i=seanses.size();
		for (Seanse seanse : seanses) {
			System.out.println((i--)+")"+seanse);
		}
		System.out.println("\n�� ������ �� ������� ��������?");
		int c = sc.nextInt();
		i=seanses.size();
		Seanse seanse = null;
		for (Seanse s1 : seanses) {
			if(i-- == c){
				seanse=s1;
			}
		}
		if(seanse==null){
			System.out.println("��� ����� �� ����!!!");
		}else{
			seanses.remove(seanse);
		}
		
	}
	
	public void showShedule() {
		System.out.println("-------------------------\n³������ �: "+open+" �����. [0-24]");
		seanses.forEach(System.out::println);
		System.out.println("���� ������� �: "+close +" ����. [0-24]\n-------------------------");
	}
	
	public void showShedule(Day y) {
		System.out.println("-------------------------\n"+y.name()+":\n³������ �: "+open+" �����. [0-24]");
		seanses.forEach(System.out::println);
		System.out.println("���� ������� �: "+close +" ����. [0-24]\n-------------------------");
	}

	@Override
	public String toString() {
		return "�������:  [³������: " + open + ", �������: " + close + ", ������: " + seanses.size()+ "]";
	}
	
	
}
