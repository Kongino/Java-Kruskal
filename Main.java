import java.util.Collection;

public class Main {
	
	public static void main(String args[]) {
		
		EdgeList el = new EdgeList("WOW");
		
		Collection<Edge> a = MST.kruskal(el);
		
		for (Edge e : a)
			System.out.println(e);	
	}

}
