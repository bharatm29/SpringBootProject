import { useState } from "react";
import AuthenticationForm from "./AuthenticationForm";
import Profile from "./Profile";
import SearchAnime from "./SearchAnime";
import HomeDisplay from "./HomeDisplay";
import Register from "./Register";
import "./mainStyle.css"


export default function App() {
  const PAGE = {
    home: "HOME",
    search: "SEARCH",
    profile: "PROFILE",
    auth: "AUTH",
    register: "register"
  }

  const [showPage, setShowPage] = useState(PAGE.home);
  const [userProfile, setUserProfile] = useState(null);
  const [isAuthenticated, setAuthenticated] = useState(false);

  const cookie = getCookie("loggedIn");
  if(!isAuthenticated && cookie.startsWith("TRUE")){
    let email = cookie.substring(6, cookie.length);
    fetchUserDetails(email)
    return;
  }

  const handlePageChanging = (page) => {
    if((page === PAGE.home) || (!isAuthenticated && page === PAGE.register)){
      setShowPage(page);
      return;
    }

    else if(!isAuthenticated){
      setShowPage(PAGE.auth);
      return;
    }

    else if((isAuthenticated && page === PAGE.auth) || (isAuthenticated && page === PAGE.register)){
      setShowPage(PAGE.home);
      return;
    }

    setShowPage(page);
  }

  async function fetchUserDetails(email){
    setAuthenticated(true);
    setShowPage(PAGE.home)

    createCookie("loggedIn", `TRUE, ${email}`, 10);

    const jwt = "eyJhbGciOiJIUzI1NiJ9.eyJwYXNzd29yZCI6InRlc3QiLCJzdWIiOiJ0ZXN0QGdtYWlsLmNvbSIsImlhdCI6MTY4NTY5OTEzNn0.vEPRZgBURHBETEPovWsRMSqBKRS4zMNIFcVrJphkmkY";
    let bufferUserProfile = {
      email: "",
      username: "",
      animes: []
    };
    await fetch(`http://localhost:4001/user/${email}`, 
    {
      method: "GET",
    }).then(res => res.json()).then(data => bufferUserProfile = data);

    await fetch(`http://localhost:4000/anime/user/${email}`, 
    {
      method: "GET",
      headers:{
        "Authorization": `Bearer ${jwt}`
      }
    }).then(res => res.json()).then(data => {
      setUserProfile(
        {username: bufferUserProfile.username, email: bufferUserProfile.email, animes: data.animes}
      )
    })
  }

  function createCookie(name, value, days) {
      var expires;
      if (days) {
          var date = new Date();
          date.setTime(date.getTime() + (days * 24 * 60 * 60 * 1000));
          expires = "; expires=" + date.toGMTString();
      }
      else {
          expires = "";
      }
      document.cookie = name + "=" + value + expires + "; path=/";
  }

  function getCookie(c_name) {
      if (document.cookie.length > 0) {
          let c_start = document.cookie.indexOf(c_name + "=");
          if (c_start != -1) {
              c_start = c_start + c_name.length + 1;
              let c_end = document.cookie.indexOf(";", c_start);
              if (c_end == -1) {
                  c_end = document.cookie.length;
              }
              return document.cookie.substring(c_start, c_end);
          }
      }
      return "";
  }

  return (
    <>
      <header className="mainHeader header">
        <div className="headerBox">
          <span className="appNameTag">App name</span>
          <span className="span listSpan">
            <ul className="navList">
              <li className="navListElem" onClick={() => handlePageChanging(PAGE.home)}>Home</li>
              <li className="navListElem" onClick={() => handlePageChanging(PAGE.search)}>Search</li>
              <li className="navListElem" onClick={() => handlePageChanging(PAGE.profile)}>Profile</li>
            </ul>
          </span>
          <span className="headerBtnSpan">
            <button className="dropShadowBtns btns" id="registerBtn" onClick={() => handlePageChanging(PAGE.register)}>Register</button>
            <button className="dropShadowBtns btns" onClick={() => handlePageChanging(PAGE.auth)}>Log in</button>
          </span>
        </div>
      </header>

      {showPage === PAGE.register && <Register fetchUserDetails={fetchUserDetails}></Register>}

      {(showPage === PAGE.home) && <HomeDisplay></HomeDisplay>}

      {(showPage === PAGE.search) && <SearchAnime {...userProfile} ></SearchAnime>}

      {(showPage === PAGE.profile) && <Profile {...userProfile}></Profile>}

      {(showPage === PAGE.auth) && <AuthenticationForm fetchUserDetails={fetchUserDetails}></AuthenticationForm>}
    </>
  )
}