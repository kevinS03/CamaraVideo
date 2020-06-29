package com.example.camaravideo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ListView;
import android.widget.VideoView;

import com.example.camaravideo.Adaptador.ListaAdaptador;
import com.example.camaravideo.Entidades.Video;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public ListaAdaptador listaAdaptador;
    private ListView lista;
    private String videoPath = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = (ListView)findViewById(R.id.ListaVideo_ActivityMain);

        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA}, 1000);
        }
    }


    //METODO PARA GRABAR VIDEOS
    static final int REQUEST_VIDEO_CAPTURE = 1;
    public void metodo_TomarVideo(View view) {
        Intent takeVideoIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        if (takeVideoIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takeVideoIntent, REQUEST_VIDEO_CAPTURE);
        }
    }

    public VideoView videoView;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        ArrayList<Video> videos = new ArrayList<>();

        if (requestCode == REQUEST_VIDEO_CAPTURE && resultCode == RESULT_OK) {

            Uri videoUri = intent.getData();
            videoPath = getRealPathFromURI(videoUri);
            videos.add(new Video(videoPath));

        }

        listaAdaptador = new ListaAdaptador(getApplicationContext(), videos);
        lista.setAdapter(listaAdaptador);
    }
    public String getRealPathFromURI(Uri contentUri) {
        String[] proj = { MediaStore.Images.Media.DATA };
        Cursor cursor = managedQuery(contentUri, proj, null, null, null);
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        return cursor.getString(column_index);
    }
}