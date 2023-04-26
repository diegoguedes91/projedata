package entities;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Employee extends People {
	
	Locale localeBr = new Locale("pt", "BR");
	NumberFormat currency = NumberFormat.getCurrencyInstance(localeBr);
	
	DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private Double salary; 
	private String function;
	
	public Employee(String name, LocalDate birthDate, Double salary, String function) {
		super(name, birthDate);
		this.salary = salary;
		this.function = function;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	} 

	public void increaseSalary(double percentage) {
		salary += salary * percentage / 100; 
	}
	
	public double minimum_salary() {
		double minimum_salary = salary / 1212;
		return minimum_salary;
	}

	
	@Override
	public String toString() {
		return getName() + 
				" " + fmt.format(getBirthDate()) + 
				" " + currency.format(salary) + 
				" " + function;
	}
	
}
