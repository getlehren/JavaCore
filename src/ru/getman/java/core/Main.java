package ru.getman.java.core;


public class Main {

	public static void main(String[] args) {
		String[] arrayWords = {"pain", "misery", "java", "hardship", "pain", "java",
				"agony", "pain", "java", "pain", "hardship", "java", "agony", "suffer"};
		Words words = new Words();
		words.returnUnique(arrayWords);

		words.count(arrayWords);
		System.out.println("**********************************************************");

		PhoneDirectory phoneDirectory = new PhoneDirectory();
		phoneDirectory.add("Sidorov", "+7777");
		phoneDirectory.add("Sidorov", "+8888");
		phoneDirectory.add("Ivanov", "+9999");
		phoneDirectory.add("Petrov", "+1111");
		phoneDirectory.add("Kotin", "+2222");
		phoneDirectory.add("Motin", "+6666");
		phoneDirectory.add("Motin", "+3333");
		phoneDirectory.add("Ivanov", "+4444");
		phoneDirectory.add("Sidorov", "+5555");

		System.out.println(phoneDirectory.getDirectory());
		phoneDirectory.get("Sidorov");
		phoneDirectory.get("Kotin");
		phoneDirectory.get("Motin");
	}
}
