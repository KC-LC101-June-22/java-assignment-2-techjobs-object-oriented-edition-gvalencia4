package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.

    public Job() {
        this.id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    @Override
    public String toString() {
        String emptyFieldMessage = "Data not available";

        // TODO: (Bonus) If a Job object ONLY contains data for the id field, the method should return, “OOPS! This job does not seem to exist.
        //  Test is already built but is commented out.”

        return "\n" +
                String.format("ID: %s\n", String.valueOf(this.getId()) != "" ? this.getId() : emptyFieldMessage) +
                String.format("Name: %s\n", this.getName() != "" ? this.getName() : emptyFieldMessage) +
                String.format("Employer: %s\n", this.getEmployer().toString() != "" ? this.getEmployer() : emptyFieldMessage) +
                String.format("Location: %s\n", this.getLocation().toString() != "" ? this.getLocation() : emptyFieldMessage) +
                String.format("Position Type: %s\n", this.getPositionType().toString() != "" ? this.getPositionType() : emptyFieldMessage) +
                String.format("Core Competency: %s\n", this.getCoreCompetency().toString() != "" ? this.getCoreCompetency() : emptyFieldMessage);
    }

    //  Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Job)) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    // Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public Location getLocation() {
        return location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }
}
