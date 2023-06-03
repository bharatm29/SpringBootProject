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
    }

    return(
        <>
            <div className="tag authFormTag popUpElem"><span className="authFormTagText">Log In</span></div>
            {isInvalid && (<div className="invalidAuth">
                Invalid! Try again
            </div>)}
            <div className="popUpElem formHead">
                <form onSubmit={handleForm}>
                    <div className="formContainer">
                        <div className="credentialContainer">
                            <label htmlFor="emailTextField" className="tag labelText">Email</label>
                            <input 
                                className="textField" 
                                type="email" 
                                id="emailTextField" 
                                value={emailState}
                                autoComplete="off"
                                required
                                spellCheck={false}
                                placeholder="enter email"
                                onChange={e => setEmailState(e.target.value)}/>
                        </div>
                        <div className="credentialContainer">
                            <label htmlFor="passwordTextField" className="tag labelText">Password</label>
                            <input 
                                className="textField" 
                                type="password"
                                id="passwordTextField"
                                value={passwordState}
                                required
                                spellCheck={false}
                                placeholder="enter password"
                                onChange={e => setPasswordState(e.target.value)}/>
                        </div>
                        <div className="submitContainer">
                            <input className="btns dropShadowBtns submitBtn"
                                type="submit" 
                                value="LOG IN" />
                        </div>
                    </div>
                </form>
            </div>
        </>
    )
}