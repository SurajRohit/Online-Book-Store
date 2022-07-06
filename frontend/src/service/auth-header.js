export default function authHeader() {
    const user = JSON.parse(localStorage.getItem("user"));
  
    if (user && user.jwt) {
       return { 'Authorization': 'Bearer ' + user.jwt ,
                 'Content-Type': 'application/json',
                //  'Access-Control-Allow-Origin': "*",
                // 'Access-Control-Allow-Methods': "GET,PUT,POST,DELETE,PATCH,OPTIONS",
                };
      
    } else {
      return {};
    }
  }