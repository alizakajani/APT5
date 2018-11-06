import java.util.Arrays;
import java.util.Comparator;

public class ClientsList {

	public class Person {
		String first;
		String last;
		public Person(String s) {
			first = s.split(" ")[0];
			last = s.split(" ")[1];
		}
		public String getLast(){
			return last;
		}
		public String getFirst(){
			return first;
		}
		
		@Override
		public String toString() {
			return first+" "+last;
		}
		
	}
	
	public String[] dataCleanup(String[] names) {
		Person[] list = new Person[names.length];
        for (int k = 0; k < names.length; k += 1) {
        	if (names[k].indexOf(',') >= 0) {
        		String[] name1 = names[k].split(", ");
        		String first = name1[1];
        		String last = name1[0];
        		list[k] = new Person(first+" "+last);
        	}
        	else {
        		list[k] = new Person(names[k]);
        	}
        }
        	
        Comparator<Person> comp = Comparator.comparing(Person::getLast);
        comp = comp.thenComparing(Person::getFirst);
        Arrays.sort(list,comp);
        for (int k = 0; k < names.length; k++) {
        	names[k] = list[k].toString();
        }
        return names;
	
	}

}
