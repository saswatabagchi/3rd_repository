package com.saswata.foc.assignemnt1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;





public class Test {

	// problem statement duration 30 mints 
	// 1.make two list of emp with properties of name , age , salary , department , designation 
	// 2.marge two list with java 8 stream function 
	// 3.to traverse using iterator 
	// 4.sort list using lambda function 
	// 5.concatinate two lists by java 8 stream 
	// 6.filter out only ast 
	// 7.and remove duplicate by predicate on basis of one single property , need for multiple propety 
	// 8. Predicate join on condition '
	// 9. Composite sort by stream by comparetor 
	// 10. incremental add using function 
	// 11 max and min salary 
	// 12 ast spetial increment function by map 
	
	
	public static void main(String[] args) {
		
		List<Employee> emp1= new ArrayList<>();
		
		emp1.add(new Employee("Saswata",30,50000.00,"BFSI","ITA"));
		emp1.add(new Employee("Amit",30,5000.00,"BFSI","BST"));
		emp1.add(new Employee("Ram",30,500.00,"BFSI","SE"));
		
		//itterrator print
		Iterator<Employee> itr = emp1.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());

		}
		
		// 1st sort by name the sort by designation thru Collections lumbda function 
		// int sort 
		//listDevs.sort((Developer o1, Developer o2)->o1.getAge()-o2.getAge());
		 Collections.sort(emp1 , (p1, p2) -> {
	         return p1.getName().compareTo(p2.getName()); 
	      }); 
		 Collections.sort(emp1 , (p1, p2) -> {
	         return p1.getDesignation().compareTo(p2.getDesignation()); 
	      }); 
		  
		
		List<Employee> emp2= new ArrayList<>();
		emp2.add(new Employee("Suraj",30,50000.00,"BFSI","ITA"));
		emp2.add(new Employee("Amit",30,5000.00,"BFSI","XST"));
		emp2.add(new Employee("Sumit",30,5000.00,"BFSI","AST"));
		
		// concatinate thru stream 
		List<Employee> consolidatedList = Stream.concat(emp1.stream(),emp2.stream()).collect(Collectors.toList());
		
		//itterrator print
		Iterator<Employee> itr1 = consolidatedList.iterator();
		while (itr1.hasNext()) {
			System.out.println(itr1.next());

		}
		
		String customFilterDesinetion = "AST";
		//Filter out one AST designation 
		List<Employee> astList = consolidatedList.stream().filter(employee -> customFilterDesinetion.equals(employee.getDesignation())).collect(Collectors.toList());
		
		
		List<Employee> temp = astList.stream().filter(distinctByKey(Employee::getName)).collect(Collectors.toList());
        
		if (temp.size() > 0 ) {
			  System.out.println("manegers are " + temp);
			} else {
			  System.out.println("no manegers found");
			}
		
		  
		
	}
	
	// Remove duplicate function
	public static <T> Predicate <T> distinctByKey(Function <? super T, ?> keyExtractor) {
	    Set<Object> seen = ConcurrentHashMap.newKeySet();
	    return t -> seen.add(keyExtractor.apply(t));
	}
}