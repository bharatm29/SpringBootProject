import { useState } from "react";
import { Outlet, useNavigate } from "react-router-dom";
import "./index.css";
import { MagnifyingGlassIcon } from "@heroicons/react/20/solid";

export default function DictionarySearch() {
    const navigate = useNavigate();
    const [word, setWord] = useState("");

    const handleSubmit = (e) => {
        e.preventDefault();
        navigate(`search/${word}`);
    };

    return (
        <>
            <div className="search-form-contaier">
                <form className="search-form" onSubmit={handleSubmit}>
                    <div className="search-container">
                        <input
                            type="text"
                            name="word"
                            id="word"
                            className="search-field"
                            value={word}
                            onChange={(e) =>
                                setWord((prevWord) => {
                                    return e.target.value;
                                })
                            }
                            autoComplete="off"
                            spellCheck={false}
                        />
                        <button type="submit" className="submit-btn">
                            <MagnifyingGlassIcon
                                width={"1.5em"}
                                color="var(--dark-purple)"
                            />
                        </button>
                    </div>
                </form>
            </div>
            <div className="word-wrapper-container">
                <Outlet></Outlet>
            </div>
        </>
    );
}
