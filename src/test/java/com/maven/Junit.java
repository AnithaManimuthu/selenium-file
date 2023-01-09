package com.maven;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Junit {
	@BeforeClass
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
			public void tc0() {
				System.out.println("method 0");
				
			}
			
			@Test
			
			public void tc1(){
				System.out.println("method 1");
			}

}

