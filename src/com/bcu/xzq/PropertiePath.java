package com.bcu.xzq;

/**
 * 
 * @author xzq
 * @version 1.0
 * @since 1.1: alter singleton class 
 *
 * You can use PropertiePath.getPropertiePath() to get an object with
 * an String return value type which contains the path of system.properties
 *
 */

public class PropertiePath {

	public String getPropertiePath() {
		String propertiesPath = getClass().getClassLoader().getResource("system.properties").getPath().replace("%20", " ");
		return propertiesPath;
	}
}
