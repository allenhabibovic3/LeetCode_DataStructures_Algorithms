public Node returnKthLast(int k) {
		
		int pos = this.getSize() - k;
		if(k == 1 || pos == 1)
			return head;
		if(k == this.size || pos == this.size)
			return tail;
		
		Node curr_node = head.getNextLink();
		
		for(int i = 2; i <= this.size; i++) {
			if(i == pos) {
				return curr_node;
			}
			curr_node = curr_node.getNextLink();
		}
		
		return null;
	}
