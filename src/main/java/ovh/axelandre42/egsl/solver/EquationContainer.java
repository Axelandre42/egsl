package ovh.axelandre42.egsl.solver;

import ovh.axelandre42.egsl.graph.Vertex;

/**
 * A value container to feed a matrix.
 * @param <V> the vertex type used in the graph
 * @param <N> the number type used in the solver
 */
public interface EquationContainer<V extends Vertex, N extends Number> {
	/**
	 * Returns the value associated to the given vertex.
	 * @param vertex a given vertex
	 * @return the value associated to the given vertex, returns {@code 0.0D} when there is no associated value to
	 * the given vertex
	 */
	N get(V vertex);

	/**
	 * Returns the independent term of this equation.
	 * @return the independent term
	 */
	N get();

	/**
	 * Associates a value to a given vertex.
	 * @param vertex a given vertex
	 * @param value the value to associate the vertex to
	 */
	void set(V vertex, N value);

	/**
	 * Sets the independent term of this equation.
	 * @param value the independent term
	 */
	void set(N value);
}
