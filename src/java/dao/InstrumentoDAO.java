/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dbase.Conexion;
import vo.Instrumento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import vo.Categoria;

/**
 *
 * @author ggruz
 */
public class InstrumentoDAO  implements IInstrumento{
    
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
    
    private  CategoriaDAO categoriaDAO=new CategoriaDAO();
    
    @Override
    public void insert(Instrumento in) {
    {        
        try
        {
            conn=Conexion.SQLServer();
            ps=conn.prepareStatement("insert into Instrumentos(instrumentoId,nombre,marca,categoriaId) values(?,?,?,?)");
            
            ps.setString(1,in.getInstrumentoId());
            ps.setString(2,in.getNombre());
            ps.setString(3,in.getMarca());
            ps.setString(4,in.getCategoria().getCategoriaId());
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
    public void update(Instrumento in) {
        
       try {
            conn = Conexion.SQLServer();
            ps = conn.prepareStatement("update Instrumentos set nombre=?,"
                    + "marca=?, categoriaId=? where instrumentoId =?");
             
                ps.setString(1,in.getNombre());
                ps.setString(2,in.getMarca());
                ps.setString(3,in.getCategoria().getCategoriaId());
                ps.setString(4,in.getInstrumentoId());
                
                
            int rows = ps.executeUpdate();
            
            if(rows!=1){
                System.out.println("ERROR INSERT");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String instrumentoId) {
          try {
            conn = Conexion.SQLServer();
            ps = conn.prepareStatement("delete from Instrumentos where instrumentoId=?");
            ps.setString(1, instrumentoId);
            int rows = ps.executeUpdate();
            
            if(rows!=1){
                System.out.println("ERROR INSERT");
               
            }
                
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public Instrumento findById(String instrumentoId) {
        
        Instrumento objInstrumento = new Instrumento();
         try {
            conn = Conexion.SQLServer();
            ps = conn.prepareStatement("select * from Instrumentos where instrumentoId=?");
            ps.setString(1, instrumentoId);
            rs = ps.executeQuery();
            if(rs.next()){
                objInstrumento.setInstrumentoId(rs.getString(1));
                objInstrumento.setNombre(rs.getString(2));
                objInstrumento.setMarca(rs.getString(3));
                Categoria categoria=categoriaDAO.findById(rs.getString("categoriaId"));               
                objInstrumento.setCategoria(categoria);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
         
         
         return objInstrumento;
    }

    @Override
    public Collection<Instrumento> findAll() {
    {
        Collection<Instrumento> list=new ArrayList<>();
        
        try
        {
            conn=Conexion.SQLServer();
            
            ps=conn.prepareStatement("select * from Instrumentos");
            rs=ps.executeQuery();
            
            while(rs.next())
            {
                Instrumento vo=new Instrumento();
                
                vo.setInstrumentoId(rs.getString("instrumentoId"));
                vo.setNombre(rs.getString("nombre"));
                vo.setMarca(rs.getString("marca"));
                Categoria categoria=categoriaDAO.findById(rs.getString("categoriaId"));               
                vo.setCategoria(categoria);
                list.add(vo);
            }
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        
        return list;
          }
    }
}
