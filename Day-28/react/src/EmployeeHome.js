import { useState } from "react";

function EmployeeHome() {
  const [eid, setEid] = useState("");
  const [ename, setEname] = useState("");
  const [dno, setDno] = useState("");
  const [salary, setSalary] = useState("");

  const [eidError, setEidError] = useState("");
  const [enameError, setEnameError] = useState("");
  const [dnoError, setDnoError] = useState("");
  const [salaryError, setSalaryError] = useState("");

  const [employee, setEmployee] = useState(null);

  function handleSubmit() {
    setEidError("");
    setEnameError("");
    setDnoError("");
    setSalaryError("");

    let valid = true;

    if (eid === "") {
      setEidError("Employee ID is required");
      valid = false;
    } else if (isNaN(eid) || Number(eid) <= 0) {
      setEidError("Employee ID must be positive number");
      valid = false;
    }

    if (ename === "") {
      setEnameError("Employee Name is required");
      valid = false;
    } else if (!/^[A-Za-z ]+$/.test(ename)) {
      setEnameError("Name should contain only alphabets");
      valid = false;
    }

    if (dno === "") {
      setDnoError("Department No is required");
      valid = false;
    } else if (isNaN(dno) || Number(dno) <= 0) {
      setDnoError("Department No must be positive number");
      valid = false;
    }

    if (salary === "") {
      setSalaryError("Salary is required");
      valid = false;
    } else if (isNaN(salary) || Number(salary) <= 0) {
      setSalaryError("Salary must be positive number");
      valid = false;
    }

    if (valid) {
      setEmployee({
        eid,
        ename,
        dno,
        salary
      });
    }
  }

  

  return (
    <>
      <h2>Employee Registration</h2>

      <p>Employee ID: 
        <input type="text" value={eid} onChange={(e) => setEid(e.target.value)}/></p>
      <p style={{ color: "red" }}>{eidError}</p>

      <p>Employee Name: 
        <input type="text" value={ename} onChange={(e) => setEname(e.target.value)}/></p>
      <p style={{ color: "red" }}>{enameError}</p>

      <p>Department No: 
        <input type="text" value={dno} onChange={(e) => setDno(e.target.value)}/></p>
      <p style={{ color: "red" }}>{dnoError}</p>

      <p>Salary: 
        <input type="text" value={salary} onChange={(e) => setSalary(e.target.value)}/></p>
      <p style={{ color: "red" }}>{salaryError}</p>

      <button onClick={handleSubmit}>Submit</button> <br /> <br />

      <button>Save</button>
      <button>Update</button>
      <button>Delete</button>
      <button>Find</button>
      <button>FindAll</button>

      {employee && (
        <div>
          <h3>Employee Details</h3>
          <p>Employee ID: {employee.eid}</p>
          <p>Employee Name: {employee.ename}</p>
          <p>Department No: {employee.dno}</p>
          <p>Salary: {employee.salary}</p>
        </div>
      )}
    </>
  );
}

export default EmployeeHome;