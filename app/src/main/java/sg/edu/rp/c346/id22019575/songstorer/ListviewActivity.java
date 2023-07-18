package sg.edu.rp.c346.id22019575.songstorer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ListviewActivity extends AppCompatActivity {
    ListView lv;
    Song data;
    ArrayList<Song> al;
    //ArrayAdapter<Song> aa;
    CustomAdapter customAdapter;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        lv = findViewById(R.id.lv);
        button = findViewById(R.id.button);

        Intent i = getIntent();
        data = (Song) i.getSerializableExtra("data");

        al = new ArrayList<Song>();
        //aa = new ArrayAdapter<Song>(this,
         //       android.R.layout.simple_list_item_1, al);
        //lv.setAdapter(aa);
        customAdapter = new CustomAdapter(this, R.layout.row, al);
        lv.setAdapter(customAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Song song = al.get(position);
                Intent i = new Intent(ListviewActivity.this,
                        EditActivity.class);
                i.putExtra("data", (CharSequence) song);
                startActivity(i);

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show only songs with 5 stars
                showSongsWithFiveStars();
            }
        });

    }

    private void showSongsWithFiveStars() {
        al.clear();
        for (Song song : al) {
            if (song.getStar() == 5) {
                al.add(song);
            }
        }
        customAdapter.notifyDataSetChanged();
    }

}
