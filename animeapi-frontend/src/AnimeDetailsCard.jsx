import "./mainStyle.css"

export default function AnimeDetailsCard({ animeTitle, synopsis, animeUrl, animeImg, status, releasedDate, genres, episodesList }){
    return (
        <div>
            <div className="animeDetailsCard">
                <div>Title: {animeTitle}</div>
                <div>Status: {status}</div>
                <div>
                    Synopsis:
                    <p>{synopsis}</p>
                </div>
                <div>Released Date: {releasedDate}</div>
                <div>
                    <img src={animeImg} alt="Not found" height={100} />
                </div>
                <button onClick={() => addAnimeToUser(animeId)}>Add me</button>
            </div>
        </div>
    )
}