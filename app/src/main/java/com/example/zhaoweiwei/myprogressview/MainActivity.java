package com.example.zhaoweiwei.myprogressview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Visibility;
import android.view.View;
import android.widget.Button;

import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;

public class MainActivity extends AppCompatActivity {

	private ProgressView progressView;
	private Button button;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		progressView = (ProgressView) findViewById(R.id.progressview);
		button = (Button) findViewById(R.id.button_progressview);
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (VISIBLE == progressView.getVisibility()) {
					button.setText("开始加载");
					progressView.setVisibility(INVISIBLE);
				} else {
					button.setText("停止加载");
					progressView.setVisibility(VISIBLE);
				}
			}
		});
	}
}
