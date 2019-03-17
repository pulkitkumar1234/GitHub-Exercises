package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/*@Repository
public class UserDAO {
    @Autowired
    DataSource dataSource;

    void printUserName() throws SQLException{
        Connection connection =dataSource.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM user");
        ResultSet resultSet=preparedStatement.executeQuery();
        while(resultSet.next()){
            System.out.println(resultSet.getString("name"));
        }

    }
}*/
