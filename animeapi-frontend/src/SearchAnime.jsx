import { useState } from "react";
import AnimeCard from "./AnimeCard";
import "./mainStyle.css"

export default function SearchAnime( {email} ){
    const [searchName, setSearchName] = useState("");
    const [searchAnimeResults, setSearchAnimeResults] = useState([])

    const jwt = "eyJhbGciOiJIUzI1NiJ9.eyJwYXNzd29yZCI6InRlc3QiLCJzdWIiOiJ0ZXN0QGdtYWlsLmNvbSIsImlhdCI6MTY4NTY5OTEzNn0.vEPRZgBURHBETEPovWsRMSqBKRS4zMNIFcVrJphkmkY";

    async function addAnimeToUser(animeId){
        const requestObj = {
            email,
            animeIds: [
                animeId
            ]
        }
        await fetch(`http://localhost:4000/anime/user/add`,
        {
            method: "POST",
            body: JSON.stringify(requestObj),
            headers: {
                "Authorization": `Bearer ${jwt}`,
                "content-type": "application/json"
            }
        })
    }

    const getSearchResults = () => {
        fetch(`http://localhost:4000/anime/search/${searchName}`,
        {
            method: "GET",
            headers:{
                "Authorization": `Bearer ${jwt}`
            }
        }).then(res => res.json()).then(data => {
            setSearchAnimeResults(data.animes);
        })
    }
    const handleFormSubmit = (e) => {
        e.preventDefault();
        getSearchResults();
    }

    return(
        <>
            <section className="mainDisplay">
            <div className="searchFormContainer">
                <form onSubmit={handleFormSubmit} className="searchForm">
                    <div className="searchFieldContainer">
                        <input 
                            className="searchField" 
                            type="text"
                            spellCheck={false}
                            name="search"
                            id="seach"
                            placeholder="search anime"
                            value={searchName} 
                            onChange={e => setSearchName(e.target.value)}
                        />
                    </div>
                    <div className="searchBtnContainer">
                        <input 
                            type="submit" 
                            value="search"
                            className="searchBtn btns dropShadowBtns"
                        />
                    </div>
                </form>
            </div>
            </section>

            <div className="searchResultTag tag">
                <h3>Search Results</h3>
            </div>

            <div className="searchResultsContainer">
                {
                    searchAnimeResults.map(anime => {
                        return (
                            <AnimeCard {...anime} addAnimeToUser={addAnimeToUser}></AnimeCard>
                        )
                    })
                }
            </div>
        </>
    )
}