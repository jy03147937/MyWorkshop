package Math;

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
		int[][] mergedIntervels = new int[colNum][rowNum];
		
		int i = 0;
		int k = 0;
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
			
			mergedIntervels[0][k] = start;
			mergedIntervels[1][k] = end;
			k++;
			i++;
			
		}
		
		return mergedIntervels;
	}

}
