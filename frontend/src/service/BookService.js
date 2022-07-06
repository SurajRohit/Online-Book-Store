import axios from "axios";
import authHeader from "./auth-header";
const BOOK_API_BASE_URL = "http://localhost:4000/api";

class BookService {
  saveBook(course) {
    return axios.post(BOOK_API_BASE_URL+ "/addcourse", course);
  }

  getBooks() {
    return axios.get(BOOK_API_BASE_URL + "/books", { headers: authHeader() } );
  }

  deleteBook(id) {
    return axios.delete(BOOK_API_BASE_URL + "/delbook/" + id, { headers: authHeader() });
  }
}

export default new BookService();