package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Funcionarios;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Funcionarios> lista = new ArrayList<> ();
		
		System.out.println("Quantos funcionários serão registrados: ");
		int qtdFuncionario = sc.nextInt();
		
		for (int i = 1; i <= qtdFuncionario; i++) {
			System.out.println();
			System.out.println("Funcionario #" + i + ": ");
			System.out.print("Id: ");
			Integer id = sc.nextInt();
			sc.nextLine();
			System.out.print("Nome: ");
			String nome = sc.nextLine();
			System.out.print("Salario: ");
			Double salario = sc.nextDouble();
			
			Funcionarios obj = new Funcionarios (id, nome, salario);
			lista.add(obj);
		}
		
		System.out.println();
		System.out.print("Digite o ID do funcionario que irá receber o aumento: ");
		int idFunc = sc.nextInt();
		
		Funcionarios obj = lista.stream().filter(x -> x.getId() == idFunc).findFirst().orElse(null);
		if (obj == null) {
			System.out.println("Esse ID não existe!");
		} else {
			System.out.println("Digite a porcentagem do aumento do funcionario: ");
			double bonus = sc.nextDouble();
			obj.aumento(bonus);
		}
		
		
		System.out.println();
		System.out.println("Lista de Funcionarios: ");
		for (Funcionarios func : lista) {
			System.out.println(func);
		}
		
		sc.close();
	}

}
