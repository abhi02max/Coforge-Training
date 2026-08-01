import { Component } from "react";

class Calculator  extends Component {
    constructor(props){
        super(props);
        this.state = {
            n1 : "",
            n2 : "",
            result : ""
        }
    }

    addition = () => this.setState({result : "Addition :  "  +  (parseInt(this.state.n1) + parseInt(this.state.n2))})
   
    subtraction = () =>  this.setState({result : "Subtraction :  "  +  (parseInt(this.state.n1) - parseInt(this.state.n2))})

    multiplication = () =>  this.setState({result : "Multiplication :  "  +  (parseInt(this.state.n1) * parseInt(this.state.n2))})

    division = () => this.setState({result : "Division :  "  +  (parseInt(this.state.n1) / parseInt(this.state.n2))})



    render() {
        return(
            <>
            <h1>Calculator Application</h1>
            <b>Enter Number 1 : <input type="text" value={this.state.n1} onChange={(event) => this.setState({n1 : event.target.value})} /></b><br /><br />
            <b>Enter Number 2 : <input type="text" value={this.state.n2} onChange={(event) => this.setState({n2 : event.target.value})}/></b>
           <br /> <br /> 
           <button onClick={this.addition}>Add</button> 
           <button onClick={this.subtraction}>Sub</button> 
           <button onClick={this.multiplication}>Mul</button> 
           <button onClick={this.division}>Div</button> 
           <br /> <br />
            <b>result : {this.state.result}</b>
            </>
        );
    }
}

export default Calculator;