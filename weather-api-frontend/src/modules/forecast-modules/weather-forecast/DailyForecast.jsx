import { useQuery } from "@tanstack/react-query";
import { useLocation } from "react-router-dom";

const fetchResults = (location) => {
    return fetch(
        `http://localhost:4000/weather/forecast/daily/${location}`
    ).then((res) => res.json());
};

export default function DailyForecast() {
    const locationState = useLocation();
    const locationField = locationState.state.location;
    const result = useQuery({
        staleTime: 3600000,
        cacheTime: 5400000,
        queryKey: ["daily", locationField],
        queryFn: () => fetchResults(locationField),
    });
    return <div className="daily-container">{JSON.stringify(result.data)}</div>;
}
