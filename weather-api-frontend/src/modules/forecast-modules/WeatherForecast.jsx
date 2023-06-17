import React from "react";
import { Outlet, useNavigate } from "react-router-dom";
import SearchForm from "./SearchForm";

export default function WeatherForecast() {
    const navigate = useNavigate();
    return (
      <>
      
        <div className="weather-container">
            <div>Weather Forecast</div>
            <SearchForm></SearchForm>
            <button className="forecast-btn" onClick={e => navigate('/forecast/weather/daily')}>Daily</button>
            <button className="forecast-btn" onClick={e => navigate('/forecast/weather/hourly')}>Hourly</button>
        </div>
        <Outlet></Outlet>
        </>
    );
}
