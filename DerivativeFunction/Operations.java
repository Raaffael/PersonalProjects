
public class Operations {
	
	public Operations() {
		
	}
	public static char[][] stringToCharDArry(String strng) {
		char[] orgnal = strng.toCharArray();
		char[][] terms = new char[3][10];
		int j=0;
		int k=0;
		for(int i=0; i<orgnal.length; i++) {
			if(orgnal[i]=='+'||orgnal[i]=='-') {
				if(i!=0) {
					j++;
				}
				k=0;
			}
			terms[j][k]+=orgnal[i];
			k++;
		}
		return terms;
	}
	public static Term[] generateTermArrayFromString(String strng) {
		char[][] dubArray=stringToCharDArry(strng);
		Term[] terms= new Term[dubArray.length];
		for(int i=0;i<terms.length;i++) {
			//for(int j=0;j<dubArray[i].length;j++) {
				terms[i]=new Term(dubArray[i]);
			//}
		}
		return terms;
	}
	public static Term[] combineTwoTermArrays(Term[] first, Term[] second) {
		//Term[] pol = poly;
		Term[] newRA;
		if(first==null) {
			newRA= new Term[second.length];
		}else {
			newRA= new Term[first.length+second.length];
			int k = 0;
			for (int i = 0; i < first.length; i++) {
				try {
					newRA[k] = new Term(first[i].dispTerm().toCharArray());
					k++;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}
			}
			for (int i = 0; i < second.length; i++) {
				newRA[k] = new Term(second[i].dispTerm().toCharArray());
				k++;
			} 
		}
		return newRA;
	}
	public static Term multiplyTerms(Term first, Term second) {
		Term product=new Term(first.dispTerm().toCharArray());
		Term sec = new Term(second.dispTerm().toCharArray());
			for (int j = 0; j < sec.getVarArray().length; j++) {
				Variable sLetter=sec.getOneVar(j);
				try {
					product.addNewVar(sLetter.getLetter(), sLetter.getPower());
					//System.out.println("\n"+product.dispTerm()+ "A : add one new var");	
				} catch (NullPointerException e) {
					//e.printStackTrace();
				}
		}
		product.setCoefficient(product.getCoefficient()*sec.getCoefficient());
		return product;
	}
	public static void dispNrray(Term[] test) {
		System.out.print("\n{");
		for (int i = 0; i < test.length; i++) {
			try {
				System.out.print(test[i].dispTerm());
			} catch (NullPointerException e) {
				
			}
		}
		System.out.println("}");
	}
	public static Term[] combineLikeTerms(Term[] func) {
		Term[] simpFunc = new Term[func.length];
		int k=0;
		for(int i=0; i<func.length;i++) {
			for(int j=func.length-1; j>i;j--) {
				if(func[i]!=null&&func[j]!=null) {
					if(compatibleToAdd(func[i], func[j])) {
							Term sum =add(func[i],func[j]);
							if(sum.getCoefficient()!=0) {
								simpFunc[k]=sum;
								k++;
							}
						func[i]=null;
						func[j]=null;
					}
					combineLikeTerms(simpFunc);
				}
			}
		}
		for(int i=0; i<func.length;i++) {
			if(func[i]!=null) {
				simpFunc[k]=func[i];
				k++;
			}
		}
		
		return removeEmptySpace(simpFunc);
	}
	public static boolean compatibleToAdd(Term first, Term second) {
		
		for (int i = 0; i < first.getVarArray().length; i++) {
			/*if((int)first.getOneVar(0).getLetter()==0||(int)second.getOneVar(0).getLetter()==0) {
				if((int)first.getOneVar(0).getLetter()==0&&(int)second.getOneVar(0).getLetter()==0) {
					return true;
				}
			}*/
			try {
				if (first.getOneVar(i).getLetter()!=second.getOneVar(i).getLetter()) {
					return false;
				}
				if(first.getOneVar(i).getPower()!=second.getOneVar(i).getPower()) {
					return false;
				}
			} catch (NullPointerException e) {
				if(first.getOneVar(i)==null&&second.getOneVar(i)==null) {
				//	System.out.println("HII");
					return true;
				}else {
					return false;
				}
			}
			
		}
		return false;
	}
	public static Term[] removeEmptySpace(Term[] ra) {
		int numOfTerms=0;
		for(int i=0; i<ra.length;i++) {
			if(ra[i]!=null) {
				numOfTerms++;
			}
		}
		Term[] full = new Term[numOfTerms];
		int k=0;
		for(int i=0; i<ra.length;i++) {
			if(ra[i]!=null) {
				full[k]=new Term(ra[i].dispTerm().toCharArray());
				k++;
			}
		}
		return full;
	}
	public static Term add(Term first, Term second) {
		if(compatibleToAdd(first, second)) {
			Term sum = new Term(first.dispTerm().toCharArray());
			sum.setCoefficient(first.getCoefficient()+second.getCoefficient());
			//System.out.println(sum.coefficient + " Term: " + sum.showTerm());
			return sum;
		}else {
			System.out.println("Terms are not compatible");
		}
		return null;
	}
	public static Term[] copyOfTermArray(Term[] original) {
		Term[] newOne;
		try {
			newOne = new Term[original.length];
			for(int i=0 ; i<original.length;i++) {
				newOne[i]=new Term(original[i].dispTerm().toCharArray());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			newOne=null;
		}
		return newOne;
		
	}
	public static void displayFunction(Polynomial numerator, Polynomial denominator) { //DID NOT USE
		numerator.dispArray();
		if(denominator.getArray()!=null) {
			for(int i=0; i<numerator.getArray().length*7; i++) {
				System.out.print("_");
			}
			System.out.print("\n");
			denominator.dispArray();
		}
		
	}
	
}
