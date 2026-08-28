package com.example.lab1_20233429.model;

import org.slf4j.spi.LocationAwareLogger;

import java.time.LocalDate;
import java.util.Date;


public class Equipo {

    private String nombre;
    private String tipo;
    private String codigoActivo;
    private LocalDate fechaAdquisicion;

    public Equipo( String nombre, String tipo, String codigoActivo, LocalDate fechaAdquisicion) {

        this.nombre = nombre;
        this.tipo = tipo;
        this.codigoActivo = codigoActivo;
        this.fechaAdquisicion = fechaAdquisicion;
    }

    public Equipo() {
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDate getFechaAdquisicion() {
        return fechaAdquisicion;
    }

    public void setFechaAdquisicion(LocalDate fechaAdquisicion) {
        this.fechaAdquisicion = fechaAdquisicion;
    }

    public String getCodigoActivo() {
        return codigoActivo;
    }

    public void setCodigoActivo(String codigoActivo) {
        this.codigoActivo = codigoActivo;
    }
}
