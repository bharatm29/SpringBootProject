import React from "react";
import SearchForm from "./forecast-utils/SearchForm";
import { Outlet, useNavigate } from "react-router-dom";

export default function RealtimeForecast() {
    const navigate = useNavigate();
    const handleSubmit = (e, location) => {
        e.preventDefault();
        navigate("/forecast/realtime/results", { state: { location } });
    };

    return (
        <div className="realtime-container">
            <div>Realtime Forecast</div>
            <SearchForm handleSubmit={handleSubmit}></SearchForm>
            <Outlet></Outlet>
        </div>
    );
}
