package com.example.dynamicspinn;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends Activity {

	Spinner mySpinner1, mySpinner2;
	List<String> myList1, myList2;
	private ArrayAdapter<String> myAdapter1, myAdapter2;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mySpinner1 = (Spinner) findViewById(R.id.myspinner1);
		mySpinner2 = (Spinner) findViewById(R.id.myspinner2);

		initList();
		myAdapter1 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, myList1);
		myAdapter1
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		mySpinner1.setAdapter(myAdapter1);

		myAdapter2 = new ArrayAdapter<String>(MainActivity.this,
				android.R.layout.simple_spinner_item, myList2);
		myAdapter2
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		mySpinner2.setAdapter(myAdapter2);

		mySpinner1.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int pos, long id) {
				if (pos != AdapterView.INVALID_POSITION) {
					myList2.add(myList1.get(pos));
					myAdapter2.notifyDataSetChanged();
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub

			}
		});

	}

	void initList() {
		myList1 = new ArrayList<String>();
		myList1.add("Sunday");
		myList1.add("Monday");
		myList1.add("Tuesday");
		myList1.add("Wednesday");
		myList1.add("Thursday");
		myList1.add("Friday");
		myList1.add("Saturday");

		myList2 = new ArrayList<String>();
		myList2.add("1");
		myList2.add("2");
		myList2.add("3");
		myList2.add("4");

	}
}