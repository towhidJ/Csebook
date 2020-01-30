package com.example.csebook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.Manifest;
import android.app.ProgressDialog;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnDrawListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.listener.OnPageErrorListener;
import com.github.barteksc.pdfviewer.listener.OnRenderListener;
import com.github.barteksc.pdfviewer.listener.OnTapListener;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.listener.multi.BaseMultiplePermissionsListener;
import com.karumi.dexter.listener.single.BasePermissionListener;
import com.krishna.fileloader.FileLoader;
import com.krishna.fileloader.listener.FileRequestListener;
import com.krishna.fileloader.pojo.FileResponse;
import com.krishna.fileloader.request.FileLoadRequest;

import java.io.File;
import java.util.Collections;

public class PdfViewActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private PDFView myPdfViewer;
    private WebView webView;
    ProgressBar progressBar;
    ProgressDialog progressDialog;
    private int progressStatus = 0;
    private Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_view);


        implemenatation();
    }

    private void implemenatation() {
        progressDialog = new ProgressDialog(this);
        myPdfViewer = findViewById(R.id.pdfViewer);
        progressBar = findViewById(R.id.progressBarId);
        Bundle bundle = getIntent().getExtras();
        if (bundle!=null)
        {


            String title = bundle.getString("item");
            firstSemester(title);
            secondSemester(title);
            thirdSemester(title);
            fourSemester(title);
            fiveSemester(title);
            sixSemester(title);
            sevenSemester(title);
            eightSemester(title);


        }
    }



    //Start Book select Method//
    void firstSemester(String title)
    {
        if(title.equals("Programming in Ansi C")){
            pdfDownload("https://www.dropbox.com/s/1f25xgmjt8bsyb8/Programming-in-ANSI-C.pdf?dl=1");
        }else if (title.equals("Introduction To computers"))
        {
            pdfDownload("https://www.dropbox.com/s/z9jym4ci8r8ga5l/introduction-to-computers-by-peter-norton-6th-ed.pdf?dl=1");
        }else if (title.equals("Accounting Principles"))
        {
            pdfDownload("https://www.dropbox.com/s/8bz0mn9sqorz503/Accounting%20Principles%209th%20Edition%20by%20Weygandt%2C%20Kieso%20%26%20Kimmel.pdf?dl=1");
        }else if (title.equals("Differential Calculas"))
        {
            pdfDownload("https://www.dropbox.com/s/giggj6lu5vqwv6q/engineeringmathematics-hkdass.pdf?dl=1");
        }
        else if (title.equals("কম্পিউটার প্রোগ্রামিং"))
        {
            pdfDownload("https://www.dropbox.com/s/pg1hrwk2a2y5k6s/computer%20programming.pdf?dl=1");
        }
        else if (title.equals("প্রোগ্রামিংয়ে হাতেখড়ি"))
        {
            pdfDownload("https://www.dropbox.com/s/4m0yaq419fj7x59/programming%20e%20hate%20khori.pdf?dl=1");
        }
    }

    void secondSemester(String title)
    {
        if (title.equals("Programming With c++")) {
            pdfDownload("https://www.dropbox.com/s/ppd2xi07wvekl4a/schoums%20outlines%20programming%20with%20c%2B%2B%20by%20john%20r%20hubbard%202e.pdf?dl=1");
        }else if (title.equals("Data Structure With c")) {
            pdfDownload("https://www.dropbox.com/s/pfi1lsifinqbibi/schaum%27s%20outline%20of%20data%20structures%20with%20c.pdf?dl=1");
        }
        else if (title.equals("Advance Engineering Mathematics(Math-II)")) {
            pdfDownload("https://www.dropbox.com/s/giggj6lu5vqwv6q/engineeringmathematics-hkdass.pdf?dl=1");
        }
        else if (title.equals("Professional Ethics of Computing")) {
            pdfDownload("https://www.dropbox.com/s/lzfsxozke3i58q6/security-in-computing-5-e-charles-p-pfleeger-pdf.pdf?dl=1");
        }
        else if (title.equals("Basic Electrical Circuit"))
        {
            pdfDownload("https://www.dropbox.com/s/wgwbj9jxr71o803/Basic%20Electrical%20circuit.pdf?dl=1");
        }

    }
    void thirdSemester(String title)
    {
        if (title.equals("Discrete Mathematics"))
        {
            pdfDownload("https://www.dropbox.com/s/85qbehwhb1ma0yp/Discrete%20Mathematics%20and%20Its%20Applications%20Seventh%20Edition%20by%20Kenneth%20H.%20Rosen.pdf?dl=1");
        }
        else if (title.equals("Advance Engineering Mathematics(Math-III)")) {
            pdfDownload("https://www.dropbox.com/s/giggj6lu5vqwv6q/engineeringmathematics-hkdass.pdf?dl=1");
        }
        else if (title.equals("Basic Electronics"))
        {
            pdfDownload("https://www.dropbox.com/s/ory91c3dn7sd936/Electronic%20Devices%20and%20Circuit%20Theory%2011th%20Ed.pdf?dl=1");
        }
        else if (title.equals("Java Programming"))
        {
            pdfDownload("https://www.dropbox.com/s/w1mwf169ftdmd9a/%5BG%5D%20java-wrox-Beginning%20Java%205%200%202005%20.pdf?dl=1");
        }
        else if (title.equals("Digital Logic Design"))
        {
            pdfDownload("https://www.dropbox.com/s/899wii43gc8mus3/Digital_Logic_and_Computer_Design_Morris.pdf?dl=1");
        }


    }
    void fourSemester(String title){
        if (title.equals("Computer Algorithms"))
        {
            pdfDownload("https://www.dropbox.com/s/u8m58svjlfq21r7/Horowitz_and_sahani_fundamentals_of_comp.pdf?dl=1");
        }
        else if (title.equals("Advance Engineering Mathematics(Math-IV)")) {
            pdfDownload("https://www.dropbox.com/s/giggj6lu5vqwv6q/engineeringmathematics-hkdass.pdf?dl=1");
        }
        else if (title.equals("Beginning Php5(INC)"))
        {
            pdfDownload("https://www.dropbox.com/s/tb4sim66jn8gyeu/PHP.pdf?dl=1");

        }else if (title.equals("Computer Architecture"))
        {
            pdfDownload("https://www.dropbox.com/s/e6t4k7dbs7msn0h/john_-L_Hennessy_and_David_A_Patterson_c.pdf?dl=1");
        }
        else  if (title.equals("Numerical Analysis"))
        {
            pdfDownload("https://www.dropbox.com/s/u2jmsgfwnwqutt6/numerical%20methods%20for%20engineers%20by%20steven%20c.%20chapra%2C%20raymond%20p.%20canale%206e.pdf?dl=1");
        }
    }

    void fiveSemester(String title)
    {
        if (title.equals("Database Systems")){
            pdfDownload("https://www.dropbox.com/s/4vrpw6lszfg3ndk/Database%20System%20Concepts%206e%20By%20Abraham%20Silberschatz%2C%20Henry%20Korth%20and%20S%20Sudarshan.pdf?dl=1");
        }else if (title.equals("Data Communication & Networking"))
        {
            pdfDownload("https://www.dropbox.com/s/qwuhzm6k1p6qf3u/Data_Communication_and_Networking_by_Behrouz.A.Forouzan_4th.edition.pdf?dl=1");
        }else if (title.equals("Operating Systems"))
        {
            pdfDownload("https://www.dropbox.com/s/lggky3ef09h85jz/Operating_System_Concepts%20_8th_Edition%20A4%20.pdf?dl=1");
        }else if (title.equals("System analysis and Design"))
        {
            pdfDownload("https://www.dropbox.com/s/z7cfvgodlosafje/System%20Analysis%20and%20Design%209e%20-%20Shelly%20Cashman.pdf?dl=1");
        }else if (title.equals("The INTEL Microprocessors"))
        {
            pdfDownload("https://www.dropbox.com/s/v6vnwxm6tkbrjgd/intel%20microprocessors%20by%20barry%20b.%20brey%208e.pdf?dl=1");
        }

    }
    void sixSemester(String title)
    {
        if (title.equals("Computer Networks")){
            pdfDownload("https://www.dropbox.com/s/zgr3msfat6mmapj/Computer-Networks---A-Tanenbaum---5th-edition.pdf?dl=1");
        }else if (title.equals("Computer Modeling and Simulation"))
        {
            pdfDownload("https://www.dropbox.com/s/9zv69qomb7qpi6v/Discrete%20Event%20System%20Simulation%20%28Fifth%20Edition%29%20.pdf?dl=1");
        }else if (title.equals("The INTEL Microprocessors(CPI)"))
        {
            pdfDownload("https://www.dropbox.com/s/v6vnwxm6tkbrjgd/intel%20microprocessors%20by%20barry%20b.%20brey%208e.pdf?dl=1");
        }else if (title.equals("Introduction to Compiler"))
        {
            pdfDownload("https://www.dropbox.com/s/56xvrw5x169uexw/Compilers.pdf?dl=1");

        }else if (title.equals("Theory of Computing"))
        {
            pdfDownload("https://www.dropbox.com/s/qxa4cgsfm26pz4n/introduction%20to%20the%20theory%20of%20computation%203e%20by%20michael%20sipser.pdf?dl=1");
        }else if (title.equals("Software Engineering"))
        {
            pdfDownload("https://www.dropbox.com/s/6g0zf1boupgboxu/RPL-7th_ed_software_engineering_a_practitioners_approach_by_roger_s._pressman_%20%281%29.pdf?dl=1");
        }

    }
    void sevenSemester(String title)
    {
        if (title.equals("Fuzzy Logic and Neural Networks")){

        }else if (title.equals("Artificial Intelligence"))
        {
            pdfDownload("https://www.dropbox.com/s/9dl0h7h1x24p8yp/artificial%20intelligence%20a%20moder%20approach%20by%20russell%2C%20norvig%203e.pdf?dl=1");
        }else if (title.equals("Telecommunication Engineering"))
        {
            pdfDownload("https://www.dropbox.com/s/mzypgm4lfle3fgp/Mobile_Communication-_john_schiller-%20By%20EasyEngineering.net.pdf?dl=1");
        }else if (title.equals("Digital System Design"))
        {
            pdfDownload("https://www.dropbox.com/s/899wii43gc8mus3/Digital_Logic_and_Computer_Design_Morris.pdf?dl=1");
        }else if (title.equals("Cryptography and Network security"))
        {
            pdfDownload("https://www.dropbox.com/s/lzfsxozke3i58q6/security-in-computing-5-e-charles-p-pfleeger-pdf.pdf?dl=1");
        }

    }
    void eightSemester(String title)
    {
        if (title.equals("Computer Graphics")){
            pdfDownload("https://www.dropbox.com/s/7gz32agycho49b5/schaum%27s%20outlines%20computer%20graphics%202e.pdf?dl=1");
        }else if (title.equals("Digital Signal Processing"))
        {
            pdfDownload("https://www.dropbox.com/s/ie3069yrjymbvhb/4th%20Digital%20Signal%20Processing%20-%20Proakis%20and%20Manolakis.pdf?dl=1");
        }
    }

    //End Book select Method//

    void pdfDownload(String url){


        progressDilogbar();
        FileLoader.with(this).load(url).fromDirectory("CSE Book",FileLoader.DIR_EXTERNAL_PUBLIC).asFile(new FileRequestListener<File>() {
            @Override
            public void onLoad(FileLoadRequest request, FileResponse<File> response) {
                //progressBar.setVisibility(View.GONE);
                progressDialog.dismiss();
                File pdfFile = response.getBody();
                myPdfViewer.fromFile(pdfFile).password(null).defaultPage(0).enableSwipe(true)
                        .swipeHorizontal(false).enableDoubletap(true)
                        .onDraw(new OnDrawListener() {
                            @Override
                            public void onLayerDrawn(Canvas canvas, float pageWidth, float pageHeight, int displayedPage) {

                            }
                        })
                        .onDrawAll(new OnDrawListener() {
                            @Override
                            public void onLayerDrawn(Canvas canvas, float pageWidth, float pageHeight, int displayedPage) {

                            }
                        })
                        .onPageError(new OnPageErrorListener() {
                            @Override
                            public void onPageError(int page, Throwable t) {
                                Toast.makeText(PdfViewActivity.this, "Error", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .onPageChange(new OnPageChangeListener() {
                            @Override
                            public void onPageChanged(int page, int pageCount) {

                            }
                        })

                        .onTap(new OnTapListener() {
                            @Override
                            public boolean onTap(MotionEvent e) {
                                return true;
                            }
                        }).onRender(new OnRenderListener() {
                    @Override
                    public void onInitiallyRendered(int nbPages, float pageWidth, float pageHeight) {
                        myPdfViewer.fitToWidth();
                    }
                })
                        .enableAnnotationRendering(true)
                        .invalidPageColor(Color.WHITE)
                        .load();

            }

            @Override
            public void onError(FileLoadRequest request, Throwable t) {
                Toast.makeText(PdfViewActivity.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
                //progressBar.setVisibility(View.GONE);
                progressDialog.dismiss();
            }
        });
    }

    void progressDilogbar()
    {
        //progressBar.setVisibility(View.VISIBLE);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        //Without this user can hide loader by tapping outside screen
        progressDialog.setCancelable(false);
        progressDialog.setMessage("File Downloading please Wait");
        progressDialog.show();
        // Start Process Operation in a background thread
        new Thread(new Runnable() {
            public void run() {
                while (progressStatus < 100) {
                    try{
                        // This is mock thread using sleep to show progress
                        Thread.sleep(300);
                        progressStatus += 5;
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    // Change percentage in the progress bar
                    handler.post(new Runnable() {
                        public void run() {
                            progressDialog.setProgress(progressStatus);
                        }
                    });
                }
            }
        }).start();
    }
}
