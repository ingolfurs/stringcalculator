package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		text = text.replace("\n",",");

		/* Empty string */
		if(text.equals("")){
			return 0;
		}

		/* One number */
		else if (containsOnlyNumbers(text)) {
			return toInt(text);
		}

		/* The input text contains more than one number */

		/* Handle different delimiter */
		if (text.length() > 2 && text.substring(0,2).equals("//")) {
			String delimiter = text.substring(2,3);
			text = text.replace(delimiter,",");
			text = text.substring(4,text.length());
		}

		if(text.contains(",")){
			return sum(splitNumbers(text));
		}
		else
			return 1;
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers){
	    return numbers.split(",");
	}

	private static int sum(String[] numbers){
		int total = 0;
		for(String number : numbers){
			total += toInt(number);
		}
		return total;
	}

	private static boolean containsOnlyNumbers(String text) {
		if (text == null || text.length() == 0)
			return false;

		for (int i = 0; i < text.length(); i++) {
			if (!Character.isDigit(text.charAt(i))) 
				return false;
		}
		return true;
	}
}
