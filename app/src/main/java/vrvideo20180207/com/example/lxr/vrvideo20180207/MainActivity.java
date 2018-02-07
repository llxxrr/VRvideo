package vrvideo20180207.com.example.lxr.vrvideo20180207;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatSeekBar;
import android.widget.TextView;

import com.google.vr.sdk.widgets.video.VrVideoView;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    private VrVideoView vr;
    private AppCompatSeekBar seek;
    private TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        @SuppressLint("StaticFieldLeak") AsyncTask<Void, Void, Void> asyncTask = new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                try {
                    VrVideoView.Options options= new VrVideoView.Options();
                    options.inputType=VrVideoView.Options.TYPE_STEREO_OVER_UNDER;
                   //流媒体格式，直播用的多 VrVideoView.Options.FORMAT_HLS
                    options.inputFormat=VrVideoView.Options.FORMAT_DEFAULT;
                    vr.loadVideoFromAsset("tang.mp4",options);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void s) {
                super.onPostExecute(s);
            }
        };
        asyncTask.execute();
    }

    private void initView() {
        vr = (VrVideoView) findViewById(R.id.vr);
        seek = (AppCompatSeekBar) findViewById(R.id.seek);
        t = (TextView) findViewById(R.id.t);
    }
}
