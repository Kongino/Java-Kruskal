
import java.util.Collection;
import java.util.Iterator;
import java.util.PriorityQueue;

public class AscendingIterator<T extends Comparable<T>> implements Iterator<T> {

	private PriorityQueue<T> atp; // PriorityQueue를 사용
	
	public AscendingIterator(Collection<T> items) {
		atp = new PriorityQueue<T>();
		for (T a : items)
			atp.add(a); // 모든 값을 PriorityQueue에 add
	}

	@Override
	public boolean hasNext() {
		return !atp.isEmpty(); // 비어있지 않다면 hasNext()인 것
	}

	@Override
	public T next() {
		return atp.poll(); // PriorityQueue에서 poll()한 값이 다음 값
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}
}
