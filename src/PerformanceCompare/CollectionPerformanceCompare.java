package PerformanceCompare;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CollectionPerformanceCompare {

	public static void main(String[] args) {
		compareSetAndList_FindingPerformance();
	}

	private static void compareSetAndList_FindingPerformance() {
		List<Double> list = new ArrayList<Double>();
		
		for(int i = 0; i < 5000; i++) {
			
			Double temp = Math.random();
			while(list.contains(temp)) {
				temp = Math.random();
			}
			list.add(temp);
		}
		
		Set<Double> set = new HashSet<Double>();
		
		while(set.size() < 5000) {
			
			Double temp = Math.random();
			while(set.contains(temp)) {			
				temp = Math.random();
			}
			set.add(temp);
		}
		
		long startListFinding=System.currentTimeMillis();
		for(int i = 0; i < 500000; i++) {
			list.contains(Math.random());
		}
		long endListFinding=System.currentTimeMillis();
		long listInterval=endListFinding-startListFinding;
		
		long startSetFinding=System.currentTimeMillis();
		for(int i = 0; i < 500000; i++) {
			set.contains(Math.random());
		}
		long endSetFinding=System.currentTimeMillis();
		long setInterval=endSetFinding-startSetFinding;
		
		System.out.println("listInterval Costs : " + listInterval + "ms");
		System.out.println("setInterval Costs : " + setInterval + "ms");
	}
}
