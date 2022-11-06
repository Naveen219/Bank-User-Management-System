import React from "react";
import { Container, Button } from "reactstrap";
import { useNavigate } from "react-router-dom";

const Menu = () => {
    
    const navigate=useNavigate();
    const handleLoan=()=>{
        navigate("/loan");
    }
  return (
    <Container className="p-5" style={{display:"flex",flexDirection:"column",alignItems:"center"}}>
      <Button color="warning" size="md" className="m-3" onClick={handleLoan}  style={{width:"500px"}}>
        <b>Apply for Loan</b>
      </Button>
      <Button color="warning" size="md" className="m-3" style={{width:"500px"}}>
        <b>Transactions</b>
      </Button>
      <Button color="warning" size="md" className="m-3" style={{width:"500px"}}>
        <b>View Statement</b>
      </Button>
    </Container>
  );
};

export default Menu;
