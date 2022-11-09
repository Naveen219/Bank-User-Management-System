import React from "react";
import { Container, Button } from "reactstrap";
import { useNavigate,useLocation } from "react-router-dom";
import axios from "axios";

const Menu = () => {
  const navigate = useNavigate();
  const handleLoan = (e) => {
    e.preventDefault();
    axios
    .get("http://localhost:8080/api/customer/accountExist",{
             params: { customer_number: localStorage.getItem("customer_number") },headers: {
              'Authorization': "Bearer " + localStorage.getItem("token")
            }
           })
    .then((res)=>{
      if(res.data){
        
        navigate("/loan");
      }
      else{
        alert("Account not exist");
      }
    })
  
  };
  const handleTransaction = (e) => {
    e.preventDefault();
    axios
    .get("http://localhost:8080/api/customer/accountExist",{
             params: { customer_number: localStorage.getItem("customer_number") },headers: {
              'Authorization': "Bearer " + localStorage.getItem("token")
            }
           })
    .then((res)=>{
      if(res.data){
        
        navigate("/transaction");
      }
      else{
        alert("Account not exist");
      }
    })
  
  };
  const handleViewTransaction= (e) => {
    e.preventDefault();
    axios
    .get("http://localhost:8080/api/customer/accountExist",{
             params: { customer_number: localStorage.getItem("customer_number") },headers: {
              'Authorization': "Bearer " + localStorage.getItem("token")
            }
           })
    .then((res)=>{
      if(res.data){
        console.log(res.data);
        navigate("/viewTransaction");
      }
      else{
        alert("Account not exist");
      }
    })
  
  };
  
  const { state } = useLocation();
  const branch_names = state;
  return (
    
    <Container
      className="p-5"
      style={{ display: "flex", flexDirection: "column", alignItems: "center" }}
    >
      {/* {console.log(JSON.parse(localStorage.getItem("branch_names")))} */}
      <Button
        color="warning"
        size="md"
        className="m-3"
        onClick={handleLoan}
        style={{ width: "500px" }}
      >
        <b>Apply for Loan</b>
      </Button>
      <Button
        color="warning"
        size="md"
        className="m-3"
        onClick={handleTransaction}
        style={{ width: "500px" }}
      >
        <b>Transactions</b>
      </Button>
      <Button
        color="warning"
        size="md"
        className="m-3"
        onClick={handleViewTransaction}
        style={{ width: "500px" }}
      >
        <b>View Statement</b>
      </Button>
    </Container>
  );
};

export default Menu;
