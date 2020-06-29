package com.example.camaravideo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class ReproducirVIdeo extends AppCompatActivity {

    public VideoView videoView;
    public MediaController mediacontroller;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reproducir_v_ideo);
    }

    /*public void cargarVIdeo(){
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
        intent.setType("video/*");
        startActivityForResult(intent.createChooser(intent, "Seleccione la aplicacion"),10);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (requestCode == REQUEST_VIDEO_CAPTURE && resultCode == RESULT_OK) {
            Uri videoUri = intent.getData();
            videoView.setVideoURI(videoUri);
            videoView.pause();
        }

        mediacontroller.show();
        mediacontroller.setAnchorView(videoView);
        videoView.start();
    }*/
}