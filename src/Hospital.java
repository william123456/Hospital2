import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Hospital {
	private ArrayList <Doctor> doctors = new ArrayList<>();
	private ArrayList<Patient> patients = new ArrayList<>();
	public void addDoctor(Doctor doctor) {
		
		doctors.add(doctor);
	}

	public List<Doctor> getDoctors() {

		return doctors;
	}

	public void addPatient(Patient patient) {
	
		patients.add(patient);
	}

	public List<Patient> getPatients() {
		
		return patients;
	}

	public void assignPatientsToDoctors() throws NoDoctorsException, DoctorFullException{
		// TODO Auto-generated method stub
		if(doctors.isEmpty()){
			throw new NoDoctorsException();
		}
		Iterator<Doctor> doctorIterator = doctors.iterator();
		Doctor currentDoctor = doctorIterator.next();
		for(Patient p: patients){
			try {
				currentDoctor.assignPatient(p);
			} catch (DoctorFullException e) {
				// TODO Auto-generated catch block
				currentDoctor = doctorIterator.next();
				try {
					currentDoctor.assignPatient(p);
				} catch (DoctorFullException e1) {
					// TODO Auto-generated catch block
					throw e1;
				}
			}
		}
	}

}
