package ca.group20.sysc4806project.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SurveyorTest {

    private Surveyor test_surveyor;
    @Before
    public void setUp() throws Exception {
        test_surveyor = new Surveyor("SquidGuy", "Erik", "Iuhas","####");
    }

    @After
    public void tearDown() throws Exception {
        test_surveyor = null;
    }

    @Test
    public void addSurvey(){
        Survey test_survey1 = new Survey("Amazing Survey");
        test_surveyor.addSurvey(test_survey1);
        assertEquals(1,test_surveyor.getSurveys().size());
    }

    @Test
    public void multipleSurveys(){
        Survey test_survey1 = new Survey("Amazing Survey");
        Survey test_survey2 = new Survey("Terrible Survey");
        Survey test_survey3 = new Survey("Dazling Survey");
        test_surveyor.addSurvey(test_survey1);
        test_surveyor.addSurvey(test_survey2);
        test_surveyor.addSurvey(test_survey3);
        assertEquals(3,test_surveyor.getSurveys().size());
    }
}