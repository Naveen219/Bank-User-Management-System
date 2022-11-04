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

const Register = () => {
    const [userid, setuserid] = useState("");
    const [password, setpassword] = useState("");
    const [firstname, setfirstname] = useState("");
    const [lastname, setlastname] = useState("");
    const [city, setcity] = useState("");
    const [dob, setdob] = useState("");
  return (
    <Container className="p-4">
      <h2 className="text-center py-3">Register</h2>
      <Form>
        <FormGroup row>
          <Col lg={3}></Col>
          <Label for="userid" sm={3} lg={2}>
            User Id
          </Label>
          <Col sm={9} lg={4}>
            <Input
              id="userid"
              name="userid"
              placeholder="Enter your Customer id"
              value={userid}
              onChange={(e)=>{
                setuserid(e.target.value);
              }}
              type="text"
            />
          </Col>
          <Col lg={3}></Col>
        </FormGroup>
        <FormGroup row>
          <Col lg={3}></Col>
          <Label for="firstname" sm={3} lg={2}>
            First Name
          </Label>

          <Col sm={9} lg={4}>
            <Input
              id="firstname"
              name="firstname"
              placeholder="First Name"
              value={firstname}
              onChange={(e)=>{
                setfirstname(e.target.value);
              }}
              type="text"
            />
          </Col>
          <Col lg={3}></Col>
        </FormGroup>
        <FormGroup row>
          <Col lg={3}></Col>
          <Label for="lastname" sm={3} lg={2}>
            Last Name
          </Label>

          <Col sm={9} lg={4}>
            <Input
              id="lastname"
              name="lastname"
              placeholder="Last Name"
              value={lastname}
              onChange={(e)=>{
                setlastname(e.target.value);
              }}
              type="text"
            />
          </Col>
          <Col lg={3}></Col>
        </FormGroup>
        <FormGroup row>
          <Col lg={3}></Col>
          <Label for="city" sm={3} lg={2}>
            City
          </Label>

          <Col sm={9} lg={4}>
            <Input
              id="city"
              name="city"
              placeholder="Enter your city"
              value={city}
              onChange={(e)=>{
                setcity(e.target.value);
              }}
              type="text"
            />
          </Col>
          <Col lg={3}></Col>
        </FormGroup>
        <FormGroup row>
          <Col lg={3}></Col>
          <Label for="dob" sm={3} lg={2}>
            Date Of Birth
          </Label>

          <Col sm={9} lg={4}>
            <Input
              id="dob"
              name="dob"
              placeholder="Enter date of birth"
              value={dob}
              onChange={(e)=>{
                setdob(e.target.value);
              }}
              type="text"
            />
          </Col>
          <Col lg={3}></Col>
        </FormGroup>
        <FormGroup row>
          <Col lg={3}></Col>
          <Label for="password" sm={3} lg={2}>
           Set Password
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
}

export default Register
