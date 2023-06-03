import AnimeDetailsCard from "./AnimeDetailsCard";
import "./mainStyle.css"

export default function Profile({ username, email, animes }){
    return (
        <>
            <span>
                Name <strong>{username}</strong> <br/>
                Email <strong>{email}</strong>
            </span>
            <div>
                {
                    animes.map(anime => {
                        return <AnimeDetailsCard {...anime}></AnimeDetailsCard>
                    })
                }
            </div>
        </>
    )
}