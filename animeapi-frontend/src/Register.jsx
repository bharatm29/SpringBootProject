import { useState } from "react"
import "./mainStyle.css"

export default function Register({ fetchUserDetails }){
    const [nameState, setNameState] = useState("");
    const [emailState, setEmailState] = useState("");
    const [passwordState, setPasswordState] = useState("");

    const registerUser = () => {
        const registerObj = {
            username: nameState,
            email: emailState,
            password: passwordState,
        }

        fetch("http://localhost:4000/auth/register", 
        {
            method: "POST",
            body: JSON.stringify(registerObj),
            headers: {
                "content-type": "application/json"
            }
        }).then(res => console.log("Registered!"))
    }

    return (
        <form onSubmit={registerUser}>
            Username: <input type="text" id="nameField" value={nameState} onChange={e => setNameState(e.target.value)}/>
            <br/>Email: <input type="text" id="emailField" value={emailState} onChange={e => setEmailState(e.target.value)}/>
            <br/>Password: <input type="text" id="passwordField" value={passwordState} onChange={e => setPasswordState(e.target.value)}/>
            <br/><input type="submit" value="Register"/>
        </form>
    )
}