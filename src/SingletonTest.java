public class SingletonTest {
	static SingletonTest instance;

	public static SingletonTest getInstance() {
		synchronized (SingletonTest.class) {
			if (instance == null) {
				instance = new SingletonTest();
			}
		}
		return instance;
	}

}
