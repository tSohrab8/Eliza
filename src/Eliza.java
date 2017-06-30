import java.util.*;


public class Eliza {
	
	private static Set<String> hedgeSet = new HashSet<String>();
	private static Set<String> qualifierSet = new HashSet<String>();
	private static Map<String,String> replacementMap = new HashMap<String,String>();
	
	public static void main(String[]args){
		
		initialize();
		
		Scanner k = new Scanner(System.in);
		Random rand = new Random();
		
		System.out.println("Welcome to your Therapy Session. My name is Eliza. Please, tell me your problems.");
		while(true){
			String response = k.nextLine();
			
			if (response.equalsIgnoreCase("q")){
				System.out.println("Thank you for coming today. Goodbye.");
				break;
			}
			
			int roll = rand.nextInt(2);
			if (roll == 0){
				System.out.println(getHedge());
			}
			else{
				System.out.println(getQualifier() + replace(response));
			}
		}
		
	}
	
	public static String getHedge(){
		Random rand = new Random();
		int index = rand.nextInt(hedgeSet.size());
		Iterator<String> iter = hedgeSet.iterator();
		for (int i = 0; i < index; i++) {
			iter.next();
		}
		return iter.next();
	}
	
	public static String getQualifier(){
		Random rand = new Random();
		int index = rand.nextInt(qualifierSet.size());
		Iterator<String> iter = qualifierSet.iterator();
		for (int i = 0; i < index; i++) {
		    iter.next();
		}
		return iter.next();
	}
	
	public static String replace(String text) {
		Set<String> keys = replacementMap.keySet();
		Iterator<String> iter = keys.iterator();
		for (int i = 0; i < keys.size(); i++) {
			String key = iter.next();
			text = text.replaceAll("\\b" + key + "\\b", replacementMap.get(key));
		}
		return text;
	}
	
	public static void initialize(){
		
		hedgeSet.add("Please tell me more");
		hedgeSet.add("Why do you feel that way?");
		hedgeSet.add("That is quite amazing");
		
		qualifierSet.add("Does anyone else know that ");
		qualifierSet.add("But your body language makes it seem like you're not sure that ");
		qualifierSet.add("Can you explain how it is that ");
		
		replacementMap.put("I", "you");
		replacementMap.put("me", "you");
		replacementMap.put("my", "your");
		replacementMap.put("am", "are");
		replacementMap.put("our", "all of your");
		replacementMap.put("we", "all of you");
		replacementMap.put("was", "were");
		replacementMap.put("I'm not", "you aren't");
		replacementMap.put("you", "me");
		replacementMap.put("your", "my");
		replacementMap.put("are", "am");
		replacementMap.put("all of your", "our");
		replacementMap.put("were", "was");
		replacementMap.put("all of you", "we");
		replacementMap.put("you aren't", "I'm not");
		
	}
	

}
