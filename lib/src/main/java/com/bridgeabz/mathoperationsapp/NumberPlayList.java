package com.bridgeabz.mathoperationsapp;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;



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
	}
}
