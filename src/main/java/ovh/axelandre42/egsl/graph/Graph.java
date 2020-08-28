package ovh.axelandre42.egsl.graph;

import java.util.stream.Stream;

/**
 * A graph interface to be used with {@link Vertex} and {@link Edge}.
 * @param <V> is the type of the vertices
 * @param <E> is the type of the edges
 */
public interface Graph<V extends Vertex, E extends Edge> {
	/**
	 * Adds an {@link Edge} to this graph.
	 * @param edge the edge to be added
	 */
	void add(Edge edge);

	/**
	 * Adds a {@link Vertex} to this graph.
	 * @param vertex the vertex to be added
	 */
	void add(Vertex vertex);

	/**
	 * Removes an {@link Edge} from this graph.
	 * @param edge the edge to be removed
	 */
	void remove(Edge edge);

	/**
	 * Removes an {@link Vertex} from this graph.
	 * @param vertex the vertex to be removed
	 */
	void remove(Vertex vertex);

	/**
	 * Returns all edges in this graph.
	 * @return all edges
	 */
	Edge[] getEdges();

	/**
	 * Returns all vertices in this graph.
	 * @return all vertices
	 */
	Vertex[] getVertices();

	/**
	 * Returns a stream of edges contained in this graph.
	 * @return a stream of edges
	 */
	Stream<E> streamEdges();

	/**
	 * Returns a stream of vertices contained in this graph.
	 * @return a stream of vertices
	 */
	Stream<V> streamVertices();
}
