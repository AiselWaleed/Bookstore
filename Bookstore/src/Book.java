
public class Book {
String iSBN;
String title;
int pubyear;
double price;
	public Book(String iSBN,String title,int pubyear,double price){
		this.iSBN= iSBN;
		this.title=title;
		this.pubyear=pubyear;
		this.price=price;
	}
	
	public String getiSBN() {
		return iSBN;
	}
	
	public String getTitle() {
		return title;
	}
	
	public int getPubyear() {
		return pubyear;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String toString(){
		return getTitle()+" ("+getPubyear()+")";
	}
}
