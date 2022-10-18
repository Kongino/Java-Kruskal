
import java.util.Collection;
import java.util.Iterator;
import java.util.PriorityQueue;

public class AscendingIterator<T extends Comparable<T>> implements Iterator<T> {

	private PriorityQueue<T> atp; // PriorityQueue�� ���
	
	public AscendingIterator(Collection<T> items) {
		atp = new PriorityQueue<T>();
		for (T a : items)
			atp.add(a); // ��� ���� PriorityQueue�� add
	}

	@Override
	public boolean hasNext() {
		return !atp.isEmpty(); // ������� �ʴٸ� hasNext()�� ��
	}

	@Override
	public T next() {
		return atp.poll(); // PriorityQueue���� poll()�� ���� ���� ��
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}
}
