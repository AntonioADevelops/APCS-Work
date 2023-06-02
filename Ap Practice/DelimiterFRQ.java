import java.util.ArrayList;
public class DelimiterFRQ {
    public static void main(String[] args) 
    {
		/*Test part a*/
		Delimiters parens = new Delimiters("(", ")");
		String[] mathTokens = {"(", "x+y", ")", "*5"};
		ArrayList<String> mathDelimiters = parens.getDelimitersList(mathTokens);
		System.out.println(mathDelimiters + " " + parens.getType());

		Delimiters qTags = new Delimiters("<q>", "</q>");
		String[] qTokens = {"<q>", "yy", "</q>", "zz", "</q>"};
		ArrayList<String> qDelimiters = qTags.getDelimitersList(qTokens);
		System.out.println(qDelimiters);

		/*Test part b*/
		Delimiters supTags = new Delimiters("<sup>", "</sup>");
		
		//balanced
		String[] ex1 = {"<sup>", "<sup>", "</sup>", "<sup>", "</sup>", "</sup>"};
		ArrayList<String> ex1Delimiters = supTags.getDelimitersList(ex1);
		System.out.println(supTags.isBalanced(ex1Delimiters));

		//not balanced
		String[] ex2 = {"<sup>", "</sup>", "</sup>", "<sup>"};
		ArrayList<String> ex2Delimiters = supTags.getDelimitersList(ex2);
		System.out.println(supTags.isBalanced(ex2Delimiters));

		//not balanced
		String[] ex3 = {"</sup>"};
		ArrayList<String> ex3Delimiters = supTags.getDelimitersList(ex3);
		System.out.println(supTags.isBalanced(ex3Delimiters));

		//not balanced
		String[] ex4 = {"<sup>", "<sup>", "</sup>"};
		ArrayList<String> ex4Delimiters = supTags.getDelimitersList(ex4);
		System.out.println(supTags.isBalanced(ex4Delimiters));

	}
}
