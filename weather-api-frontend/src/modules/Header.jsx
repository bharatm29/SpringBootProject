import React from "react";
import { NavLink, Outlet } from "react-router-dom";

export default function Header() {
    return (
        <>
            <header className="main-header">
                <div className="app-container">Weather API</div>
                <nav className="main-nav">
                    <ul className="header-ul">
                        <li className="header-li">
                            <NavLink to={"/"} className="header-link">
                                Home
                            </NavLink>
                        </li>
                        <li className="header-li">
                            <NavLink to={"/forecast"} className="header-link">
                                Forecast
                            </NavLink>
                        </li>
                    </ul>
                </nav>
            </header>
            <Outlet></Outlet>
        </>
    );
}
