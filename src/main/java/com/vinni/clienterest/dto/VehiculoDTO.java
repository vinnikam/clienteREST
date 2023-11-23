package com.vinni.clienterest.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class VehiculoDTO implements Serializable {
    private long id;
    private String placa;
    private int modelo;
}
