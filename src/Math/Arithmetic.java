package Math;

public class Arithmetic {

	public static void main(String[] args) {
		int times = 10000000;
		int num = 5000;
		double result = 0;
		long startTime=System.currentTimeMillis();
		for(int i = 0; i < times; i++) {
			result = Math.sqrt(num);
		}
		long endTime=System.currentTimeMillis();
		long interval=endTime-startTime;
		System.out.println("Sqrt costs : " + String.valueOf(result) + "  " + interval + "ms");
		
		long BisectionStartTime=System.currentTimeMillis();
		for(int i = 0; i < times; i++) {
			result = SqrtByBisection(num);
		}
		long BisectionEndTime=System.currentTimeMillis();
		long BisectionInterval=BisectionEndTime-BisectionStartTime;
		System.out.println("SqrtByBisection costs : " + String.valueOf(result) + "  " + BisectionInterval + "ms");
		
		long NewtonStartTime=System.currentTimeMillis();
		for(int i = 0; i < times; i++) {
			result = SqrtByNewton(num);
		}
		long NewtonEndTime=System.currentTimeMillis();
		long NewtonInterval=NewtonEndTime-NewtonStartTime;
		System.out.println("SqrtByNewton costs : " + String.valueOf(result) + "  " + NewtonInterval + "ms");
		
	}
	
	public static double SqrtByBisection(double x)
	{
		if (x == 0) {
			return x;
		}
		if(x < 0) {
			return -1;
		}
		
		double left = 0;
		double right = x;
		double result = (left + right)/2;
		while((result*result - x) > 0.000000001 || (result*result - x) < -0.000000001) {
			if(result*result < x) {
				left = result;
				result = (left + right) / 2;
			} else {
				right = result;
				result = (left + right) / 2;
			}
		}
		return result;
	}
	
	public static double SqrtByNewton(double x)
	{
		if (x == 0) {
			return x;
		}
		if(x < 0) {
			return -1;
		}
		
		double result = x / 2;
		while((result*result - x) > 0.000000001) {
			result = (result + x / result) / 2;
		}
		return result;
	}
	
}
