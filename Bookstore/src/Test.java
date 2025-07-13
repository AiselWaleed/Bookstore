
public class Test {
	public static void main (String [] args){
		Store store= new Store();
		//String iSBN,String title,int pubyear,double price
		
		store.addBook("978-0-06-112008-4", "To Kill a Mockingbird", 1960, 300.0,6);
		
		PaperBook prideandprejudice= new PaperBook("978-1-85326-000-1","Pride and Prejudice",1813,400.0, 40);
		store.addBook(prideandprejudice,3);
		
		store.addBook("978-0-7432-7356-5", "The Great Gatsby", 1925, 240.0,4);
		
		EBook nineteeneightyfour= new EBook("978-0-547-24964-7","1984",1949,320.0, ".pdf");
		store.addBook(nineteeneightyfour);
		
		store.addBook("978-0-06-112241-5", "The Alchemist", 1988, 270.0);
		
		//Same content, different formats = different ISBNs.
		EBook prideandprejudice2= new EBook("978-1-4209-5968-2","Pride and Prejudice",1813,390.0, ".epub");
		store.addBook(prideandprejudice2);
		
		DemoBook atomichabits= new DemoBook("978-0-316-76948-0","The Catcher in the Rye", 1951, 0);
		store.addBook(atomichabits);
		
		store.addBook("978-0-486-28499-0", "Common Sense", 1776, 230.0);


		store.displayInventory();
		
		//removing a specific existing book using its iSBN
		
		store.removeBook("978-0-7432-7356-5");
		store.displayInventory();
		
		//removing a non-existing book (no change)
		
		store.removeBook("0000");
		store.displayInventory();


		//removing outdated books
		
		System.out.println(store.removeOutdated(220));
		store.displayInventory();
		
		//buying a book (no. of copies decrement by the given quantity)
		System.out.println(store.buyBook("978-0-06-112008-4", 1,"user1@gmail.com", "Nasr City" ));
		store.displayInventory();
		
		//buying a paperbook (book gets shipped to address)
		store.buyBook("978-1-85326-000-1", 1,"user2@gmail.com", "Giza" );

		//buying an Ebook (book gets sent to mail)
		store.buyBook("978-0-547-24964-7", 1,"user3@gmail.com", "Helipolis" );

		
		//attempting to buy a non-existing book 
		store.buyBook("0000", 1, "null@gmail.com", "New Cairo");
		
		//attempting to buy a demo book
		store.buyBook("978-0-316-76948-0", 1, "user4@gmail.com", "Alexandria");

		//Final inventory
		store.displayInventory();

	}
}
