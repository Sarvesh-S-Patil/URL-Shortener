package com.Sarvesh.SpringBootJPA.Service;

import org.springframework.stereotype.Service;

@Service
public class BaseConverter {
	private int BASE = 26;
	private String Characters = "abcdefghijklmnopqrstuvwxyz";
	
	public String longToString(long l) {
		StringBuilder result = new StringBuilder();
		while(l>0) {
			int remainder = (int) (l%BASE);
			result.append(Characters.charAt(remainder));
			l /= BASE;
		}
		return result.toString().toUpperCase();
	}
	
	public long StringToLong(String s) {
		s = s.toLowerCase();
		long result = 0;
		for(char c : s.toCharArray()) {
			result = result*BASE + Characters.indexOf(c);
		}
		return result;
	}

}
