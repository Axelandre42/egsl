package ovh.axelandre42.egsl.graph;

/**
 * An edge interface to be used with {@link Graph} and {@link Vertex}
 */
public interface Edge {
	/**
	 * Connects one side of this edge to a {@link Vertex}.
	 * @param vertex the vertex to be connected.
	 */
	void a(Vertex vertex);

	/**
	 * Connects the other side of this edge to a {@link Vertex}.
	 * @param vertex the vertex to be connected.
	 */
	void b(Vertex vertex);

	/**
	 * Returns the vertex connected using {@link #a(Vertex)}.
	 * @return the connected vertex
	 */
	Vertex a();

	/**
	 * Returns the vertex connected using {@link #b(Vertex)}.
	 * @return the connected vertex
	 */
	Vertex b();
}
