package com.example.makaotalk.activity;

import com.example.makaotalk.Constants;
import com.example.makaotalk.R;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;

public class ChatActivity extends ActionBarActivity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		int whichRoom = getIntent().getExtras().getInt(Constants.Extra.CHAT_POSITION, 0);
	}
}
