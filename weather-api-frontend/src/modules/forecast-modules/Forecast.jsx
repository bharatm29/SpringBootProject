import { useLocation, useNavigate } from "react-router-dom";
import { NavLink, Outlet } from "react-router-dom";
import '../../styles/styles.css'

export default function Forecast() {
    const navigate = useNavigate();
    return (
        <>
            <div className="forecast-container">
                <button
                    className="forecast-btn"
                    onClick={(e) => navigate("/forecast/realtime")}
                >
                    <NavLink className="navLink btnLink">Realtime Forecast</NavLink>
                </button>
                <button
                    className="forecast-btn"
                    onClick={(e) => navigate("/forecast/weather")}
                >
                    <NavLink className="navLink tnLink">Weather Forecast</NavLink>
                </button>
                <Outlet/>
            </div>
        </>
    );
}
