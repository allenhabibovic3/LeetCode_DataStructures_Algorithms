void reverse()
    {
        Stack<Integer> stack = new Stack<>();
        Node temp = head;
        while (temp != null)
        {
            stack.push(temp.data);
            temp = temp.next;
        } 
        // added all the elements sequemce wise in the
        // stack
        temp = head;
        while (temp != null) 
        {
            temp.data = stack.pop();
            temp = temp.next;
        } 
        // popped all the elements and the added in the
        // linked list,
        // which are in the reversed order.
    }
