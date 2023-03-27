import java.util.List;

// interface to represent the Skin Consultation Centre
public interface SkinConsultationCentre {
    void addDoctor(Person.Doctor doctor);
    void deleteDoctor(String name);
    List<Person.Doctor> getDoctors();
    void addConsultation(Consultation consultation);
    void cancelConsultation(Consultation consultation);
    List<Consultation> getConsultations();
    void printConsultations();
    void saveConsultations();
    void saveInformation();
}

