class Operations {

	public static void main(String args[]) {
		System.out.println("Simple Calculator!");
	}

	public static int addition() {

		try {
			System.out.println("Insert the Number 1:");
			int n1 = System.in.read();
			System.out.println("Insert the Number 2:");
			int n2 = System.in.read();
			int res = n1 + n2;
			return res;
		} catch (Exception e) {
			return 00000;
		}

	}

	public static void subtraction() {
		System.out.println("\nSubtraction (-).");
	}

	public static void multiplication() {
		System.out.println("\nMultiplication (*).");
	}

	public static void division() {
		System.out.println("\nDivision (/).");
	}

}

class Calculator {

	public static void main(String args[]) {

		int res;
		Operations oper = new Operations();
		String opt = System.console().readLine("\nOperator (+ - * /): ");

		if ( opt.equals("+") ) 
			res = oper.addition();
			System.out.println("Result!");
		else if ( opt.equals("-") )
			oper.subtraction();
		else if ( opt.equals("*") )
			oper.multiplication();
		else if ( opt.equals("/") )
			oper.division();
		else
			System.out.println("\nWrong operation -> " + opt);

	}

}
