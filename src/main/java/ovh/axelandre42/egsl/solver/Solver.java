package ovh.axelandre42.egsl.solver;

import ovh.axelandre42.egsl.graph.Edge;
import ovh.axelandre42.egsl.graph.Graph;
import ovh.axelandre42.egsl.graph.Vertex;

import java.util.function.BiConsumer;
import java.util.function.Function;

// TODO finish writing javadoc.
/**
 * A solver interface.
 * @param <V> the vertex type used in the graph
 * @param <E> the edge type used int the graph
 * @param <N> the number type used in the solver
 */
public interface Solver<V extends Vertex, E extends Edge, N extends Number> {
	/**
	 * Solves a graph using a parser and an applicator.
	 * @param graph the graph to solve
	 * @param parser a function that parse each vertex to a map of double matching each vertex of the graph.
	 *               <p>
	 *                   It will resolve using a linear equation system solver, so each vertex should be
	 *                   mapped to an equation in the form <code>Av1 + Bv2 + Cv3 + ... + Xvn + Y = 0</code> where
	 *                   each <code>Xvn</code> represents a relationship to another vertex and <code>Y</code> is the
	 *                   independent term for the current vertex.
	 *               </p>
	 *               <p>
	 *                   The following example is a parsed 3-vertex electrical network made using Kirchhoff's current
	 *                   law. It can be seen as a triangle with one generator G and two loads named L1 and L2.
	 *                   Vertices are named N1, N2 and N3. Each vertex is connected to both others. N1 is connected
	 *                   to L1, N2 is connected to L2 and N3 is connected to G. Intensities are expressed as
	 *                   <code>I(node1, node2)</code> or <code>I(load)</code>. Voltages are expressed
	 *                   as <code>V(node)</code>. Nodes can be either vertices or devices (generators or loads).
	 *                   Resistances are expressed as <code>R(node1, node2)</code>.
	 *               </p>
	 *               <table>
	 *                   <tr><th>A &times; V(N1)</th><th>B &times; V(N2)</th><th>C &times; V(N3)</th><th>D</th></tr>
	 *                   <tr><td>-(1/R(N1,L1) + 1/R(N1,N2) + 1/R(N1,N3))</td><td>1/R(N1,N2)</td><td>1/R(N1,N3)
	 *                   </td><td>I(L1)</td></tr>
	 *                   <tr><td>1/R(N2,N1)</td><td>-(1/R(N2,L2) + 1/R(N2,N1) + 1/R(N2,N3))</td><td>1/R(N2,N3)
	 * 	                 </td><td>I(L2)</td></tr>
	 * 	                 <tr><td>1/R(N3,N1)</td><td>1/R(N3,N2)</td><td>-(1/R(N3,G) + 1/R(N3,N1) + 1/R(N3,N2))</td>
	 * 	                 <td>V(G)/R(N3,G)</td></tr>
	 *               </table>
	 *               <p>
	 *                   As you can see, each row is a parsed vertex.
	 *               </p>
	 * @param applicator a object-and-double consumer applying the new values to the vertices.
	 */
	void solve(Graph<V, E> graph, Function<V, EquationContainer<V, N>> parser, BiConsumer<V, N> applicator);
}
