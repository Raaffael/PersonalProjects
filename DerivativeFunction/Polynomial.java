//import java.util.Arrays;

public class Polynomial {
	private Term[] array;
	
	public Polynomial(Term[] ar) {
		setArray(Operations.copyOfTermArray(ar));
	}
	public Term[] getArray() { //USED
		return array;
	}
	public void setArray(Term[] array) { //USED
		this.array = array;
	}
	public Term[] insertH(Term trm) { //USED
		Term[] newTerm;
		try {
			if (trm.getOneVar(0).getPower()==2) {
				newTerm = new Term[4];
				newTerm[0] = new Term("x^2".toCharArray());
				newTerm[1] = new Term("xh".toCharArray());
				newTerm[2] = new Term("xh".toCharArray());
				newTerm[3] = new Term("h^2".toCharArray());
			}else {
				newTerm = new Term[2];
				newTerm[0] = new Term("x".toCharArray());
				newTerm[1] = new Term("h".toCharArray());
			}
			for (int i = 0; i < newTerm.length; i++) {
				newTerm[i].setCoefficient(newTerm[i].getCoefficient() * trm.getCoefficient());
			}
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			newTerm=new Term[1];
			newTerm[0] = new Term(trm.dispTerm().toCharArray());
		}
		return Operations.combineLikeTerms(newTerm);
	}
	public Term[] insertHToAll(Term[] original) { //USED
		Term[] combined=insertH(original[0]);
		for(int i=1;i<original.length;i++) {
			//Operations.dispNrray(combined);
			combined = Operations.combineTwoTermArrays(combined, insertH(original[i]));
		}
		
		return combined;
	}
	public void dispArray() { //USED
		System.out.print("\n{");
		for (int i = 0; i < this.array.length; i++) {
			System.out.print(this.array[i].dispTerm());
		}
		System.out.println("}");
	}
	public void distributeNeg() { //USED
		for(int i=0;i<this.array.length;i++) {
			array[i].distributeNeg();
		}
	}
	public void factorOut(char c) { //USED
		for(int i=0; i<this.array.length;i++) {
			try {
				for(int j=0; j<this.array[i].getVarArray().length;j++) {
					if(this.array[i].getOneVar(j).getLetter()==c) {
						this.array[i].getOneVar(j).setPower(this.array[i].getOneVar(j).getPower()-1);
						this.array[i]=new Term(this.array[i].dispTerm().toCharArray());
					}
				}
			} catch (NullPointerException e) {
				
			}
		}
	}
	public void evaluate(char charac , int input) { //USED
		for(int i=0; i<this.array.length;i++) {
			try {
				for(int j=0; j<this.array[i].getVarArray().length;j++) {
					if(this.array[i].getOneVar(j).getLetter()==charac) {
						//this.array[i].getOneVar(j).setPower(this.array[i].getOneVar(j).getPower()-1);
						int result = (int) (input*(Math.pow(this.array[i].getCoefficient(), this.array[i].getOneVar(j).getPower())));
						this.array[i]= new Term(String.valueOf(result).toCharArray());
					}
				}
			} catch (NullPointerException e) {
				
			}
		}
	}

}
