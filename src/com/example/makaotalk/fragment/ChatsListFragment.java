package com.example.makaotalk.fragment;

import com.example.makaotalk.Constants;
import com.example.makaotalk.R;
import com.example.makaotalk.activity.ChatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;

public class ChatsListFragment extends Fragment {
	String[] chatUrls = Constants.CHAT_ROOMS;
	
	AbsListView listView;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Log.i(Constants.TAG, "ChatsList : onCreate finished");
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fr_chats, container, false);

		listView = (ListView) rootView.findViewById(android.R.id.list);
		((ListView) listView).setAdapter(new ChatRoomAdapter());
		listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				startChatActivity(position);
			}
		});
		
		Log.i(Constants.TAG, "ChatsList : onCreateView finished");

		return rootView;
	}
	
	/** Start the chatting activity */
	void startChatActivity(int position) {
		Log.i(Constants.TAG, "ChatList : starting Chat Activity");
		Intent intent = new Intent(getActivity(), ChatActivity.class);
		intent.putExtra(Constants.Extra.CHAT_POSITION, position);
		startActivity(intent);
	}
/////////////////
	private static class ViewHolder {
		TextView text;
		ImageView image;
	}
	
	class ChatRoomAdapter extends BaseAdapter {
		private LayoutInflater inflater;
		
		ChatRoomAdapter() {
			inflater = LayoutInflater.from(getActivity());
		}
		
		@Override
		public int getCount() {
			return chatUrls.length;
		}

		@Override
		public Object getItem(int position) {
			return position;
		}

		@Override
		public long getItemId(int position) {
			return position;
		}
//////////////////////////////////
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View view = convertView;
			final ViewHolder holder;
			
			if (convertView == null) {
				view = inflater.inflate(R.layout.item_list_chat_room, parent, false);
				holder = new ViewHolder();
				holder.text = (TextView) view.findViewById(R.id.text);
				holder.image = (ImageView) view.findViewById(R.id.image);
				view.setTag(holder);
			} else {
				holder = (ViewHolder) view.getTag();
			}
			
			// item fill in
			holder.text.setText("Item " + (position+1));
			
			return view;
		}
	}
}
