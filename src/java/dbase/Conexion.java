/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbase;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion 
{
    public static Connection SQLServer() throws Exception
    {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url="jdbc:sqlserver://localhost:1433;databaseName=BDInstrumento_RogerAC;";
        
        return DriverManager.getConnection(url,"usuario","1234");
    }
}

