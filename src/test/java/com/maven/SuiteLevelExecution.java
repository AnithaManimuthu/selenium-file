package com.maven;

import java.util.List;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({Junit.class,Sample1.class,Sample2.class})

public class SuiteLevelExecution {
	
	
	public static void main(String[] args) {
		
		
		Result runClasses=JUnitCore.runClasses(Sample1.class,Sample2.class,Junit.class);
		
		//TO GET THE RUN COUNT
		
		int runCount=runClasses.getRunCount();
		System.out.println("Total method executed:"+runCount);
		
		
		//TO GET THE IGNORE COUNT
		
		int ignoreCount=runClasses.getIgnoreCount();
		System.out.println("Ignore method count:"+ ignoreCount);
		
		
		//TO GET FAILURE COUNT
		
		
		int failureCount=runClasses.getFailureCount();
		System.out.println("Failure method count:"+  failureCount);
		
		
		//TO GET FAILURE METHOD NAME:
		
		
		List <Failure> failures=runClasses.getFailures();
		
		
		for (int i=0;i<failures.size();i++) {
			
			Failure failure = failures.get(i);
			String string=failure.toString();
			System.out.println("Method Name :"+ string);
			
			
		}
				
				
	}
	
	
	
	

}
