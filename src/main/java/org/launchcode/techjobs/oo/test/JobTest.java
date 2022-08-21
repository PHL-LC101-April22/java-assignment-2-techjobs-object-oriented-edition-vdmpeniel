package org.launchcode.techjobs.oo.test;

import org.junit.Assert;
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
    public void testSettingJobId(){
        Job firstJob = new Job();
        Job secondJob = new Job();
        assertNotEquals(firstJob.getId(), secondJob.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job firstJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(firstJob.getName() instanceof String);
        assertTrue(firstJob.getEmployer() instanceof Employer);
        assertTrue(firstJob.getLocation() instanceof Location);
        assertTrue(firstJob.getPositionType() instanceof PositionType);
        assertTrue(firstJob.getCoreCompetency() instanceof CoreCompetency);

        assertEquals(firstJob.getName(), "Product tester");
        assertEquals(firstJob.getEmployer().getValue(), "ACME");
        assertEquals(firstJob.getLocation().getValue(), "Desert");
        assertEquals(firstJob.getPositionType().getValue(), "Quality control");
        assertEquals(firstJob.getCoreCompetency().getValue(), "Persistence");
    }

    @Test
    public void testJobsForEquality(){
        Job firstJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job secondJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(firstJob.equals(secondJob));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job firstJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        System.out.println(firstJob.toString());
        assertEquals((long) firstJob.toString().charAt(0), 10l);
        assertEquals((long) firstJob.toString().charAt(firstJob.toString().length() - 1), 10l);
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job firstJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals(String.format(
                "\nID: %d\n" +
                "Name: %s\n" +
                "Employer: %s\n" +
                "Location: %s\n" +
                "Position Type: %s\n" +
                "Core Competency: %s\n",
                firstJob.getId(),
                "Product tester",
                "ACME",
                "Desert",
                "Quality control",
                "Persistence"
        ), firstJob.toString());


        firstJob = new Job();
        assertEquals("OOPS! This job does not seem to exist.", firstJob.toString());
    }

    public void testToStringHandlesEmptyField(){
        Job firstJob = new Job(
                "Product tester",
                new Employer(""),
                new Location("Desert"),
                new PositionType(""),
                new CoreCompetency("Persistence")
        );
        assertEquals(String.format(
                "\nID:  %d\n" +
                "Name: %s\n" +
                "Employer: %s\n" +
                "Location: %s\n" +
                "Position Type: %s\n" +
                "Core Competency: %s\n",
                firstJob.getId(),
                "Product tester",
                "Data not available",
                "Desert",
                "Data not available",
                "Persistence"
        ), firstJob.toString());
    }
}
