import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NDTV {
	public static ForkJoinPool forkJoinPool = new ForkJoinPool();
	public static void main(String[] arg) {
		
		  ForkJoinPool fj = new ForkJoinPool(8); 
		  int[] a =
		  {4,5,4,4,2,3,3,3,3,5,4,4,45,45,45,545,45,45,4,5,5,6,5,4,5,2,3,4,4,4,4,4,4,4,4,4,4,4,5,5,4,3,4,4,2,3,4};
		  summa s =
		  new summa(a,0,a.length-1); //System.out.println(stack.));
		  System.out.println(fj.invoke(s));
		
     
	}
	
	

}

class summa extends RecursiveTask{
    int[] toSum;
    int strt;
    int end;
    
    summa(int[] li, int strt, int end){
    	toSum = li;
    	this.strt = strt;
    	this.end = end;
    }
	@Override
	protected Object compute() {
	

		if(end - strt < 6)
		{
			int sum =0;
			for(int i=strt ; i <= end ; i++) {
				sum += toSum[i];
				
			}
			System.out.println("print no fork"+ Thread.currentThread()+" "+(end - strt));
			return sum;
		}
		else
		{
			System.out.println("print forking now"+ strt+" "+end+" "+(end - strt));

		summa	sum1 = new summa(toSum,strt,(end + strt)/2);
		summa	sum2 = new summa(toSum,(end + strt)/2 +1 ,end);
		sum1.fork();
		sum2.fork();
		
		return ((Integer)sum1.join() + (Integer)sum2.join());
		}
		
	}

	
	
}

@FunctionalInterface
interface calculator {
	public int operation(int a, int b);

	public static void hello() {
		System.out.println("hello");
	}

	public default void newfunc() {
	}
}
