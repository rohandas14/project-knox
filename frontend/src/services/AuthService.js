import axios from 'axios';

const API_URL = process.env.REACT_APP_IS_DEV==='true' ? 'http://localhost:8080/' :'';

class AuthService {

  login(username, password) {
    
    return axios
      .post(API_URL + 'authenticate', {
        username,
        password
      })
      .then(response => {
        if (response.data.token) {
          localStorage.setItem('user', JSON.stringify(response.data));
        }
        return response.data;
      })
  }

  logout() {
    localStorage.removeItem('user');
  }

  register(username, password) {
    return axios.post(API_URL + 'register', {
      username,
      password
    });
  }

  getCurrentUser() {
    return JSON.parse(localStorage.getItem('user'));
  }
}
export default new AuthService();