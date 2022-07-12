import logo from './logo.svg';
import './App.css';
import React from 'react';
import "bootstrap/dist/css/bootstrap.min.css";
import { BrowserRouter , Routes, Route} from "react-router-dom";
import { useState, useEffect } from "react";
import AuthService from "./service/auth-service";

import Navbar from "./components/layout/navbar"
import BookList from "./components/bookList";
import AddBook from "./components/addbook";
import Login from "./components/login";
import Cart from "./components/cart";

function App() {
  const [currentUser, setCurrentUser] = useState(undefined);

  useEffect(() => {
    const user = AuthService.getCurrentUser();

    if (user) {
      setCurrentUser(user);
    }

    console.log(currentUser);
  }, []);

  const logOut = () => {
    AuthService.logout();
  };

  if(!currentUser) {
    //return <Login setToken={setToken} />
    return <Login />
  }

  return (
    <BrowserRouter>
    <Navbar name={ currentUser.username}/>
      <div className="App">
      <Routes>
      <Route  path="/"  element={< BookList />} />
      <Route  path="/booklist" element={< BookList />} />
      <Route  path="/login" element={< Login />} />
      <Route  path="/addbook" element={< AddBook />} />
      <Route  path="/cart" element={< Cart name={ currentUser.username} />} />
      </Routes>
      </div>
    </BrowserRouter>
  );
}

export default App;
