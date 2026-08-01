import { Component } from "react";

class EmployeeComponent extends Component{
    constructor(props){
        super(props);
        this.state = {
            eid : 101,
            ename : "Neeraj",
            esalary : 100000
        }
    }
    render(){
        return (
        <>
        <h1>React Props and States</h1>
        <h1>Organization = {this.props.org}</h1>
        <p>State Variables</p>
        <p>eno : {this.state.eid}</p>
        <p>ename : {this.state.ename}</p>
        <p>esalary : {this.state.esalary}</p>
        </>
        );
    }
}


export default EmployeeComponent;