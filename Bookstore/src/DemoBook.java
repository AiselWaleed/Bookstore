
public class DemoBook extends Book{
	
	public DemoBook(String iSBN,String title,int pubyear,double price){
		super(iSBN, title, pubyear, price);
	}
	
	public String toString(){
		return super.toString() +"(Demo)";
	}
}
