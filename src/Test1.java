public class Test1 {
	public static void main(String[] args) {
		System.out.println("zhangyisu");
		Thread thread = new Thread() {
			public void run() {
				while(true){
					try {
						sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				System.out.println("zys");
				}
			};
		};
		thread.start();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		thread.interrupt();
		thread.isInterrupted();
		Thread.interrupted();
		System.out.println("thread interupted");
	}
}
