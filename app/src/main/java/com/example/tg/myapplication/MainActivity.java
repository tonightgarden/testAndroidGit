package com.example.tg.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.Arrays;

import rx.Observable;
import rx.Subscriber;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toOtherActivity(View view)
    {

        byte[] fileLengthBytes = new byte[3];
        fileLengthBytes[0]=57;
        fileLengthBytes[1]=-69;

        Toast.makeText(this,""+Arrays.toString(fileLengthBytes),Toast.LENGTH_LONG).show();

        Intent intent = new Intent(this,Main2Activity.class);
        startActivity(intent);

    }

    public void testRxJava(View view)
    {
        Observable sender = Observable.create(new Observable.OnSubscribe<String>() {

            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("一二三四五");
                subscriber.onNext("上山打老虎");
                subscriber.onNext("老虎一发威");
                subscriber.onNext("武松就发怵");
                subscriber.onCompleted();

            }
        });

        sender.subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                Log.d("TG",s);
                Log.d("TG",s);
                Log.d("TG",s);
                Log.d("TG",s);


            }
        });
    }

}
