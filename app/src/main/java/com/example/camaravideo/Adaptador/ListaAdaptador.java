package com.example.camaravideo.Adaptador;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.VideoView;

import com.example.camaravideo.Entidades.Video;
import com.example.camaravideo.R;

import java.util.ArrayList;
import java.util.List;

public class ListaAdaptador extends ArrayAdapter<Video> {
    private List<Video> opciones = new ArrayList<>();
    private Context context1;

    public ListaAdaptador(Context context, List<Video> datos){
        super(context, R.layout.list_video_templ, datos);
        opciones = datos;
        context1=context;
    }
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.list_video_templ, null);

        VideoView hola = (VideoView)item.findViewById(R.id.templeVideo_listVideoTempl);
        Uri myUri = Uri.parse(opciones.get(position).getVideo());
        hola.setVideoURI(myUri);
        return(item);
    }
}

