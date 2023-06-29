import "./index.css";
export default function WordMeaningNotFound({ word }) {
    return (
        <div className="wordMeaning-container">
            <div className="wordMeaning-word-container">
                <div className="wordMeaning-word">{word} not found</div>
            </div>
        </div>
    );
}
