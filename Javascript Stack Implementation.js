var Stack = function() {
			this.count = 0;
			this.storage = {};

			//add a value to the top of the stack
			this.push = (value) => {
				this.storage[this.count] = value;
				this.count++;
			}

			//remove and return the top element of the stack
			this.pop = () => {
				if(this.count === 0){
					return undefined;
				}

				this.count--;
				let top = this.storage[this.count];
				delete this.storage[this.count];
				return top;
			}

			//return the size of the stack
			this.size = () => {
				return this.count;
			}

			//return the top or last element of the stack
			this.peek = () => {
				return this.storage[this.count - 1];
			}

			this.indexOf = (key) => {
				if(this.count === 0){
					return undefined;
				}
				for(let i = 0; i < this.count; i++) {
					if(this.storage[i] === key){
						return i;
					}
				}
				return -1;
			}
		};

		let myStack = new Stack();
		myStack.push("Allen");
		myStack.push("Jack");
		myStack.push("Zerin");

		myStack.pop();

		let result1 = myStack.indexOf("Allen");

		console.log(result1);
