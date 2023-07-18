package sg.edu.rp.c346.id22019575.songstorer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class EditActivity extends AppCompatActivity {
    Button btnUpdate, btnDelete;
    RadioGroup rgStars;
    EditText etYear, etSingers, etTitle;
    Song data;
    TextView tvId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        btnUpdate = findViewById(R.id.update);
        btnDelete = findViewById(R.id.delete);
        rgStars = findViewById(R.id.Stars);
        etSingers = findViewById(R.id.singers);
        etTitle = findViewById(R.id.title2);
        etYear = findViewById(R.id.year);
        tvId = findViewById(R.id.id);

        Intent i = getIntent();
        data = (Song) i.getSerializableExtra("data");

        etTitle.setText(data.getTitle());
        etSingers.setText(data.getSingers());
        etYear.setText(data.getYear());
        tvId.setText(data.getId());
        for (int y = 0; y < rgStars.getChildCount(); y++) {
            View view = rgStars.getChildAt(y);
            if (view instanceof RadioButton) {
                RadioButton radioButton = (RadioButton) view;
                int radioButtonStars = Integer.parseInt(radioButton.getText().toString());
                if (data.getStar() == radioButtonStars) {
                    radioButton.setChecked(true);
                    break; // Once the matching radio button is found and selected, exit the loop
                }
            }
        }

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(EditActivity.this);
                data.setTitle(etTitle.getText().toString());
                data.set_id(Integer.parseInt(tvId.getText().toString()));
                data.setSingers(etSingers.getText().toString());
                data.setYear(Integer.parseInt(etYear.getText().toString()));
                dbh.updateSong(data);
                dbh.close();
                finish();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(EditActivity.this);
                dbh.deleteNote(data.getId());

                finish();
            }
        });
    }
}
