package ds;

public class Queue<E> {

	private int size, rear, front;
	private int maxSize;
	private E arr[];

	
	@SuppressWarnings("unchecked")
	public Queue(int maxSize) {
		this.maxSize = maxSize;
		this.front = 0; 
		this.size = 0;
		this.rear = maxSize - 1;
		arr = (E[]) new Object[maxSize];
		
	}
	
	public boolean isEmpty() {
		
		return size == 0;
	}
	
	public boolean isFull() {
		
		return size >= maxSize;
	}
	
	public boolean add(E ele) {
		
		if(isFull()) {
			
			System.out.println("Queue is full");
			return false;
		}
		
		rear = (rear + 1) % maxSize;
		arr[rear] = ele;
		size += 1;
		
		
		return true;
	}
	
	public E remove() {
		
		if(isEmpty()) {
			System.out.println("Queue is empty");
			return null;
		}
		
		E item = arr[front];
		front = (front + 1) % maxSize;
		size -= 1;
		
		return item;
	}
	
}
