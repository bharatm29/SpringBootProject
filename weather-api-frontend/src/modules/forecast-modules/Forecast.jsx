import { useLocation, useNavigate } from "react-router-dom";
import { NavLink, Outlet } from "react-router-dom";

export default function Forecast() {
    const location = useLocation();
    const navigate = useNavigate();
    return (
        <>
            <div className="forecast-container">
                <button
                    className="forecast-btn"
                    onClick={(e) => navigate("/forecast/realtime")}
                >
                    <NavLink className="btnLink">Realtime Forecast</NavLink>
                </button>
                <button
                    className="forecast-btn"
                    onClick={(e) => navigate("/forecast/weather")}
                >
                    <NavLink className="btnLink">Weather Forecast</NavLink>
                </button>
                <Outlet/>
            </div>
        </>
    );
}
