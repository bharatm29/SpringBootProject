import React from "react";
import { Route, Routes } from "react-router-dom";
import Home from "./Home";
import Forecast from "./forecast-modules/Forecast";
import RealtimeForecast from "./forecast-modules/RealtimeForecast";
import WeatherForecast from "./forecast-modules/WeatherForecast";
import Header from "./Header";
import DailyForecast from "./forecast-modules/weather-forecast/DailyForecast";
import HourlyForecast from "./forecast-modules/weather-forecast/HourlyForecast";

export default function APIRouter() {
    return (
        <Routes>
            <Route path="/" element={<Home></Home>} />
            <Route path="/forecast" element={<Forecast></Forecast>}>
                <Route
                    path="realtime"
                    element={<RealtimeForecast></RealtimeForecast>}
                />
                <Route
                    path="weather"
                    element={<WeatherForecast></WeatherForecast>}
                >
                    <Route
                        path="daily"
                        element={<DailyForecast></DailyForecast>}
                    />
                    <Route
                        path="hourly"
                        element={<HourlyForecast></HourlyForecast>}
                    />
                </Route>
            </Route>
        </Routes>
    );
}
