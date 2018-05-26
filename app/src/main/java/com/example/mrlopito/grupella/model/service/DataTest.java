package com.example.mrlopito.grupella.model.service;

import com.example.mrlopito.grupella.model.entity.Grupo;
import com.example.mrlopito.grupella.model.entity.Usuario;

import java.util.LinkedList;
import java.util.List;

public class DataTest {

    public static List<Grupo> todosOsGrupos() {
        List<Grupo> eList = new LinkedList<Grupo>();
        eList.add(new Grupo(0,"Estruturada de dados", "Grupo de estudo de ESD", true, "https://tremendadespedida.com/wp-content/uploads/2016/11/Restaurante-despedida-soltero-1.jpg"));
        eList.add(new Grupo(1,"FTC", "Grupo de estudo", false, "https://tremendadespedida.com/wp-content/uploads/2016/11/Restaurante-despedida-soltero-1.jpg"));

        return eList;
    }

    public static List<Usuario> todosOsUsuarios() {
        List<Usuario> eList = new LinkedList<Usuario>();
        eList.add(new Usuario(0,"Lucas"));
        eList.add(new Usuario(1,"José"));

        return eList;
    }

    public static Usuario getUsuario(int id) {

        for ( Usuario usuario: todosOsUsuarios() ) {
            if(usuario.getId() == id) {
                return usuario;
            }
        }

        return todosOsUsuarios().get( 0 );
    }


}
