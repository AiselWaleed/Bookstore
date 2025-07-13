
public class EBook extends Book{
	String filetype;
	public EBook(String iSBN,String title,int pubyear,double price,	String filetype){
		super(iSBN,title, pubyear, price);
		this.filetype=filetype;
	}
	
	public String getFiletype() {
		return filetype;
	}
	
	public void send(String email){
		//no implementation required.
		System.out.println(getTitle()+" sent to "+email+"!");
		System.out.println("");
	}
	
	public String toString(){
		return super.toString() +"<"+getFiletype()+">";
	}
}
