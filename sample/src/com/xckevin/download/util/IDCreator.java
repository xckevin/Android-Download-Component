package com.xckevin.download.util;

import com.xckevin.download.DownloadTask;
import com.xckevin.download.DownloadTaskIDCreator;

public class IDCreator implements DownloadTaskIDCreator {

	@Override
	public String createId(DownloadTask task) {
		return task.getUrl();
	}

}
