export default function EpisodeButton({episodeNum, episodeUrl, episodeId}){
    return(
        <button key={episodeId} className="episodeBtn btns">
            <a href={episodeUrl} target="blank">{episodeNum}</a>
        </button>
    )
}