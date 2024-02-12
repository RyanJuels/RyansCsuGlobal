public interface BagInterface<T> {
	public T[] toArray();
	public boolean isFull();
	public boolean isEmpty();
	public boolean add(T newItem);
	public boolean remove(T anItem);
}
