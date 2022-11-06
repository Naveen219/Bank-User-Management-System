import React from "react";
import { Container, Button } from "reactstrap";
import { useNavigate,useLocation } from "react-router-dom";

const Menu = () => {
  const navigate = useNavigate();
  const handleLoan = () => {
    navigate("/loan");
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
        style={{ width: "500px" }}
      >
        <b>Transactions</b>
      </Button>
      <Button
        color="warning"
        size="md"
        className="m-3"
        style={{ width: "500px" }}
      >
        <b>View Statement</b>
      </Button>
    </Container>
  );
};

export default Menu;
