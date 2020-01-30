package com.example.csebook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.BaseMultiplePermissionsListener;
import com.rengwuxian.materialedittext.MaterialEditText;

import java.util.List;

public class MainActivity extends BaseActivity  implements View.OnClickListener {

    private CardView firstcardview;
    private CardView secondcardview;
    private CardView thirdcardview;
    private CardView fourthcardview;
    private CardView fifthcardview;
    private CardView sixthcardview;
    private CardView seventhcardview;
    private CardView eighthcardview;

    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        implemenatation();
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Dexter.withActivity(this).withPermissions(Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .withListener(new BaseMultiplePermissionsListener(){
                    @Override
                    public void onPermissionsChecked(MultiplePermissionsReport report) {
                        super.onPermissionsChecked(report);
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                        super.onPermissionRationaleShouldBeShown(permissions, token);
                    }
                }).check();



    }


    /*@Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage("Are you sure you wan to Exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        MainActivity.super.onBackPressed();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }*/
    private void implemenatation() {
        //Id declear//
        firstcardview = findViewById(R.id.firstId);
        secondcardview = findViewById(R.id.secondId);
        thirdcardview = findViewById(R.id.thiredId);
        fourthcardview = findViewById(R.id.fourId);
        fifthcardview = findViewById(R.id.fiveId);
        sixthcardview = findViewById(R.id.sixId);
        seventhcardview = findViewById(R.id.sevenId);
        eighthcardview = findViewById(R.id.eightId);

        //Action Lisener Call//
        firstcardview.setOnClickListener(this);
        secondcardview.setOnClickListener(this);
        thirdcardview.setOnClickListener(this);
        fourthcardview.setOnClickListener(this);
        fifthcardview.setOnClickListener(this);
        sixthcardview.setOnClickListener(this);
        seventhcardview.setOnClickListener(this);
        eighthcardview.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.firstId:
                Intent intent1 = new Intent(MainActivity.this,FirstActivity.class);
                startActivity(intent1);
                break;
            case R.id.secondId:
                Intent intent2 = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent2);
                break;
            case R.id.thiredId:
                Intent intent3 = new Intent(MainActivity.this,ThirdActivity.class);
                startActivity(intent3);
                break;
            case R.id.fourId:
                Intent intent4 = new Intent(MainActivity.this,FourthActivity.class);
                startActivity(intent4);
                break;
            case R.id.fiveId:
                Intent intent5 = new Intent(MainActivity.this,FifthActivity.class);
                startActivity(intent5);
                break;
            case R.id.sixId:
                Intent intent6 = new Intent(MainActivity.this,SixthActivity.class);
                startActivity(intent6);
                break;
            case R.id.sevenId:
                Intent intent7 = new Intent(MainActivity.this,SeventhActivity.class);
                startActivity(intent7);
                break;
            case R.id.eightId:
                Intent intent8 = new Intent(MainActivity.this,EightActivity.class);
                startActivity(intent8);
                break;
        }
    }



}
