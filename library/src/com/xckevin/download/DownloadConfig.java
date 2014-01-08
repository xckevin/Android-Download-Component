package com.xckevin.download;

import android.content.Context;

public class DownloadConfig {

	String downloadSavePath;
	
	int maxDownloadThread;
	
	DownloadProvider provider;
	
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
		
		public Builder setDownloadProvider(DownloadProvider provider) {
			config.provider = provider;
			return this;
		}
	}
}
