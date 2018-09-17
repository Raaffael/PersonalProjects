import javax.swing.JList;

public class FirstMenu extends Root {
	String[] arr = new String[] {"rely","wow"};
	JList name;//= new JList(arr);
	public FirstMenu(JList names, ListListener listener) {
		super(names, listener);
		System.out.println("HI!");
		this.name=names;;
		
	}

}
