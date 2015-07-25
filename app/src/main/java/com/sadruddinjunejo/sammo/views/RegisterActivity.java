package com.sadruddinjunejo.sammo.views;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.sadruddinjunejo.sammo.R;

public class RegisterActivity extends Activity implements OnClickListener {

	private EditText etRegisterUsername;
	private EditText etRegisterPassword;
	private EditText etRegisterPasswordConfirm;
	private EditText etRegisterEmail;
	private EditText etRegisterEmailConfirm;
	
	private Button btnRegister;
	private Button btnSelectAvatar;
	
	private String strAvatarURL;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_register);
		this.initialiseComponents();
	}
	
	private void initialiseComponents(){
		etRegisterUsername = (EditText) findViewById(R.id.etRegisterUsername);
		etRegisterPassword = (EditText) findViewById(R.id.etRegisterPassword);
		etRegisterPasswordConfirm = (EditText) findViewById(R.id.etRegisterPasswordConfirm);
		etRegisterEmail = (EditText) findViewById(R.id.etRegisterEmail);
		etRegisterEmailConfirm = (EditText) findViewById(R.id.etRegisterEmailConfirm);
		
		btnRegister = (Button) findViewById(R.id.btnRegisterFinalise);
		btnRegister.setOnClickListener(this);
		btnSelectAvatar = (Button) findViewById(R.id.btnSelectAvatar);
		btnSelectAvatar.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()){
			case R.id.btnSelectAvatar:
			this.selectAvatar();
				break;
		
			case R.id.btnRegisterFinalise:
				if (this.registrationDataIsValid())
					this.beginRegistrationProcessing();
				break;
		}
	}
	
	/**
	 * Input validation method
	 * @return true if reg input is valid, false if not
	 */
	private boolean registrationDataIsValid(){
		return true;
	}
	
	private void selectAvatar(){
		
	}
	
	private void beginRegistrationProcessing(){
		
	}

}
