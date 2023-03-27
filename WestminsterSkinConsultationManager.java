import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class WestminsterSkinConsultationManager implements SkinConsultationCentre {
    private static final List<Person.Doctor> doctorList = new ArrayList<>();
    private static final List<Consultation> consultations = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        WestminsterSkinConsultationManager centre = new WestminsterSkinConsultationManager();

        System.out.println("-----Westminster Skin Consultation-----");

        while (true) {
            System.out.println("Following are the actions available");
            System.out.println("A -  Add a new doctor");
            System.out.println("B -  Delete a doctor");
            System.out.println("C -  Print list of doctors");
            System.out.println("D -  Save information");
            System.out.println("E -  Exit");
            System.out.println("Choose an action");

            String option = scanner.next().toUpperCase();

            switch (option) {
                case "A" -> {

                    centre.addNewDoctor();
                }
                case "B" -> {

                    centre.deleteDoctor();

                }
                case "C" -> {
                    // Print list of doctors
                    System.out.println("List of doctors:");
                    for (Person.Doctor d : centre.getDoctors()) {
                        System.out.println(d.getName() + " - " + d.getSpecialisation());
                    }
                }
                case "D" -> {
                    // Save information
                    centre.saveInformation();
                    System.out.println("Information saved successfully.");
                }
                case "E" -> {
                    // Exit
                    System.out.println("Exiting program.");
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    /**
     A function to add a new doctor to the centre.
     Number of doctors that can be added to the centre is 10.
     The number of doctors registered in the centre is checked and if the count is less than 10 a new doctor is added.
     */
    @Override
    public void addNewDoctor() {

        Scanner scanner = new Scanner(System.in);
        int count = doctorList.size();
        if (count < 10) {
            System.out.println("Enter doctor name:");
            String name = scanner.nextLine();

            System.out.println("Enter doctor surname:");
            String surname = scanner.nextLine();

            System.out.println("Enter doctor date of birth in dd/mm/yyyy format:");
            String dateOfBirth = scanner.nextLine();

            System.out.println("Enter doctor mobile number :");
            String mobileNo = scanner.nextLine();

            System.out.println("Enter doctor Medical License Number:");
            String medicalLicenseNo = scanner.nextLine();

            System.out.println("Enter doctor specialty:");
            String specialisation = scanner.nextLine();

            Person.Doctor doctor = new Person.Doctor(name, surname, dateOfBirth, mobileNo, medicalLicenseNo, specialisation);
            doctorList.add(doctor);
            System.out.println("Dr. " + name + " " + surname + " added to the Centre.");
        }
        else {
            System.out.println("Centre consists of 10 doctors. No more doctors can be added.");
        }
    }


    @Override
    public void deleteDoctor(String name) {
        Scanner scanner = new Scanner(System.in);

        // Delete a doctor
        System.out.println("Enter doctor name:");
        String doctorName = scanner.nextLine();
        // search for doctor with matching name
        Person.Doctor doctorToDelete = null;
        for (Person.Doctor d : doctorList) {
            if (d.getName().equals(name)) {
                doctorToDelete = d;
                break;
            }
        }
        if (doctorToDelete != null) {
            doctorList.remove(doctorToDelete);
        }
        System.out.println("Doctor deleted successfully.");
        System.out.println("Number of doctors in the centre: " + centre.getDoctors().size());
    }

    @Override
    public List<Person.Doctor> getDoctors() {
        return doctorList;
    }

    @Override
    public void addConsultation(Consultation consultation) {
        consultations.add(consultation);
    }

    @Override
    public void cancelConsultation(Consultation consultation) {
        consultations.remove(consultation);
    }

    @Override
    public List<Consultation> getConsultations () {
        return consultations;
    }

    @Override
    public void printConsultations () {
        for (Consultation consultation : consultations) {
            System.out.println(consultation.getDoctor().getName() + " - " + consultation.getPatient().getName() + " - " + consultation.getDate() + " " + consultation.getTime());
        }
    }

    @Override
    public void saveConsultations () {
            // code to save the consultations to a file
    }

    @Override
    public void saveInformation () {
        // create a file to save the information
        File file = new File("consultation_centre_information.txt");
        try {
            // create a BufferedWriter to write to the file
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));

            // write the number of doctors to the file
            writer.write(String.valueOf(doctorList.size()));
            writer.newLine();

            // write each doctor's information to the file
            for (Person.Doctor doctor : doctorList) {
                writer.write(doctor.getName());
                writer.newLine();
                writer.write(doctor.getSpecialisation());
                writer.newLine();
            }

            // write the number of consultations to the file
            writer.write(String.valueOf(consultations.size()));
            writer.newLine();

            // write each consultation's information to the file
            for (Consultation consultation : consultations) {
                writer.write(consultation.getDoctor().getName());
                writer.newLine();
                writer.write(consultation.getPatient().getName());
                writer.newLine();
                writer.write(consultation.getDate());
                writer.newLine();

            }

            // close the writer
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            }
        }
    }

