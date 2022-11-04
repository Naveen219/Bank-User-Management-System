import logo from './logo.svg';
import './App.css';
import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";
import Login from "./Components/Login";
import Menu from './Components/Menu';
import Register from './Components/Register';
function App() {
  return (
    <>
    <Router>
        
        <Routes>
          <Route path="/login" element={<Login />}></Route>
          <Route path='/register' element={<Register/>}></Route>
          <Route path='/menu' element={<Menu/>}></Route>
        </Routes>
      </Router>
    </>
  );
}

export default App;
