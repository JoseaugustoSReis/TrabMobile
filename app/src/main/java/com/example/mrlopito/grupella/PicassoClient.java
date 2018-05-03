package com.example.mrlopito.grupella;

import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.example.mrlopito.grupella.R;

/**
 * Essse é um seviço de armazenamento e download de imagens atraves da biblioteca Picasso.
 * @author Gian Fonseca, Pedro Henrique
 */
public class PicassoClient {

    /**
     * Realiza o download de imagens, de acordo com a solicitação.
     * @link http://square.github.io/picasso/
     * @param c
     * @param url
     * @param img
     */
    public static void downloadImage(Context c,String url,ImageView img)
    {
        if(url != null && url.length()>0)
        {
            Picasso.with(c).load(url).placeholder(R.drawable.ic_launcher_foreground).into(img);

        }else {
            Picasso.with(c).load(R.drawable.ic_launcher_foreground).into(img);
        }
    }

}
