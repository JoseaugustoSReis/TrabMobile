package com.example.mrlopito.grupella.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mrlopito.grupella.R;
import com.example.mrlopito.grupella.model.entity.Grupo;
import com.example.mrlopito.grupella.model.service.PicassoClient;
import com.example.mrlopito.grupella.view.adapter.FragmentAdapter;
import com.example.mrlopito.grupella.view.fragment.FragmentNavigator;
import com.example.mrlopito.grupella.view.fragment.MainFragment;
import com.example.mrlopito.grupella.view.widget.BottomNavigatorView;

public class GrupoDetalheActivity extends AppCompatActivity implements BottomNavigatorView.OnBottomNavigatorViewItemClickListener {

    private static final int DEFAULT_POSITION = 0;

    private FragmentNavigator mNavigator;

    private BottomNavigatorView bottomNavigatorView;

    private TextView nome;
    private TextView descricao;
    private ImageView imagem;

    private Grupo grupo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.informacoes_grupo);

        //mNavigator = new FragmentNavigator(getSupportFragmentManager(), new FragmentAdapter(), 0);
        mNavigator = new FragmentNavigator(getSupportFragmentManager(), new FragmentAdapter(), R.id.container);
        mNavigator.setDefaultPosition(DEFAULT_POSITION);
        mNavigator.onCreate(savedInstanceState);

        bottomNavigatorView = (BottomNavigatorView) findViewById(R.id.bottomNavigatorView);
        if (bottomNavigatorView != null) {
            bottomNavigatorView.setOnBottomNavigatorViewItemClickListener(this);
        }

        setCurrentTab(mNavigator.getCurrentPosition());

        initView();
    }

    public void initView(){

        nome = (TextView)
                findViewById(R.id.detalhe_grupo_nome);

        imagem = (ImageView)
                findViewById(R.id.detalhe_grupo_imagem);


        this.grupo =
                (Grupo) getIntent().getSerializableExtra("grupo");


        Context c = this.getBaseContext();
        nome.setText(this.grupo.getNome());
        PicassoClient.downloadImage(c, this.grupo.getPhotoURL(), imagem);



        Bundle bundle = new Bundle();
        bundle.putString("grupo", "test");
        new MainFragment().setArguments(bundle);

    }

    public void onFragmentViewCreated(View view) {
        // Iniciar os campos buscando no layout do Fragment
       // descricao
              //  = (TextView) view.findViewById(R.id.detalhe_grupo_descricao);

       // descricao.setText(this.grupo.getDescricao());
    }

    @Override
    public void onBottomNavigatorViewItemClick(int position, View view) {
        setCurrentTab(position);
    }


    private void setCurrentTab(int position) {
        mNavigator.showFragment(position);
        bottomNavigatorView.select(position);
    }

}
