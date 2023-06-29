import React from "react";
import Routing from "./Routing";
import "./index.css";

export default function App() {
    return (
        <>
            <header className="main-header">
                <h1 className="app-name">Dictionary App</h1>
                <button className="styled-btn">Dictionary API</button>
            </header>
            <main>
                <div className="main-container">
                    <Routing></Routing>
                </div>
            </main>
        </>
    );
}
