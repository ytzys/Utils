import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

class TestThread extends Thread {

	ThreadCompleteListener listener;
	int index;

	public TestThread(ThreadCompleteListener listener, int index) {
		this.listener = listener;
		this.index = index;
	}

	@Override
	public void run() {
		int count = 0;
		Random random = new Random();
		while (count < 5) {
			System.out.println("thread index:" + index
					+ "\t executing thread number:"
					+ Work.getInstance().getActiveThreadCount());
			try {
				int i = random.nextInt() % 3;
				int sleepTime = 500 * i + 500;
				sleep(sleepTime);
				// System.out.println("thread index:" + index
				// + "----------------------->>> sleep time:" + sleepTime
				// + "ms");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			count++;
		}
		System.out.println("thread index:" + index + "complete");
		// listener.onComplete();
	}
}

interface ThreadCompleteListener {
	void onComplete();
}

class Work implements ThreadCompleteListener {

	static Work instance = new Work();

	int index = 0;

	public static Work getInstance() {
		return instance;
	}

	public int getActiveThreadCount() {
		return threadPool.getActiveCount();
	}

	private ThreadPoolExecutor threadPool;
	private TestThread testThread;

	public void doSomeWork() {
		testThread = new TestThread(this, index);
		threadPool.submit(testThread);
		index++;
	}

	public void initThreadPool() {
		threadPool = (ThreadPoolExecutor) Executors.newCachedThreadPool();
	}

	@Override
	public void onComplete() {
		doSomeWork();
	}
}

public class ThreadPoolTest {

	public static void main(String[] args) {
		Work work = Work.getInstance();
		work.initThreadPool();
		for (int i = 0; i < 5; i++) {
			work.doSomeWork();
		}
	}

}
