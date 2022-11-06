import React, { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";
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

const Loan = () => {
  const [branch_name, setbranch_name] = useState("");
  const [loan_amount, setloan_amount] = useState(0);
  const [formErrors, setFormErrors] = useState({});

  const handleLoanSubmit = (e) => {
    e.preventDefault();
    setFormErrors(validateForm({ loan_amount, branch_name }));
    console.log(branch_name + " " + loan_amount);
  };
  const validateForm = (values) => {
    const error = {};
    if (!values.loan_amount) {
      error.loan_amount = "loan amount is required";
    }
    else if(values.loan_amount>100000){
      error.loan_amount="amount should be less than 100000";
    }
    else if(values.loan_amount<0){
      error.loan_amount="Loan amount should be positive";
    }
    if (!values.branch_name) {
      error.password = "Branch Name is required";
    }
    return error;
  };
  return (
    <Container className="p-4">
      <h2 className="text-center py-3">Apply for Loan</h2>
      <Form onSubmit={handleLoanSubmit}>
        <FormGroup row>
          <Col lg={3}></Col>
          <Label for="customer_number" sm={3} lg={2}>
            Customer Id
          </Label>
          <Col sm={9} lg={4}>
            <Input
              id="customer_number"
              name="customer_number"
              placeholder="Enter your User id"
              value={localStorage.getItem("customer_number")}
              disabled
              type="text"
            />
            
          </Col>
          <Col lg={3}></Col>
        </FormGroup>
        <FormGroup row>
          <Col lg={3}></Col>
          <Label for="branch_name" sm={3} lg={2}>
            Select Branch
          </Label>

          <Col sm={9} lg={4}>
            <select
              id="branch_name"
              onChange={(e) => setbranch_name(e.target.value)}
              style={{ width: "100%", padding: "7px", borderRadius: "5px" }}
            >
              <option value="select branch">select branch</option>
              {JSON.parse(localStorage.getItem("branch_names")).map(
                (branch_name) => (
                  <option value={branch_name.branch_id}>
                    {branch_name.branch_name}
                  </option>
                )
              )}
            </select>
            <p style={{ color: "red" }}>{formErrors.branch_name}</p>
          </Col>
          <Col lg={3}></Col>
        </FormGroup>
        <FormGroup row>
          <Col lg={3}></Col>
          <Label for="loan_amount" sm={3} lg={2}>
            Loan Amount
          </Label>

          <Col sm={9} lg={4}>
            <Input
              id="loan_amount"
              name="loan_amount"
              placeholder="Enter Loan Amount"
              type="text"
              onChange={(e) => {
                setloan_amount(e.target.value);
              }}
            />
            <p style={{ color: "red" }}>{formErrors.loan_amount}</p>
          </Col>
          <Col lg={3}></Col>
        </FormGroup>
        <FormGroup check row>
          <Col className="d-flex justify-content-center">
            <Button>Submit</Button>
          </Col>
        </FormGroup>
      </Form>
    </Container>
  );
};

export default Loan;
