package it.unibo.oop.lab06.generics1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GraphImpl<N> implements Graph<N> {

	private Map<N, Set<N>> nodes;
	
	public GraphImpl() {
		this.nodes = new HashMap<N, Set<N>>();
	}
	
	@Override
	public void addNode(N node) {
		if(node != null) {
			this.nodes.putIfAbsent(node, null);
		}
	}

	@Override
	public void addEdge(N source, N target) {
		if((source != null) && (target != null)) {
			if(this.nodes.get(target) == null) {
				this.nodes.putIfAbsent(target, new HashSet<N>());
			}
			this.nodes.get(source).add(target);
			
			if(this.nodes.get(source) == null) {
				this.nodes.putIfAbsent(source, new HashSet<N>());
			}
			this.nodes.get(target).add(source);
			
		}
	}

	@Override
	public Set<N> nodeSet() {
		Set<N> everyNode = new HashSet<N>();
		Collection<Set<N>> coll = this.nodes.values();
		
		for(Set<N> elem : coll) {
			everyNode.addAll(elem);
		}
		return everyNode;
	}

	@Override
	public Set<N> linkedNodes(N node) {
		return this.nodes.get(node);
	}

	@Override
	public List<N> getPath(N source, N target) {
		
		return null;
	}

}
