 # ![](https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRvyvnSVHE7fbUji89jf-7CbZkQnMUXoU2gS4bc3CQRqEI7lN_h2KYJF4dntrFfZuS95fc&usqp=CAU) 

## TESTE PRÁTICO PROGRAMAÇÃO PROJEDATA

### 1  - Classe Pessoa com os atributos: nome (String) e data nascimento (LocalDate).

### 2 – Classe Funcionário que estenda a classe Pessoa, com os atributos: salário (BigDecimal) e função (String).

### 3 – Deve conter uma classe Principal para executar as seguintes ações:
* 3.1 – Inserir todos os funcionários, na mesma ordem e informações da tabela acima.
```Java 
		List<Employee> list = new ArrayList<>(); 
		list.add(new Employee("Maria", LocalDate.parse("18/10/2000", fmt), 2009.44, "Operador"));
		list.add(new Employee("João", LocalDate.parse("12/05/1990", fmt), 2284.38, "Operador"));
		list.add(new Employee("Caio", LocalDate.parse("02/05/1961", fmt), 9836.14, "Coordenador"));
		list.add(new Employee("Miguel", LocalDate.parse("14/10/1988", fmt), 19116.88, "Diretor"));
		list.add(new Employee("Alice", LocalDate.parse("05/01/1995", fmt), 2234.68, "Recepcionista"));
		list.add(new Employee("Heitor", LocalDate.parse("19/11/1999", fmt), 1582.72, "Operador"));
		list.add(new Employee("Arthur", LocalDate.parse("31/03/1993", fmt), 4071.84, "Contador"));
		list.add(new Employee("Laura", LocalDate.parse("08/07/1994", fmt), 3017.45, "Gerente"));
		list.add(new Employee("Heloísa", LocalDate.parse("24/05/2003", fmt), 1606.85, "Eletrecista"));
		list.add(new Employee("Helena", LocalDate.parse("02/09/1996", fmt), 2799.93, "Gerente"));
 ```

* 3.2 – Remover o funcionário “João” da lista.
```Java
		for(int i = 0; i < list.size(); i++) {
			Employee emp = list.get(i);
			if(emp.getName().equals("João")) {
				list.remove(emp);
			}
		}
```

* 3.3 – Imprimir todos os funcionários com todas suas informações, sendo que:<br>
 • informação de data deve ser exibido no formato dd/mm/aaaa;<br>
 ```Java
 DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
 ```
• informação de valor numérico deve ser exibida no formatado com separador de milhar como ponto e decimal como vírgula. 
```Java
	Locale localeBr = new Locale("pt", "BR");
	NumberFormat currency = NumberFormat.getCurrencyInstance(localeBr);
 ```
 ```Java
 	@Override
	public String toString() {
		return getName() + 
				" " + fmt.format(getBirthDate()) + 
				" " + currency.format(salary) + 
				" " + function;
	}
  ```
  
  ```Java
  	System.out.println("Lista de Funcionários");
		for(Employee emp : list) {
			System.out.println(emp);
		}
 ```
 ![](https://github.com/diegoguedes91/projedata/blob/main/img/lista_de_funcionarios.JPG)

* 3.4 – Os funcionários receberam 10% de aumento de salário, atualizar a lista de funcionários com novo valor.
```Java
	public void increaseSalary(double percentage) {
		salary += salary * percentage / 100; 
	}
```
```Java
		System.out.println();
		for(Employee emp: list) {
			emp.increaseSalary(10);
		}
		System.out.println("Lista de Funcionários após o aumento de 10%");
		for(Employee emp : list) {
			System.out.println(emp);
		}
 ```
 ![](https://github.com/diegoguedes91/projedata/blob/main/img/lista_apos_aumento.JPG)
 
* 3.5 – Agrupar os funcionários por função em um MAP, sendo a chave a “função” e o valor a “lista de funcionários”.
```Java
		Map<String, List<Employee>> groupByFunction = new HashMap<String, List<Employee>>();
		for(Employee emp: list) {
			var function = emp.getFunction();
			var functionFound = groupByFunction.get(function);
			if(functionFound == null) {
				functionFound = new ArrayList<>();
				functionFound.add(emp); 
				groupByFunction.put(function, functionFound);
				continue; 
			}
			functionFound.add(emp);
		}
```
* 3.6 – Imprimir os funcionários, agrupados por função.
```Java
		System.out.println("Funcionários agrupados por função");
        for (List<Employee> key: groupByFunction.values()) {
            System.out.println(key);
        }
```
![](https://github.com/diegoguedes91/projedata/blob/main/img/por_funcao.JPG)
* 3.8 – Imprimir os funcionários que fazem aniversário no mês 10 e 12.
```Java
		System.out.println("Lista de Funcionários que fazem aniversário no mês 10 e 12");
		for(Employee emp : list) {
			if(emp.getBirthDate().getMonthValue() == 10 || emp.getBirthDate().getMonthValue() == 12)
			System.out.println(emp);
		}
```
![](https://github.com/diegoguedes91/projedata/blob/main/img/aniversario_10_12.JPG)
* 3.9 – Imprimir o funcionário com a maior idade, exibir os atributos: nome e idade.
```Java
		System.out.println("Funcionário com a maior idade");
		String nameMaxAge = ""; 
		int age = 0; 
		for(int i = 0; i < list.size(); i ++ ) {
			Employee emp = list.get(i);
			
			// Descobrindo a idade de cada membro da lista
			Period period = Period.between(emp.getBirthDate(), LocalDate.now());
			int cont = period.getYears(); 
			if(age < cont) {
				age = cont; 
				nameMaxAge = emp.getName();
			}
		}
		System.out.println("Nome: " + nameMaxAge + " Idade: " + age);
```
![](https://github.com/diegoguedes91/projedata/blob/main/img/maior_idade.JPG)
* 3.10 – Imprimir a lista de funcionários por ordem alfabética.
```Java
		System.out.println("Lista em ordem alfabetica");
		List<Employee> alphabeticalOrder = new ArrayList<>(list); 
		alphabeticalOrder.sort(Comparator.comparing(Employee::getName));
		for(Employee emp : alphabeticalOrder) {
			System.out.println(emp);
		}
```
![](https://github.com/diegoguedes91/projedata/blob/main/img/ordem_alfabetica.JPG)
* 3.11 – Imprimir o total dos salários dos funcionários.
```Java
		System.out.println();
		System.out.println("Total do salário dos Funcionários");
		double totalSalary = 0.0; 
		for(Employee emp : list) {
			totalSalary += emp.getSalary(); 
		}
		System.out.println("Valor total do salário dos funcionário: " + currency.format(totalSalary));
 ```
   ![](https://github.com/diegoguedes91/projedata/blob/main/img/total.JPG)

* 3.12 – Imprimir quantos salários mínimos ganha cada funcionário, considerando que o salário mínimo é R$1212.00.
```Java
	public double minimum_salary() {
		double minimum_salary = salary / 1212;
		return minimum_salary;
	}  
```
```Java
		for(Employee emp : list) {
			System.out.println(emp.getName() + " recebe " + (int)emp.minimum_salary() + " salário(s) mínimo");
		}
```
![](https://github.com/diegoguedes91/projedata/blob/main/img/salario_minimo.JPG)
