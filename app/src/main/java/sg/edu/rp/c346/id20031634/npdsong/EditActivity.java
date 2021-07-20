package sg.edu.rp.c346.id20031634.npdsong;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class EditActivity extends AppCompatActivity {
    EditText etId,ettitle,etsingers,etyear;
    Button btndelete, btnupdate,btncancel;
    RadioGroup rgstar;
    RadioButton r1,r2,r3,r4,r5;
    Song song;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        etId = findViewById(R.id.etID);
        ettitle = findViewById(R.id.etTitle);
        etsingers = findViewById(R.id.etsingers);
        etyear = findViewById(R.id.etYears);
        r1 = findViewById(R.id.r1);
        r2 = findViewById(R.id.r2);
        r3 = findViewById(R.id.r3);
        r4 = findViewById(R.id.r4);
        r5 = findViewById(R.id.r5);
        btncancel = findViewById(R.id.btnCancel);
        btndelete = findViewById(R.id.btnDelete);
        btnupdate = findViewById(R.id.btnUpdate);

        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(EditActivity.this);
                dbh.deleteSong(song.get_id());
                finish();

            }
        });

        btncancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });

        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                song.setTitle(ettitle.getText().toString());
                song.setSingers(etsingers.getText().toString());
                song.setYear(Integer.parseInt(etyear.getText().toString()));
                song.setStars(getStars());
            }
        });

        Intent i = getIntent();
        song =(Song) i.getSerializableExtra("song");
        etId.setText(String.valueOf(song.get_id()));
        ettitle.setText(song.getTitle());
        etsingers.setText(song.getSingers());
        etyear.setText(song.getYear());
        int stars = song.getStars();
        if(stars == 1){
            r1.setChecked(true);
        }
        if(stars == 2){
            r1.setChecked(true);
        }
        if(stars == 3){
            r1.setChecked(true);
        }
        if(stars == 4){
            r1.setChecked(true);
        }
        if(stars == 5){
            r1.setChecked(true);
        }



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