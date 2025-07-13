import java.util.ArrayList;


public class Store {
	ArrayList <Book> inventory;
	ArrayList <Integer> amounts;
	public Store(){
		inventory=new ArrayList <Book> ();
		amounts= new ArrayList <Integer> ();
	}
	
	public void addBook(String iSBN,String title,int pubyear,double price){
		addBook(iSBN, title, pubyear, price, 1);
	}
	
	public void addBook(String iSBN,String title,int pubyear,double price, int amount){
		int wantedIndex= findBook(iSBN);
		if (wantedIndex==-1){
			inventory.add(new Book(iSBN, title, pubyear,price));
			amounts.add(amount);
		}
		else{
			int currentAmount=amounts.get(wantedIndex);
			amounts.set(wantedIndex,currentAmount+amount);			
		}
	}
	
	public void addBook(Book book){
		if (book instanceof EBook){
			addBook (book, 9999); //represents infinite number of purchases
		}
		else 
			addBook(book, 1);
	}
	
	public void addBook(Book book, int amount){
		inventory.add(book);
		amounts.add(amount);
	}
	
	public void removeBook(String iSBN){
		if (findBook(iSBN)!=-1){
			amounts.remove(findBook(iSBN));
			inventory.remove(findBook(iSBN));
		}
	}
	
	//Same content, different formats = different ISBNs.
	
	public int findBook(String iSBN){
		for (int i=0; i< inventory.size(); i++){
			if(inventory.get(i).getiSBN()==iSBN)
				return i;
		}
		return -1;
	}
	
	
	public ArrayList<Book> removeOutdated (int noOfYears){
		int bookAge=0;
		ArrayList <Book> outdatedBooks= new ArrayList <Book>();
		
		for (int i=0; i< inventory.size(); i++){
			bookAge=2025-inventory.get(i).getPubyear();
			if (bookAge>noOfYears){
				outdatedBooks.add(inventory.remove(i));
				amounts.remove(i);
			}
		}
		return outdatedBooks;
	}
	
	public double buyBook(String iSBN, int quantity, String email, String address){
		int wantedBookIndex=findBook(iSBN);
		
		try {	
			if (wantedBookIndex==-1)
				throw new UnavailableBookException("Apologies! Book is unavailable.");
			
			//SELF--non-existent books excluded
			Book wantedBook= inventory.get(wantedBookIndex); 
	
			if (wantedBook instanceof DemoBook)
				throw new UnavailableBookException("Unfortunately, book is not for sale.");
			
			//SELF--Demos excluded
			
			if(quantity>amounts.get(wantedBookIndex))
				throw new UnavailableBookException("Unfortunately, book is not available in the required amount.");
				//assuming only paperbooks have limited quantities, a single EBook can be sold for infinite times.
			
			if (wantedBook instanceof PaperBook){
					PaperBook wantedPaperBook= (PaperBook)(inventory.get(wantedBookIndex));
					wantedPaperBook.ship(address);
				}
			
			int oldAmount=amounts.get(wantedBookIndex);
			amounts.set(wantedBookIndex,oldAmount-quantity);
			
			if (inventory.get(wantedBookIndex) instanceof EBook){
				EBook wantedEBook= (EBook)(inventory.get(wantedBookIndex));
				wantedEBook.send(email);
				amounts.set(wantedBookIndex,9999);	
			}
			
			return wantedBook.getPrice();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			System.out.println("");
			return -1;
		}
	}
	
	public void displayInventory(){
		
		System.out.println("--Welcome to Your Online BookStore!!--");
		System.out.println("Available Books("+inventory.size()+"):");
		for (int i=0; i< inventory.size(); i++){
			String current=inventory.get(i)+ (amounts.get(i)==9999? "" : "("+amounts.get(i)+")");
			System.out.println(current);
		}
		System.out.println(" ");
		
	}
	
}
