package test1;

import java.util.ArrayList;
import java.util.Arrays;

class Developer{
    private String name;
    private int career;
    String[] levels={"초급","중급","고급"};
    int[] basicSalary = {2800,3500,4500};
    
    Developer(String name,int career){
        this.name=name;
        this.career=career;
    }
    public String level(){
        return levels[getIndex()];
    }
    public String salary(){
        return name+" : "
        		+(basicSalary[getIndex()]+(100*career))+"만원";
    }
    public int getSalary(){
        return basicSalary[getIndex()]+(100*career);
    }

    private int getIndex(){
        int result;
        if(career<3) {
        	result=0;
        }else if(career<7) {
        	result=1;
        }else {
        	result=2;
        }
        return result;
    }
}
class Corperation{
    private String name;
    private ArrayList<Developer> developers;

    Corperation(String name){
        this.name=name;
        developers = new ArrayList<>();
    }
    public void addDeveloper(Developer developer){
        developers.add(developer);
    }
    public void addDeveloper(ArrayList<Developer> developers){
        this.developers=developers;
    }
    public String salaryExpen(){
        int total=0;
        for(Developer dev: developers){
            total += dev.getSalary();
        }
        return "총지급액 : "+total+"만원";
    }
}
public class Exam05 {
	public static void main(String[] args) {
        Developer tom = new Developer("Tom",5);
		Developer john = new Developer("John",8);
		System.out.println(tom.salary());
		System.out.println(john.salary());
//=======================================================
		Corperation corp = new Corperation("Google");
		Developer james = new Developer("James",1);
		Developer kate = new Developer("Kate",4);
		Developer paul = new Developer("Paul",10);
        corp.addDeveloper(james);
        corp.addDeveloper(kate);
        corp.addDeveloper(paul);
        corp.addDeveloper(tom);
        corp.addDeveloper(john);
//		ArrayList<Developer> developers = 
//				new ArrayList<>(
//						Arrays.asList(tom,john,james,kate,paul));
//        corp.addDeveloper(developers);
		System.out.println(corp.salaryExpen());
	}
}
