package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		text = text.replace("\n",",");

		/* Handle different delimiter */
		if (text.length() > 2 && text.substring(0,2).equals("//")) {
			String delimiter = text.substring(2,3);
			text = text.replace(delimiter,",");
			text = text.substring(4,text.length());
		}

		return sum(splitNumbers(text));
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers){
		/* Empty string */
		if (numbers.isEmpty())
			return new String[0];
		return numbers.split(",");
	}

	private static int sum(String[] numbers){
		int total = 0;
		for(String number : numbers){
			total += toInt(number);
		}
		return total;
	}
}
