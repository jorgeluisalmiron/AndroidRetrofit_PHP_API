package com.example.jorgeluis.testRetrofit.Model;

/**
 * Created by Jorge Luis on 20/09/2016.
 */
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;


public class Alumno {
    @SerializedName("id")
    private int idAlumno;
    @SerializedName("nombre")
    private String nombre;
    @SerializedName("direccion")
    private String direccion;

    public Alumno(int idAlumno, String nombre, String direccion) {
        this.idAlumno = idAlumno;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}