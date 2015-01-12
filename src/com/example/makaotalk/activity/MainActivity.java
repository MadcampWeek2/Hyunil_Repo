package com.example.makaotalk.activity;

import java.util.Locale;

import com.example.makaotalk.Constants;
import com.example.makaotalk.R;
import com.example.makaotalk.fragment.ChatsListFragment;
import com.example.makaotalk.fragment.FindFragment;
import com.example.makaotalk.fragment.FriendsListFragment;
import com.example.makaotalk.fragment.MoreFragment;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentPagerAdapter;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

@SuppressWarnings("deprecation")
public class MainActivity extends ActionBarActivity implements ActionBar.TabListener {
	private static final String STATE_POSITION = "STATE_POSITION";

	SectionsPagerAdapter adapter;
	ViewPager pager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ac_main);

		int pagerPosition = savedInstanceState == null ? 0 : savedInstanceState.getInt(STATE_POSITION);
		
		/* ActionBar setup */
		final ActionBar actionBar = getSupportActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		// action icons
		
		/* Adapter, Pager, Tab setup */
		adapter = new SectionsPagerAdapter(getSupportFragmentManager());
		pager = (ViewPager) findViewById(R.id.pager);
		pager.setAdapter(adapter);
		pager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
					@Override
					public void onPageSelected(int position) {
						// Change tab
						actionBar.setSelectedNavigationItem(position);

						// Change title
						actionBar.setTitle(adapter.getPageTitle(position));
						/* section specific tasks
						switch (position) {
							case 0:
								break;
							case 1:
								break;
						}
						*/
					}
				});
		for (int i = 0; i < adapter.getCount(); i++) {
			actionBar.addTab(actionBar.newTab()
					.setText(adapter.getPageTitle(i))
					.setTabListener(this));
		}
		actionBar.setTitle(adapter.getPageTitle(pagerPosition));
		
		Log.i(Constants.TAG, "Main : onCreate finished");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.ac_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
		pager.setCurrentItem(tab.getPosition());
	}

	@Override
	public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
	}

	@Override
	public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
	}

	public void onSaveInstanceState(Bundle outState) {
		outState.putInt(STATE_POSITION, pager.getCurrentItem());
	}
	
	public class SectionsPagerAdapter extends FragmentPagerAdapter {
		Fragment sec1;
		Fragment sec2;
		Fragment sec3;
		Fragment sec4;
		
		public SectionsPagerAdapter(FragmentManager fm) {
			super(fm);
			sec1 = new FriendsListFragment();
			sec2 = new ChatsListFragment();
			sec3 = new FindFragment();
			sec4 = new MoreFragment();
		}

		@Override
		public int getCount() {
			return 4;
		}

		@Override
		public Fragment getItem(int position) {
			switch (position) {
				case 0:
					return sec1;
				case 1:
					return sec2;
				case 2:
					return sec3;
				case 3:
					return sec4;
				default:
					return null;
			}
		}

		@Override
		public CharSequence getPageTitle(int position) {
			Locale l = Locale.getDefault();
			switch (position) {
				case 0:
					return getString(R.string.title_section1).toUpperCase(l);
				case 1:
					return getString(R.string.title_section2).toUpperCase(l);
				case 2:
					return getString(R.string.title_section3).toUpperCase(l);
				case 3:
					return getString(R.string.title_section4).toUpperCase(l);
				default:
					return null;
			}
		}
	}
}