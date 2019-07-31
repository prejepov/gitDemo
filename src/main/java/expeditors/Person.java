package expeditors;

public class Person implements Comparable<Person> {

	private String first_name;
	private String last_name;
	private String address;
	private String age;

	public Person(String first_name, String last_name, String address, String age) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.address = address;
		this.age = age;
	}

	public String getFirst_name() {
		return first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public String getAddress() {
		return address;
	}

	public String getAge() {
		return age;
	}

	 @Override
	public int compareTo(Person o) {

		return this.getFirst_name().compareTo(o.getFirst_name());
	}

	public int compare(Person o) {

		return this.getLast_name().compareTo(o.getLast_name());
	}

	@Override
	public String toString() {
		return first_name + ", " + last_name + ", " + address + ", " + age;
	}

	
}
