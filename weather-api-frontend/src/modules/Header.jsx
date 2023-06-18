import React from "react";
import { NavLink, Outlet } from "react-router-dom";
import '../styles/styles.css'

export default function Header() {
    return (
        <>
            <header className="main-header">
                <div className="app-container">Weather API</div>
                <nav className="main-nav">
                    <ul className="header-ul" role="list">
                        <li className="header-li">
                            <NavLink to={"/"} className="header-link navLink">
                                Home
                            </NavLink>
                        </li>
                        <li className="header-li">
                            <NavLink to={"/forecast"} className="header-link navLink">
                                Forecast
                            </NavLink>
                        </li>
                    </ul>
                </nav>
                <button className="styles-btn"><NavLink className={"navLink"} to={'https://www.tomorrow.io'} target="blank">Tomorrow API</NavLink></button>
            </header>
            <Outlet></Outlet>
        </>
    );
}
