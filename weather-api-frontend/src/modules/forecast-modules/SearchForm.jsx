export default function SearchForm() {
    return (
        <>
            <div className="form-container">
                <form action="" className="search-form">
                    <input
                        type="search"
                        name="searchLoc"
                        id="searchLoc"
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
