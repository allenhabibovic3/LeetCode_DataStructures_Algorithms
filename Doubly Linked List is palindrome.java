public boolean isPalindrome() {
		Node slow = head;
		Node fast = head;
		
		Stack<Integer> stack = new Stack<Integer>();
		
		while(fast != null && fast.getNextLink() != null) {
			stack.push(slow.getData());
			slow = slow.getNextLink();
			fast = fast.getNextLink().getNextLink();
		}
		
		if(fast != null) {
			slow = slow.getNextLink();
		}
		
		while(slow != null) {
			int top = stack.pop().intValue();
			if(top != slow.getData())
				return false;
			slow = slow.getNextLink();
		}
		return true;
	}
