package com.example.call_recorder;

import android.app.Service;
import android.content.Intent;
import android.media.MediaRecorder;
import android.os.Build;
import android.os.Environment;
import android.os.IBinder;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.text.format.DateFormat;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class RecordingService extends Service {

    MediaRecorder mediaRecorder;
    private boolean recordStarted;
    private String file;
    private String path = "";

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // return super.onStartCommand(intent, flags, startId);
        Date date = new Date();
        CharSequence sdf = DateFormat.format("MM-dd-yy-hh-mm-ss", date.getTime());
        path = "/" + sdf + "rec.3gp";
        file = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator +path;
        mediaRecorder = new MediaRecorder();
        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.VOICE_CALL);
        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mediaRecorder.setOutputFile(file);
        mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);


        TelephonyManager telephonyManager = (TelephonyManager) getApplicationContext().getSystemService(getApplicationContext().TELEPHONY_SERVICE);
        telephonyManager.listen(new PhoneStateListener() {
            @Override
            public void onCallStateChanged(int state, String phoneNumber) {
                //super.onCallStateChanged(state, phoneNumber) {
                if (TelephonyManager.CALL_STATE_IDLE == state && mediaRecorder == null) {
                    mediaRecorder.stop();
                    mediaRecorder.reset();
                    mediaRecorder.release();
                    recordStarted = false;
                    stopSelf();
                } else if (TelephonyManager.CALL_STATE_OFFHOOK == state) {

                    try {
                        mediaRecorder.prepare();
                        mediaRecorder.start();
                        recordStarted = true;

                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }

                }
            }
        }, PhoneStateListener.LISTEN_CALL_STATE);
        return START_STICKY;
    }
}
