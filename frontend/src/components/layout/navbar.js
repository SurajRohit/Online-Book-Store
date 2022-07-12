import React from 'react';
import { Link} from "react-router-dom";
import { useNavigate } from "react-router-dom";
import AuthService from "../../service/auth-service";

function Navbar(props) {

  const navigate = useNavigate();
  
  const logOut = () => {
    AuthService.logout();
    navigate("/login")
  };
    
  return (
        <nav className="navbar navbar-expand-lg navbar-dark bg-secondary ">
        <a className="navbar-brand" href="#">Welcome {props.name.toUpperCase()}</a>
        {/* <span>Navbar</span> */}
        <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
          <span className="navbar-toggler-icon" />
        </button>
        <div className="collapse navbar-collapse" id="navbarNavAltMarkup">
          <div className="navbar-nav">
            <Link className="nav-item nav-link active" to="/home">Home </Link>
            <Link className="nav-item nav-link active" to="/booklist">Booklist</Link>
            <Link className="nav-item nav-link active" to="/cart">My Cart</Link>
            {props.name=="admin"  &&
             <Link className="nav-item nav-link active" to="/addbook">New Book</Link>
            }
            {/* <Link className="nav-item nav-link active" to="/addbook">New Book</Link> */}
            <button type="button" className="btn btn-secondary btn-lg" onClick={logOut}>Log Out</button>
            
          </div>
        </div>
      </nav>
    )
    
  }

  export default Navbar;