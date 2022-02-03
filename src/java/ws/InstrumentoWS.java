/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import dao.CategoriaDAO;
import dao.ICategoria;
import dao.IInstrumento;
import dao.InstrumentoDAO;
import java.util.Collection;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import vo.Categoria;
import vo.Instrumento;

/**
 *
 * @author ggruz
 */
@WebService(serviceName = "ProductoWS")
public class InstrumentoWS {

        private IInstrumento instrumentoDao=new InstrumentoDAO();
        
                 
        private ICategoria categoriaDao=new CategoriaDAO();
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
    @WebMethod(operationName="instrumento_listar")
    public Collection<Instrumento> instrumento_listar() {
        return instrumentoDao.findAll();
    }
    
    @WebMethod(operationName="instrumento_registrar")
    public void producto_registrar(Instrumento in) {
        instrumentoDao.insert(in);
    }
        @WebMethod(operationName="instrumento_actualizar")
    public void instrumento_actualizar(Instrumento in) {
        instrumentoDao.update(in);
    }    
    
    @WebMethod(operationName="instrumento_eliminar")
    public void instrumento_eliminar(String instrumentoId) {
        instrumentoDao.delete(instrumentoId);
    }    

    @WebMethod(operationName="instrumento_buscar")
    public Instrumento instrumento_buscar(String instrumentoId) {
        return instrumentoDao.findById(instrumentoId);
    }        
    
    
  
    //CATEGORIA////////////////////////////////////////////////////////////////
    
    @WebMethod(operationName="categoria_buscar")
    public Categoria categoria_buscar(String catgoriaId) {
        return categoriaDao.findById(catgoriaId);
    }  
    
    @WebMethod(operationName="categoria_listar")
    public Collection<Categoria> categoria_listar() {
        return categoriaDao.findAll();
    }     
    
    @WebMethod(operationName="categoria_registrar")
    public void categoria_registrar(Categoria ca) {
        categoriaDao.insert(ca);
    }   
    
    @WebMethod(operationName="categoria_actualizar")
    public void categoria_actualizar(Categoria ca) {
        categoriaDao.update(ca);
    }   
    
    @WebMethod(operationName="categoria_eliminar")
    public void categoria_eliminar(String categoriaId) {
        categoriaDao.delete(categoriaId);
    }     

    @WebMethod(operationName="categoria_buscarName")
    public Categoria categoria_buscarName(String nombre) {
        return categoriaDao.findByName(nombre);
    }      

}
