/* 
	this is the class create person object
	The person read from file app_c_new.csv
	we are use Serializable because the network cannot send object on RAM
	reference: https://daynhauhoc.com/t/giao-thuc-rmi-trong-java-ung-dung-phan-tan/23963/3
*/
import java.io.Serializable;

public class Person implements Serializable {

	private String name; 
	private int count;
	private double pctwhite;
	private double pctblack;

	//defaut constructor
	public Person() {

	}

	//this is constructor
	public Person(String name, int count, double pctwhite, double pctblack) {
		this.name = name;
		this.count = count;
		this.pctwhite = pctwhite;
		this.pctblack = pctblack;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public double getPctwhite() {
		return pctwhite;
	}

	public void setPctwhite(double pctwhite) {
		this.pctwhite = pctwhite;
	} 

	public double getPctblack() {
		return pctblack;
	}

	public void setPctblack(double pctblack) {
		this.pctblack = pctblack;
	}
}