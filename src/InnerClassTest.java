class A {
	class B {
	}
}

class C extends A.B {
	C(A a) {
		a.super();
	}
}

public class InnerClassTest {

	public static void main(String[] args) {
		A a = new A();
		C c = new C(a);
	}
}
