package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*@Repository
public class UserDAO2 {
    @Autowired
    DataSource dataSource2;

    void printUserDetails() throws SQLException{
        Connection connection=dataSource2.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM user");
        ResultSet resultSet=preparedStatement.executeQuery();
        while(resultSet.next()){
            System.out.println(resultSet.getString("dob"));
        }
    }

}*/
