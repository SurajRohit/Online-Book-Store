import React from 'react';
import { Link} from "react-router-dom";

function Navbar(props) {
    return (
        <nav className="navbar navbar-expand-lg navbar-dark bg-secondary ">
        <a className="navbar-brand" href="#">Welcome {props.name}</a>
        {/* <span>Navbar</span> */}
        <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
          <span className="navbar-toggler-icon" />
        </button>
        <div className="collapse navbar-collapse" id="navbarNavAltMarkup">
          <div className="navbar-nav">
            <Link className="nav-item nav-link active" to="/home">Home </Link>
            <Link className="nav-item nav-link active" to="/booklist">Booklist</Link>
            {props.name=="admin"  &&
             <Link className="nav-item nav-link active" to="/addbook">New Book</Link>
            }
            {/* <Link className="nav-item nav-link active" to="/addbook">New Book</Link> */}
            
          </div>
        </div>
      </nav>
    )
    
  }

  export default Navbar;