import javax.swing.*;

public class Window extends JFrame{
	
	public Window(ListListener listener) {
		setTitle("SMART");
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		add(new Menus(listener));
		setVisible(true);
	}
}
