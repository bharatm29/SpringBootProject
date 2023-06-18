export default function ForecastValue({
    freezingRainIntensity,
    humidity,
    iceAccumulation,
    iceAccumulationLwe,
    precipitationProbability,
    pressureSurfaceLevel,
    rainAccumulation,
    rainIntensity,
    snowAccumulation,
    snowIntensity,
    temperature,
    weatherCode,
    windDirection,
    windGust,
    windSpeed,
}) {
    return <div className="value-container">Code: {weatherCode}</div>;
}
