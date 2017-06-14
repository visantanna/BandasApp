package com.example.visantanna.bandasapp.com.lbd_project.BandaView;

/**
 * Created by vis_a on 29-Apr-17.
 */

public class ImageNotRegisteredException extends Exception{
    public ImageNotRegisteredException(){
        super("Imagem não foi devidamente registrada no metodo BandAboutUsPage.GetImage");
    }
    public ImageNotRegisteredException(String message){
        super(message);
    }
}
