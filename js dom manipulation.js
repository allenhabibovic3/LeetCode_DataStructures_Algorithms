//javascript code here, let browser render HTML first, then script
		//console.dir(document); //display tree structure of document object

		let items = document.getElementsByClassName('list-group-item');

		for(let i = 0; i < items.length; i++) {
			items[i].style.backgroundColor = "#f4f4f4";
			items[i].style.fontWeight = "bold";
			items[i].style.padding = "15px";
		}

		let odd_list_items = document.querySelectorAll('.list-group-item:nth-child(odd)');
		let even_list_items = document.querySelectorAll('.list-group-item:nth-child(even)');
		console.log(odd_list_items);

		for(let i = 0; i < odd_list_items.length; i++) {
			odd_list_items[i].style.color = "blue";
			even_list_items[i].style.color = "red";
		}

		//document.getElementById('id');
		//document.getElementsByClassName('class-name');
		//document.getElementsByTagName('tag');
		//document.querySelector('#id'); //return first result only
		//document.querySelectorAll('.class_name'); //return all
