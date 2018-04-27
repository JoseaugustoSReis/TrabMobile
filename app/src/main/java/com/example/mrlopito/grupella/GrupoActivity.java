package com.example.mrlopito.grupella;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class GrupoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grupo);


        List<Grupo> grupos = todosOsGrupos();
        ListView listView = (ListView) findViewById(R.id.listview);
        ArrayAdapter<Grupo> adapter = new ArrayAdapter<Grupo>(this, android.R.layout.simple_list_item_1, grupos);
        //AdapterGrupos adapter = new AdapterGrupos(grupos, this);

        listView.setAdapter(adapter);
    }

    public List<Grupo> todosOsGrupos() {
        List<Grupo> eList = new LinkedList<Grupo>();
        eList.add(new Grupo("FTC", "Grupo de estudo", true));
        eList.add(new Grupo("FTC", "Grupo de estudo", false));

        return eList;
    }
}
