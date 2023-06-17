import APIRouter from "./modules/APIRouter";
import Header from "./modules/Header";

export default function App() {
    return (
        <>
			<Header></Header>
            <APIRouter></APIRouter>
        </>
    );
}
