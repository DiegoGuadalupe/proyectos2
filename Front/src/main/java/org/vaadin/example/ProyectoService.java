package org.vaadin.example;

import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.awt.geom.GeneralPath;
import java.io.IOException;
import java.io.Serializable;
import java.net.URISyntaxException;

@Service
public class ProyectoService implements Serializable {

    public int VerificaciónUsuario(String usuario, String contra) throws IOException, URISyntaxException, InterruptedException {

        Usuario user = new Usuario(usuario,contra,0);
        Gson gson = new Gson();
        String data = gson.toJson(user);
        Api api = new Api();
        return Integer.parseInt(api.enviarDatosUsuarios(data));

    }





}
