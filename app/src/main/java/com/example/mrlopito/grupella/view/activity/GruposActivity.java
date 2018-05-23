package com.example.mrlopito.grupella.view.activity;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mrlopito.grupella.R;
import com.example.mrlopito.grupella.view.adapter.AdapterGrupos;
import com.example.mrlopito.grupella.model.entity.Grupo;

import java.util.LinkedList;
import java.util.List;

import static android.webkit.ConsoleMessage.MessageLevel.LOG;

public class GruposActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grupo);


        List<Grupo> grupos = todosOsGrupos();
        final ListView listView = (ListView) findViewById(R.id.listview);
        AdapterGrupos adapter = new AdapterGrupos(grupos, this, listView);

        listView.setAdapter(adapter);

        // seta o listener para pegar o click do usuário no item do seu list View
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // pega o o item selecionado com os dados do grupo
                Grupo grupo = (Grupo) listView.getItemAtPosition(position);

                // cria a intent
                Intent intent = new Intent(GruposActivity.this, GrupoDetalheActivity.class);

                // seta o parametro do grupo a exibir os dados
                intent.putExtra( "grupo" ,  grupo);

                //  chama a Activity que mostra os detalhes
                startActivity(intent);

            }

        });



    }

    public List<Grupo> todosOsGrupos() {
        List<Grupo> eList = new LinkedList<Grupo>();
        eList.add(new Grupo("Estruturada de dados", "Grupo de estudo de ESD", true, "https://tremendadespedida.com/wp-content/uploads/2016/11/Restaurante-despedida-soltero-1.jpg"));
        eList.add(new Grupo("FTC", "Grupo de estudo", false, "https://tremendadespedida.com/wp-content/uploads/2016/11/Restaurante-despedida-soltero-1.jpg"));

        return eList;
    }
}
