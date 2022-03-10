package ca.group20.sysc4806project.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SurveyorTest {
    private Surveyor test_surveyor;

    @BeforeEach
    public void setUp() {
        test_surveyor = new Surveyor("SquidGuy", "Erik", "Iuhas", "####");
    }


    @Test
    public void addSurvey() {
        Survey test_survey1 = new Survey("Amazing Survey");
        test_surveyor.addSurvey(test_survey1);
        assertEquals(1, test_surveyor.getSurveys().size());
    }

    @Test
    public void multipleSurveys() {
        Survey test_survey1 = new Survey("Amazing Survey");
        Survey test_survey2 = new Survey("Terrible Survey");
        Survey test_survey3 = new Survey("Dazling Survey");
        test_surveyor.addSurvey(test_survey1);
        test_surveyor.addSurvey(test_survey2);
        test_surveyor.addSurvey(test_survey3);
        assertEquals(3, test_surveyor.getSurveys().size());
    }
}