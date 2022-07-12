import React, { useEffect, useState } from 'react';
import BookService from "../service/BookService";
//import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'

function BookList() {
    const [books, setBooks] = useState([]);        

    useEffect(() => {
        getBooks();                               // useEffect() is called everytime page is rendered. The second array is passed on for the states for  change 
      }, []);                                       //upon whom the page will be rendered & the func will be called. [] means it will listen for no state.

    const getBooks = async()=> {
        const result = await BookService.getBooks();
        console.log(result); 
        //console.log("testing");
        setBooks(result.data);
    }
    
    const removeBook =  (e, id)=> {
      e.preventDefault();
      console.log("delete pressed")
      BookService.deleteBook(id).then((res) => {
      if (books) {
        setBooks((prevElement) => {
          return prevElement.filter((book) => book.bookid !== id);  //remove the deleted course from current state
        });
      }
    });

    }

  const addBookToCart= (e, id)=>{
    console.log("book id"+ id);

    let cartbooks = [];

	 if(localStorage.getItem('books')){
		cartbooks = JSON.parse(localStorage.getItem('books'));
	 }
	
   cartbooks.push({'bookId' : id});

   localStorage.setItem('books', JSON.stringify(cartbooks));

   alert("Book added to cart")
  
  }

    return (
      
        <div className='container'>
        <div className='py-4'>
          <h2>Welcome to Booklist</h2>;
          
          
   <table className="table table-striped">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">BookName</th>
      <th scope="col">Author</th>
      <th scope="col">Price</th>
    </tr>
  </thead>
   <tbody>
     {books.map((book, index)=> (
        <tr key={book.bookid}>
          <td scope="row">{index+1}</td>
          <td>{book.title}</td>
          <td>{book.author}</td>
          <td>{book.price}</td>
          <td>
          <button  className="btn btn-info">Update </button>
          <button style={{marginLeft: "10px"}}  className="btn btn-danger" onClick={(e, cid) =>removeBook(e, book.bookid)}>Delete </button>
          {/* <button style={{marginLeft: "10px"}}  className="btn btn-success">View </button> */}
          <button style={{marginLeft: "10px"}} type="button" className="btn btn-primary btn-lg" onClick={(e, cid) =>addBookToCart(e, book.bookid)}><i className='fa fa-shopping-cart'></i></button>
          </td>
        </tr>
     ))}
   </tbody>
    </table>

        </div>
            <div>
            
            </div>
        </div>
        
        )
    
    
  }

  export default BookList;