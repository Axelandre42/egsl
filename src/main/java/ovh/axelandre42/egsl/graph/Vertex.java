package ovh.axelandre42.egsl.graph;

/**
 * A vertex interface to be used with {@link Graph} and {@link Edge}.
 * @see Graph
 * @see Edge
 * @since 0.1
 */
public interface Vertex {
	/**
	 * Connects this vertex to an {@link Edge}.
	 * @param edge an edge to be connected to this vertex
	 */
	void connect(Edge edge);

	/**
	 * Disconnects this vertex from an {@link Edge}.
	 * @param edge an edge to be disconnected from this edge
	 */
	void disconnect(Edge edge);

	/**
	 * Returns all connected {@link Edge} instances to this vertex.
	 * @return an array of all connected {@link Edge} instances
	 */
	Edge[] getConnections();
}
