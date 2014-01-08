package com.xckevin.download;

import com.xckevin.download.util.MD5;

public class DownloadTask {
	
	public static final String ID = "_id";
	public static final String URL = "c";
	public static final String THUMBURL = "d";
	public static final String MIMETYPE = "e";
	public static final String SAVEPATH = "f";
	public static final String FINISHEDSIZE = "h";
	public static final String TOTALSIZE = "i";
	public static final String NAME = "j";
	public static final String DESC = "k";
	public static final String STATUS = "l";
	
	public static final int STATUS_PENDDING = 1 << 0;
	
	public static final int STATUS_RUNNING = 1 << 1;
	
	public static final int STATUS_PAUSED = 1 << 2;
	
	public static final int STATUS_CANCELED = 1 << 3;
	
	public static final int STATUS_FINISHED = 1 << 4;
	
	public static final int STATUS_ERROR = 1 << 5;

	private String id;
	
	private String name;
	
	private String desc;
	
	private String url;
	
	private String thumbUrl;
	
	private String mimeType;
	
	private String downloadSavePath;
	
	private long downloadFinishedSize;
	
	private long downloadTotalSize;
	
	// @Transparent no need to persist
	private long downloadSpeed;
	
	private int status;
	
	public DownloadTask() {
		downloadFinishedSize = 0;
		downloadTotalSize = 0;
		status = STATUS_PENDDING;
	}

	@Override
	public boolean equals(Object o) {
		if(o == null) {
			return false;
		}
		if(!(o instanceof DownloadTask)) {
			return false;
		}
		DownloadTask task = (DownloadTask) o;
		if(this.name == null || this.downloadSavePath == null) {
			return this.url.equals(task.url);
		}
		return this.name.equals(task.name) && this.url.equals(task.url) && this.downloadSavePath.equals(task.downloadSavePath);
	}

	@Override
	public int hashCode() {
		int code = name == null ? 0 : name.hashCode();
		code += url.hashCode();
		return code;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
		this.id = MD5.getMD5(url);
	}

	public String getThumbUrl() {
		return thumbUrl;
	}

	public void setThumbUrl(String thumbUrl) {
		this.thumbUrl = thumbUrl;
	}

	public String getMimeType() {
		return mimeType;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	public String getDownloadSavePath() {
		return downloadSavePath;
	}

	public void setDownloadSavePath(String downloadSavePath) {
		this.downloadSavePath = downloadSavePath;
	}

	public long getDownloadFinishedSize() {
		return downloadFinishedSize;
	}

	public void setDownloadFinishedSize(long downloadFinishedSize) {
		this.downloadFinishedSize = downloadFinishedSize;
	}

	public long getDownloadTotalSize() {
		return downloadTotalSize;
	}

	public void setDownloadTotalSize(long downloadTotalSize) {
		this.downloadTotalSize = downloadTotalSize;
	}

	public long getDownloadSpeed() {
		return downloadSpeed;
	}

	public void setDownloadSpeed(long downloadSpeed) {
		this.downloadSpeed = downloadSpeed;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
