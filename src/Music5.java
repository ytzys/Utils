//enum Note {
//	MIDDLE_C;
//}
//
//interface Instrument {
//	// Compile-time constant:
//	int VALUE = 5; // static & final
//
//	// Cannot have method definitions:
//	void play(Note n); // Automatically public
//
//	void adjust();
//}
//
//abstract class A {
//	public void play(Note n) {
//		System.out.println(this + ".play() " + n);
//	}
//
//	public void adjust() {
//		System.out.println(this + ".adjust()");
//	}
//}
//
//class Wind extends A implements Instrument {
//
//	public String toString() {
//		return "Wind";
//	}
//
//}
//
//class Percussion extends A implements Instrument {
//
//	public String toString() {
//		return "Percussion";
//	}
//
//}
//
//class Stringed extends A implements Instrument {
//
//	public String toString() {
//		return "Stringed";
//	}
//
//}
//
//public class Music5 {
//	// Doesn't care about type, so new types
//	// added to the system still work right:
//	static void tune(Instrument i) {
//		// ...
//		i.play(Note.MIDDLE_C);
//	}
//
//	static void tuneAll(Instrument[] e) {
//		for (Instrument i : e)
//			tune(i);
//	}
//
//	public static void main(String[] args) {
//		// Upcasting during addition to the array:
//		Instrument[] orchestra = { new Wind(), new Percussion(), new Stringed() };
//		tuneAll(orchestra);
//	}
//}
