package thermostat;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.*;

public class ThermostatTest_CACC
{
	//clause a = (curTemp < dTemp - thresholdDiff)
	//clause b = (Override)
	//clause c = (curTemp < overTemp - thresholdDiff)
	//clause d = (timeSinceLastRun > minLag)
	
	@Test
	public void CCAC_testBCD_True() //row 9 in the truth table
	{
		//This test is for the turnHeaterOn() method in the Thermostat class
		//Criterion CACC (Input: covers Major clause b, c, and d as true for active clause)
		//Expected result: True
		//This test covers both predicates P1 and P2 which consists of lines 28-32 and 36-37
		
		//This sets up the objects needed for the test to be run
		Thermostat tstat = new Thermostat();
		ProgrammedSettings setUp = new ProgrammedSettings();
		
		//Initializing and assigning values to dTemp
		setUp.setSetting(Period.DAY, DayType.WEEKDAY, 65);
		tstat.setDay(DayType.WEEKDAY);
		tstat.setPeriod(Period.DAY);
		
		//clause a: false
		tstat.setCurrentTemp(70);
		tstat.setThresholdDiff(2);
		
		//clause b: true
		tstat.setOverride(true);
		
		//clause c: true
		tstat.setOverTemp(74);
		
		//clause d: true
		tstat.setMinLag(5);
		tstat.setTimeSinceLastRun(8);
		
		assertTrue(tstat.turnHeaterOn(setUp));
		
		
	}
	
	@Test
	public void CCAC_testAB_False()  //row 11 in the truth table
	{
		//This test is for the turnHeaterOn() method in the Thermostat class
		//Criterion CACC (Input: covers Major clause a and b as false for active clause coverage)
		//Expected result: False
		//This test covers both predicates P1 and P2 which consists of lines 28-32 and 36-37
		
		//This sets up the objects needed for the test to be run
		Thermostat tstat = new Thermostat();
		ProgrammedSettings setUp = new ProgrammedSettings();
		
		//Initializing and assigning values to dTemp
		setUp.setSetting(Period.DAY, DayType.WEEKDAY, 65);
		tstat.setDay(DayType.WEEKDAY);
		tstat.setPeriod(Period.DAY);
		
		//clause a: false
		tstat.setCurrentTemp(70);
		tstat.setThresholdDiff(2);
		
		//clause b: true
		tstat.setOverride(true);
		
		//clause c: false
		tstat.setOverTemp(69);
		
		//clause d: true
		tstat.setMinLag(5);
		tstat.setTimeSinceLastRun(8);
		
		assertFalse(tstat.turnHeaterOn(setUp));
		
		
	}
	
	@Test
	public void CCAC_testA_True() //row 3 in the truth table
	{
		//This test is for the turnHeaterOn() method in the Thermostat class
		//Criterion CACC (Input: covers Major clause a as true for active clause)
		//Expected result: True
		//This test covers both predicates P1 and P2 which consists of lines 28-32 and 36-37
		
		//This sets up the objects needed for the test to be run
		Thermostat tstat = new Thermostat();
		ProgrammedSettings setUp = new ProgrammedSettings();
		
		//Initializing and assigning values to dTemp
		setUp.setSetting(Period.DAY, DayType.WEEKDAY, 72);
		tstat.setDay(DayType.WEEKDAY);
		tstat.setPeriod(Period.DAY);
		
		//clause a: true
		tstat.setCurrentTemp(65);
		tstat.setThresholdDiff(4);
		
		//clause b: true
		tstat.setOverride(true);
		
		//clause c: false
		tstat.setOverTemp(62);
		
		//clause d: true
		tstat.setMinLag(5);
		tstat.setTimeSinceLastRun(8);
		
		assertTrue(tstat.turnHeaterOn(setUp));
		
		
	}
	
	@Test
	public void CCAC_testD_False() //row 2 in the truth table
	{
		//This test is for the turnHeaterOn() method in the Thermostat class
		//Criterion CACC (Input: covers Major clause  d as false for active clause)
		//Expected result: False
		//This test covers both predicates P1 and P2 which consists of lines 28-32 and 36-37
		
		//This sets up the objects needed for the test to be run
		Thermostat tstat = new Thermostat();
		ProgrammedSettings setUp = new ProgrammedSettings();
		
		//Initializing and assigning values to dTemp
		setUp.setSetting(Period.DAY, DayType.WEEKDAY, 75);
		tstat.setDay(DayType.WEEKDAY);
		tstat.setPeriod(Period.DAY);
		
		//clause a: true
		tstat.setCurrentTemp(70);
		tstat.setThresholdDiff(2);
		
		//clause b: false
		tstat.setOverride(false);
		
		//clause c: true
		tstat.setOverTemp(74);
		
		//clause d: true
		tstat.setMinLag(5);
		tstat.setTimeSinceLastRun(8);
		
		assertTrue(tstat.turnHeaterOn(setUp));
		
		
	}
	
	@Test
	public void CCAC_testC_False() //row 13 in the truth table
	{
		//This test is for the turnHeaterOn() method in the Thermostat class
		//Criterion CACC (Input: covers Major clause c as false for active clause)
		//Expected result: false
		//This test covers both predicates P1 and P2 which consists of lines 28-32 and 36-37
		
		//This sets up the objects needed for the test to be run
		Thermostat tstat = new Thermostat();
		ProgrammedSettings setUp = new ProgrammedSettings();
		
		//Initializing and assigning values to dTemp
		setUp.setSetting(Period.DAY, DayType.WEEKDAY, 65);
		tstat.setDay(DayType.WEEKDAY);
		tstat.setPeriod(Period.DAY);
		
		//clause a: false
		tstat.setCurrentTemp(70);
		tstat.setThresholdDiff(2);
		
		//clause b: true
		tstat.setOverride(true);
		
		//clause c: true
		tstat.setOverTemp(74);
		
		//clause d: false
		tstat.setMinLag(8);
		tstat.setTimeSinceLastRun(5);
		
		assertFalse(tstat.turnHeaterOn(setUp));
		
		
	}
	
}
	