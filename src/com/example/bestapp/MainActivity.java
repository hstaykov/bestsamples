package com.example.bestapp;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	private final String bestTag = "BEST";
	Button btnShow;
	TextView tvResult;
	EditText etInput;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_linear_layout);

		tvResult = (TextView) (findViewById(R.id.tv_text_from_the_field));
		etInput = (EditText) (findViewById(R.id.et_input));

		btnShow = (Button) findViewById(R.id.btn_show_text);
		
		if (tvResult != null) {
			tvResult.setText("Test");
			if (btnShow == null) {
				tvResult.setText("There was error. We can't find the button.");
			} else {
				btnShow.setOnClickListener(this);
			}
		} else {
			Log.e(bestTag, "We can't find the reuslt field");
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		if (v.getId() == btnShow.getId()) {
			if (etInput != null) {
				tvResult.setText(etInput.getText());
			} else {
				tvResult.setText("The was an error");
				Log.e(bestTag, "The input field is not available");
			}
		}
	}

}
