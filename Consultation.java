// class to represent a consultation
import java.util.Date;

public class Consultation {
    private final Person.Doctor doctor;
    private final Person.Patient patient;
    private Date date;

    private int cost;

    private String notes;

    public Consultation(Person.Doctor doctor, Person.Patient patient, Date date, int cost, String notes) {
        this.doctor = doctor;
        this.patient = patient;
        this.date = date;
        this.cost = cost;
        this.notes = notes;
    }

    public Person.Doctor getDoctor() {
        return doctor;
    }

    public Person.Patient getPatient() {
        return patient;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date){
        this.date = date;
    }


    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}

