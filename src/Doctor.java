import java.util.ArrayList;
import java.util.List;

public class Doctor {

	private static final int MAX_PATIENTS = 3;

	public boolean performsSurgery() {

		return false;
	}

	public boolean makesHouseCalls() {

		return false;
	}

	private ArrayList<Patient> patients = new ArrayList<>();

	public void assignPatient(Patient patient) throws DoctorFullException  {
		// TODO Auto-generated method stub
		if(patients.size() >= MAX_PATIENTS){
			throw new DoctorFullException();
		}
		patients.add(patient);
		
	}

	public List<Patient> getPatients() {
		// TODO Auto-generated method stub
		return patients;
	}

	public void doMedicine() {
		// TODO Auto-generated method stub
		for(Patient p : patients){
			p.checkPulse();
		}
	}

}
