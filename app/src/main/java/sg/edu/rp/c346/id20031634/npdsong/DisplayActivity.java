package sg.edu.rp.c346.id20031634.npdsong;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class DisplayActivity extends AppCompatActivity {
    Button btnshow;
    ListView lv;
    ArrayList<Song> al;
    ArrayAdapter<Song> aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        btnshow = findViewById(R.id.btnshow);
        lv = findViewById(R.id.lv);

        DBHelper dbh = new DBHelper(DisplayActivity.this);

        al = new ArrayList<>();
        al = dbh.getAllSongs();
        aa = new ArrayAdapter<Song>(DisplayActivity.this, android.R.layout.simple_list_item_1, al);
        lv.setAdapter(aa);
        aa.notifyDataSetChanged();

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int
                    position, long identity) {
                Song data = al.get(position);
                Intent i = new Intent(DisplayActivity.this,
                        EditActivity.class);
                i.putExtra("data", data);
                startActivity(i);
            }
        });
        btnshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                al.addAll(dbh.getAllSongsByStars(5));
                lv.setAdapter(aa);
                aa.notifyDataSetChanged();

            }
        });

    }
}