package ex04;

import java.util.HashMap;

public class MyDB {
	private HashMap<String, String> table;
	public MyDB() {
		table = new HashMap<>();
		table.put("if", "if1234");
		table.put("else",  "else1234");
		table.put("while", "while1234");
		table.put("for", "for1234");
		table.put("admin", "admin1234");
		
	}
	public String getPassword(String id) {
		return table.get(id);
	}
}
