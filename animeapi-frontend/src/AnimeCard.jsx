import "./mainStyle.css"

export default function AnimeCard({ animeId, animeTitle, animeUrl, animeImg, status, addAnimeToUser }){
    return (
        <div className="animeCardContainer">
            <div className="titleTag animeTag popUpElem">
                <a href={animeUrl} target="_blank">{animeTitle}</a>
            </div>
            <div className="statusTag animeTag popUpElem">{status}</div>
            <div>
                <img className="genImg animeImg popUpShadowElem" src={animeImg} alt="Not found" height={100} />
            </div>
            <div className="addBtnContainer">
                <dialog id="addDialogBox">
                    <div className="addMsg">Added!</div>
                    <div className="closeBtnContainer addCloseBtn">
                        <button className="closeBtn btns" onClick={e => {
                            document.querySelector("#addDialogBox").close();
                        }}>close</button>
                    </div>
                </dialog>
                <button className="addBtn btns" onClick={() => addAnimeToUser(animeId)}>Add</button>
            </div>
        </div>
    )
}