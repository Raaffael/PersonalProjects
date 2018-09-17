
public class Variable {
	//private char[] possibVars = {'x', 'y', 'h'};
	private int power;
	private char letter;
	public Variable(char vari, int pwr) {
		letter=vari;
		power=pwr;
	}
	public String showVari() {
		String fin = "";
		fin+=letter;
		if(power>1) {
			fin+=("^"+power);
		}
		return fin;
	}
	public int getPower() {
		return power;
	}
	public char getLetter() {
		return letter;
	}
	public void setPower(int pwr) {
		power=pwr;
	}
	public void addPower(int p) {//when multiplying vars together
		power+=p;
	}
	public void setLetter(char let) {
		letter=let;
	}
	
}
