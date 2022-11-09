import React from "react";
import { useLocation } from "react-router-dom";
import {
    Container,
    Form,
    FormGroup,
    Input,
    Label,
    Col,
    FormText,
    Button,
    Dropdown,
    DropdownToggle,
    DropdownMenu,
    DropdownItem,
  } from "reactstrap";
import Menu from "./Menu";
const TransactionList = () => {
  const location = useLocation();
  if(!location.state) return <Menu/>
//   if(location.state.length===0) return <></>
//   console.log(location.state.length)
  return (
    <Container>
        <h2 className="text-center">Transactions</h2>
      <ul className="m-5">
      {location.state.map((transaction) => (
        <li style={{"listStyleType":"none" ,"border":"2px solid"}} key={transaction.transaction_number} className="m-4 p-3"> 

          <p><b>Transaction Number</b> : {transaction.transaction_number}</p>
          
          <p>Transaction Amount :{transaction.transaction_amount}</p>
          <p>Date of Transaction :{(transaction.date_of_transaction).split("T")[0]}</p>
        </li>
        
      ))}
      
    </ul>
    </Container>
  );
};

export default TransactionList;
