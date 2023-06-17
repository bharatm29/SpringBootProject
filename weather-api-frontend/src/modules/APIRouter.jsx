import React from 'react'
import { Route, Routes } from 'react-router-dom'
import Home from './Home'
import Forecast from './Forecast'

export default function APIRouter() {
  return (
    <Routes>
        <Route path='/' element={<Home></Home>}></Route>
        <Route path='/forecast' element={<Forecast></Forecast>}></Route>
    </Routes>
)
}
