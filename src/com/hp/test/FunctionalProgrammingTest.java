package com.hp.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

interface Vehicle {
	
	public String drive(String type, double price); 
}



public class FunctionalProgrammingTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Runnable runnable = new Runnable () {
			public void run() {
				System.out.println("run started...");
			}
		};
		new Thread(runnable).start();
		
		
		Runnable runnable1 = () -> {
			System.out.println("run method business logic..");
		};
		
		new Thread(runnable1).start();
		
		Vehicle v = (str1 , price) -> {
			System.out.println("drive method bl.." + " " + str1 + "has price of"+ price);
			
			return "success..";
		};
		
		String str = v.drive("car", 10000);
		System.out.println(str);
		
		
		List<String> strLst = new ArrayList<String>();
		
		strLst.add("hi");
		strLst.add("hello");
		strLst.add("java");
		strLst.add("hi");
		strLst.add("functional");
		
		System.out.println(strLst.stream().count());
		
		List strLst1 = strLst.stream().filter(str1 -> str1.length() >2).collect(Collectors.toList());
		System.out.println(strLst1);
		
		
		Stream<String> strListStream = strLst.stream();
		System.out.println("using forEach...");
		strListStream.forEach(s -> {
			System.out.println(s);
			});
		
		strLst.stream().filter(s -> s.equals("hi")).count();
		Set<String> set= strLst.stream().collect(Collectors.toSet());
		System.out.println("using set foreach");
		
		set.parallelStream().forEach(s -> System.out.println(s));
		
		//Method references
		
		set.parallelStream().forEach(System.out::println);
		
	}

}
