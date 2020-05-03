package practices;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Temp {

	public static void main (String args[]) {
	}
		
		/*for (i=0; 0 ;i++){
			
		} 
		Exception in thread "main" java.lang.Error: Unresolved compilation problems: 
			i cannot be resolved to a variable
			Type mismatch: cannot convert from int to boolean
			i cannot be resolved to a variable
*/
		
		/*
		 * String str=null; if(str.isEmpty()||str!=null){
		 * System.out.println("in Test Case 1"); } Exception in thread "main"
		 * java.lang.NullPointerException at 
		 */

		 
		/*
		 * int i; System.out.println("in Test Case 1"+i); Exception in thread "main"
		 * java.lang.Error: Unresolved compilation problem: The local variable i may not
		 * have been initialized
		 */

		//String str = "CME123XYZCME456" ;
				///– how to fetch CME from the string.(String Pattern Matcing)
			//	"(.*CME)"
		
		/*
		 * String data = "CME123XYZCME456"; Pattern pattern =
		 * Pattern.compile("\\\\b(\\\\w+)(\\\\s+\\\\1\\\\b)+"); Matcher matcher =
		 * pattern.matcher(data); if (matcher.find()) {
		 * System.out.println(matcher.group()); }
		 */	
		
		
		/*
		 * String data = "This is a test String and 'This is data we want'"; Pattern
		 * pattern = Pattern.compile("'(.*?)'"); Matcher matcher =
		 * pattern.matcher(data); if (matcher.find()) {
		 * System.out.println(matcher.group(1)); }
		 */	
				
		
/*		String input = "The the string String string stringing.";
        String regex = "\\b(\\w+)(\\s+\\1\\b)+";
        // Use compile(regex) if you want case sensitive.
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(input);
        while (m.find()) {
            input = input.replaceAll(m.group(), m.group(1));
        }
        System.out.println(input);
*/      
         
		/*
		 * //2 or more spaces into single space 
		 * String line ="  aa bbbbb   ccc     d  ";
		 * System.out.println(line.replaceAll("[\\s]+", " "));
		 * 
		 */
	
	public void tempmethod() {
		try {
                String blogName = "CME123XYZCME456";
                char[] chars = blogName.toCharArray();
                 
                Map<Character, Integer> map = new HashMap<Character, Integer>();
                for(char c : chars) 
                {
                    if(map.containsKey(c)) {
                        int counter = map.get(c);
                        map.put(c, ++counter);
                    } else {
                        map.put(c, 1);
                    }
                }
                 
                System.out.println("Duplicate characters:");
                 
                //Print duplicate characters
                for(char c : map.keySet()) {
                    if(map.get(c) > 1) {
                        System.out.println(c);
                    }
                }
                 
                System.out.println("Duplicate characters excluding white space :");
                 
                //Print duplicate characters excluding white space
                for(char c : map.keySet()) {
                    if(map.get(c) > 1 && !Character.isWhitespace(c)) {
                        System.out.println(c);
                    }
                }
                 
                System.out.println("Distinct characters:");
                 
                //Print distinct characters
                for(char c : map.keySet()) {
                    if(map.get(c) == 1) {
                        System.out.println(c);
                    }
                }
            
	//}catch (Exception e){
	}	finally {
	
		
	}
}
}
