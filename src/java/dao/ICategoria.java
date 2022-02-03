/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import vo.Categoria;
import java.util.Collection;

/**
 *
 * @author ggruz
 */
public interface ICategoria {
    public abstract void insert(Categoria ca);
    public abstract void update(Categoria ca);
    public abstract void delete(String categoriaId);
    public abstract Categoria findById(String categoriaId);
    public abstract Collection<Categoria> findAll();
    
    public abstract Categoria findByName(String nombre);
}
