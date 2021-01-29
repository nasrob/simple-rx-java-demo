package rx.demo;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

public class RxJavaIterableDemo {

	public static void main(String[] args) {
		
		List<EmployeeRating> employeeRatingList = new ArrayList<EmployeeRating>();
		
		EmployeeRating employeeRating1 = new EmployeeRating();
		employeeRating1.setName("Sara");
		employeeRating1.setRating(6);
		employeeRatingList.add(employeeRating1);
		
		EmployeeRating employeeRating2 = new EmployeeRating();
		employeeRating2.setName("John");
		employeeRating2.setRating(5);
		employeeRatingList.add(employeeRating2);
		
		EmployeeRating employeeRating3 = new EmployeeRating();
		employeeRating3.setName("Paula");
		employeeRating3.setRating(7);
		employeeRatingList.add(employeeRating3);
		
		EmployeeRating employeeRating4 = new EmployeeRating();
		employeeRating4.setName("Jako");
		employeeRating4.setRating(8);
		employeeRatingList.add(employeeRating4);
		
		Observable<EmployeeRating> employeeRatingSource = Observable.fromIterable(employeeRatingList);
		employeeRatingSource.filter(emplRating -> emplRating.getRating() >= 7)
							.subscribe(empRating -> System.out.println("Star Employee: " + empRating.getName()
							+ " Rating: " + empRating.getRating()));
	}
}

class EmployeeRating {
	
	private String name;
	private int rating;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	
	
	
}