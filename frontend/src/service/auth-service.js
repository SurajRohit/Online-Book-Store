import axios from "axios";

//const API_URL = "/auth";
const API_URL = "http://localhost:4000/auth"

// const signup = (email, password) => {
//   return axios
//     .post(API_URL + "/signup", {
//       email,
//       password,
//     })
//     .then((response) => {
//       if (response.data.accessToken) {
//         localStorage.setItem("user", JSON.stringify(response.data));
//       }

//       return response.data;
//     });
// };

const login = (username, password) => {
  return axios.post(API_URL + "/login", {
      username,
      password,
    })
    .then((response) => {
      if (response.data.jwt) {
        console.log(response);
        localStorage.setItem("user", JSON.stringify(response.data));
      }

      return response.data;
    });
};

const logout = () => {
  localStorage.removeItem("user");
  console.log("logged out!")
};

const getCurrentUser = () => {
  return JSON.parse(localStorage.getItem("user"));
};

const AuthService = {
 // signup,
  login,
  logout,
  getCurrentUser,
};

export default AuthService;