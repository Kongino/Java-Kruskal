import java.util.ArrayList;
import java.util.Collection;


public abstract class MST {

	public static DisjointSets Mdjs;

	
	public static Collection<Edge> kruskal(EdgeList edges) {
		
		Collection<Edge> ce = new ArrayList<>();
		Mdjs = new DisjointSets(edges.getVertices()); 
		// �־��� EdgeList�� getVertices()�� �����Ǵ� DisjointSet �ϳ��� ����
		
		for (Edge a : edges) { // ��� edges�� Edge�� ���� ����
			if (!Mdjs.sameSet(a.vertices()[0], a.vertices()[1])) {
				// �� Edge�� �� ���� sameSet�� �ƴ� ���
				Mdjs.merge(a.vertices()[0], a.vertices()[1]);
				// merge()�Լ��� �� ���� sameSet���� �����ǵ��� �Ѵ�
				ce.add(a);
				// �� Edge �ϳ��� ce�� add
			}
		}
		return ce; // kruskal ������� add�� Collection<Edge>�� ���
	}

}
