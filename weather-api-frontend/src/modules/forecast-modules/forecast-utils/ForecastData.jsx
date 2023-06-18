import ForecastValue from "./ForecastValue";
export default function ForecastData({ time, values }) {
    return (
        <div className="forecast-data">
            <div className="forecast-time">{time}</div>
            <ForecastValue {...values}></ForecastValue>
        </div>
    );
}
