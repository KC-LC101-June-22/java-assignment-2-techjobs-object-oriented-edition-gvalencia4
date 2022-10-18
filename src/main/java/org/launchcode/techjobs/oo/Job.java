package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Job {

    private final int id;
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
    // per toby, toStringTwo is probably the way to go. see for loop
    public String toString() {
        // (Bonus) If a Job object ONLY contains data for the id field, the method should return, "OOPS! This job does not seem to exist."

        String emptyFieldMessage = "Data not available";
        String allFieldsEmptyMessage = "OOPS! This job does not seem to exist.";

        // Get each field string
        String[] jobFieldStrings = {this.getName(),
                this.getEmployer().toString(),
                this.getLocation().toString(),
                this.getPositionType().toString(),
                this.getCoreCompetency().toString()};

        int fieldCount = jobFieldStrings.length;
        int emptyFieldCount = 0;

        // If the field is empty, add a message and count it
        // doing a check with a loop makes it difficult to refactor or debug
        for (int i = 0; i < fieldCount; i++) {
            if (jobFieldStrings[i].equals("")) {
                jobFieldStrings[i] = emptyFieldMessage;
                emptyFieldCount++; // pesky
            }
        }

        // If all the fields are empty, print the appropriate message
        if (emptyFieldCount == fieldCount) {
            return allFieldsEmptyMessage;
        }


        return "\n" +
                String.format("ID: %s\n", this.getId()) +
                String.format("Name: %s\n", jobFieldStrings[0]) +
                String.format("Employer: %s\n", jobFieldStrings[1]) +
                String.format("Location: %s\n", jobFieldStrings[2]) +
                String.format("Position Type: %s\n", jobFieldStrings[3]) +
                String.format("Core Competency: %s\n", jobFieldStrings[4]);
    }

    //@Override
    //a better toString method
    public String toStringTwo() {
        // (Bonus) If a Job object ONLY contains data for the id field, the method should return, "OOPS! This job does not seem to exist."

        String emptyFieldMessage = "Data not available";
        String allFieldsEmptyMessage = "OOPS! This job does not seem to exist.";

        // If all the fields are empty, print the appropriate message
        if (this.getName().equals("")
                && this.getEmployer().toString().equals("")
                && this.getLocation().toString().equals("")
                && this.getPositionType().toString().equals("")
                && this.getCoreCompetency().toString().equals("")) {
            return allFieldsEmptyMessage;
        } else {
            // If a field is empty, print a message, otherwise print the field
            return "\n" +
                    String.format("ID: %s\n", String.valueOf(this.getId()).equals("") ? emptyFieldMessage : this.getId()) + // The logic here might be unnecessary
                    String.format("Name: %s\n", this.getName().equals("") ? emptyFieldMessage : this.getName()) +
                    String.format("Employer: %s\n", this.getEmployer().toString().equals("") ? emptyFieldMessage : this.getEmployer()) +
                    String.format("Location: %s\n", this.getLocation().toString().equals("") ? emptyFieldMessage : this.getLocation()) +
                    String.format("Position Type: %s\n", this.getPositionType().toString().equals("") ? emptyFieldMessage : this.getPositionType()) +
                    String.format("Core Competency: %s\n", this.getCoreCompetency().toString().equals("") ? emptyFieldMessage : this.getCoreCompetency());
        }
    }

    // Two Job objects are equal if they have the same id.
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

    // Getters for each field EXCEPT nextId. Setters for each field EXCEPT nextID and id.

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
