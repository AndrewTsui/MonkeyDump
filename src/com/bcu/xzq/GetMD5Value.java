package com.bcu.xzq;

import com.fsm.build.AndroidAppFSM;

public class GetMD5Value {

	private GetMD5Value() {
		// TODO Auto-generated constructor stub
	}
	
	public static String getMD5Value(String filePath) {
		
		AndroidAppFSM aFsm = AndroidAppFSM.getFSMBuilder();
		aFsm.parseAppState(filePath, "", "");
		String MD5Value = aFsm.getStateByName(filePath).getMD5Value();
		
		return MD5Value;
	}
}
