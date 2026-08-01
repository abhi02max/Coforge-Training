import { Component } from "react";
import Employee from "../models/Employee";
import EmployeeService from "../services/EmployeeService";

class EmployeeHome extends Component {

    constructor() {
        super();

        this.employeeService = new EmployeeService();

        this.state = {
            eid: "",
            ename: "",
            esalary: "",
            dno: "",
            result: "",
            employees: [],

            eidError: "",
            enameError: "",
            esalaryError: "",
            dnoError: ""
        };
    }

    saveEmployeeValidation = () => {

        this.setState({
            eidError: "",
            enameError: "",
            esalaryError: "",
            dnoError: ""
        });

        let valid = true;

        if (this.state.eid === "") {
            this.setState({ eidError: "Employee ID is required" });
            valid = false;
        }
        else if (isNaN(this.state.eid) || Number(this.state.eid) <= 0) {
            this.setState({ eidError: "Employee ID must be positive number" });
            valid = false;
        }

        if (this.state.ename === "") {
            this.setState({ enameError: "Employee Name is required" });
            valid = false;
        }
        else if (!/^[A-Za-z ]+$/.test(this.state.ename)) {
            this.setState({ enameError: "Name should contain only alphabets" });
            valid = false;
        }

        if (this.state.esalary === "") {
            this.setState({ esalaryError: "Salary is required" });
            valid = false;
        }
        else if (isNaN(this.state.esalary) || Number(this.state.esalary) <= 0) {
            this.setState({ esalaryError: "Salary must be positive number" });
            valid = false;
        }

        if (this.state.dno === "") {
            this.setState({ dnoError: "Department No is required" });
            valid = false;
        }
        else if (isNaN(this.state.dno) || Number(this.state.dno) <= 0) {
            this.setState({ dnoError: "Department No must be positive number" });
            valid = false;
        }

        return valid;
    }

    saveEmployee = () => {

        if (this.saveEmployeeValidation()) {

            let employee = new Employee(
                this.state.eid,
                this.state.ename,
                this.state.esalary,
                this.state.dno
            );

            this.employeeService.saveEmployee(employee)
                .then((result) => {
                    this.setState({
                        result: result,
                        eid: "",
                        ename: "",
                        esalary: "",
                        dno: ""
                    });
                })
                .catch((error) => {
                    console.log(error);
                });

        }

    }

    updateEmployee = () => {

        if (this.saveEmployeeValidation()) {

            let employee = new Employee(
                this.state.eid,
                this.state.ename,
                this.state.esalary,
                this.state.dno
            );

            this.employeeService.updateEmployee(this.state.eid, employee)
                .then((result) => {
                    this.setState({ result: result });
                })
                .catch((error) => {
                    console.log(error);
                });

        }

    }

    deleteEmployee = () => {

        if (this.state.eid === "") {
            this.setState({ eidError: "Employee ID is required" });
            return;
        }

        this.employeeService.deleteEmployee(this.state.eid)
            .then((result) => {
                this.setState({
                    result: result,
                    eid: "",
                    ename: "",
                    esalary: "",
                    dno: ""
                });
            })
            .catch((error) => {
                console.log(error);
            });

    }

 findEmployee = () => {

    if (this.state.eid === "") {
        this.setState({ eidError: "Employee ID is required" });
        return;
    }

    this.employeeService.findEmployee(this.state.eid)
        .then((emp) => {

            this.setState({
                employees: [emp],      // Display only the found employee
                result: "Employee Found Successfully"
            });

        })
        .catch((error) => {
            console.log(error);
        });
    }

    findAllEmployees = () => {

        this.employeeService.findAllEmployees()
            .then((employees) => {

                this.setState({
                    employees: employees,
                    result: "Employees Loaded"
                });

            })
            .catch((error) => {
                console.log(error);
            });

    }
        render() {

        return (

            <>

                <h2>Employee Registration</h2>

                <p>
                    Employee ID :
                    <input
                        type="text"
                        value={this.state.eid}
                        onChange={(e) => this.setState({ eid: e.target.value })}
                    />
                </p>

                <p style={{ color: "red" }}>
                    {this.state.eidError}
                </p>

                <p>
                    Employee Name :
                    <input
                        type="text"
                        value={this.state.ename}
                        onChange={(e) => this.setState({ ename: e.target.value })}
                    />
                </p>

                <p style={{ color: "red" }}>
                    {this.state.enameError}
                </p>

                <p>
                    Salary :
                    <input
                        type="text"
                        value={this.state.esalary}
                        onChange={(e) => this.setState({ esalary: e.target.value })}
                    />
                </p>

                <p style={{ color: "red" }}>
                    {this.state.esalaryError}
                </p>

                <p>
                    Department No :
                    <input
                        type="text"
                        value={this.state.dno}
                        onChange={(e) => this.setState({ dno: e.target.value })}
                    />
                </p>

                <p style={{ color: "red" }}>
                    {this.state.dnoError}
                </p>

                <button onClick={this.saveEmployee}>
                    Save Employee
                </button>

                &nbsp;

                <button onClick={this.updateEmployee}>
                    Update Employee
                </button>

                &nbsp;

                <button onClick={this.deleteEmployee}>
                    Delete Employee
                </button>

                &nbsp;

                <button onClick={this.findEmployee}>
                    Find Employee
                </button>

                &nbsp;

                <button onClick={this.findAllEmployees}>
                    Find All Employees
                </button>

                <br /><br />

                <b>{this.state.result}</b>

                <br /><br />

                <table border="1" cellPadding="8">

                    <thead>
                        <tr>
                            <th>Employee ID</th>
                            <th>Name</th>
                            <th>Salary</th>
                            <th>Department No</th>
                        </tr>
                    </thead>

                    <tbody>

                        {
                            this.state.employees.map((emp) => (

                                <tr key={emp.eid}>
                                    <td>{emp.eid}</td>
                                    <td>{emp.ename}</td>
                                    <td>{emp.esalary}</td>
                                    <td>{emp.dno}</td>
                                </tr>

                            ))
                        }

                    </tbody>

                </table>

            </>

        );

    }

}

export default EmployeeHome;