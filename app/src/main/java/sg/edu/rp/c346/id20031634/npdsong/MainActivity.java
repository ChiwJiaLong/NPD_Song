package sg.edu.rp.c346.id20031634.npdsong;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText ettitle,etsingers,etyear;
    Button btninsert, btnshowlist;
    RadioGroup rgstar;
    ArrayList al;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ettitle = findViewById(R.id.etTitle);
        etsingers = findViewById(R.id.etSingers);
        etyear = findViewById(R.id.etYears);
        btninsert = findViewById(R.id.btnInsert);
        btnshowlist = findViewById(R.id.btnshowlist);
        rgstar = findViewById(R.id.rstar);
        al = new ArrayList<Song>();

        btninsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = ettitle.getText().toString();
                String singer = etsingers.getText().toString();
                int year = Integer.parseInt(etyear.getText().toString());
                DBHelper dbh = new DBHelper(MainActivity.this);
                long inserted_id = dbh.insertSong(title,singer,year,getStars());

                if (inserted_id != -1) {
                    al.clear();
                    al.add(dbh.getAllSongs());
                    Toast.makeText(MainActivity.this, "Insert successful",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnshowlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DisplayActivity.class);
                startActivity(intent);
            }
        });
    }
    private int getStars() {
        int stars = 1;
        if(rgstar.getCheckedRadioButtonId() == R.id.r1) {
            stars = 1;
        }
        else if(rgstar.getCheckedRadioButtonId() == R.id.r2) {
            stars = 2;
        }
        else if(rgstar.getCheckedRadioButtonId() == R.id.r3) {
            stars = 3;
        }
        else if(rgstar.getCheckedRadioButtonId() == R.id.r4) {
            stars = 4;
        }
        else if(rgstar.getCheckedRadioButtonId() == R.id.r5) {
            stars = 5;
        }
        return stars;
    }
}