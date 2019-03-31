package com.appy.cardview;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;
import java.lang.Thread;

public class MainActivity extends AppCompatActivity {


    private ProgressBar pb1;
    private ProgressBar pb2;
    private ProgressBar pb3;
    private ImageView im1;
    private int mps1=0;
    private int mps2=0;
    private int mps3=0;
    private Handler psh1=new Handler();
    private Handler psh2=new Handler();
    private Handler psh3=new Handler();
    private LinearLayout c1;
    private LinearLayout c2;

    private int l;
    private Runnable r;
    private double ti;
    private boolean b=true;
    public  void cord(int n)
    {
        l=n;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        pb1=(ProgressBar) findViewById(R.id.pb1);
        pb2=(ProgressBar) findViewById(R.id.pb2);
        pb3=(ProgressBar) findViewById(R.id.pb3);
        im1=(ImageView) findViewById(R.id.imageView);
        c1=(LinearLayout) findViewById(R.id.c1);
        c2=(LinearLayout) findViewById(R.id.c2);



        final int f[]={R.drawable.mm1,R.drawable.mm2,R.drawable.mm3};
        r =new Runnable() {
            @Override
            public void run() {

                while(true) {
                    //mps2=0;
                    //im1.setImageResource(f[0]);
                    while (mps1 < 100 && l==0) {

                        if(b)
                        mps1++;
                        android.os.SystemClock.sleep(30);
                        if(b)
                        psh1.post(new Runnable() {
                            @Override
                            public void run() {

                                pb1.setProgress(mps1);
                                im1.setImageResource(f[0]);
                                c1.setOnTouchListener(new View.OnTouchListener() {
                                    @Override
                                    public boolean onTouch(View v, MotionEvent event) {
                                        switch (event.getAction()){
                                            case MotionEvent.ACTION_DOWN:
                                                b=false;

                                                return true;

                                            case MotionEvent.ACTION_UP:
                                                b=true;
                                                ti=event.getEventTime()-event.getDownTime();
                                                //Toast.makeText(getApplicationContext(),String.valueOf(ti),Toast.LENGTH_SHORT).show();
                                                break;
                                        }
                                        return false;
                                    }
                                });
                                c2.setOnTouchListener(new View.OnTouchListener() {
                                    @Override
                                    public boolean onTouch(View v, MotionEvent event) {
                                        switch (event.getAction()){
                                            case MotionEvent.ACTION_DOWN:
                                                b=false;
                                                return true;

                                            case MotionEvent.ACTION_UP:
                                                b=true;
                                                ti=event.getEventTime()-event.getDownTime();
                                                //Toast.makeText(getApplicationContext(),String.valueOf(ti),Toast.LENGTH_SHORT).show();
                                                if(ti<100)
                                                {mps1 = 100;

                                                cord(1);}


                                                break;
                                        }
                                        return false;
                                    }
                                });



                            }
                        });

                    }
                    if(l!=2) {
                        cord(1);
                    }

                    while (mps2 < 100 && l==1) {
                        if(b)
                        mps2++;
                        android.os.SystemClock.sleep(30);
                        if(b)
                        psh2.post(new Runnable() {
                            @Override
                            public void run() {
                                pb2.setProgress(mps2);
                                im1.setImageResource(f[1]);

                                c1.setOnTouchListener(new View.OnTouchListener() {
                                    @Override
                                    public boolean onTouch(View v, MotionEvent event) {
                                        switch (event.getAction()){
                                            case MotionEvent.ACTION_DOWN:
                                                b=false;
                                                return true;

                                            case MotionEvent.ACTION_UP:
                                                b=true;
                                                ti=event.getEventTime()-event.getDownTime();
                                               // Toast.makeText(getApplicationContext(),String.valueOf(ti),Toast.LENGTH_SHORT).show();
                                                if(ti<100)
                                                {mps3 = 100;
                                                cord(0);}

                                                break;
                                        }
                                        return false;
                                    }
                                });
                                c2.setOnTouchListener(new View.OnTouchListener() {
                                    @Override
                                    public boolean onTouch(View v, MotionEvent event) {
                                        switch (event.getAction()){
                                            case MotionEvent.ACTION_DOWN:
                                                b=false;

                                                return true;

                                            case MotionEvent.ACTION_UP:
                                                b=true;
                                                ti=event.getEventTime()-event.getDownTime();
                                                //Toast.makeText(getApplicationContext(),String.valueOf(ti),Toast.LENGTH_SHORT).show();
                                                if(ti<100)
                                                {mps2 = 100;

                                                cord(2);}

                                                break;
                                        }
                                        return false;
                                    }
                                });


                            }
                        });
                    }
                    cord(2);
                    while (mps3 < 100 && l==2) {
                        if(b)
                        mps3++;
                        android.os.SystemClock.sleep(30);
                        if(b)
                        psh3.post(new Runnable() {
                            @Override
                            public void run() {
                                pb3.setProgress(mps3);
                                im1.setImageResource(f[2]);
                                c1.setOnTouchListener(new View.OnTouchListener() {
                                    @Override
                                    public boolean onTouch(View v, MotionEvent event) {
                                        switch (event.getAction()){
                                            case MotionEvent.ACTION_DOWN:
                                                b=false;

                                                return true;

                                            case MotionEvent.ACTION_UP:
                                                b=true;
                                                ti=event.getEventTime()-event.getDownTime();
                                                //Toast.makeText(getApplicationContext(),String.valueOf(ti),Toast.LENGTH_SHORT).show();
                                                if(ti<100)
                                                {mps3=0;
                                                cord(1);}

                                                break;
                                        }
                                        return false;
                                    }
                                });
                                c2.setOnTouchListener(new View.OnTouchListener() {
                                    @Override
                                    public boolean onTouch(View v, MotionEvent event) {
                                        switch (event.getAction()){
                                            case MotionEvent.ACTION_DOWN:
                                                b=false;

                                                return true;

                                            case MotionEvent.ACTION_UP:
                                                b=true;
                                                ti=event.getEventTime()-event.getDownTime();
                                                //Toast.makeText(getApplicationContext(),String.valueOf(ti),Toast.LENGTH_SHORT).show();
                                                if(ti<100)
                                                {mps3 = 100;

                                                cord(0);}


                                                break;
                                        }
                                        return false;
                                    }
                                });

                            }
                        });
                    }
                   if(l!=1)
                       cord(0);
                    mps2=0;
                    pb2.setProgress(mps2);
                    mps1 = 0;

                    mps3=0;
                    pb3.setProgress(mps3);


                }

            }

            };


        new Thread(r).start();



    }

}
