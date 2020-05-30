package com.bcu.xzq;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;

public class GetAllFileName {	//Singleton Pattern
	
	private GetAllFileName() {
		// TODO Auto-generated constructor stub
	}
	
	public static void getAllFileName(String path,LinkedList<String> fileNameList) {
        boolean flag = false;
        File file = new File(path);
        File[] tempList = file.listFiles();

        for (int i = 0; i < tempList.length; i++) {
            if (tempList[i].isFile()) {
                fileNameList.add(tempList[i].getName());
            }
            if (tempList[i].isDirectory()) {
                getAllFileName(tempList[i].getAbsolutePath(),fileNameList);
            }
        }
        return;
    }
}
