/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dbase.Conexion;
import vo.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author ggruz
 */
public class CategoriaDAO implements ICategoria
{
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
    @Override
    public void insert(Categoria ca) {
    {        
        try
        {
            conn=Conexion.SQLServer();
            ps=conn.prepareStatement("insert into Categorias(categoriaId,nombre) values(?,?)");
            
             ps.setString(1,ca.getCategoriaId());
            ps.setString(2,ca.getNombre());
            
            int rows=ps.executeUpdate();
            
            if(rows!=1) {
                System.out.println("ERROR INSERT!");
            }
        }
        catch(Exception ex) {
            ex.printStackTrace();
            }
        }
    }
    @Override
    public void update(Categoria ca) {
        
       try {
            conn = Conexion.SQLServer();
            ps = conn.prepareStatement("update Categorias set nombre=? where categoriaId =?");
             
                ps.setString(1,ca.getNombre());
                ps.setString(2,ca.getCategoriaId());
            
            int rows = ps.executeUpdate();
            
            if(rows!=1){
                System.out.println("ERROR INSERT");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String categoriaId) {
          try {
            conn = Conexion.SQLServer();
            ps = conn.prepareStatement("delete from Categorias where categoriaId=?");
            ps.setString(1, categoriaId);
            int rows = ps.executeUpdate();
            
            if(rows!=1){
                System.out.println("ERROR INSERT");
               
            }
                
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public Categoria findById(String categoriaId) {
        
        Categoria objCategoria = new Categoria();
         try {
            conn = Conexion.SQLServer();
            ps = conn.prepareStatement("select * from Categorias where categoriaId=?");
            ps.setString(1, categoriaId);
            rs = ps.executeQuery();
            if(rs.next()){
                objCategoria.setCategoriaId(rs.getString(1));
                objCategoria.setNombre(rs.getString(2));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
         
         
         return objCategoria;
    }


    @Override
    public Collection<Categoria> findAll() {
    {
        Collection<Categoria> list=new ArrayList<>();
        
        try
        {
            conn=Conexion.SQLServer();
            
            ps=conn.prepareStatement("select * from Categorias");
            rs=ps.executeQuery();
            
            while(rs.next())
            {
                Categoria ca=new Categoria();
                
                ca.setCategoriaId(rs.getString("categoriaId"));
                ca.setNombre(rs.getString("nombre"));

                
                list.add(ca);
            }
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        
        return list;
          }
    }

    @Override
    public Categoria findByName(String nombre) {
        
        Categoria objCategoria = new Categoria();
         try {
            conn = Conexion.SQLServer();
            ps = conn.prepareStatement("select * from Categorias where nombre=?");
            ps.setString(1, nombre);
            rs = ps.executeQuery();
            if(rs.next()){
                objCategoria.setCategoriaId(rs.getString(1));
                objCategoria.setNombre(rs.getString(2));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
         
         
         return objCategoria;
    }

    
}
