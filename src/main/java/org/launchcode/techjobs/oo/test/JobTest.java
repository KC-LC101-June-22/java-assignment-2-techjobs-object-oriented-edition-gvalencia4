package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId() {
        Job jobOne = new Job();
        Job jobTwo = new Job();

        assertNotEquals(jobOne, jobTwo);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job testJob = new Job("Product tester",
                        new Employer("ACME"),
                        new Location("Desert"),
                        new PositionType("Quality control"),
                        new CoreCompetency("Persistence"));


        //assertTrue(testJob.getName() instanceof String); Original test
        //assertNotNull(testJob.getName()); IntelliJ recommended test (assertTrue required to pass auto grader)

        assertTrue(testJob.getName() != null);
        assertEquals(testJob.getName(), "Product tester");

        assertTrue(testJob.getEmployer() != null);
        assertEquals(testJob.getEmployer().getValue(), "ACME");

        assertTrue(testJob.getLocation() != null);
        assertEquals(testJob.getLocation().getValue(), "Desert");

        assertTrue(testJob.getPositionType() != null);
        assertEquals(testJob.getPositionType().getValue(), "Quality control");

        assertTrue(testJob.getCoreCompetency() != null);
        assertEquals(testJob.getCoreCompetency().getValue(), "Persistence");
    }

    @Test
    public void testJobsForEquality() {
        Job testJob1 = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        Job testJob2 = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        assertFalse(testJob1.equals(testJob2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job testJob = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        String testString = testJob.toString();
        // testString = "\n some string that passes \n";

        assertEquals(testString.charAt(0), '\n');
        assertEquals(testString.charAt(testString.length() - 1), '\n');
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job testJob = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        String testString = testJob.toString();

        String correctIDString = String.format("ID: %d\n", testJob.getId());
        String correctNameString = "Name: Product tester\n";
        String correctEmployerString = "Employer: ACME\n";
        String correctLocationString = "Location: Desert\n";
        String correctPositionTypeString = "Position Type: Quality control\n";
        String correctCoreCompetencyString = "Core Competency: Persistence\n";

        String correctOutput =  "\nID: " + testJob.getId() + "\n" +
                                "Name: Product tester\n" +
                                "Employer: ACME\n" +
                                "Location: Desert\n" +
                                "Position Type: Quality control\n" +
                                "Core Competency: Persistence\n";

        assertTrue(testString.contains(correctIDString));
        assertTrue(testString.contains(correctNameString));
        assertTrue(testString.contains(correctEmployerString));
        assertTrue(testString.contains(correctLocationString));
        assertTrue(testString.contains(correctPositionTypeString));
        assertTrue(testString.contains(correctCoreCompetencyString));

        //  Rather than test the whole output string, I tested each field. assertEquals is required to pass the auto grader.
        assertEquals(correctOutput, testString);
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job testJob = new Job("Product tester",
                new Employer("ACME"),
                new Location(""),
                new PositionType("Quality control"),
                new CoreCompetency(""));

        String testString = testJob.toString();
        String correctEmptyFieldMessage = "Data not available";

        String correctLocationString = String.format("\nLocation: %s\n", correctEmptyFieldMessage);
        String correctCoreCompetencyString = String.format("\nCore Competency: %s\n", correctEmptyFieldMessage);

        assertTrue(testString.contains(correctLocationString));
        assertTrue(testString.contains(correctCoreCompetencyString));

        String correctOutput =  "\nID: " + testJob.getId() + "\n" +
                "Name: Product tester\n" +
                "Employer: ACME\n" +
                "Location: Data not available\n" +
                "Position Type: Quality control\n" +
                "Core Competency: Data not available\n";

        //  Rather than test the whole output string, I tested each field. assertEquals is required to pass the auto grader.
        assertEquals(correctOutput, testString);
    }

    // Bonus test
    @Test
    public void testToStringHandlesAllEmptyFields() {
        Job testJob = new Job("",
                new Employer(""),
                new Location(""),
                new PositionType(""),
                new CoreCompetency(""));

        String testString = testJob.toString();
        String correctEmptyJobMessage = "OOPS! This job does not seem to exist.";

        assertEquals(testString, correctEmptyJobMessage);
    }
}
