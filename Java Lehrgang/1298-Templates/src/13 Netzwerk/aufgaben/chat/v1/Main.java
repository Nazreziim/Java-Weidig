package aufgaben.chat.v1;



public class Main {

	public static void main(String[] args) {
		ChatModel cc = new ChatModel();
		ChatFrame cf = new ChatFrame(cc);
		cc.addObserver(cf);
		new Thread(cc).start();;
			      
	

	}

}
