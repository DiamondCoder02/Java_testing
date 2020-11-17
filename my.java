import java.util.Scanner;

public class my{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Number one?");
		Integer elsoertek = scanner.nextInt();
		
		System.out.println("Number two?");
		Integer masodikertek = scanner.nextInt();
		
		Integer eredmeny = elsoertek + masodikertek;
		
		System.out.println("Eredmény: \n" + eredmeny);
	}
}