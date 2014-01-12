package com.xckevin.download;

import java.io.File;


import android.content.Context;

public class DownloadConfig {

	String downloadSavePath;
	
	int maxDownloadThread;
	
	int retryTime;
	
	DownloadProvider provider;
	
	DownloadTaskIDCreator creator;
	
	public static DownloadConfig getDefaultDownloadConfig(DownloadManager manager) {
		DownloadConfig config = new DownloadConfig();
		config.downloadSavePath = Env.ROOT_DIR + File.separator + "download";
		config.maxDownloadThread = 2;
		config.retryTime = 2;
		config.provider = SqlLiteDownloadProvider.getInstance(manager);
		config.creator = new MD5DownloadTaskIDCreator();
		
		return config;
	}
	
	public static class Builder {
		
		private DownloadConfig config;
		
		public Builder(Context context) {
			config = new DownloadConfig();
		}
		
		public Builder setDownloadSavePath(String downloadSavePath) {
			config.downloadSavePath = downloadSavePath;
			return this;
		}
		
		public Builder setMaxDownloadThread(int maxDownloadThread) {
			config.maxDownloadThread = maxDownloadThread;
			return this;
		}
		
		public Builder setRetryTime(int retryTime) {
			config.retryTime = retryTime;
			return this;
		}
		
		public Builder setDownloadProvider(DownloadProvider provider) {
			config.provider = provider;
			return this;
		}
		
		public Builder setDownloadTaskIDCreator(DownloadTaskIDCreator creator) {
			config.creator = creator;
			return this;
		}
	}
}
