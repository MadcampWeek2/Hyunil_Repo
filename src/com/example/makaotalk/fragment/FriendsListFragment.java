package com.example.makaotalk.fragment;

import com.example.makaotalk.Constants;
import com.example.makaotalk.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FriendsListFragment extends Fragment {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Log.i(Constants.TAG, "FriendsList : onCreate finished");
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fr_friends, container, false);


		Log.i(Constants.TAG, "FriendsList : onCreateView finished");

		return rootView;
	}
}
