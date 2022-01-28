/* Infinite loop detection
 * Author: Suvasish Das (https://suvasish114.github.io/) 
 * */
package infinite;

public class Main {
	public static void main(String[] args) {
		System.out.println("The infinite loop lines are: "+new InfiniteDetect("test/a.cpp").getLines());
	}
}
