
public class Term{
	private char[] possibVars = {'x', 'y', 'h','z'};
	private int coefficient;
	private Variable[] variables;
	public Term(char[] trm) {
		generateCoefficient(trm);
		generateVarsFromScratch(trm);
	}
	public boolean isPos(){
		if(coefficient<0) {
			return false;
		}else {
			return true;
		}
	}
	public Variable getOneVar(int i) {
		Variable getter = variables[i];
		return getter;
	}
	public Variable[] getVarArray() {
		return variables;
	}
	public void distributeNeg() {
		coefficient=(coefficient*-1);
	}
	public void generateVarsFromScratch(char[] org) {
		variables=new Variable[5];
		int k=0;
		for(int i=0; i<org.length; i++) {
			for(int j=0; j<possibVars.length; j++) {
				if(org[i]==possibVars[j]) {
					try {
						if(org[i+1]=='^') {
							variables[k] = new Variable(org[i], Character.getNumericValue(org[i+2]));
							
							k++;
						}else {
							variables[k] = new Variable(org[i], 1);
							k++;
						}
					} catch(IndexOutOfBoundsException e) {
						variables[k] = new Variable(org[i], 1);
						k++;
					}
				}
			}
		}
	}
	public void addNewVar(char org, int pwr) {
		for(int i=0;i<variables.length;i++) {
			if(variables[i]==null){
				variables[i]=new Variable(org,pwr);
				break;
			}
			else if(variables[i].getLetter()==org) {
				variables[i].addPower(pwr);
				break;
			}
		}
	}
	public void setVarArray(Variable[] varis) {
		variables=varis;
	}
	public void eraseAndSetOneVar(char org, int power) {
		variables=new Variable[1];
		variables[0]=new Variable(org, power);

	}
	public void generateCoefficient(char[] org) {
		String coef = "";
		for(int i=0; i<org.length; i++) {
			for (int j = 0; j < possibVars.length; j++) {
				if (org[0] == possibVars[j]) {
					coefficient=1;
					return;
				} 
			}
			if(Character.isDigit(org[i])) {
				coef+=org[i];
				
					try {
						if (!Character.isDigit(org[i + 1])) {
							coefficient = Integer.parseInt(coef);
							break;
						}
					} catch (ArrayIndexOutOfBoundsException e) {
						// TODO Auto-generated catch block
						//e.printStackTrace();
						//System.out.println("HI");
						coefficient = Integer.parseInt(coef);
						break;
						//System.out.println(coef);
					} 
				
			}else {
				coefficient=1;
			}
		}
		if(org[0]=='-') {
			coefficient = (coefficient*-1);
		}
	}
	public int getCoefficient() {
		return coefficient;
	}
	public void setCoefficient(int newCoeff) {
		coefficient=newCoeff;
	}
	public String dispTerm() {
		String finalTerm="";
		//finalTerm+="[";
		if(coefficient>=0) {
			finalTerm+="+";
		}
		finalTerm+=coefficient+"(";
		for(int i=0;i<variables.length;i++) {
			try {
				if (variables[i].getPower()>=1) {
					finalTerm += variables[i].showVari();
				}
			}catch(NullPointerException e) {
				//e.printStackTrace();
			}
		}
		finalTerm+=")";
		//finalTerm+="]";
		return finalTerm;
	}
	
}
