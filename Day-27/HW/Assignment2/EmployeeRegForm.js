import { useState } from "react";

function EmployeeRegForm() {
  const [employee, setEmployee] = useState({
    id: "",
    name: "",
    dno: "",
    salary: "",
    display: false,
  });

  const [error, setError] = useState({
    idError: "",
    nameError: "",
    dnoError: "",
    salaryError: "",
  });

  const validate = (e) => {
    e.preventDefault();

    let valid = true;

    let newErrors = {
      idError: "",
      nameError: "",
      dnoError: "",
      salaryError: "",
    };


    if (employee.id === "" || Number(employee.id) < 0) {
      newErrors.idError = "Employee Id should be greater than  0";
      valid = false;
    }


    if (employee.name.trim() === "") {
      newErrors.nameError = "Employee Name is required";
      valid = false;
    }


    if (employee.dno === "" || Number(employee.dno) < 0) {
      newErrors.dnoError =
        "Department Number should be greater than 0";
      valid = false;
    }


    if (employee.salary === "" || Number(employee.salary) < 0) {
      newErrors.salaryError =
        "Salary should be greater than 0";
      valid = false;
    }

    setError(newErrors);

    if (valid) {
      setEmployee({ ...employee, display: true });
    } else {
      setEmployee({ ...employee, display: false });
    }
  };

  return (
    <>
      <form onSubmit={validate}>
        Enter Employee Id :
        <input
          type="number"
          value={employee.id}
          onChange={(e) =>
            setEmployee({ ...employee, id: e.target.value })
          }
        />
        <br />
        <b style={{ color: "red" }}>{error.idError}</b>
        <br />

        Enter Employee Name :
        <input
          type="text"
          value={employee.name}
          onChange={(e) =>
            setEmployee({ ...employee, name: e.target.value })
          }
        />
        <br />
        <b style={{ color: "red" }}>{error.nameError}</b>
        <br />

        Enter Department No :
        <input
          type="number"
          value={employee.dno}
          onChange={(e) =>
            setEmployee({ ...employee, dno: e.target.value })
          }
        />
        <br />
        <b style={{ color: "red" }}>{error.dnoError}</b>
        <br />

        Enter Salary :
        <input
          type="number"
          value={employee.salary}
          onChange={(e) =>
            setEmployee({ ...employee, salary: e.target.value })
          }
        />
        <br />
        <b style={{ color: "red" }}>{error.salaryError}</b>
        <br />

        <button type="submit">Submit</button>
      </form>

      <br />

      {employee.display && (
        <>
          <h2>Employee Information</h2>

          <b>Employee Id : {employee.id}</b>
          <br />

          <b>Employee Name : {employee.name}</b>
          <br />

          <b>Department No : {employee.dno}</b>
          <br />

          <b>Salary : {employee.salary}</b>
          <br />
        </>
      )}
    </>
  );
}

export default EmployeeRegForm;