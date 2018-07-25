package heapimplementation;

public class App {

	public static void main(String[] args) {
		Heap heap = new Heap(8);
		
		/*heap.insert(95);
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
		heap.insert(30);*/
		
		heap.insert(10);
		heap.insert(12);
		heap.insert(42);
		heap.insert(35);
		heap.insert(16);
		heap.insert(88);
		heap.insert(42);
		heap.insert(7);
		
		
		/*heap.dispHeap();
		heap.remove();
		System.out.println("");
		heap.dispHeap();
		System.out.println("");
		heap.remove();
		heap.dispHeap();*/
		heap.dispHeap();
		System.out.println("");
		System.out.println("");
		heap.displayHeap();
		
	}//end main

}//end class
