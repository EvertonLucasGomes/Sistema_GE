package Sistema_GE.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConstantesUtil {
	public final static String SISTEMA_GE_DATABASE_PATH;
    public final static String SISTEMA_GE_DATABASE_PORT;
    public final static String SISTEMA_GE_DATABASE_IP;
    public final static String SISTEMA_GE_DATABASE_NAME;

    private static Properties prop;
    private static FileInputStream fis;

    static {

        try {
            prop = new Properties();
            fis = new FileInputStream("propriedades");
            prop.load(fis);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }

        SISTEMA_GE_DATABASE_PATH = prop.getProperty("sistema_ge_database_path");
        SISTEMA_GE_DATABASE_PORT = prop.getProperty("sistema_ge_database_port");
        SISTEMA_GE_DATABASE_IP = prop.getProperty("sistema_ge_database_ip");
        SISTEMA_GE_DATABASE_NAME = prop.getProperty("sistema_ge_database_name");
    }


}
