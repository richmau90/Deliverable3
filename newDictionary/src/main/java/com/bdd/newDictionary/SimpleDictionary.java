package com.bdd.newDictionary;

// CS/COE 1501
// Use this class with Assignment 1.  Read over the code and make sure
// you understand how it works and why it is not very efficient.

import java.util.*;
public class SimpleDictionary implements DictionaryInterface {
	// Store Strings in an ArrayList
	private ArrayList<String> list;

	public SimpleDictionary() {
		list = new ArrayList<String>();
	}

	// Add new String to end of list.  If String should come before
	// previous last string (i.e. it is out of order) sort the list.
	// We are keeping the data sorted in this implementation of
	// DictionaryInterface to make searches a bit faster.
	public boolean add(String s) {
		boolean ans = list.add(s);
		if (list.size() > 1) {
			String prevLast = list.get(list.size()-2);
			if (s.compareTo(prevLast) < 0)
				Collections.sort(list);
		}
		return ans;
	}

	// Implement the search method as described in the DictInterface
	public int search(StringBuilder s) {
		boolean doneIn, doneOut, currTest, prefix, word;
		String curr;
		doneOut = false;
		prefix = false;
		word = false;

		// Iterate through the ArrayList, until the end or until the
		// key is passed up (since it is sorted).
		for (int i = 0; i < list.size() && !doneOut; i++) {
			doneIn = false;
			curr = list.get(i);
			// Iterate through the key and the current String in the
			// ArrayList character by character.  
			for (int j = 0; j < s.length() && !doneIn; j++) {
				// We have passed the end of the string in the ArrayList,
				// so stop with this string.
				if (j >= curr.length()) {
					doneIn = true;
				}
				// Current character in the key is less than the current
				// character in the string in the ArrayList.  Since the
				// ArrayList is in alphabetical order, this means we can
				// stop our search altogether.
				else if (s.charAt(j) < curr.charAt(j)) {
					doneIn = true;
					doneOut = true;
				}
				else {
					currTest = (s.charAt(j) == curr.charAt(j));
					if (currTest && j == s.length()-1 && j < curr.length()-1) {
						prefix = true;  // Chars match and we are at end of
						doneIn = true;  // key but not end of String
					}
					else if (currTest && j == s.length()-1 && j == curr.length()-1) {
						word = true;    // Chars match and we are at end of
						doneIn = true;  // key and end of String
					}
					else if (!currTest) {
						doneIn = true;  // Chars do not match
					}
				}
			}
		}
		if (prefix && word) return 3;
		else if (word) return 2;
		else if (prefix) return 1;
		else return 0;
	}
}
