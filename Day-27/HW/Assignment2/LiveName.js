import { useState } from "react";

function LiveName() {
    const [name, setName] = useState("Guest");

    return (
        <>
    
        <input type = "text" value={name}  onChange={(e) => setName(e.target.value)}/> <br />
        <b>Welcome {name}</b>
        
        </>
    )
}

export default LiveName;