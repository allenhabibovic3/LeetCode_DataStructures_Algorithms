import React, { Component } from 'react';

class Counter extends Component {

    state = { 
        count: 1,
        imageUrl: 'https://picsum.photos/200',
        names: ['Allen', 'Jack', 'Zerin', 'Ming', 'Adis']
     };


    handleIncrement = () => {
        this.setState({count: this.state.count + 1});
    }

    renderTags() {
        if (this.state.names.length == 0) return 'Empty';

        return <ul>{this.state.names.map(name => <li key={name}> {name} </li>)}</ul>
    }

    handleDecrement = () => {
        this.setState({count: this.state.count - 1});
    }

    render() { 

        return (
            <div>
                <span style={{fontSize:25}}class={this.getBadgeClass()}>{this.getCount()}</span>
                <button class="btn btn-secondary btn-sm m-2" onClick={this.handleIncrement}>Increment</button>
                <button class="btn btn-warning btn-sm" onClick={this.handleDecrement}>Decrement</button>
                {this.renderTags()}
            </div>
        );
    }

    getCount() {
        return (this.state.count == 0) ? "Zero" : this.state.count;
    }

    getBadgeClass() {
        let classes = "badge m-2 badge-";
        
        if(this.state.count < 0) classes += "danger";
        else if(this.state.count == 0) classes += "warning";
        else classes += "primary";

        return classes;
    }
}
 
export default Counter;
