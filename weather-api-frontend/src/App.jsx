import APIRouter from "./modules/APIRouter";
import Header from "./modules/Header";
import Footer from "./modules/Footer";

export default function App() {
    return (
        <>
            <Header></Header>
            <APIRouter></APIRouter>
            <Footer></Footer>
        </>
    );
}
