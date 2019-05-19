package Application;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		System.out.println("Enter the number of elements in the array");
		try {
			Scanner scanner = new Scanner(System.in);
			int numberOfElements = scanner.nextInt();
			int[] array = new int[numberOfElements];
			for(int index = 0; index < numberOfElements; index++) {
				System.out.println("Element "+(index+1)+":");
				array[index] = scanner.nextInt();
			}
			PrintMajorityElement(array);
		}catch(Exception exception) {
			System.out.println("Thrown exception is "+exception.getMessage());
		}
		
	}
	
	private static void PrintMajorityElement(int[] array) {
		HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
		for(int index = 0; index < array.length; index++) {
			if(hashMap.containsKey(array[index])) {
				int frequencyOfAppearing = hashMap.get(array[index]) + 1;
				if(frequencyOfAppearing > array.length/2) {					
					System.out.println("The majority element is "+array[index]);
					return;
				}else {
					hashMap.put(array[index], frequencyOfAppearing);
				}
			}else {
				hashMap.put(array[index],1);
			}
		}
		System.out.println("There is no majority element!");
	}
}
