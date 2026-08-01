
import './App.css';
import Child1 from './Child1';
import Child2 from './Child2';
import Calculator from './states/Calculator';
import Counter from './states/Counter';
import EmployeeComponent from './states/EmployeeComponent';
import CalculatorWithFunCom from './states/CalculatorWithFunCom';
import CounterApplication from './Assignment2/CounterApplication';
import LiveName from './Assignment2/LiveName';
import StudentRegForm from './Assignment2/StudentRegForm';
import LoginForm from './Assignment2/LoginForm';
import EmployeeRegForm from './Assignment2/EmployeeRegForm';
import EvenComponent from './date_30/EvenComponent';
import OddComponent from './date_30/OddComponent';
 
import {Routes, Route} from 'react-router-dom';
import Home from "./date_30/pages/Home";
import About from "./date_30/pages/About";
import Contact from "./date_30/pages/Contact";
import Navbar from './date_30/Navbar';

function App(props) {


//conditional rendering
  //  let n = props.n;
  //  if(n % 2 === 0)
  //   return <EvenComponent  n = {n} />
  //   else
  //     return <OddComponent n = {n}/>
// return (
//   <>
//   {n % 2 === 0 &&  <EvenComponent n = {n} />}
//   {n % 2 !== 0 &&  <OddComponent n = {n} />}
//   </>
// );
   
// return (
//     <>
//       {(n % 2 == 0) ? <EvenComponent n={n}></EvenComponent> : <OddComponent n={n}></OddComponent>}
//     </>
//   )
//   }

  return (
    <>
     {/* <h1>My React App</h1>
    <h2>Weclome to React</h2>
    <Child1 name="Neeraj" />
   <Child2 />
    <h1>College : {props.college}</h1>  */}
     {/* <h1><u> React States </u></h1>
    <EmployeeComponent  org = "Coforge"/>
    <Calculator />
    <Counter />
    <CalculatorWithFunCom /> */}
    {/* <CounterApplication /> <br /> <br />
    <LiveName /> <br /> <br/>
    <StudentRegForm /><br /> <br/>
    <LoginForm />
    <EmployeeRegForm /> */}

    <Navbar />

    <Routes>
      <Route path="/" element={<Home />} />
      <Route path="/about" element={<About />} />
      <Route path="/contact" element={<Contact />} />
    </Routes>
    
    </>
  );
}


export default App;
