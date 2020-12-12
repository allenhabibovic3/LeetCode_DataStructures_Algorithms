public boolean removeDuplicates() {
		HashSet<Integer> set = new HashSet<Integer>();
		if(isEmpty())
			return false;
		Node p = null;
		Node curr_node = head;
		boolean containsDup = false;
		while(curr_node != null) {
			if(set.contains(curr_node.getData())) {
				containsDup = true;
				p.setNextLink(curr_node.getNextLink());
			}else {
				set.add(curr_node.getData());
				p = curr_node;
			}
			curr_node = curr_node.getNextLink();
		}
		
		return containsDup;
	}
