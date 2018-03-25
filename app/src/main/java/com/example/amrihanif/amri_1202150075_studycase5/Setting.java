package com.example.amrihanif.amri_1202150075_studycase5;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Setting extends AppCompatActivity {
    int color;
    TextView colors;
    AlertDialog.Builder builder;
    SharedPreferences.Editor edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        //deklarasi objek yang digunakan
        builder = new AlertDialog.Builder(this);

        //Mendapatkan SharedPreference dan menentukan editor untuk SharedPreference
        SharedPreferences pref = getApplicationContext().getSharedPreferences("pref", 0);
        edit = pref.edit();
        color = pref.getInt("background", R.color.red);
        colors = findViewById(R.id.bebas);
        colors.setText(getWarna(color));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            this.onBackPressed();
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(Setting.this, MainActivity.class));
        finish();
    }



    //Method untuk mendapatkan String warna
    public String getWarna(int i) {
        if (i == R.color.green) {
            return "Green";
        } else if (i == R.color.blue) {
            return "Blue";
        } else {
            return "Red";
        }
    }

    //Method untuk mendapatkan id warna
    public int getIntColor(int i) {
        if (i == R.color.green) {
            return R.id.green;
        } else if (i == R.color.blue) {
            return R.id.blue;
        } else {
            return R.id.red;
        }
    }

    public void pilihWarna(View view) {
        builder.setTitle("Choose Color");
        View v = getLayoutInflater().inflate(R.layout.pilihwarna, null);
        builder.setView(v);

        //Menentukan radiobutton yang dipilih
        final RadioGroup rg = v.findViewById(R.id.grup);
        rg.check(getIntColor(color));

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                int check = rg.getCheckedRadioButtonId();
                switch (check) {
                    case R.id.blue:
                        color = R.color.blue;
                        break;
                    case R.id.green:
                        color = R.color.green;
                        break;
                    case R.id.red:
                        color = R.color.red;
                        break;
                }

                //Mengatur SharedPreference
                colors.setText(getWarna(color));
                edit.putInt("background", color);
                edit.commit();
            }
        });

        //Method ketika menekan Cancel
        builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                }
        );

        //Menampilkan choosecolors
        builder.create().show();
    }
}