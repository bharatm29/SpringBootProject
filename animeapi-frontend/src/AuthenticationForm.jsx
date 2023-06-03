import { useState } from "react"
import "./mainStyle.css"

export default function AuthenticationForm({ fetchUserDetails }){
    const [emailState, setEmailState] = useState("");
    const [passwordState, setPasswordState] = useState("");
    const [isInvalid, setInvalid] = useState(false)

    const handleForm = (e) => {
        e.preventDefault();

        const authBody = {
            email: emailState,
            password: passwordState
        }

        fetch("http://localhost:4000/auth/authenticate", 
        {
            method: "POST",
            body: JSON.stringify(authBody),
            headers: {
                "content-type": "application/json",
            }
        }).then(res =>{
            if(res.ok){
                fetchUserDetails(emailState);
            }
            else{
                setInvalid(true);
            }
        })

        //this will validate if the user is valid or not and sets isInvalid to true
    }

    return(
        <>
            {isInvalid && (<div className="invalidAuth">
                <span>Invalid! Try again</span>
            </div>)}
            <span>Authentication Form</span>
            <form onSubmit={handleForm}>
                <input className="textField" type="text" id="emailTextField" value={emailState} onChange={e => setEmailState(e.target.value)}/>
                <input className="textField" type="text" id="passwordTextField" value={passwordState} onChange={e => setPasswordState(e.target.value)}/>
                <input type="submit" value="log in" />
            </form>
        </>
    )
}