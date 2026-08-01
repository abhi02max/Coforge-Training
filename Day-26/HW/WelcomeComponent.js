import { Component } from "react";

class WelcomeComponent extends Component{
    
    render(){
        const today = new Date().toLocaleDateString();
        return(
            <>
                <h1>Welcome Component</h1>
                <h2>Akkinapalli Sai Pranav</h2>
                <p><strong>Today's Date is : </strong>{today}</p>
            </>
        );
    }
}

export default WelcomeComponent;