import { useQuery } from "@tanstack/react-query";
import { useLocation } from "react-router-dom";
import ForecastData from "./forecast-utils/ForecastData";

const fetchResults = async (location) => {
    const res = await fetch(
        `http://localhost:4000/weather/realtime/${location}`
    );
    return await res.json();
};

export default function RealtimeResults() {
    const locationState = useLocation();
    const locationField = locationState?.state?.location;
    const result = useQuery({
        queryKey: ["realtime", locationField],
        queryFn: () => fetchResults(locationField),
        staleTime: 3600000,
        cacheTime: 5400000
    });

    const location = result?.data?.location;
    const data = result.data?.data;
    return (
        <div className="realtime-results-container">
            {JSON.stringify(result.data)}
            <div className="realtime-location">{location?.name}</div>
            <ForecastData {...data}></ForecastData>
        </div>
    );
}
