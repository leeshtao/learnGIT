package sortDuck;

import java.util.Arrays;

public class DuckSortTestDrive {

	public static void main(String[] args) {
		Duck[] ducks = {new Duck("Duck1", 8),
						new Duck("Duck2", 3),
						new Duck("Duck3", 5),
						new Duck("Duck4", 2),
						new Duck("Duck5", 6)};
		System.out.println("Before sorting:");
		display(ducks);
		
		Arrays.sort(ducks);
		System.out.println("\nAfter sorting:");
		display(ducks);
		
	}
	
	public static void display(Duck[] ducks){
		for(Duck d : ducks){
			System.out.println(d);
		}
	}
}
