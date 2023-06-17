import React from "react";
import { Outlet, useNavigate } from "react-router-dom";

export default function WeatherForecast() {
    const navigate = useNavigate();
    return (
      <>
      
        <div className="weather-container">
            <div>Weather Forecast</div>
            <button className="forecast-btn" onClick={e => navigate('/forecast/weather/daily')}>Daily</button>
            <button className="forecast-btn" onClick={e => navigate('/forecast/weather/hourly')}>Hourly</button>
        </div>
        <Outlet></Outlet>
        </>
    );
}
