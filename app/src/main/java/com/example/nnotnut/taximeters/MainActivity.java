package com.example.nnotnut.taximeters;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase mDb;
   static MyDbHelper mHelper;
    double tmp = 0.0;
    double tmpshort = 0.0;
    double tmplong = 0.0;
    String test[] = {"0","1","10","20","40","60","80"};
//    final AlertDialog.Builder dDialog = new AlertDialog.Builder(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mainContent();
    }

    public void mainContent() {
        mHelper = new MyDbHelper(this);
        mDb = mHelper.getWritableDatabase();
        setContentView(R.layout.activity_main);
        Button predictBtn = (Button) findViewById(R.id.button);
        predictBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                predictCalContent();
            }
        });

        Button realBtn = (Button) findViewById(R.id.button1);
        realBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realtimeCalContent();
            }
        });
    }

    public void predictCalContent() {

        setContentView(R.layout.predict);
        final Button preDictCalBtn = (Button) findViewById(R.id.button4);
        preDictCalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText e = (EditText) findViewById(R.id.editText3);
                String s = String.valueOf(e.getText());
                EditText e1 = (EditText) findViewById(R.id.editText4);
                String s1 = String.valueOf(e1.getText());
                RadioButton r = (RadioButton) findViewById(R.id.radioButton);
                RadioButton r1 = (RadioButton) findViewById(R.id.radioButton7);
                RadioButton r2 = (RadioButton) findViewById(R.id.radioButton8);
                RadioButton r3 = (RadioButton) findViewById(R.id.radioButton9);
                ;

                // input shorthway and longway
                if (s.equalsIgnoreCase("") || s1.equalsIgnoreCase("")) {
                    Toast.makeText(MainActivity.this, "Please enter distance", Toast.LENGTH_LONG).show();
                }
                //select levels traffic jams
                else if (!(r.isChecked() || r1.isChecked() || r2.isChecked() || r3.isChecked())) {
//                        log.d("",r.isSelected());
                    Toast.makeText(MainActivity.this, "Please select traffic jam levels", Toast.LENGTH_LONG).show();
                }
                // longway > shortway
                else if( Double.valueOf(s) >= Double.valueOf(s1) ){
                    Toast.makeText(MainActivity.this,"Longdistance should be more than shortdistance",Toast.LENGTH_LONG).show();
                }
                //calculate taxi service
                else {
                    tmpshort = cal(s);
                    tmplong = cal(s1);

                    // radiobutton Traffic jams (Low Medium High)
                    // low
                    if(r1.isChecked()){
                        tmpshort = tmpshort + caltraf(15);
                        tmplong = tmplong + caltraf(15);
                    }
                    //Medium
                    else if(r2.isChecked()){
                        tmpshort = tmpshort + caltraf(30);
                        tmplong = tmplong + caltraf(30);
                    }
                    //High
                    else if(r3.isChecked()){
                        tmpshort = tmpshort + caltraf(60);
                        tmplong = tmplong + caltraf(60);
                    }

                    tmplong = calper(tmplong);
//                    tmpshort = calper(tmpshort);

                    for(int i =0;i<test.length;i++){
                        Log.d("Distance","distance : "+test[i]);
                        Log.d("No traffic jams","distance "+test[i]+" : "+(cal(test[i]) + caltraf(0)));
                        Log.d("traffic jams","distance "+test[i]+" "+(cal(test[i]) + caltraf(15)));
                        Log.d("raffic jams","distance "+test[i]+" "+(cal(test[i]) + caltraf(30)));
                        Log.d("traffic jams","distance "+test[i]+" "+(cal(test[i]) + caltraf(60)));
                    }


//                    Log.d("No traffic jams",r.isSelected());
//                    Log.d("No traffic jams",r.isSelected());
//                    Log.d("No traffic jams",r.isSelected());







                    serviceChargeContent();
                }


            }
        });
    }

    public void realtimeCalContent() {
        setContentView(R.layout.realtime);
        Button realCalBtn = (Button) findViewById(R.id.realtimeCalBtn);
        realCalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                serviceChargeContent();
            }
        });
    }

    public void serviceChargeContent() {
        setContentView(R.layout.calculate);

        TextView tv = (TextView) findViewById(R.id.textView4);
        tv.setText(String.valueOf(tmpshort));

        TextView tv1 = (TextView) findViewById(R.id.textView8);
        tv1.setText(String.valueOf(tmplong));

        Button preDictCalBtn = (Button) findViewById(R.id.predictCalBack);
        preDictCalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainContent();

            }
        });
    }

    public static double cal(String way) {
        double tmpway = Double.valueOf(way);
        double forRe = 0;
        int i=0;
        Cursor res = mHelper.getAllData();
//       int dis[] = {1,9,10,20,20,20};
        // skip First Colum because First Colum is StartService
        res.moveToNext();
        while (true){
            res.moveToNext();
            double tmpcal = tmpway;
//            Log.e("Database","shortway (km)"res.getString(1) +"longway (km)"+ res.getString(2)+"rate: "+res.getString(3) );

            double distance = Double.valueOf(res.getString(2)) - Double.valueOf(res.getString(1)) ;
//            if(i==0 && tmp1 == 10){
//                ++rayatang;
//                tmp1--;
//            }
            tmpway -= distance;
            if(tmpcal - distance>=0)
                tmpcal = distance;

            if(i==0)
                forRe = forRe + ((tmpcal-1)*Double.valueOf(res.getString(3)));
            else
                forRe = forRe + ((tmpcal)*Double.valueOf(res.getString(3)));
            if(tmpway <=0)
                break;
            i++;


        }

        forRe = Math.ceil(forRe+35);
        forRe = forRe+((forRe+1)%2);
        return forRe;
        //       for(int i=0;i<loop;i++) {
//           if(i == 0){
//               res.moveToNext();
//               tmp += Double.valueOf(res.getString(3));
//           }else{
//               res.moveToNext();
//             tmpway   -= Double.valueOf(res.getString(2));
//               tmp += Double.valueOf(res.getString(3));
//           }
//
//        }
    }

    public static double caltraf(int min){
        return min*2.0;
    }
    public static double calper(double ser){
        if(ser == 0){
            return 0.0;
        }
        ser = Math.ceil(ser*1.3)+1;
//        Log.e("error ", String.valueOf(ser));
        ser = ser + ((ser+1)%2);
        return ser;
    }
}
