package runner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.function.Consumer;

public class MyForEach {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello");
		
		
		//List
		List<Integer> newlist = new ArrayList<Integer>();
		newlist.add(1);
		newlist.add(2);
		newlist.add(3);
		newlist.add(4);
		newlist.add(5);
		
		newlist.forEach(x -> System.out.println(x + " foreach"));
		
		for(int i : newlist) {
			System.out.println(i + " for(int i : newlist)");
		}
		Iterator<Integer> itr1 = newlist.iterator();
		while(itr1.hasNext()) {
			System.out.println(itr1.next() + " Iterator");
		}
		
		for(int i=0; i<newlist.size();i++) {
			System.out.println(i + " for(int i : newlist)");
		}
		
		List<String> newlist2 = new ArrayList<String>();
		newlist2.add("L");
		newlist2.add("O");
		newlist2.add("V");
		newlist2.add("E");
		
		newlist.forEach(new Consumer<Integer>() {

			public void accept(Integer t) {
				System.out.println("forEach anonymous class Value::"+t);
			}

		});
		
		newlist2.forEach(new Consumer<String>() {

			@Override
			public void accept(String t) {
				// TODO Auto-generated method stub
				
			}
		});
		
		//traversing with Consumer interface implementation
		MyConsumer action = new MyConsumer();
		newlist.forEach(action);
		
		//Map
		Map<Integer, Integer> newMap = new HashMap<Integer, Integer>();
		newMap.put(1, 2);
		newMap.put(2, 3);
		newMap.put(3, 4);
		
		for(Map.Entry<Integer, Integer> entry : newMap.entrySet()) {
			System.out.println(entry.getKey() + " Map " + entry.getValue());
		}
		
		//if you don't need values and only needs key then use keySet to get a set of all keys.
		Iterator<Integer> mapItr = newMap.keySet().iterator();
		while(mapItr.hasNext()) {
			System.out.println(mapItr.next() + " Map Iterator");
		}
		
		
		//if you only need values, as it requires less memory than the first approach
		Collection<Integer> mapValue = newMap.values();
		for(int i : mapValue) {
			System.out.println(i + " only values in map");
		}
		
		newMap.forEach((x, y) -> System.out.println(x + " " + y));
		
		
		//Set
		Set<Integer> newSet = new HashSet<Integer>();
		newSet.add(6);
		newSet.add(7);
		newSet.add(8);
		newSet.add(9);
		
		
		Set<String> newSet2 = new HashSet<String>();
		newSet2.add("hhdf");
		newSet2.add("sdafert");
		newSet2.add("aewe");
		newSet2.add("adfae");
		Iterator<String> itr = newSet2.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next() + " Iterator");
		}
		
		//Java 5 for enhanced for loop
		for(String i : newSet2) {
			System.out.println(i + " enhanced for loop : Set");
		}
		
		System.out.println(newSet2);
		
		String[] newSetArray = newSet2.stream().toArray(String[]::new);
		
		for (String string : newSetArray) {
			System.out.println(string + "  newSetArray");
		}
		
		System.out.println("Queue");
		//Queue
		Queue<String> newQueue = new PriorityQueue<String>();
		newQueue.add("aef");
		newQueue.add("wefad");
		newQueue.add("xcze");
		newQueue.add("ttyefea");
		newQueue.add("Atyefea");
		
		Queue<String> newQueue1 = new LinkedList<String>();
		newQueue1.add("aef");
		newQueue1.add("wefad");
		newQueue1.add("xcze");
		newQueue1.add("ttyefea");
		newQueue1.add("Atyefea");
		
		
		for(String i : newQueue) {
			System.out.println(i);
		}
		
		Iterator<String> queueItr = newQueue.iterator();
		while(queueItr.hasNext()) {
			System.out.println(queueItr.next() + " Queue Iterator");
		}
		newQueue.forEach(x -> System.out.println(x));
		newQueue.stream().forEach(x->System.out.println(x));
		
		while(newQueue.peek() != null) {
			System.out.println(newQueue.poll());
		}
		
		while(newQueue1.peek() != null) {
			System.out.println(newQueue1.poll() + " linkedlist Queue");
		}
		
		List<String> newList = Arrays.asList("safe","afew","aefewfas");
		List<Integer> number = Arrays.asList(2,3,4,5);
		int even = number.stream().filter(x->x%2==0).reduce(0,(ans,i)->ans+i);
		System.out.println(even); 
	}
	static class MyConsumer implements Consumer<Integer>{

		public void accept(Integer t) {
			System.out.println("Consumer impl Value::"+t);
		
		}
	}
}