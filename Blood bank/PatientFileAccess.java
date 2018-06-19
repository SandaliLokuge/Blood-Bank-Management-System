package server.ijse.rmi.bloodbank.fileaccess;

import common.ijse.rmi.bloodbank.model.Patient;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.StringTokenizer;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class PatientFileAccess{
	private final File file=new File("DataAccess/patientDataAccess.txt");
	private static ReentrantReadWriteLock readWriteLock=new ReentrantReadWriteLock();
	
	public boolean addPatient(Patient patient)throws RemoteException,ClassNotFoundException,IOException{
		try{
			readWriteLock.writeLock().lock();
			FileWriter fileWriter=null;
			BufferedWriter bufferedWriter=null;
			try{
				if(!file.exists()){
					file.createNewFile();
				}
				String data="";
				data+=patient.getPatientid() + "$";
				data+=patient.getTitle() + "$";
				data+=patient.getFirstname() + "$";
				data+=patient.getLastname() + "$";
				data+=patient.getGender() + "$";
				data+=patient.getHospital() + "$";
				data+=patient.getAge() + "$";
				data+=patient.getDiseasedetail() + "$";
				
				fileWriter=new FileWriter(file,true);
				bufferedWriter=new BufferedWriter(fileWriter);
				bufferedWriter.write(data);
				bufferedWriter.flush();
				
			}finally{
				bufferedWriter.close();
				fileWriter.close();
			}
			return true;
		}finally{
			readWriteLock.writeLock().unlock();
		}
	}
	public Patient searchPatientByid(String patientid)throws RemoteException,ClassNotFoundException,IOException{
		try{
			readWriteLock.readLock().lock();
			if(file.exists()){
				BufferedReader bufferedReader=new BufferedReader(new FileReader(file));
			    String line=bufferedReader.readLine();
			    StringTokenizer stringTokenizer=new StringTokenizer(line);
			    String ar[]=new String[stringTokenizer.countTokens()];
			    for(int i=0;i<ar.length;i++){
					if(stringTokenizer.hasMoreTokens()){
						ar[i]=stringTokenizer.nextToken();
				    }
			    }
			    Patient patient=null;
			    for(int i=0;i<ar.length;i+=8){
					if(patientid.equals(ar[i])){
						patient=new Patient();
					    patient.setPatientid(ar[i]);
					    patient.setTitle(ar[i + 1]);
					    patient.setFirstname(ar[i + 2]);
					    patient.setLastname(ar[i + 3]);
					    patient.setGender(ar[i + 4]);
					    patient.setHospital(ar[i + 5]);
					    patient.setAge(ar[i + 6]);
					    patient.setDiseasedetail(ar[i + 7]);
					    break;
				    }
			    }
			    return patient;
		    }else{
			    return null;
		    } 
         }finally{
			readWriteLock.readLock().unlock();
		 }
	 }
}
