/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vo;

import java.util.Date;

/**
 * 
 * @author ggruz
 */
public class Instrumento {
    private String instrumentoId;
    private String nombre;
    private String marca;
    
    private Categoria categoria;
    
    public Instrumento() {
    }

    @Override
    public String toString() {
        return "Instrumento{" + "instrumentoId=" + instrumentoId + ", nombre=" + nombre + ", marca=" + marca + '}';
    }

    public Instrumento(String instrumentoId, String nombre, String marca, Categoria categoria) {
        this.instrumentoId = instrumentoId;
        this.nombre = nombre;
        this.marca = marca;
        this.categoria = categoria;
    
    }
    
    

    public String getInstrumentoId() {
        return instrumentoId;
    }

    public void setInstrumentoId(String instrumentoId) {
        this.instrumentoId = instrumentoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    
}
