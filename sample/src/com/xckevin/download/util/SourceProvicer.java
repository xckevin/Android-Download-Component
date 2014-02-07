package com.xckevin.download.util;

import com.xckevin.download.DownloadTask;

public class SourceProvicer {

	public static final String APK_URL = "http://static.huaqianapp.com/apk/HuaQian-release.apk";
	
	public static DownloadTask getSimpleTask() {
		DownloadTask task = new DownloadTask();
		task.setName("HuaQian");
		task.setUrl(APK_URL);
		
		return task;
	}
}
