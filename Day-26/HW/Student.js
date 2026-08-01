import { Component } from "react";


class Student extends Component{
    render(){
        return (
            <>
                <h1>Student Component</h1>
                <p><strong>Name : </strong>{this.props.name}</p>
                <p><strong>Course : </strong>{this.props.course}</p>
                <p><strong>Age : </strong>{this.props.age}</p>
                <p><strong>City : </strong>{this.props.city}</p>
            </>
        );
    }
}

export default Student;