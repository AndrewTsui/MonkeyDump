package com.bcu.xzq;

public class CountActivities {
	
	private CountActivities() {
		// TODO Auto-generated constructor stub
	}
	
	public static void countActivities() {
		GetActivitiesStatistics getActivitiesStatistics = new GetActivitiesStatistics();
		getActivitiesStatistics.getStatisticsConsequence();
	}
}
