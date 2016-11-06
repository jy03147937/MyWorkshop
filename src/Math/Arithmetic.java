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
		System.out.println("Sqrt costs : " + interval + " ms result: " + String.valueOf(result));
		
		long BisectionStartTime=System.currentTimeMillis();
		for(int i = 0; i < times; i++) {
			result = SqrtByBisection(num);
		}
		long BisectionEndTime=System.currentTimeMillis();
		long BisectionInterval=BisectionEndTime-BisectionStartTime;
		System.out.println("SqrtByBisection costs: " + BisectionInterval + " ms result: " + String.valueOf(result));
		
		long NewtonStartTime=System.currentTimeMillis();
		for(int i = 0; i < times; i++) {
			result = SqrtByNewton(num);
		}
		long NewtonEndTime=System.currentTimeMillis();
		long NewtonInterval=NewtonEndTime-NewtonStartTime;
		System.out.println("SqrtByNewton costs: " + NewtonInterval + " ms result: " + String.valueOf(result));
		
	}
	
	public static double SqrtByBisection(double x)
	{
		if(x < 0) {
			return Double.NaN;
		}
		
		double err = 1E-15;
		
		double left = 0;
		double right = x;
		double result = (left + right)/2;
		while(Math.abs(result*result - x) > err) {
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
		if(x < 0) {
			return Double.NaN;
		}
		
		double err = 1E-10;
		
		double result = x / 2;
		while((result*result - x) > err) {
			result = (result + x / result) / 2;
		}
		return result;
	}
	
}
