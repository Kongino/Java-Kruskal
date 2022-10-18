
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DisjointSets {

	private Set<Vertex> djs;
	private Map<Vertex, Vertex> vvm;
	// key는 특정 Vertex, 그리고 value는 그 특정 Vertex에 대한 parent
	private Map<Vertex, List<Vertex>> vmlist;
	// key값인 Vertex를 parent로 가지는 Vertex들의 List가 value.
	
	public DisjointSets(Set<Vertex> vertices) {
		this.djs = vertices;
		vvm = new HashMap<>();
		vmlist = new HashMap<>();
		for (Vertex b : djs) {
			vvm.put(b, b); // 자기 자신을 parent로 가지도록 설정 ( b라는 key에 해당하는 parent 값 value)
			List<Vertex> lvb = new ArrayList<>();
			lvb.add(b);
			vmlist.put(b, lvb); // b를 parent로 가지는 Vertex의 List
		}
	}

	public Vertex find(Vertex u) {
		if (vvm.containsKey(u))
			return vvm.get(u); // vvm에서 u를 키 값으로 가지는 value가 있다면 그 value를 출력
		else
			return null;
	}
	public boolean sameSet(Vertex u, Vertex v) {
		if (vvm.containsKey(u) && vvm.containsKey(v))
			return find(u).equals(find(v)); // parent가 같은 경우 sameSet으로 취급
		else
			return false;
	}

	public void merge(Vertex u, Vertex v) {
		Vertex pu = find(u);
		Vertex pv = find(v);
		if (!sameSet(u, v)) { // sameSet이 아닌 경우
			for (int i=0; i<vmlist.get(pu).size(); i++) {
				// u의 parent값을 parent로 가지는 모든 Vertex에 대한 루프
				Vertex temv = vmlist.get(pu).get(i);
				vvm.remove(temv);
				vvm.put(temv, pv);
				// temv값에 대한 parent를 pv로 설정한다
				vmlist.get(pv).add(temv);
				// pv를 parent로 하는 새로운 Vertex값인 temv를 pv를 parent로 하는 list에 추가한다.
			}

		}
	}
}
