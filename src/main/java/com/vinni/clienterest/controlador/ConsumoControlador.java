package com.vinni.clienterest.controlador;

import com.vinni.clienterest.servicio.ConsumoServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/testconsumo")
public class ConsumoControlador {

    @Autowired
    ConsumoServicio consumoServicio;
    @GetMapping
    public ResponseEntity<String> verificaURL() {
        var vehiculos = consumoServicio.consumir();
        return new ResponseEntity<>(vehiculos, HttpStatus.OK);
    }
}
