/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbase;

import dao.InstrumentoDAO;
import vo.Instrumento;

public class Test 
        
{
    public static void main(String[] args) throws Exception
    {
        Conexion.SQLServer(); //llamar a conexión a DB
        System.out.println("¡Conexión... OK!");
        
        InstrumentoDAO dao=new InstrumentoDAO();
        
        for(Instrumento i:dao.findAll()){
            System.out.println(i.toString());
        }
    }    
}
