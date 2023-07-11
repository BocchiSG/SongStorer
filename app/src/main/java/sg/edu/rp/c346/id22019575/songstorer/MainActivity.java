package sg.edu.rp.c346.id22019575.songstorer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnInsert, btnShowList;
    RadioGroup rgStars;
    EditText etYear, etSingers, etTitle;
    ArrayList<Song> al;
    ArrayAdapter<Song> aa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInsert = findViewById(R.id.insert);
        btnShowList = findViewById(R.id.showList);
        rgStars = findViewById(R.id.Stars);
        etSingers = findViewById(R.id.Singers);
        etTitle = findViewById(R.id.Title);
        etYear = findViewById(R.id.Year);


        al = new ArrayList<Song>();
        aa = new ArrayAdapter<Song>(this,
                android.R.layout.simple_list_item_1, al);


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
                Song target = al.get(0);

                Intent i = new Intent(MainActivity.this,
                        ListviewActivity.class);
                i.putExtra("data", (CharSequence) target);
                startActivity(i);

            }
        });


    }



}