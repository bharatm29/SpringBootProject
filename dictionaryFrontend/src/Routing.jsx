import React from 'react'
import { Route, Routes } from "react-router-dom";
import DictionarySearch from './DictionarySearch';
import Word from './Word';

export default function Routing() {
  return (
    <Routes>
        <Route path='/' element={<DictionarySearch></DictionarySearch>}>
            <Route path="search/:word" element={<Word></Word>} />
        </Route>
    </Routes>
  )
}
