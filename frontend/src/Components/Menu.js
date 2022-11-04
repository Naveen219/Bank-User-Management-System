import React from "react";
import { Container, Button } from "reactstrap";

const Menu = () => {
  return (
    <Container>
      <Button color="primary" size="md" className="m-5">
        Apply for Loan
      </Button>
      <Button color="secondary" size="md" className="m-5">
        Transactions
      </Button>
      <Button color="warning" size="md" className="m-5">
        View Statement
      </Button>
    </Container>
  );
};

export default Menu;
