import React, { useEffect, useState } from 'react';
import BookService from "../service/BookService";


function Cart(props) {
    const [books, setBooks] = useState([]);        

    useEffect(() => {
        getBooks();                                
      }, []);                                     

    const getBooks = async()=> {
        let ids=""; let cart_books = [];
         cart_books = JSON.parse(localStorage.getItem('books'));

         //console.log(cart_books);
         

         for (var i = 0; i < cart_books.length; i++){
            console.log(cart_books[i]);
            ids+=cart_books[i].bookId+","
        }

        

        // console.log(ids);

        const result = await BookService.getBooksForCart(ids);
        console.log(result); 
        //console.log("testing");
        setBooks(result.data);
    }
    
    const removeFromCart =  (e, id)=> {
      e.preventDefault();
      
      
	let storageProducts = JSON.parse(localStorage.getItem('books'));
  let products = storageProducts.filter(product => product.bookId !== id );
  localStorage.setItem('books', JSON.stringify(products));

  alert("removed from cart")

    }


    if(books.length==0){
      return(
        <div>
          <h1>No Books Found</h1>
        </div>
      )
    }
  

    return (
      
        <div className='container'>
        <div className='py-4'>
          <h2> {props.name}'s cart</h2>;
          {/* <button className='btn btn-success'><i className='fa fa-home'></i></button> */}
          {/* <button type="button" className="btn btn-primary btn-lg"><i className='fa fa-shopping-cart'></i></button> */}
          
   <table className="table">
  <thead className="thead-dark">
    <tr>
      {/* <th scope="col">#</th> */}
      <th scope="col">BookName</th>
      <th scope="col">Author</th>
      <th scope="col">Price</th>
    </tr>
  </thead>
   <tbody>
     {books.map((book, index)=> (
        <tr key={book.bookid}>
          {/* <td scope="row">{index+1}</td> */}
          <td>{book.title}</td>
          <td>{book.author}</td>
          <td>{book.price}</td>
          <td>
          
          {/* <button style={{marginLeft: "10px"}}  className="btn btn-danger" onClick={(e, cid) =>removeFromCart(e, book.bookid)}>Delete </button> */}
          <button style={{marginLeft: "10px"}} type="button" className="btn btn-primary btn-lg" onClick={(e, cid) =>removeFromCart(e, book.bookid)}><i className='fa fa-trash'></i></button>
          
          </td>
        </tr>
     ))}
   </tbody>
    </table>
    <br></br>
<h3>Proceed to Payment
<button style={{marginLeft: "10px"}} type="button" className="btn btn-primary btn-lg" ><i className='fa fa-credit-card-alt'></i></button>
</h3>
        </div>
            <div>
            
            </div>
        </div>
        
        )
    
    
  }

  export default Cart;