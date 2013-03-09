package il.ac.huji.todolist;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ListView;

public class TodoListManagerActivity extends Activity {

    private TodoListAdapter adapter;
    private ArrayList<String> todoList;
    private ListView todoListView;
    
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_list_manager);
        todoList = new ArrayList<String>();
        todoListView = (ListView)findViewById(R.id.lstTodoItems);
        adapter = new TodoListAdapter(this, todoList);
        todoListView.setAdapter(adapter);        
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	getMenuInflater().inflate(R.menu.main, menu);
    	return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	switch (item.getItemId()) {
    	case R.id.menuItemAdd:
    		EditText newToDo = (EditText) findViewById(R.id.edtNewItem);
    		adapter.add(newToDo.getText().toString());
    		break;
    	case R.id.menuItemDelete:
    		todoList.remove(todoListView.getSelectedItemPosition());
    		adapter.notifyDataSetChanged();
    	}
    	return true;
    }    	
}
	