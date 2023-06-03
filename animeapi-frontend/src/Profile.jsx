import AnimeDetailsCard from "./AnimeDetailsCard";
import "./mainStyle.css"

export default function Profile({ username, email, animes }){
    return (
        <>
            <div className="profileInfoContainer">
                <div className="nameInfoTag tag">{username}'s inventory</div>
                {/* <div className="emailInfo tag">{email}</div> */}
            </div>

            <div className="profileAnimes">
                {
                    animes.map(anime => {
                        return <AnimeDetailsCard {...anime}></AnimeDetailsCard>
                    })
                }
            </div>
        </>
    )
}