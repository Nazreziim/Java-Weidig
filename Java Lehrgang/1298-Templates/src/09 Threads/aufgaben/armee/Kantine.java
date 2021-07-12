package aufgaben.armee;

public class Kantine {

	public synchronized void verpflegen(Gruppe g){
		System.out.println("Gruppe "+g.getId()+" verpflegt");
		for(int i = 0; i < g.soldaten.size(); i++){
			g.soldaten.set(i,new Soldat(g.soldaten.get(i), 1));
		}
		for(Soldat s : g.soldaten){
			s.start();
		}
		for(Soldat s : g.soldaten){
			try {
				s.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Gruppe "+g.getId()+" ist fertig");		
	}
}
