import java.util.LinkedList;
import java.util.List;

public class BlockingQueue {
	private List queue;
	private Integer limit;
	public BlockingQueue(Integer limit) {
		this.limit = limit;
		queue = new LinkedList();
	}
	
	public synchronized Boolean isEmpty() {
		return this.queue.size() == 0;
	}
	
	public synchronized void add(Object o) throws InterruptedException {
		while(this.queue.size() == this.limit) {
			wait();
		}
		if(this.queue.size() == 0) {
			notifyAll();
		}
		this.queue.add(o);
	}
	public synchronized Object pop() throws InterruptedException {
		while(this.queue.size() == 0){
			wait();
		}
		if(this.queue.size() == this.limit){
			notifyAll();
		}

		return this.queue.remove(0);
	}

}
