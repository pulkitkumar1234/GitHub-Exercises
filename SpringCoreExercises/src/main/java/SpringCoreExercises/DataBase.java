package SpringCoreExercises;

import org.springframework.stereotype.Component;

@Component
public class DataBase {
    int port;
    String name;



    /*public DataBase(int port, String name) {
        this.port = port;
        this.name = name;
    }*/
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
