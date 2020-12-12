public void reverse() {
		
		Node temp = null;
		Node curr = head;
		
		while(curr != null) {
			temp = curr.getPrevLink();
			curr.setPrevLink(curr.getNextLink());
			curr.setNextLink(temp);
			curr = curr.getPrevLink();
		}
		
		if(temp != null) {
			head = temp.getPrevLink();
		}
	}
