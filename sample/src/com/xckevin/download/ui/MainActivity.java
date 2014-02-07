package com.xckevin.download.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.xckevin.download.DownloadListener;
import com.xckevin.download.DownloadManager;
import com.xckevin.download.DownloadTask;
import com.xckevin.download.R;
import com.xckevin.download.util.SourceProvicer;

public class MainActivity extends Activity implements OnClickListener, DownloadListener {
	
	private TextView state;
	private ProgressBar progressBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		init();
	}
	
	private void init() {
		state = (TextView) findViewById(R.id.state);
		progressBar = (ProgressBar) findViewById(R.id.progressbar);
		findViewById(R.id.start).setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onDownloadStart(DownloadTask task) {
		state.setText(task.getName() + "==> start download");
	}

	@Override
	public void onDownloadUpdated(DownloadTask task, long finishedSize,
			long trafficSpeed) {
		// TODO Auto-generated method stub
		state.setText(task.getName() + "==> downloading..., speed: " + trafficSpeed);
		long total = task.getDownloadTotalSize();
		if(total != 0) {
			progressBar.setProgress((int) (task.getDownloadFinishedSize() * 100 / total));
		}
	}

	@Override
	public void onDownloadPaused(DownloadTask task) {
		state.setText(task.getName() + "==> pause download");
	}

	@Override
	public void onDownloadResumed(DownloadTask task) {
		state.setText(task.getName() + "==> resume download");

	}

	@Override
	public void onDownloadSuccessed(DownloadTask task) {
		state.setText(task.getName() + "==> download successed");

	}

	@Override
	public void onDownloadCanceled(DownloadTask task) {
		state.setText(task.getName() + "==> download canceled");
	}

	@Override
	public void onDownloadFailed(DownloadTask task) {
		state.setText(task.getName() + "==> download failed");
	}

	@Override
	public void onDownloadRetry(DownloadTask task) {
		state.setText(task.getName() + "==> retry download ");
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()) {
		case R.id.start:
			DownloadManager.getInstance().addDownloadTask(SourceProvicer.getSimpleTask(), this);
			break;
		default:
			break;
		}
	}

}
