import { useLocation } from "react-router-dom";
import { useQuery } from "@tanstack/react-query";
import ForecastData from "../forecast-utils/ForecastData";

const fetchResults = (location) => {
    return fetch(
        `http://localhost:4000/weather/forecast/hourly/${location}`
    ).then((res) => res.json());
};

export default function HourlyForecast() {
    const locationState = useLocation();
    const locationField = locationState.state.location;
    const result = useQuery({
        staleTime: 3600000,
        queryKey: ["hourly", locationField],
        queryFn: () => fetchResults(locationField),
        cacheTime: 5400000
    });

    const location = result.data?.location;
    const data = result?.data?.data;

    return (
        <div className="hourly-container">
            {JSON.stringify(result?.data)}
            <div className="hourly-results-container">
                <div className="realtime-location">{location?.name}</div>
                {data?.map((item) => {
                    return <ForecastData {...item}></ForecastData>;
                })}
            </div>
        </div>
    );
}
