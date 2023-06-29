import { useQuery } from "@tanstack/react-query";
import React from "react";
import { useParams } from "react-router-dom";
import WordMeaning from "./WordMeaning";
import "./index.css";

export default function Word() {
    const params = useParams();

    const word = params.word;

    const getWordMeaning = async () => {
        const res = await fetch(
            `http://192.168.0.102:4000/api/wordmeaning/${word}`, {
                method: "GET"
            }
        );

        return res.json();
    };

    const meaningResponse = useQuery({
        queryKey: [word],
        queryFn: getWordMeaning,
        cacheTime: 1000 * 60 * 60,
        staleTime: 1000 * 1000 * 1000,
    });

    return (
        <>
            <div className="word-container">
                {meaningResponse?.data?.wordMeanings?.map((wordMeaning) => {
                    return <WordMeaning searchedParam={word} {...wordMeaning}></WordMeaning>;
                })}
            </div>
        </>
    );
}
