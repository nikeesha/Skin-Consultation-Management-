import java.util.UUID;
public class Person {
    private String name;
    private String surname;
    private String dateOfBirth;
    private String mobileNo;


    public Person(String name, String surname, String dateOfBirth, String mobileNo) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.mobileNo = mobileNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber() {
        return mobileNo;
    }

    public void setPhoneNumber(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public static class Doctor extends Person {
        private final String medicalLicenseNo;
        private final String specialisation;


        public Doctor(String name, String surname, String dateOfBirth, String mobileNo, String medicalLicenseNo, String specialisation) {
            super(name, surname, dateOfBirth, mobileNo);
            this.medicalLicenseNo = medicalLicenseNo;
            this.specialisation = specialisation;
        }

        public String getSpecialisation() {
            return specialisation;
        }

        public String getMedicalLicenseNo() {
            return medicalLicenseNo;
        }
    }

    public static class Patient extends Person {
        private final UUID patientID; // Unique ID for patient

        public Patient(String name, String surname, String dateOfBirth, String mobileNo) {
            super(name, surname, dateOfBirth, mobileNo);
            this.patientID = UUID.randomUUID(); // Randomly generating a unique ID for patient

        }

        public UUID getPatientID() {
            return patientID;
        }
    }
}
