import "./mainStyle.css"

export default function AnimeCard({ animeId, animeTitle, animeUrl, animeImg, status, addAnimeToUser }){
    return (
        <div className="animeCardContainer">
            <div className="titleTag animeTag">
                <a href={animeUrl}>{animeTitle}</a>
            </div>
            <div className="statTag animeTag">Status: {status}</div>
            <div>
                <img className="genImg animeImg" src={animeImg} alt="Not found" height={100} />
            </div>
            <div>
                <button className="addBtn btns" onClick={() => addAnimeToUser(animeId)}>Add</button>
            </div>
        </div>
    )
}