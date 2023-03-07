package helpers;

public class ConfigReader {

    public static String readProperty(String configPropertyKey){
        String property="";
        try {
            System.getProperties().load(ClassLoader.getSystemResourceAsStream("config.properties"));
            property=System.getProperty(configPropertyKey);
        }catch (Exception e){
            System.out.println(">>>>>>>>>>>>>>>>>>\n Couldn't connect to config file \n>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        }
        return property;
    }
}
