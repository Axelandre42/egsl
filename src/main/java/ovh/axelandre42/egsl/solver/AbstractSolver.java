package ovh.axelandre42.egsl.solver;

import org.ejml.data.Matrix;
import ovh.axelandre42.egsl.graph.Edge;
import ovh.axelandre42.egsl.graph.Graph;
import ovh.axelandre42.egsl.graph.Vertex;
import ovh.axelandre42.egsl.util.BiStream;

import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collectors;

// TODO finish writing javadoc.
public abstract class AbstractSolver<V extends Vertex, E extends Edge, M extends Matrix, N extends Number>
		implements Solver<V, E, N> {
	protected abstract M createMatrix(Set<EquationContainer<V, N>> values);
	protected abstract M createVector(Set<EquationContainer<V, N>> values);
	protected abstract M solveMatrix(M matrix, M vector);
	protected abstract BiStream<V, N> streamSolution(M solution);

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void solve(Graph<V, E> graph, Function<V, EquationContainer<V, N>> parser, BiConsumer<V, N> applicator) {
		Set<EquationContainer<V, N>> values = graph.streamVertices().map(parser).collect(Collectors.toSet());
		M matrix = this.createMatrix(values);
		M vector = this.createVector(values);
		M solution = this.solveMatrix(matrix, vector);
		this.streamSolution(solution).forEach(applicator);
	}
}
