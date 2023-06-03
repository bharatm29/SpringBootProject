import { useState } from "react"
import "./mainStyle.css"

export default function Register({ fetchUserDetails }) {
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
        <>
        <div className="tag authFormTag popUpElem"><span className="authFormTagText">Register</span></div>
        <div className="popUpElem">
            <form onSubmit={registerUser}>
                <div className="formContainer">
                    <div className="credentialContainer">
                        <label htmlFor="nameField" className="labelText tag">Username</label>
                        <input
                            type="text"
                            id="nameField"
                            value={nameState}
                            className="textField"
                            required
                            placeholder="enter username"
                            autoComplete="off"
                            spellCheck={false}
                            onChange={e => setNameState(e.target.value)} />
                    </div>

                    <div className="credentialContainer">
                        <label htmlFor="emailField" className="labelText tag">Email</label>
                        <input
                            type="email"
                            id="emailField"
                            value={emailState}
                            className="textField"
                            required
                            placeholder="enter email"
                            autoComplete="off"
                            spellCheck={false}
                            onChange={e => setEmailState(e.target.value)} />
                    </div>
                    <div className="credentialContainer">
                        <label htmlFor="passwordField" className="labelText tag">Password</label><input
                            type="password"
                            id="passwordField"
                            value={passwordState}
                            className="textField"
                            required
                            placeholder="enter password"
                            spellCheck={false}
                            autoComplete="off"
                            onChange={e => setPasswordState(e.target.value)} />
                    </div>
                    <div className="submitContainer">
                        <input
                            type="submit"
                            value="Register"
                            className="btns dropShadowBtns submitBtn" />
                    </div>
                </div>
            </form>
        </div>
        </>
    )
}