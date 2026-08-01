import { Component } from "react";

class Employee extends Component{
    render(){
        return(
            <div className="card">

                <div className="card-header bg-primary text-white">
                    <h3>Employee Details</h3>
                </div>

                <div className="card-body">
                    <p><strong>Employee ID : </strong>{this.props.eid}</p>
                    <p><strong>Employee Name : </strong>{this.props.ename}</p>
                    <p><strong>Department : </strong>{this.props.department}</p>
                    <p><strong>Designation : </strong>{this.props.designation}</p>
                    <p><strong>Salary : </strong>{this.props.salary}</p>
                </div>
            </div>

        );
    }
}
export default Employee;