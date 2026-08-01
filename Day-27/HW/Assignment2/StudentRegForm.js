import { useState } from "react";

function StudentRegForm() {
  const [student, setStudent] = useState({
  name: "",
  age: "",
  gender: "",
  course: "",
  city: "",
  display : false
});

    let change = (e) => {
          e.preventDefault();
        setStudent({...student, display : true});
    }

    return (
        <>
        <form>
    
     Enter Name :   <input type = "text" value={student.name}  onChange={(e) => setStudent({...student, name : e.target.value})}/> <br />
     Enter Age :    <input type = "number" value={student.age}   onChange={(e) => setStudent({...student, age : e.target.value})}/> <br />
     Enter Gender :    <input type = "text" value={student.gender}   onChange={(e) => setStudent({...student, gender : e.target.value})}/> <br />
    Enter Course : <input type = "text" value={student.course}  onChange={(e) => setStudent({...student, course : e.target.value})}/> <br />
    Enter City :    <input type = "text" value={student.city}   onChange={(e) => setStudent({...student, city : e.target.value})}/> <br />
        <button onClick={change}>Submit</button>
    </form>
    <br /> <br />


{student.display && (
  <>
    <h1>Student Information</h1>
    <b>Name : {student.name}</b> <br />
    <b>Age : {student.age}</b> <br />
    <b>Gender : {student.gender}</b> <br />
    <b>Course : {student.course}</b> <br />
    <b>City : {student.city}</b> <br />
  </>
)}
        
        </>
    )
}

export default StudentRegForm;