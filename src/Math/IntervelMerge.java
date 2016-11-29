package Math;

import java.util.ArrayList;
import java.util.Arrays;


public class IntervelMerge {

	public static void main(String[] args) {
		int[][] testArray = {{2,4,5,13,16},{3,9,7,15,22}};
		
		int[][] mergedArray = IntervelMerge(testArray);
		
		System.out.println(Arrays.deepToString(mergedArray));

	}
	
	public static int[][] IntervelMerge(int[][] intervels) {
		if(intervels == null || intervels.length == 0 || intervels[0].length == 0) {
			return null;
		}
		
		int colNum = intervels.length;
		int rowNum = intervels[0].length;

		ArrayList mergedStartlist = new ArrayList();
		ArrayList mergedEndlist = new ArrayList();
		
		int i = 0;
		while(i <= (rowNum - 1)) {
			int start = intervels[0][i];
			int end = intervels[1][i];
			for(int j = i + 1; j < rowNum; j++) {
				if (end < intervels[0][j]) {
					i = j - 1;
					break;
				} else if (end <= intervels[1][j]) {
					i = j;
					end = intervels[1][j];
				} else {
					i = j;
					continue;
				}
			}
			
			mergedStartlist.add(start);
			mergedEndlist.add(end);
			i++;
			
		}
		
		int[][] mergedIntervels = new int[colNum][mergedStartlist.size()];
		for(int k = 0; k < mergedStartlist.size(); k++) {
			mergedIntervels[0][k] = (int)mergedStartlist.get(k);
			mergedIntervels[1][k] = (int)mergedEndlist.get(k);
		}
		
		return mergedIntervels;
	}

}
