package com.example.csebook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import java.util.Calendar;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Element adsElement = new Element();
        adsElement.setTitle("Adverties here");

        View aboutPage = new AboutPage(this)
                .isRTL(false)
                .setImage(R.drawable.towhid1)
                .setDescription("BGCTUB CSE BooK")
                .addItem(new Element().setTitle("Version 1.0"))
                .addItem(adsElement)
                .addGroup("Connect with us")
                .addEmail("towhidulislamcse@gmail.com")
                .addWebsite("towhiduli3.blogspot.com")
                .addFacebook("towhiduli3","Towhidul Islam")
                .addTwitter("towhiduli3","Towhidul Islam")
                .addYoutube("UC9D7SyqO95GBn-X14FXNPPQ")
                .addGitHub("towhidJ")
                .addItem(createCopyRight())
                .create();

        setContentView(aboutPage);

    }

    private Element createCopyRight() {
        final Element copyright = new Element();

        final String copyrightString = String.format("\u00a9 Copyright %d by Towhidul Islam", Calendar.getInstance().get(Calendar.YEAR));
        copyright.setTitle(copyrightString);
//        copyright.setIconDrawable(R.mipmap.ic_launcher);
        copyright.setGravity(Gravity.CENTER);
        copyright.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AboutActivity.this, copyrightString, Toast.LENGTH_SHORT).show();
            }
        });
        return copyright;
    }
}
