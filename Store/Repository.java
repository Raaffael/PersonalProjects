import javax.swing.JList;
import javax.swing.JPanel;

public class Repository extends JPanel{
	String list[][] = {
			{"Merchandise Management", "Utilities", "Handheld Utilities"},
			{"A","B", "C"},
			{"One", "Two", "Three"}
	};
	public Repository() {
		String wow[][] = new String[4][0];
		wow[0] = new String[] {"Merchandise Management", "Utilities", "Handheld Utilities"};
		wow[1] = new String[] {"A","B", "C"};
		wow[2] = new String[] {"One", "Two", "Three"};
		
	}
	public JList newOne() {
		int one = 2;
		int two =4;
		String[] wo;
		if(one==2&&two==4) {
			wo = new String[]{"A","B", "C"};
		}
		else {
			wo = new String[] {"One", "Two", "Three"};
		}
		return new JList(wo);
	}
	
//	String wow[][] = new String[4][0];
//	wow[0] = new String[] {"Merchandise Management", "Utilities", "Handheld Utilities"};
//	wow[1] = new String[] {"A","B", "C"};
//	wow[2] = new String[] {"One", "Two", "Three"};

}
