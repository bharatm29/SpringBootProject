import React, { useState } from "react";
import { Outlet, useNavigate } from "react-router-dom";
import SearchForm from "./forecast-utils/SearchForm";

export default function WeatherForecast() {
    const navigate = useNavigate();
    const [timeline, setTimeline] = useState("d");
    const handleSubmit = (e, location) => {
        e.preventDefault();
        if (timeline == "d") {
            navigate("/forecast/weather/daily", { state: { location } });
        } else {
            navigate("/forecast/weather/hourly", { state: { location } });
        }
    };

    return (
        <>
            <div className="weather-container">
                <div>Weather Forecast</div>
                <SearchForm handleSubmit={handleSubmit}></SearchForm>
                <button
                    className="forecast-btn"
                    onClick={(e) => {
                        setTimeline("d");
                    }}
                >
                    Daily
                </button>
                <button
                    className="forecast-btn"
                    onClick={(e) => setTimeline("h")}
                >
                    Hourly
                </button>
            </div>
            <Outlet></Outlet>
        </>
    );
}
