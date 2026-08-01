import { useState } from "react"

function CalculatorWithFunCom() {

    const [n1, setN1] = useState(0);
    const [n2, setN2] = useState(0);
    const [result, setResult] = useState("");

    let  addition = () => setResult("Addition : " + (parseInt(n1) + parseInt(n2)));
   
   let  subtraction = () => setResult("Subtraction : " + (parseInt(n1) - parseInt(n2)));

   let  multiplication = () => setResult("Multiplication : " + (parseInt(n1) * parseInt(n2)));

    let  division = () => setResult("Division : " + (parseInt(n1) - parseInt(n2)));

    return (
    <>
            <h1>Calculator Application using functional component</h1>
            <b>Enter Number 1 : <input type="text" value={n1} onChange={(event) => setN1(event.target.value)} /></b><br /><br />
            <b>Enter Number 2 : <input type="text" value={n2} onChange={(event) => setN2(event.target.value)}/></b>
           <br /> <br /> 
           <button onClick={addition}>Add</button> 
           <button onClick={subtraction}>Sub</button> 
           <button onClick={multiplication}>Mul</button> 
           <button onClick={division}>Div</button> 
           <br /> <br />
            <b>result : {result}</b>
    </>);
}

export default CalculatorWithFunCom;