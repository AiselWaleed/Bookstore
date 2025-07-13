
public class PaperBook extends Book {
	int stock;
	public PaperBook(String iSBN,String title,int pubyear,double price, int stock){
		super(iSBN,title, pubyear, price);
		this.stock=stock;
	}
	
	public int getStock() {
		return stock;
	}
	
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public void ship(String address){
		//no implementation required.
		System.out.println(getTitle()+" shipped to "+address+"!");
		System.out.println("");

	}
	
}
