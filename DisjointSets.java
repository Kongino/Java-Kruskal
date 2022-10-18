
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DisjointSets {

	private Set<Vertex> djs;
	private Map<Vertex, Vertex> vvm;
	// key�� Ư�� Vertex, �׸��� value�� �� Ư�� Vertex�� ���� parent
	private Map<Vertex, List<Vertex>> vmlist;
	// key���� Vertex�� parent�� ������ Vertex���� List�� value.
	
	public DisjointSets(Set<Vertex> vertices) {
		this.djs = vertices;
		vvm = new HashMap<>();
		vmlist = new HashMap<>();
		for (Vertex b : djs) {
			vvm.put(b, b); // �ڱ� �ڽ��� parent�� �������� ���� ( b��� key�� �ش��ϴ� parent �� value)
			List<Vertex> lvb = new ArrayList<>();
			lvb.add(b);
			vmlist.put(b, lvb); // b�� parent�� ������ Vertex�� List
		}
	}

	public Vertex find(Vertex u) {
		if (vvm.containsKey(u))
			return vvm.get(u); // vvm���� u�� Ű ������ ������ value�� �ִٸ� �� value�� ���
		else
			return null;
	}
	public boolean sameSet(Vertex u, Vertex v) {
		if (vvm.containsKey(u) && vvm.containsKey(v))
			return find(u).equals(find(v)); // parent�� ���� ��� sameSet���� ���
		else
			return false;
	}

	public void merge(Vertex u, Vertex v) {
		Vertex pu = find(u);
		Vertex pv = find(v);
		if (!sameSet(u, v)) { // sameSet�� �ƴ� ���
			for (int i=0; i<vmlist.get(pu).size(); i++) {
				// u�� parent���� parent�� ������ ��� Vertex�� ���� ����
				Vertex temv = vmlist.get(pu).get(i);
				vvm.remove(temv);
				vvm.put(temv, pv);
				// temv���� ���� parent�� pv�� �����Ѵ�
				vmlist.get(pv).add(temv);
				// pv�� parent�� �ϴ� ���ο� Vertex���� temv�� pv�� parent�� �ϴ� list�� �߰��Ѵ�.
			}

		}
	}
}
