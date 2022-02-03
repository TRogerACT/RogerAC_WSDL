/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import vo.Instrumento;

import java.util.Collection;

/**
 *
 * @author ggruz
 */
public interface IInstrumento 
{
    public abstract void insert(Instrumento in);
    public abstract void update(Instrumento in);
    public abstract void delete(String instrumentoId);
    public abstract Instrumento findById(String instrumentoId);
    public abstract Collection<Instrumento> findAll();
}

