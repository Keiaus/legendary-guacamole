import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Student {
	private String firstName, lastName, major;
	private double gpa;
	public ArrayList<String> newList = new ArrayList<String>();
	Scanner sc = new Scanner(System.in);
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public double getGpa() {
		return gpa;
	}
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	
	public void writeToFile(ArrayList<String> newList) throws Exception {
		try {
		    FileWriter file = new FileWriter("/Users/keiaus/eclipse-workspace/Workspace2/src/students.txt", true);
			BufferedWriter bw = new BufferedWriter(file);
			for (String value : newList) {
				bw.write(value);
				bw.newLine();
			}
			bw.flush();
			bw.close();
		} catch (Exception e) {
			System.out.println("An error has occurred");
			e.printStackTrace();
		}
		readFile();
	}
	
	public void readFile() throws Exception {
		try {
		  File file = new File("/Users/keiaus/eclipse-workspace/Workspace2/src/students.txt");
	      Scanner myReader = new Scanner(file);
	      while (myReader.hasNext()) {
	        String data = myReader.nextLine();
	        System.out.println(data);
	      }
	      myReader.close();
	    } catch (Exception e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	}
	
	public void studentPrompt() throws Exception {
//		for (int i = 0; i < 3; i++) {
		System.out.print("First Name: ");
		String firstName = sc.nextLine();
		System.out.print("Last Name: ");
		String lastName = sc.nextLine();
		System.out.print("Major: ");
		String major = sc.nextLine();
		System.out.print("GPA: ");
		double gpa = sc.nextDouble();
		
		setFirstName(firstName);
		setLastName(lastName);
		setMajor(major);
		setGpa(gpa);
		
		newList.add(toString());
		writeToFile(newList);
//		}
	}
	
	@Override
	public String toString() {
		return getFirstName() + " " + getLastName() + ", " + getMajor() + ", " + getGpa();
	}
}
