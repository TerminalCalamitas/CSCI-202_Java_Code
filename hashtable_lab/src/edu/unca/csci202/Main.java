package edu.unca.csci202;

public class Main {

    /**
     * Basic SimpleHashTable tests.
     * 
     * @param args
     */
    public static void main(String[] args) {
	// initialize with 8 bins
	SimpleHashTable<String, Person> table = new SimpleHashTable<String, Person>(8);

	System.out.println("current load factor: " + table.getCurrentLoadFactor());
	Person p1 = new Person("Kevin", "Sanft");
	// System.out.println(p1);
	Person p2 = new Person("Becky", "Sanft");
	// System.out.println(p2);

	table.put(p1.getUserId(), p1);
	table.put(p2.getUserId(), p2);
	// print all the bins
	table.printTable();
	// print the key:value pairs
	System.out.println(table);
	System.out.println("current load factor: " + table.getCurrentLoadFactor());

	// reduce load factor limit, should force increase capacity to 32 bins

	table.setLoadFactorLimit(.1);
	System.out.println("current load factor: " + table.getCurrentLoadFactor()); // should be 0.0625
	table.printTable();// prints all 32 bins
	System.out.println(table);

	// insert an element with duplicate key
	Person p3 = new Person("K.", "Sanft");
	table.put(p3.getUserId(), p3); // should replace p1 ("K." instead of "Kevin")
	System.out.println(table);

	Person p4 = table.get("not_here");
	System.out.println("p4 should be null: " + p4);

	Person p5 = table.remove("ksanft");
	System.out.println("p5: " + p5); // person K. Sanft

	System.out.println(table);
    }

}
