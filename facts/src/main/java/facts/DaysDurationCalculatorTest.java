package facts;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class DaysDurationCalculatorTest
{
	
	@Test
	public void inputTest_3_Months()
	{
		Assertions.assertEquals(59, DaysDurationCalculator.cal(1, 1, 3, 1, 2022));
	}
	
	@Test
	public void inputTest_6_Months()
	{
		Assertions.assertEquals(151, DaysDurationCalculator.cal(1, 1, 6, 1, 2022));
	}
	
	@Test
	public void inputTest_9_Months()
	{
		Assertions.assertEquals(243, DaysDurationCalculator.cal(1, 1, 9, 1, 2022));
	}
	
	@Test
	public void inputTest_12_Months()
	{
		Assertions.assertEquals(334, DaysDurationCalculator.cal(1, 1, 12, 1, 2022));
	}
	
	@Test
	public void inputTest_full_year()
	{
		Assertions.assertEquals(364, DaysDurationCalculator.cal(1, 1, 12, 31, 2022));
	}
	
	@Test
	public void inputTest_Feb_Leap_Year()
	{
		Assertions.assertEquals(29, DaysDurationCalculator.cal(2, 1, 3, 1, 2020));
	}
	
	@Test
	public void inputTest_Feb_Not_Leap_Yearinput_test()
	{
		Assertions.assertEquals(28, DaysDurationCalculator.cal(2, 1, 3, 1, 2021));
	}
	
	@Test
	public void inputTest_Mid_Month()
	{
		Assertions.assertEquals(31, DaysDurationCalculator.cal(1, 15, 2, 15, 2022));
	}
	
	@Test
	public void inputTest_Half_Month()
	{
		Assertions.assertEquals(15, DaysDurationCalculator.cal(1, 1, 1, 16, 2022));
	}
	
	@Test
	public void inputTest_Neighbor_Months()
	{
		Assertions.assertEquals(45, DaysDurationCalculator.cal(4, 1, 5, 16, 2022));
	}
	
}