import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ListListener implements ListSelectionListener, KeyListener{
		private int menuNumber = 0;
		private int keyCode = 0;
		private int indexSelected;
		public void valueChanged(ListSelectionEvent e) {
			indexSelected = ((JList) e.getSource()).getSelectedIndex();
			//System.out.println("index = " + indexSelected);
		}
		public void keyPressed(KeyEvent arg0) {
			//System.out.println(arg0.getKeyCode());
			keyCode = arg0.getKeyCode();
			if(keyCode==10) {
				//setVisible(false);
				String[] hi = {"ehlo", "hi"};
				JList ha = new JList(hi);
				JPanel hey = new FirstMenu(ha, null);
				hey.revalidate();
				hey.repaint();
				//hey.setVisible(true);
				//list.requestFocus();
				menuNumber++;
				//System.out.println("menu # = " + menuNumber);
				
			}
			if(keyCode==114) {
				menuNumber--;
			}
			
		}
		public void keyReleased(KeyEvent arg0) {}
		
		public void keyTyped(KeyEvent arg0) {}
		
		public int getMenuNumber() {
			return menuNumber;
		}
		public int getIndex() {
			return indexSelected;
		}
	}
