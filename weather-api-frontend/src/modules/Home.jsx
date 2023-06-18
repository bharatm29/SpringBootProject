import { useNavigate } from "react-router-dom";
import "../styles/styles.css";

export default function Home() {
    const navigate = useNavigate();
    const handleForecast = (e) => {
        navigate("/forecast", { state: { text: "redirected from Home" } });
    };
    return (
        <>
            <div className="home-container">
                <h1>This is the home page!</h1>
                <button onClick={handleForecast}>View Forecast</button>
            </div>
        </>
    );
}
