public class AA {

//	AA() {
//		System.out.println("A()");
//	}

	AA(int a) {
		System.out.println("A(int a)");
	}
	
	AA(long a) {
		
	}

	public static void main(String[] args) {
		new B(1);
		System.out.println("123");
	}
}

class B extends AA {
	B(int a) { // 报错，必须显示调用父类的构造函数
//		super(0);
		System.out.println("B()");
	}
}