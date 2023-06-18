import { useState } from "react";

export default function SearchForm({ handleSubmit }) {
    const [location, setLocation] = useState("");
    return (
        <>
            <div className="form-container">
                <form onSubmit={e => handleSubmit(e, location)} className="search-form">
                    <input
                        type="search"
                        name="searchLoc"
                        id="searchLoc"
                        value={location}
                        onChange={e => setLocation(e.target.value)}
                        spellCheck={false}
                        autoComplete="off"
                        placeholder="enter location"
                        className="search-field"
                    />
                    <button type="submit" className="forecastBtn">
                        search
                    </button>
                </form>
            </div>
        </>
    );
}
