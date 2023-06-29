import React from "react";
import "./index.css";

export default function Meaning({
    partOfSpeech,
    definitions,
    synonyms,
    antonyms,
}) {
    return (
        <div className="meaning-container">
            <div className="meaning-partOfSpeech">
                <i>{partOfSpeech}</i>
                <div className="gray-line"></div>
            </div>
            <div className="meaning-definitions">
                <div className="meaning-tag">Meaning</div>
                <ul className="meaning-definition-list">
                    {definitions?.map((definition) => {
                        return (
                            <li className="meaning-definition-elem">
                                <p className="meaning-definition">
                                    {definition?.definition}
                                </p>
                                <div className="meaning-example">
                                    {definition?.example}
                                </div>
                            </li>
                        );
                    })}
                </ul>
            </div>
            <div className="meaning-synonyms">
                <span className="meaning-synonyms-tag">Synonyms</span>
                {synonyms?.map((word) => {
                    return <span className="synonym">{word}</span>;
                })}
            </div>
            <div className="meaning-antonyms">
                <span className="meaning-antonyms-tag">Antonyms</span>
                {antonyms?.map((word) => {
                    return <span className="antonyms">{word}</span>;
                })}
            </div>
        </div>
    );
}
