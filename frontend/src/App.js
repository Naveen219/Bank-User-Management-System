import logo from './logo.svg';
import './App.css';
import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";
import Login from "./Components/Login";
import Menu from './Components/Menu';
import Register from './Components/Register';
import Loan from './Components/Loan';
import Header from './Components/Header';
import Transaction from './Components/Transaction';
import ViewTransactions from './Components/ViewTransactions';
import TransactionList from './Components/TransactionList';
function App() {
  return (
    <>
    <Router>
        <Routes>
          <Route exact path="/" element={<Login />}></Route>
          <Route path="/login" element={<Login />}></Route>
          <Route path='/register' element={<Register/>}></Route>
          <Route path='/menu' element={<Menu/>}></Route>
          <Route path='/loan' element={<Loan/>}></Route>
          <Route path='/transaction' element={<Transaction/>}></Route>
          <Route path='/viewTransaction' element={<ViewTransactions/>}></Route>
          <Route path='/transactionList' element={<TransactionList/>}></Route>
        </Routes>
      </Router>
    </>
  );
}

export default App;
