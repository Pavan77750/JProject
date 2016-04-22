package messages;

public class PlainMessage extends ShowMessage{
	PlainMessage(String msg){
		showMessage(msg);
	}
	public void showMessage(String Message){
		System.out.println(Message);
	}
	
}