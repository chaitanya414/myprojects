package sample;

public class Trail {

	public static void main(String[] args) {
		String abc="   org inal   ";
		System.out.println(1+abc+1);
		System.out.println(1+abc.replaceAll("\\s+", " ").trim()+1);
		System.out.println(1+abc.trim()+1);
		System.out.println("after making some changes");
	}

}
