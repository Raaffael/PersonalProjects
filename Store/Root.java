import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Root extends JPanel{
	
	//
	private JList<String> list;// = new JList<String>(names);
	private int selectedItem;
	public Root(JList nombre, ListListener listener) {
		//System.out.println(nombre[0]);
		this.list=nombre;
		borderSetUp();
		listSetUp(listener);
		setVisible(true);
		//setFocusable(true);
		System.out.println("wowowwoow");
		requestFocus();
	}
	
	public void borderSetUp() {
		setPreferredSize(new Dimension(300,400));
		setLayout(new FlowLayout(FlowLayout.LEFT));
		Border border = BorderFactory.createLineBorder(Color.BLACK, 3);
		TitledBorder bod = BorderFactory.createTitledBorder(border, "MAIN");
		setBorder(bod);
	}
	public void listSetUp(ListListener listener) {
		list.requestFocus();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setVisibleRowCount(10);
		JScrollPane scrollPane = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBorder(null);
		list.addListSelectionListener(listener);
		list.addKeyListener(listener);
		System.out.println(selectedItem);
		add(scrollPane);
		selectedItem = list.getSelectedIndex();
	}
	public int selected() {
		return selectedItem;
	}
	
}
