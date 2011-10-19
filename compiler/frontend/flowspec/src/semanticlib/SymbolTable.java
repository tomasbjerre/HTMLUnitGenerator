package semanticlib;

import java.util.HashMap;

import compiler.data.Referencable;

public class SymbolTable {
	private static class StackedMap extends HashMap<String, Object> {
		private static final long serialVersionUID = 5957023940053748772L;
		private final StackedMap next;
		private final HashMap<String, Referencable> referencables = new HashMap<String, Referencable>();

		private StackedMap(StackedMap next) {
			this.next = next;
		}

		private Object lookup(String symbol) {
			Object result = get(symbol);
			if (result == null && next != null)
				result = next.lookup(symbol);
			return result;
		}

		private Referencable lookupReferencable(String symbol) {
			Referencable result = referencables.get(symbol);
			if (result == null && next != null)
				result = next.lookupReferencable(symbol);
			if (result == null)
				throw new RuntimeException("Symbol "+symbol+" not found");
			return result;
		}

		public void putReferencable(String key, Referencable referencable) {
			referencables.put(key,referencable);
		}
	}

	private StackedMap top = null;

	private int n = 0;

	public void add(String symbol, Object meaning) {
		if (top == null)
			throw new RuntimeException(
					"SymbolTable.add was called without any prior call to enterBlock");
		top.put(symbol, meaning);
	}

	public void addReferencable(String key, Referencable referencable) {
		top.putReferencable(key, referencable);
	}

	public void addTable(SymbolTable newSymbolTable) {
		for (String key : newSymbolTable.top.keySet())
			top.put(key, newSymbolTable.top.get(key));
	}

	public boolean alreadyDeclared(String symbol) {
		if (top == null)
			throw new RuntimeException(
					"SymbolTable.alreadyDeclared was called without any prior call to enterBlock");
		return top.get(symbol) != null;
	}

	public int blockLevel() {
		return n;
	}

	public void enterBlock() {
		top = new StackedMap(top);
		n++;
	}

	public void exitBlock() {
		if (top == null)
			throw new RuntimeException(
					"SymbolTable.exitBlock was called on an empty stack");
		top = top.next;
		n--;
	}

	public Object lookup(String symbol) {
		if (top == null)
			return null;
		return top.lookup(symbol);
	}

	public Referencable lookupReferencable(String symbol) {
		if (top == null)
			throw new RuntimeException(
					"SymbolTable.lookup was called without any prior call to enterBlock");
		return top.lookupReferencable(symbol);
	}
}
