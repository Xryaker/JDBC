package data;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Person {
    String name, email, pass;
    int id;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Person(String name, String password) {
        this.name = name;
        this.pass=password;
    }

    public String getPass() {
        return pass;
    }

    public int getId() {
        return id;
    }

    public Person(ResultSet resultSet) {
        try {
            name = resultSet.getString("personName");

            email = resultSet.getString("email");
            pass = resultSet.getString("pass");
            id = resultSet.getInt("p_id");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "name "+name+"\n"+
                "email "+email+"\n"+
                "pass "+pass+"\n"+
                "id "+id;
    }
}
