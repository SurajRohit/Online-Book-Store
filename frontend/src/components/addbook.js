import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import BookService from "../service/BookService";


function AddBook() {
    
    const [book, setBook] = useState({
        title: "",
        author: "",
        price: "",
        
      });

    const navigate = useNavigate();

    const handleUpdate = (e) => {
        const value = e.target.value;
        setBook({ ...book, [e.target.name]: value });
    };

    const addNewBook = async(e) => {
        e.preventDefault();   //prevents refreshing

        await BookService.saveBook(book);

        console.log(book);

        navigate("/booklist")
    }
 
    

    return (
    <div>
      <br></br>
      <div className = "row">
            <div className = "card col-md-6 offset-md-3 offset-md-3">
                Add Book
                
                    <div className = "card-body">
                        <form>
                            <div className = "form-group">
                                <label> Book Name: </label>
                                <input placeholder="title" name="title" value={book.title} onChange={(e) => handleUpdate(e)} className="form-control" />
                            </div>
                            <div className = "form-group">
                                <label> Author: </label>
                                <input placeholder="author" name="author" value={book.author} onChange={(e) => handleUpdate(e)} className="form-control" />
                            </div>
                            <div className = "form-group">
                                <label> Price: </label>
                                <input placeholder="price" name="price" value={book.price} onChange={(e) => handleUpdate(e)} className="form-control" />
                            </div>

                            <button className="btn btn-success" onClick={addNewBook} >Save</button>
                            <button className="btn btn-danger"  style={{marginLeft: "10px"}}>Cancel</button>
                        </form>
                    </div>
                </div>
            </div>

    </div>
    )
    
  }

  export default AddBook;