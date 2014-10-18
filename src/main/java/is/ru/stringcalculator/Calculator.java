package is.ru.stringcalculator;
import java.util.ArrayList;
//import java.util.regex.Pattern;
//import java.util.regex.Matcher;

public class Calculator {

	public static int add(String text){
		text = handleDelimiter(text);
		return sum(splitNumbers(text));
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers){
		/* Empty string */
		if (numbers.isEmpty())
			return new String[0];
		return numbers.split(",|\n");
	}

	private static int sum(String[] numbers){
		int total = 0;
		ArrayList<String> error = new ArrayList<String>();
		for(String number : numbers){
			int num = toInt(number);
			if (num < 0) error.add(number);
			if (num >= 1000) continue;
			total += num;
		}
		if (!error.isEmpty()) {
			String e = "Negatives not allowed: "+error.toString()
			.replace("[","")
			.replace("]","");
			throw new RuntimeException(e);
		}
		return total;
	}

	private static String handleDelimiter(String text) {
		String delimiter;
		/* Handle different delimiter */
		if (text.length() > 2 && text.substring(0,2).equals("//")) {
			if (text.contains("[") && text.contains("]")) {
				delimiter = text.substring(3,text.indexOf("]"));
				text = text.replace(delimiter,",");
				text = text.replace("\n","");
				text = text.substring(text.indexOf("]")+1,text.length());
			}
			else { 
				delimiter = text.substring(2,3);	
				text = text.replace(delimiter,",");
				text = text.substring(4,text.length());
			}
		}
		return text;
	}
}
