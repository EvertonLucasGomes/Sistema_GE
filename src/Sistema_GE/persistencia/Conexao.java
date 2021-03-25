package Sistema_GE.persistencia;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import Sistema_GE.util.ConstantesUtil;

public class Conexao {	

	    public static Connection getConnection() {
	        try {
	            Class.forName("org.postgresql.Driver");
	            return DriverManager.getConnection(ConstantesUtil.SISTEMA_GE_DATABASE_PATH + "//" + ConstantesUtil.SISTEMA_GE_DATABASE_IP + 
	            			":" + ConstantesUtil.SISTEMA_GE_DATABASE_PORT + "/" + ConstantesUtil.SISTEMA_GE_DATABASE_NAME, "postgres", "512806rm");	
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } catch (ClassNotFoundException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        return null;
	    }

	}


