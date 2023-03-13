import data.Person;
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
        System.out.println(statemenT.insertPersonByNameAndPass(new Person("basilio", "5665965")));
    }

    @Test
    public void test5() {
        System.out.println(statemenT.getListAllUsersByNames("basilio"));
    }

    @Test
    public void test6() {
        System.out.println(statemenT.selectPersonByName("basilio"));
    }
}
