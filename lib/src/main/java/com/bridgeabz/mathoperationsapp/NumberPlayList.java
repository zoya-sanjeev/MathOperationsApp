package com.bridgeabz.mathoperationsapp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;



public class NumberPlayList {
	
	public static void main(String args[]) {
		
		List<Integer> myNumberList = new ArrayList<>();
		for(int i=0; i<5; i++)
			myNumberList.add(i);
		
		//iterate using proper class
		class MyConsumer implements Consumer<Integer>{
			public void accept(Integer t) {
				System.out.println("Value using Consumer implementation: "+t);
			}
		}
		MyConsumer action = new MyConsumer();
		myNumberList.forEach(action);
		
		// iterate using anonymous class
		myNumberList.forEach(new Consumer<Integer>() {
			public void accept(Integer t) {
				System.out.println("foreach anonymous class value: "+ t);
			}
			
		});
		
		//Explicit lambda function
		Consumer<Integer> myListAction = n ->{
			System.out.println("foreach lambda implementation value: "+ n);
		};
		myNumberList.forEach(myListAction);
		
		//Implicit lambda function
		myNumberList.forEach(n -> { 
			System.out.println("foreach lambda implementation value: "+ n);
		});
		
		Function<Integer, Double> toDoubleFunction = Integer::doubleValue;
		myNumberList.forEach(n -> System.out.println("foreach lambda to double value " + toDoubleFunction.apply(n)));
		
		Predicate<Integer> isEvenFunction = n -> n > 0 && n % 2 == 0;
		myNumberList.forEach(n -> System.out.println("value of "+ n +" check for even :"+ isEvenFunction.test(n)));
		
		//creating a stream
		
		myNumberList.stream().forEach(n -> {
			System.out.println("MyNumberList forEach value"+ n);
		});
		
		//transform to a double list and store result
		
		List<Double> doubleList=myNumberList.stream()
								.filter(isEvenFunction)
								.map(toDoubleFunction)
								.collect(Collectors.toList());
		System.out.println(doubleList);
		
		//first even number
		
		Integer firstEven = myNumberList.stream()
							.filter(isEvenFunction)
							.peek(n -> System.out.println("Peek: "+ n))
							.findFirst()
							.orElse(null);
		
		System.out.println("First even number: "+firstEven);
		
		//min and max
		
		Integer min = myNumberList.stream()
					  .filter(isEvenFunction)
					  .min((n1,n2) -> n1-n2)
					  .orElse(null);
		System.out.println("Min even: "+min);
		
		Integer max=myNumberList.stream()
					.filter(isEvenFunction)
					.max(Comparator.comparing(Integer::intValue))
					.orElse(null);
		System.out.println("Max even "+ max);
		
		//sum
		
		Integer sum=myNumberList.stream()
					.reduce(0,Integer::sum);
		System.out.println("Sum :"+ sum);
		long count=myNumberList.stream().count();
		
		System.out.println("Avg: "+sum/count);
		
		//all even or any even
		
		boolean allEven=myNumberList.stream().allMatch(isEvenFunction);
		boolean oneEven=myNumberList.stream().anyMatch(isEvenFunction);
		
		System.out.println("All even: "+allEven);
		System.out.println("At least one even :"+ oneEven);
		
		//sort 
		List<Integer> unSortedList=Arrays.asList(new Integer[]{4,2,3,1,6});
		List<Integer> sortedList=unSortedList.stream()
								.sorted((n1,n2)-> n1.compareTo(n2))
								.collect(Collectors.toList());
		
		System.out.println("Sorted List: "+ sortedList);
		
	
	}
}
