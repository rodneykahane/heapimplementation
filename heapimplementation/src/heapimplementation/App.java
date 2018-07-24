package heapimplementation;

public class App {

	public static void main(String[] args) {
		Heap heap = new Heap(11);
		
		heap.insert(82);
		heap.insert(51);
		heap.insert(63);
		heap.insert(70);
		heap.insert(37);
		heap.insert(10);
		heap.insert(43);
		heap.insert(27);
		heap.insert(55);
		heap.insert(34);
		heap.insert(30);
		
		
		
		heap.dispHeap();
		heap.remove();
		System.out.println("");
		heap.dispHeap();
	}//end main

}//end class
