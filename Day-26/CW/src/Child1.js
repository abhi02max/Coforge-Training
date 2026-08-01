// function Child1(props) { // you can decontruct it 
//   return (
//     <>
//       <h1>Child</h1>
//       <b>Welcome Child1</b>
//       <p>Name : {props.name}</p>
//       <p>Co: {props.email}</p>
//     </>
//   );
// }


function Child1({name = "Ramesh" , email = "abc@gmail.com"}) { // default props for functional components 
  return (
    <>
      <h1>Child</h1>
      <b>Welcome Child1</b>
      <p>Name : {name}</p>
      <p>Co: {email}</p>
    </>
  );
}




export default Child1;