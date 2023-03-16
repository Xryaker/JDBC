package mysqlconfig;


import data.Person;
import enums.FieldsPersonTable;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StatemenT {
    private Statement statement;

    public StatemenT() {
        try {
            makeStatemenT();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Statement makeStatemenT() throws SQLException {
        Connectt c = null;

        c = new Connectt();
        Connection conn = c.makeConnection();
        statement = conn.createStatement();
        return statement;
    }

    public Person selectPersonById(int uid) {
        String s = "SELECT * FROM sys.person where p_id='" + uid + "'";
        Person p = null;
        try {
            ResultSet result = statement.executeQuery(s);
            result.next();
            p = new Person(result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }
    public Person selectPersonByName(String name) throws SQLException {
        String s = "SELECT * FROM sys.person where personName='" + name + "'";
        Person p = null;

            ResultSet result = statement.executeQuery(s);
            result.next();
            p = new Person(result);

        return p;
    }
    public Person selectPersonByField(FieldsPersonTable filed,String value) throws SQLException {
        String s = "SELECT * FROM sys.person where "+filed.getFiels()+"='" + value + "'";
        Person p = null;

            ResultSet result = statement.executeQuery(s);
            result.next();
            p = new Person(result);

        return p;
    }
    public List<Person> getListAllUsers() {
        String select = "SELECT * FROM sys.person limit 0,100";
        ResultSet result = null;
        List<Person> personList = new ArrayList<>();
        try {
            result = statement.executeQuery(select);
            while (result.next()) {
                personList.add(new Person(result));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personList;
    }

    public List<Person> getListAllUsersByNames(String name) throws Exception {
        String select = "SELECT * FROM sys.person where personName='"+name+"' limit 0,100";
        ResultSet result = null;
        List<Person> personList = new ArrayList<>();

            result = statement.executeQuery(select);
            while (result.next()) {
                personList.add(new Person(result));
            }
        if(personList.size()==0) throw new Exception("Personlist empty");
        return personList;
    }




    public boolean insertPerson(Person basilio) {
        String insert;
        if(basilio.getName()==null){
        insert="INSERT INTO `sys`.`person` (`personName`, `pass`) VALUES ('"+basilio.getName()+"', '"+basilio.getPass()+"');";}
        else{
            insert="INSERT INTO `sys`.`person` (`personName`, `email`, `pass`) VALUES ('"+basilio.getName()+"', '"+basilio.getEmail()+"', '"+basilio.getPass()+"');";
        }
        boolean b = true;
        try {
           b= statement.execute(insert);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return b;
    }

        public boolean deletePersonById(int id) throws SQLException {
        String delete="DELETE FROM `sys`.`person` WHERE (`p_id` = '"+id+"');";
        return statement.execute(delete);
    }

    //
//
//        String s="SELECT * FROM sys.user;";
//        ResultSet resultSet=statement.executeQuery(s);
//        List<Human> users=new ArrayList<>();
//        while (resultSet.next()){
//            users.add(new Human(resultSet.getString("username"),
//                    resultSet.getString("password"),
//                    resultSet.getString("email"),
//                    resultSet.getString("id")));
//        }
//        return users;
//    }


//    public void selectByUserNameEmail(String username, String email) {
//        String s = "SELECT * FROM sys.user where username=\"" + username + "\" and email=\"" + email + "\"";
//        try {
//            ResultSet resultSet = statement.executeQuery(s);//запрос с ответом resultset(ответ)
//            resultSet.next();
//            System.out.println(resultSet.getString("username"));
//            System.out.println(resultSet.getString("password"));
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public void selectUsersByName(String UserName){
//      String s="SELECT * FROM sys.user where username=\""+UserName+"\"";
//        try {
//            ResultSet resultSet=statement.executeQuery(s);
//            while (resultSet.next()){
//                System.out.println(resultSet.getString("password"));
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//    public Human getUserByid(String id){
//        String s="SELECT * FROM sys.user where id=\""+id+"\"";
//        Human human=null;
//        try {
//            ResultSet resultSet=statement.executeQuery(s);
//            resultSet.next();
//            //Human testuse=new Human("fkff","fff@dd.com","pass","jjjf888");
//            human=new Human(
//                    resultSet.getString("username"),
//                    resultSet.getString("email"),
//                    resultSet.getString("password"),
//                    resultSet.getString("id"));
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return human ;
//    }
//
//    public void insert(String username, String password, String email)  {
//        UUID uuid = UUID.randomUUID();
//        String s = "INSERT INTO `sys`.`user` (`username`, `email`, `password`, `id`) VALUES (\"" + username + "\",\"" + email + "\"" +
//                ",\"" + password + "\",\"" + uuid.toString() + "\");";
//        try {
//            statement.execute(s);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//    public void insert(String username, String password, String email,String id)  {
//        String s = "INSERT INTO `sys`.`user` (`username`, `email`, `password`, `id`) VALUES (\"" + username + "\",\"" + email + "\"" +
//                ",\"" + password + "\",\"" + id + "\");";
//        //System.out.println(s);
//        try {
//            statement.execute(s);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//    public void delete(String id)  {
//        //DELETE FROM `sys`.`user` WHERE (`id` = '62028969-a6ed-4a17-b546-0d73743f64b7');
//        String s="DELETE FROM `sys`.`user` WHERE (`id` = '"+id+"');";
//        try {
//            statement.execute(s);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
////    public USER selectfromID(String UUID) throws SQLException {
////        String s="SELECT * FROM sys.user WHERE `id`=\""+UUID+"\";";
////        ResultSet resultSet=statement.executeQuery(s);
////        resultSet.next();
////        return new USER(resultSet.getString("username"),
////                        resultSet.getString("password"),
////                        resultSet.getString("email"),
////                        resultSet.getString("createtime"),
////                        resultSet.getString("id"));
////    }
//    public List<Human> getListAllUsers() throws SQLException {
//        String s="SELECT * FROM sys.user;";
//        ResultSet resultSet=statement.executeQuery(s);
//        List<Human> users=new ArrayList<>();
//        while (resultSet.next()){
//            users.add(new Human(resultSet.getString("username"),
//                    resultSet.getString("password"),
//                    resultSet.getString("email"),
//                    resultSet.getString("id")));
//        }
//        return users;
//    }
//    public void UpdatePassword(String pass,String id){
//        String s="UPDATE `sys`.`user` SET `password` = \""+pass+"\" WHERE (`id` = \""+id+"\")";
//        try {
//            statement.execute(s);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
}
