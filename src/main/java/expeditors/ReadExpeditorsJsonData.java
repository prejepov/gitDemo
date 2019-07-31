package expeditors;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadExpeditorsJsonData {

	public static void main(String[] args) {
		
		/**Exercise
		 * 
		 * Requirements:
		 * Write a standalone executable or script using the language of your preference (Java is the primary dev language at Expeditors).
		 * Given the provided input data, print the expected output to the console or write to a text file.
		 * Input data:
		 * "Dave","Smith","123 main st.","seattle","wa","43"
		 * "Alice","Smith","123 Main St.","Seattle","WA","45"
		 * "Bob","Williams","234 2nd Ave.","Tacoma","WA","26"
		 * "Carol","Johnson","234 2nd Ave","Seattle","WA","67"
		 * "Eve","Smith","234 2nd Ave.","Tacoma","WA","25"
		 * "Frank","Jones","234 2nd Ave.","Tacoma","FL","23"
		 * "George","Brown","345 3rd Blvd., Apt. 200","Seattle","WA","18"
		 * "Helen","Brown","345 3rd Blvd. Apt. 200","Seattle","WA","18"
		 * "Ian","Smith","123 main st ","Seattle","Wa","18"
		 * "Jane","Smith","123 Main St.","Seattle","WA","13"
		 * Expected output: 
		 * Each household and number of occupants, followed by:
		 * Each First Name, Last Name, Address and Age sorted by Last Name then First Name where the occupant(s) is 18 and older. 
		 * 
		 */
		
		/*
		 * The input data converted, written as json file.
		 * The purpose of using as a json data format is 
		 * to  parse the data with json-simple library
		 *
		 */
		
		//creating JSONParser object
		JSONParser parser = new JSONParser();

		try {
			
			//Creating an object to parse the json file that is provided with FileReader
			Object obj = parser.parse(new FileReader("data.json"));
			
			//After reading data data will be parsed to a JSONObject
			JSONObject jsonObject = (JSONObject) obj;
			
			//the json file is a object of arrays and parsed to JSONArray object to iterate over it
			JSONArray jsonArray = (JSONArray) jsonObject.get("person");
			
			//List is created to store list of person objects defined in Person.java class
			List<Person> listOfPerson = new ArrayList<>();

			for (int i = 0; i < jsonArray.size(); i++) {
				
				//iterete over an jsonArray objects and assigns the jsonArray elements to Person object
				JSONObject jsonObject1 = (JSONObject) jsonArray.get(i);

				if (Integer.parseInt((String) jsonObject1.get("age")) >= 18) {

					listOfPerson.add(
							new Person(
									(String) jsonObject1.get("first_name"), 
									(String) jsonObject1.get("last_name"),
									(String) jsonObject1.get("address"), 
									(String) jsonObject1.get("age")));
				}
			}
			
			//using collections sort listOfPerson object is sorted.
			Collections.sort(listOfPerson,Comparator.comparing(Person::getLast_name).thenComparing(Person::getFirst_name));
			
			//printed in the console
			for (int i = 0; i < listOfPerson.size(); i++) {

				System.out.println("-------------------------------------------------------");
				System.out.println(listOfPerson.get(i));
			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} catch (ParseException e) {

			e.printStackTrace();
		}

	}

}
