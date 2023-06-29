import React, { useRef, useState } from "react";
import Meaning from "./Meaning";
import { PlayCircleIcon } from "@heroicons/react/20/solid";
import { ArrowTopRightOnSquareIcon } from "@heroicons/react/24/outline";
import "./index.css";
import WordMeaningNotFound from "./WordMeaningNotFound";

export default function WordMeaning({ word, phonetics, meanings, sourceUrls, searchedParam }) {
    if(word === "Not found"){
        return <WordMeaningNotFound word={searchedParam}/>
    }

    const [play, setPlay] = useState(false);
    const audioRef = useRef();

    const toggleAudio = () => {
        switch (play) {
            case true:
                audioRef.current?.pause();
                setPlay(false);
                break;
            case false:
                audioRef.current?.play();
                setPlay(true);
            default:
                break;
        }
    };

    const audioLink = phonetics?.filter((phonetic) => {
        return phonetic?.audio?.includes(`${word}-us.mp3`);
    });

    return (
        <div className="wordMeaning-container">
            <div className="wordMeaning-word-container">
                <div className="wordMeaning-word">{word}</div>
                <div className="wordMeaning-wordPronounce">
                    {audioLink[0]?.text}
                </div>
                <div className="wordMeaning-play-container">
                    <PlayCircleIcon onClick={toggleAudio} width={"3.5em"} color="var(--dark-purple)"/>
                    <audio src={audioLink[0]?.audio} ref={audioRef} />
                </div>
            </div>
            {meanings?.map((meaning) => {
                return (
                    <Meaning {...meaning}></Meaning>
                );
            })}
            <div className="source-gray-line"></div>
            <div className="wordMeaning-sourceUrl-container">
                {sourceUrls?.map((url) => {
                    return (
                        <div className="wordMeaning-sourceUrl">
                            <a
                                href={url}
                                target="_blank"
                                rel="noopener noreferrer"
                                className="source-link"
                            >
                                <div className="source-container">
                                    <div className="source-tag">Source</div>
                                    <div className="source-image">
                                        <ArrowTopRightOnSquareIcon
                                            color="var(--dark-purple)"
                                            className="source-icon"
                                        />
                                    </div>
                                </div>
                            </a>
                        </div>
                    );
                })}
            </div>
            <div className="source-gray-line"></div>
        </div>
    );
}
