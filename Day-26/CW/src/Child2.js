import { Component } from "react";


//class component
class Child2 extends Component {
    render() {
        return (
            <>
                <h1>Chil2</h1>
             <b>Welcome Child2</b><br />
             <b>Name : {this.props.name}  </b>

            </>
        );
    }

}


//to display default values intsted of blank
Child2.defaultProps = {
    name : "Vijay",
    email : "abc@gmail.com"
};


export default Child2;