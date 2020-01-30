package com.example.csebook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

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
import com.rengwuxian.materialedittext.MaterialEditText;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_layout,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id)
        {
            case R.id.aboutId:
                startActivity(new Intent(getApplicationContext(),AboutActivity.class));
                break;
            case R.id.exitId:
                ExitDialog();
                break;
            case R.id.requestBookId:
                showDailog();
                break;
        }
        return true;
    }


    public void showDailog()
    {
        final AlertDialog.Builder dialog = new AlertDialog.Builder(this);

        dialog.setTitle("Request For Book");
        dialog.setMessage("Provide us your valueable feedback");

        LayoutInflater inflater = LayoutInflater.from(this);

        final View reg_layout = inflater.inflate(R.layout.activity_feedback,null);

        final MaterialEditText name = reg_layout.findViewById(R.id.nameId);
        final MaterialEditText phone = reg_layout.findViewById(R.id.phoneId);
        final MaterialEditText email = reg_layout.findViewById(R.id.emailId);
        final MaterialEditText message = reg_layout.findViewById(R.id.messageId);

        dialog.setView(reg_layout);

        //set button

        dialog.setPositiveButton("SEND", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {


                //check validation

                if (TextUtils.isEmpty(name.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "Please Type Your Name", Toast.LENGTH_SHORT).show();
                    return;
                }if (TextUtils.isEmpty(phone.getText().toString()))
                {
                    Toast.makeText(getApplicationContext(), "Please Type Your Phone Number", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(email.getText().toString()))
                {
                    Toast.makeText(getApplicationContext(), "Please Type Your Email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(message.getText().toString()))
                {
                    Toast.makeText(getApplicationContext(), "Please Type Message", Toast.LENGTH_SHORT).show();
                    return;
                }


                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference();

                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Object value = dataSnapshot.getValue();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Toast.makeText(getApplicationContext(), "Failed To read Value", Toast.LENGTH_SHORT).show();
                    }
                });

                myRef.child("Users").child(name.getText().toString()).child("Name").setValue(name.getText().toString());
                myRef.child("Users").child(name.getText().toString()).child("Phone").setValue(phone.getText().toString());
                myRef.child("Users").child(name.getText().toString()).child("Email").setValue(email.getText().toString());
                myRef.child("Users").child(name.getText().toString()).child("Message").setValue(message.getText().toString());

                Toast.makeText(getApplicationContext(), "Thanks For Your Feedback...", Toast.LENGTH_SHORT).show();

            }
        });

        dialog.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        dialog.show();
    }


    public boolean ExitDialog()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Do You Want To Exit ?");
        builder.setCancelable(true);

        builder.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });

        builder.setPositiveButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();

        return true;
    }
}
