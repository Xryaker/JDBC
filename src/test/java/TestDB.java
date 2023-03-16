import data.Person;
import enums.FieldsPersonTable;
import mysqlconfig.StatemenT;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.SQLException;

public class TestDB {
    static StatemenT statemenT;

    @BeforeClass
    public static void b() {
        statemenT = new StatemenT();
    }

    @Test
    public void test1() {
        Assert.assertNotNull(statemenT.selectPersonById(5).getEmail());
    }

    @Test
    public void test() {
        for (Person l : statemenT.getListAllUsers()) {
            System.out.println(l);
        }
    }

    @Test
    public void test2() {
     //  statemenT.insertPerson(new Person("basilio", "5665965"));
    }

    @Test
    public void test5() throws Exception {
        System.out.println(statemenT.getListAllUsersByNames("basijkjjhikkjlio"));
    }

    @Test
    public void test6() throws SQLException {

        statemenT.selectPersonByName("Vasiliy");

    }
    @Test
    public void test7() throws SQLException {
        System.out.println(statemenT.selectPersonByField(FieldsPersonTable.P_ID, "20"));
    }
    @Test
    public void test8() throws SQLException {
        System.out.println(statemenT.deletePersonById(1));
    }
}
