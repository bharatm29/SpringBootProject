import EpisodeButton from "./EpisodeButton";
import "./mainStyle.css"

export default function AnimeDetailsCard({ animeTitle, synopsis, animeUrl, animeImg, status, releasedDate, genres, episodesList }){
    return (
        <div>
            <div className="animeDetailsCard">
                <button className="removeBtn btns" onClick={e => {
                    const modal = document.querySelector("[data-modal]");
                    modal.showModal();
                }}>Remove</button>

                <dialog className="removeDialog" data-modal>
                    <div className="removeMsg tag">Remove is not yet implemented!</div>
                    <div className="closeBtnContainer">
                        <button className="closeBtn btns" onClick={e => {
                            const modal = document.querySelector("[data-modal]");
                            modal.close();
                            }}>Close</button>
                    </div>
                </dialog>

                <div className="animeDetailsTag tag popUpElem">{animeTitle}</div>
                <div className="animeDetailsTag statusTag tag popUpElem">Status: {status}</div>
                <div className="synopsisTag popUpElem">
                    <p><i className="tag">{synopsis}</i></p>
                </div>
                <div className="animeDetailsTag tag releasedDateTag popUpElem">Released: {releasedDate}</div>
                <div className="genreContainer popUpElem">
                    {
                        genres.map(genre => {
                            return <div className="genreTag tag ">{genre}</div>
                        })
                    }
                </div>
                <div>
                    <img className="genImg animeImg popUpShadowElem" src={animeImg} alt="Not found"/>
                </div>
                <div className="episodesContainer popUpElem">
                    <div className="tag episodeTag">Episodes</div>
                    {
                        episodesList.map(episode => {
                            return <EpisodeButton {...episode} ></EpisodeButton>
                        })
                    }
                </div>
            </div>
        </div>
    )
}