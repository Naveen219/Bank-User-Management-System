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
const ViewTransactions = () => {
  const navigate=useNavigate();
  const [account_number, setaccount_number] = useState("");
  const [transaction_type, settransaction_type] = useState("");
  const [isSubmit, setisSubmit] = useState(false);
  const [fromDate, setfromDate] = useState(
    new Date().toISOString().split("T")[0]
  );
  const [toDate, settoDate] = useState(new Date().toISOString().split("T")[0]);
  const [jsonData, setjsonData] = useState([]);
  const [loading, setloading] = useState(true);
  const [formErrors, setFormErrors] = useState({});
  const handleViewTransactions = (e) => {
    e.preventDefault();
    setFormErrors(validateForm({ transaction_type, fromDate, toDate }));
    setisSubmit(true);
  };
  const validateForm = (values) => {
    const ferror = {};
    if (values.transaction_type === "select") {
      ferror.transaction_type = "Transaction type required";
    }
    if (values.fromDate > values.toDate) {
      ferror.date = "From date cannot be greater than to Date";
    }
    return ferror;
  };
  useEffect(() => {
    axios
      .get("http://localhost:8080/api/customer/getAllAccounts", {
        params: { customer_number: localStorage.getItem("customer_number") },

        headers: {
          Authorization: "Bearer " + localStorage.getItem("token"),
        },
      })
      .then((res) => {
        // setreturned(res.data);
        console.log(res.data);
        setjsonData(res.data);
        setloading(false);
      });
    if (Object.keys(formErrors).length === 0 && isSubmit) {
      axios
        .get("http://localhost:8080/api/transaction/viewTransactions", {
          params: { account_number, fromDate, toDate ,transaction_type},

          headers: {
            Authorization: "Bearer " + localStorage.getItem("token"),
          },
        })
        .then((res) => {
          console.log(res.data);
          navigate("/transactionList",{state:res.data})

        });
    }
  }, [formErrors]);
  if (loading) return <h1>Loading...</h1>;
  return (
    <Container className="p-4">
      {console.log(new Date())}
      <h2 className="text-center py-3">Transaction Page</h2>
      <Form onSubmit={handleViewTransactions}>
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
          <Label for="account_number" sm={3} lg={2}>
            Select account
          </Label>
          <Col sm={9} lg={4}>
            <select
              id="account_number"
              onChange={(e) => setaccount_number(e.target.value)}
              style={{ width: "100%", padding: "7px", borderRadius: "5px" }}
            >
              <option value="select">select Account</option>
              {console.log(jsonData)}
              {jsonData.map((account_data) => (
                <option value={account_data.account_number}>
                  {account_data.account_number +
                    "     " +
                    account_data.account_type}
                </option>
              ))}
            </select>
          </Col>
          <Col lg={3}></Col>
        </FormGroup>
        <FormGroup row>
          <Col lg={3}></Col>
          <Label for="transaction_type" sm={3} lg={2}>
            Select Transaction
          </Label>

          <Col sm={9} lg={4}>
            <select
              id="transaction_type"
              onChange={(e) => settransaction_type(e.target.value)}
              style={{ width: "100%", padding: "7px", borderRadius: "5px" }}
            >
              <option value="select">select transaction type</option>
              <option value="withdraw">Withdraw</option>
              <option value="deposit">Deposit</option>
            </select>
            <p style={{ color: "red" }}>{formErrors.transaction_type}</p>
          </Col>
          <Col lg={3}></Col>
        </FormGroup>
        <FormGroup row>
          <Col lg={3}></Col>
          <Label for="from_date" sm={3} lg={2}>
            From Date
          </Label>

          <Col sm={9} lg={4}>
            <Input
              id="from_date"
              name="from_date"
              placeholder="Enter Date"
              onChange={(e) => setfromDate(e.target.value)}
              type="Date"
            />
            {/* <p style={{ color: "red" }}>{formErrors.transaction_amount}</p> */}
          </Col>
          <Col lg={3}></Col>
        </FormGroup>
        <FormGroup row>
          <Col lg={3}></Col>
          <Label for="to_date" sm={3} lg={2}>
            To Date
          </Label>

          <Col sm={9} lg={4}>
            <Input
              id="to_date"
              name="to_date"
              placeholder="Enter Date"
              onChange={(e) => settoDate(e.target.value)}
              type="Date"
            />
            <p style={{ color: "red" }}>{formErrors.date}</p>
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

export default ViewTransactions;
