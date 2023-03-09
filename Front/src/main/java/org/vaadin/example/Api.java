package org.vaadin.example;


import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Api {
    private static final String urlPrefix = "http://192.168.45.243:8080/%s";

    public String enviarDatosUsuarios(String datos) throws IOException, InterruptedException, URISyntaxException {
        String fullUrl = String.format(urlPrefix,"usuarioNuevo");

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(fullUrl))
                .POST(HttpRequest.BodyPublishers.ofString(datos))
                .build();

        HttpResponse<String> response = HttpClient
                .newBuilder()
                .build()
                .send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();

    }


}
