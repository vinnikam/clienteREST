package com.vinni.clienterest.servicio;

import com.google.gson.JsonObject;
import com.vinni.clienterest.dto.VehiculoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;


@RequiredArgsConstructor
@Service
public class ConsumoServicio {
    public String consumir(){
        consultaGet("http://localhost:8862/vehiculo");
        //System.out.println(dato);
        VehiculoDTO vehiculoDTO = consultaGetID("http://localhost:8862/vehiculo/{id}", "1");
        System.out.println(vehiculoDTO);
        return "ok";
    }
    public void consultaGet(String url){
        final HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        JsonObject body = new JsonObject();

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> requestEntity = new HttpEntity<>(body.toString(), headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET,requestEntity, String.class);
        System.out.println(response);
        //return response.getBody();
    }
    public VehiculoDTO consultaGetID(String url, String id){
        final HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        JsonObject body = new JsonObject();

        Map<String, String> parametros = new HashMap<>();
        parametros.put("id", id);



        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> requestEntity = new HttpEntity<>(body.toString(), headers);
        return  restTemplate.getForObject(url, VehiculoDTO.class, parametros);

    }
    public VehiculoDTO verifica(String url, String datoBody){
        final HttpHeaders headers = new HttpHeaders();
        headers.add("apiToken", "valor a enviar");
        headers.setContentType(MediaType.APPLICATION_JSON);
        StringBuilder urlServicio = new StringBuilder(url);
        JsonObject body = new JsonObject();
        body.addProperty("nombreAplicacion", datoBody);
        HttpEntity<String> requestEntity = new HttpEntity<>(body.toString(), headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<VehiculoDTO> response = restTemplate.exchange(urlServicio.toString(), HttpMethod.POST,
                requestEntity, VehiculoDTO.class);
        return response.getBody();
    }
}
