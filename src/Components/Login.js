import React,{useState,useEffect} from 'react'
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
} from "reactstrap";

const Login = () => {
    
  const navigate = useNavigate();
  const [formErrors, setFormErrors] = useState({});
  const [isSubmit, setIsSubmit] = useState(false);
  
  const [password, setpassword] = useState("");
  const [customer_number, setcustomer_number] = useState("");

  
  const validateForm = (values) => {
    const error = {};
    if (!values.customer_number) {
      error.userid = "Email is required";
    } 
    if (!values.password) {
      error.password = "Password is required";
    }
    return error;
  };

  const loginHandler = (e) => {
    e.preventDefault();
    setFormErrors(validateForm({customer_number,password}));
    setIsSubmit(true);
  };

  useEffect(() => {
    if (Object.keys(formErrors).length === 0 && isSubmit) {
      axios
        .post("http://localhost:8080/customer/login",{customer_number,password})
        .then((res) => {
          console.log(res.data);
          
          if (res.data) {
            localStorage.setItem("customer_number",customer_number);
            navigate("/menu", { replace: true });
          } else {
            navigate("/register",{replace:true});
          }
        });
    }
  }, [formErrors]);
  return (
    <Container className="p-4">
      <h2 className="text-center py-3">Login</h2>
      <Form onSubmit={loginHandler}>
        <FormGroup row>
          <Col lg={3}></Col>
          <Label for="customer_number" sm={3} lg={2}>
            User Id
          </Label>
          <Col sm={9} lg={4}>
            <Input
              id="customer_number"
              name="customer_number"
              placeholder="Enter your User id"
              value={customer_number}
              onChange={(e)=>{
                setcustomer_number(e.target.value);
              }}
              type="text"
            />
            <p style={{ color: "red" }}>{formErrors.userid}</p>
          </Col>
          <Col lg={3}></Col>
        </FormGroup>

        <FormGroup row>
          <Col lg={3}></Col>
          <Label for="password" sm={3} lg={2}>
            Password
          </Label>

          <Col sm={9} lg={4}>
            <Input
              id="password"
              name="password"
              placeholder="Enter Password"
              value={password}
              onChange={(e)=>{
                setpassword(e.target.value);

              }}
              type="password"
            />
            <p style={{ color: "red" }}>{formErrors.password}</p>
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
  )
};

export default Login;
