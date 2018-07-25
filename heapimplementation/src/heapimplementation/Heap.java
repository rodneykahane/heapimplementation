package heapimplementation;

// r child = 2n+2
// l child = 2n+1
// parent = (n-1)/2

public class Heap {
	private Node[] heapArray;
	private int maxSize;  //size of the array
	private int currentSize;  //number of nodes in the array

	public Heap(int size) {
		this.maxSize = size;
		currentSize = 0;
		heapArray = new Node[size];  //actually creates array
	}

	public int getSize() {
		return currentSize;
	}

	public boolean isEmpty() {
		return(currentSize == 0);
	}

	public boolean insert(int key) {
		if(currentSize == maxSize) {
			return false;
		}

		Node newNode = new Node(key);
		heapArray[currentSize] = newNode;

		trickleUp(currentSize);		
		currentSize++;

		return true;	
	}//end insert()

	public void trickleUp(int idx){
		int parentIdx = (idx-1)/2;
		Node nodeToInsert = heapArray[idx];

		//loop as long as we havent reached the root and key of nodeToInsert's parent is less than new node
		while(idx > 0 && heapArray[parentIdx].getKey() < nodeToInsert.getKey()) {
			heapArray[idx] = heapArray[parentIdx]; //move parent down
			idx = parentIdx;
			parentIdx = (parentIdx-1)/2;
		}

		heapArray[idx]=nodeToInsert;

	}//end trickleUp()

	/*public boolean remove() {
		int removeIdx=heapArray.length-1;
		int idx=0;
		int lChild=(2*idx)+1;
		int rChild=(2*idx)+2;
		Node tmpNode;	

		heapArray[0] = heapArray[removeIdx];

		for(int i=0;i<heapArray.length;i++) {
			boolean bigger=false;

			//set to true if left is bigger
			if(lChild<heapArray.length&&heapArray[lChild].getKey()>heapArray[rChild].getKey()) {
				bigger=true; 
			} 

			if(lChild<heapArray.length&&bigger==true) {
				tmpNode = heapArray[idx];
				heapArray[idx] = heapArray[lChild];
				heapArray[lChild] = tmpNode;				
				idx=(2*idx)+1;
				lChild=(2*idx)+1;
				rChild=(2*idx)+2;


			} else if(lChild<heapArray.length&&bigger==false) {
				tmpNode = heapArray[idx];
				heapArray[idx] = heapArray[rChild];
				heapArray[rChild] = tmpNode;				
				idx=(2*idx)+2;
				rChild=(2*idx)+2;
				lChild=(2*idx)+1;
			}

		}


		currentSize--;
		Node[] tmpArray;
		tmpArray = new Node[currentSize];

		for(int i=0;i<tmpArray.length;i++) {
			tmpArray[i] = heapArray[i];
		}

		heapArray = tmpArray;
		return true;
	}//end remove()
	 */
	//professor's solution
	public Node remove() {
		Node root = heapArray[0];
		currentSize--;
		heapArray[0] = heapArray[currentSize];

		trickleDown(0);

		return root;
	}

	private void trickleDown (int idx) {

		int largerChildIdx;
		Node top = heapArray[idx];

		while(idx<currentSize/2) {
			int leftChildIdx = (2*idx)+1;
			int rightChildIdx = (2*idx)+2;

			if(rightChildIdx < currentSize && heapArray[leftChildIdx].getKey()<heapArray[rightChildIdx].getKey()) {
				largerChildIdx= rightChildIdx;
			} else {
				largerChildIdx= leftChildIdx;
			}
			if(top.getKey()>=heapArray[largerChildIdx].getKey()) {
				//successfully made root the largest
				break;
			}

			heapArray[idx] = heapArray[largerChildIdx];
			idx=largerChildIdx;

		}//end while

		heapArray[idx] = top;

	}//end trickleDown()

	public void dispHeap() {
		for(int i=0;i<heapArray.length;i++) {
			System.out.print(heapArray[i].getKey()+", ");
		}
	}

	public void displayHeap() {
		int spacing = heapArray.length/2;
		
		System.out.println("                    "+heapArray[0].getKey());

		for(int i=0;i<heapArray.length;i++) {

			int lChld = (2*i)+1;
			int rChld = (2*i)+2;
			for(int j=spacing;j>=i;j--) {
				System.out.print("   ");
			}
			if(lChld<heapArray.length) {
				System.out.print(heapArray[lChld].getKey());
			}
			for(int k=spacing;k>=i;k--) {
				System.out.print("  ");
			}
			if(rChld<heapArray.length) {
				System.out.print(heapArray[rChld].getKey());
				System.out.println("");
			}
		
	}//end for

}//end displayHeap()

}//end class
