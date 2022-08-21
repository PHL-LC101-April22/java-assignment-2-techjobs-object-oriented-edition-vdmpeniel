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


    public Job(){
        id = nextId++;
    }
    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency){
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    @Override
    public boolean equals(Object o) {
        return (this == o)? true
                :((o == null) || (o.getClass() != this.getClass()))? false
                :(this.getClass().cast(o)).getId() == id;
    }
    @Override
    public int hashCode(){
        return Objects.hash(getId());
    }
    @Override
    public String toString(){
        String emptyData = "Data not available";
        return (
                (Objects.isNull(name) || name.isEmpty() || name.isBlank())
                && (Objects.isNull(employer) || employer.getValue().isEmpty() || employer.getValue().isBlank())
                && (Objects.isNull(location) || location.getValue().isEmpty() || location.getValue().isBlank())
                && (Objects.isNull(positionType) || positionType.getValue().isEmpty() || positionType.getValue().isBlank())
                && (Objects.isNull(coreCompetency) || coreCompetency.getValue().isEmpty() || coreCompetency.getValue().isBlank())
            )? "OOPS! This job does not seem to exist."
                : String.format(
                    "\nID: %d\n" +
                    "Name: %s\n" +
                    "Employer: %s\n" +
                    "Location: %s\n" +
                    "Position Type: %s\n" +
                    "Core Competency: %s\n",
                    id,
                    ((Objects.isNull(name) || name.isEmpty() || name.isBlank())? emptyData : name),
                    ((Objects.isNull(employer.getValue()) || employer.getValue().isEmpty() || employer.getValue().isBlank())? emptyData : employer.getValue()),
                    ((Objects.isNull(location.getValue()) || location.getValue().isEmpty() || location.getValue().isBlank())? emptyData : location.getValue()),
                    ((Objects.isNull(positionType.getValue()) || positionType.getValue().isEmpty() || positionType.getValue().isBlank())? emptyData : positionType.getValue()),
                    ((Objects.isNull(coreCompetency.getValue()) || coreCompetency.getValue().isEmpty() || coreCompetency.getValue().isBlank())? emptyData : coreCompetency.getValue())
                );
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }
}
