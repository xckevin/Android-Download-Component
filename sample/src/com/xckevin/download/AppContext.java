package com.xckevin.download;

import java.io.File;

import com.xckevin.download.util.IDCreator;

import android.app.Application;
import android.os.Environment;

public class AppContext extends Application {
	
	@Override
	public void onCreate() {
		super.onCreate();
		DownloadManager downloadMgr = DownloadManager.getInstance();
		
		// use default configuration
		//downloadMgr.init();
		
		// custom configuration
		DownloadConfig.Builder builder = new DownloadConfig.Builder(this);
		String downloadPath = null;
		if(Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
			downloadPath = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "download";
		} else {
			downloadPath = Environment.getDataDirectory().getAbsolutePath() + File.separator + "data" + File.separator + getPackageName() + File.separator + "download";
		}
		File downloadFile = new File(downloadPath);
		if(!downloadFile.isDirectory() && !downloadFile.mkdirs()) {
			throw new IllegalAccessError(" cannot create download folder");
		}
		builder.setDownloadSavePath(downloadPath);
		builder.setMaxDownloadThread(3);
		builder.setDownloadTaskIDCreator(new IDCreator());
		
		downloadMgr.init(builder.build());
	}

}
