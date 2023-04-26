package entities;

import java.time.LocalDate;

public class People {
	
	private String name; 
	private LocalDate birthDate;
	
	
	public People(String name, LocalDate birthDate) {
		super();
		this.name = name;
		this.birthDate = birthDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	} 
	
	
	
	
}
