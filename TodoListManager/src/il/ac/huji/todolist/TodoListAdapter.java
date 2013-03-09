package il.ac.huji.todolist;

import java.util.ArrayList;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


public class TodoListAdapter extends ArrayAdapter<String> {

	public TodoListAdapter(TodoListManagerActivity activity, ArrayList<String> todoList) {
			super(activity, android.R.layout.simple_list_item_1, todoList);
		}

	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		String todo = getItem(position);
		LayoutInflater inflater = LayoutInflater.from(getContext());
		View view = inflater.inflate(R.layout.row, null);
		TextView rowText = (TextView)view.findViewById(R.id.rowText);
		rowText.setText(todo);
		if (position%2 == 0) {
			rowText.setTextColor(Color.RED);
		}
		else {
			rowText.setTextColor(Color.BLUE); 
		}
		return view;
	}
}
