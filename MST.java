import java.util.ArrayList;
import java.util.Collection;


public abstract class MST {

	public static DisjointSets Mdjs;

	
	public static Collection<Edge> kruskal(EdgeList edges) {
		
		Collection<Edge> ce = new ArrayList<>();
		Mdjs = new DisjointSets(edges.getVertices()); 
		// 주어진 EdgeList의 getVertices()로 생성되는 DisjointSet 하나를 선언
		
		for (Edge a : edges) { // 모든 edges의 Edge에 대한 루프
			if (!Mdjs.sameSet(a.vertices()[0], a.vertices()[1])) {
				// 한 Edge의 두 점이 sameSet이 아닌 경우
				Mdjs.merge(a.vertices()[0], a.vertices()[1]);
				// merge()함수로 두 점을 sameSet으로 설정되도록 한다
				ce.add(a);
				// 이 Edge 하나를 ce에 add
			}
		}
		return ce; // kruskal 방식으로 add된 Collection<Edge>를 출력
	}

}
