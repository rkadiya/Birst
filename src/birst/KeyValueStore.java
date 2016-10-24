package birst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class KeyValueStore {
	
	public static Map<String, String> store = new HashMap<String, String>();

	public static void main(String[] args) throws IOException {
		boolean run = true;
		while (run) {
			InputStreamReader r=new InputStreamReader(System.in);  
			BufferedReader br=new BufferedReader(r);  
			System.out.print(">");
			String command=br.readLine();
			
			// Remove spaces from command
			String goodCommand = command.replaceAll("\\s+","");
			
			if (goodCommand.startsWith("CREATE")) {
				create(goodCommand.split("CREATE")[1]);
			} else if (goodCommand.startsWith("UPDATE")) {
				update(goodCommand.split("UPDATE")[1]);
			} else if (goodCommand.equals("GETALL")) {
				getall();
			} else if (goodCommand.startsWith("GET")) {
				get(goodCommand.split("GET")[1]);
			} else if (goodCommand.startsWith("DELETE")) {
				delete(goodCommand.split("DELETE")[1]);
			} else if (goodCommand.equals("QUIT")) {
				run = false;
			} else {
				System.out.println("## Command not recognized ##");
			}
		}
	}
	
	public static void create(String keyValue) {
		Pattern p = Pattern.compile( "(\\w+)=(\\w+)" );
		Matcher m = p.matcher(keyValue);
		if (m.find( )) {
	         if (store.containsKey(m.group(1))) {
	        	 System.out.println("## Key " + m.group(1) + " already exists ##");
	         }
	         store.put(m.group(1), m.group(2));
	      }else {
	         System.out.println("## Please check command pattern ##");
	      }
	}
	
	public static void update(String keyValue) {
		Pattern p = Pattern.compile( "(\\w+)=(\\w+)" );
		Matcher m = p.matcher(keyValue);
		if (m.find( )) {
	         if (!store.containsKey(m.group(1))) {
	        	 System.out.println("## Key " + m.group(1) + " does not exist ##");
	         } else {
	        	 store.put(m.group(1), m.group(2));
	         }
	      }else {
	         System.out.println("## Please check command pattern ##");
	      }
	}
	
	public static void get(String key) {
		Pattern p = Pattern.compile( "(\\w+)" );
		Matcher m = p.matcher(key);
		if (m.find( )) {
	         if (store.containsKey(m.group(1))) {
	        	 System.out.println(store.get(m.group(1)));
	         } else {
	        	 System.out.println("## Key " + m.group(1) + " does not exist ##");
	         }
	      }else {
	         System.out.println("## Please check command pattern ##");
	      }
	}
	
	public static void getall() {
		for (Map.Entry<String, String> entry : store.entrySet()) {
			System.out.println(entry.getKey() + "=" + entry.getValue());
		}
	}
	
	public static void delete(String key) {
		Pattern p = Pattern.compile( "(\\w+)" );
		Matcher m = p.matcher(key);
		if (m.find( )) {
	         if (!store.containsKey(m.group(1))) {
	        	 System.out.println("## Key " + m.group(1) + " does not exist ##");
	         }
	         store.remove(m.group(1));
	      }else {
	         System.out.println("## Please check command pattern ##");
	      }
	}

}