package sg.edu.rp.c346.id22019575.songstorer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnInsert, btnShowList;
    RadioGroup rgStars;
    EditText etYear, etSingers, etTitle;
    ArrayAdapter adapter;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInsert = findViewById(R.id.Insert);
        btnShowList = findViewById(R.id.ShowList);
        rgStars = findViewById(R.id.Stars);
        etSingers = findViewById(R.id.Singers);
        etTitle = findViewById(R.id.Title);
        etYear = findViewById(R.id.Year);
        lv = findViewById(R.id.lv);


        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create the DBHelper object, passing in the
                // activity's Context
                DBHelper db = new DBHelper(MainActivity.this);

                // Insert a task
                String task = etTitle.getText().toString();
                int date = Integer.parseInt(etYear.getText().toString());
                String singers = etSingers.getText().toString();
                int stars = rgStars.getCheckedRadioButtonId();
                RadioButton radioButton = findViewById(stars);
                stars = Integer.parseInt(radioButton.getText().toString());

                db.insertTask(task, date, singers, stars);
                db.close();



            }
        });

        btnShowList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create the DBHelper object, passing in the
                // activity's Context
                DBHelper db = new DBHelper(MainActivity.this);

                // Insert a task
                ArrayList<String> data = db.getTaskContent();
                db.close();

                adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);
                lv.setAdapter(adapter);

            }
        });


    }



}