
public class Main {

	public static void main(String[] args) {
		findDerivative();
	}
	public static Polynomial setUpX(Term[] x) {
		Polynomial xx = new Polynomial(x);
		xx.distributeNeg();
		return xx;
	}
	public static Polynomial setUpH(Term[] h) {
		Polynomial hh = new Polynomial(h);
		hh.setArray(hh.insertHToAll(h));
		return hh;
	}
	public static Polynomial setUpNumerator(Term [] h, Term[] x) {
		Polynomial numerator = new Polynomial(Operations.combineTwoTermArrays(h, x));
		numerator.setArray(Operations.combineLikeTerms(numerator.getArray()));
		numerator.factorOut('h');
		numerator.evaluate('h', 0);
		numerator.setArray(Operations.combineLikeTerms(numerator.getArray()));
		return numerator;
	}
	public static void findDerivative() {
		String input ="2x^2-16x+35";
		Term[] originalTermArray = Operations.generateTermArrayFromString(input);	
		Polynomial x = setUpX(originalTermArray);
		Polynomial h = setUpH(originalTermArray);
		Polynomial numerator = setUpNumerator(h.getArray(), x.getArray());
		numerator.dispArray();
	}
	
}
