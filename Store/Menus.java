import javax.swing.*;

public class Menus extends JPanel{
	
	public Menus(ListListener listener) {
		String[] names = {"heloo", "wowo", "many wow"};
		JList nombre = new JList(names);
		Root oi = new Root(nombre, listener);
		add(oi);
		System.out.println("menu # = " + listener.getMenuNumber());
		System.out.println("index # = " + listener.getIndex());
		if(listener.getMenuNumber()==2&&listener.getIndex()==1) {
			System.out.println("HOOEE");
		}
		
		//add(new FirstMenu(nombre, listener));
	}
	
}
