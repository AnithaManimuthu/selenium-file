package com.maven;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

public class Sample2 {
	public static void beforeClass() {
		System.out.println("BEFORE CLASS");
	}
		
		
		@AfterClass
		public static void afterClass() {
			System.out.println("After Class");
		}
		
		@Before
		
			public void before() {
				System.out.println("Before");
			}
			
			@After
			public void after() {
				System.out.println("After");
		
	}
			
			@Test
			public void tc11() {
				System.out.println("method 33");
				
			}
			
			@Test
			
			public void tc22(){
				System.out.println("method 44");
			}


}


