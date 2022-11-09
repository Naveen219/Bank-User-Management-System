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
} from "reactstrap";

const Register = () => {
  const navigate = useNavigate();
  const [formerrors, setformerrors] = useState({});
  // const [userid, setuserid] = useState("");
  // const [password, setpassword] = useState("");
  // const [firstname, setfirstname] = useState("");
  // const [lastname, setlastname] = useState("");
  // const [customer_city, setcustomer_city] = useState("");
  const [customer_date_of_birth, setcustomer_date_of_birth] = useState("");
  const [isSubmit, setisSubmit] = useState(false);

  const [user, setuserDetails] = useState({
    customer_number: "",
    password: "",
    firstname: "",
    middlename: "",
    lastname: "",
    customer_city: "",
    customer_contact_no: "",
    occupation: "",
  });
  const handleSubmit = (e) => {
    e.preventDefault();
    setformerrors(validate(user));
    setisSubmit(true);
  };
  const changeHandler = (e) => {
    const { name, value } = e.target;
    setuserDetails({
      ...user,
      [name]: value,
    });
    setuserDetails((user) => ({
      ...user,
      customer_date_of_birth,
    }));

    console.log(user);
  };

  // const registerApiCall = async (user) => {
  //   try {
  //     axios
  //       .post("http://localhost:8080/customer/register", user)
  //       .then((res) => {
  //         if(res.data){
  //           console.log(res.data);
  //           navigate("/login", { replace: true });

  //         }
  //         else{
  //           alert("User already registered Please login");
  //         }

  //       });
  //   } catch (err) {}
  // };

  // useEffect(() => {
  //   // console.log(user);
  //   if (Object.keys(formerrors).length === 0 && isSubmit) {
  //     axios
  //       .get("http://localhost:8080/customer/accountExist", {
  //         params: { customer_number: user.customer_number },
  //       })
  //       .then((res) => {
  //         console.log(res.data);

  //         if (res.data) {
  //           registerApiCall(user);

  //         } else {
  //           alert("Account Not Exist");
  //         }
  //       });
  //   }
  // }, [formerrors]);
  useEffect(() => {
    if (Object.keys(formerrors).length === 0 && isSubmit) {
      axios
        .post("http://localhost:8080/api/customer/register",user)
        .then((res) => {
          console.log(res.data);
          if (res.data) {
            navigate("/login", { replace: true });
          } else {
            setisSubmit(false)
            alert("User already registered Please login");
          }
        });
    }
  }, [formerrors]);
  const validate = (user) => {
    const errors = {};
    if (!user.customer_number) {
      errors.customer_number = "User id is required";
    }
    if (!user.password) {
      errors.password = "Password is required";
    }
    if (!user.firstname) {
      errors.firstname = "First name is required";
    }
    // if (!user.middlename) {
    //   errors.middlename = "Middle name is required";
    // }
    if (!user.lastname) {
      errors.lastname = "Last name is required";
    }
    if (!user.customer_city) {
      errors.customer_city = "customer_city is required";
    }
    if (!user.customer_contact_no) {
      errors.customer_contact_no = "Contact number is required";
    }
    if (!user.occupation) {
      errors.occupation = "occupation is required";
    }
    if (!customer_date_of_birth) {
      errors.customer_date_of_birth = "Date of Birth is required";
    }
    return errors;
  };
  return (
    <Container className="p-4">
      <h2 className="text-center py-3">Register</h2>
      <Form onSubmit={handleSubmit}>
        <FormGroup row>
          <Col lg={3}></Col>
          <Label for="customer_number" sm={3} lg={2}>
            User Id
          </Label>
          <Col sm={9} lg={4}>
            <Input
              id="customer_number"
              name="customer_number"
              placeholder="Enter your Customer id"
              value={user.customer_number}
              onChange={changeHandler}
              type="text"
            />
            <p style={{ color: "red" }}>{formerrors.customer_number}</p>
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
              value={user.firstname}
              onChange={changeHandler}
              type="text"
            />
            <p style={{ color: "red" }}>{formerrors.firstname}</p>
          </Col>
          <Col lg={3}></Col>
        </FormGroup>
        <FormGroup row>
          <Col lg={3}></Col>
          <Label for="middlename" sm={3} lg={2}>
            Middle Name
          </Label>

          <Col sm={9} lg={4}>
            <Input
              id="middlename"
              name="middlename"
              placeholder="Middle Name"
              value={user.middlename}
              onChange={changeHandler}
              type="text"
            />
            <p style={{ color: "red" }}>{formerrors.middlename}</p>
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
              value={user.lastname}
              onChange={changeHandler}
              type="text"
            />
            <p style={{ color: "red" }}>{formerrors.lastname}</p>
          </Col>
          <Col lg={3}></Col>
        </FormGroup>
        <FormGroup row>
          <Col lg={3}></Col>
          <Label for="customer_city" sm={3} lg={2}>
            customer_city
          </Label>

          <Col sm={9} lg={4}>
            <Input
              id="customer_city"
              name="customer_city"
              placeholder="Enter your customer_city"
              value={user.customer_city}
              onChange={changeHandler}
              type="text"
            />
            <p style={{ color: "red" }}>{formerrors.customer_city}</p>
          </Col>
          <Col lg={3}></Col>
        </FormGroup>
        <FormGroup row>
          <Col lg={3}></Col>
          <Label for="customer_contact_no" sm={3} lg={2}>
            contact number
          </Label>

          <Col sm={9} lg={4}>
            <Input
              id="customer_contact_no"
              name="customer_contact_no"
              placeholder="Enter your Contact number"
              value={user.customer_contact_no}
              onChange={changeHandler}
              type="tel"
            />
            <p style={{ color: "red" }}>{formerrors.customer_contact_no}</p>
          </Col>
          <Col lg={3}></Col>
        </FormGroup>
        <FormGroup row>
          <Col lg={3}></Col>
          <Label for="occupation" sm={3} lg={2}>
            occupation
          </Label>

          <Col sm={9} lg={4}>
            <Input
              id="occupation"
              name="occupation"
              placeholder=""
              value={user.occupation}
              onChange={changeHandler}
              type="text"
            />
            <p style={{ color: "red" }}>{formerrors.occupation}</p>
          </Col>
          <Col lg={3}></Col>
        </FormGroup>
        <FormGroup row>
          <Col lg={3}></Col>
          <Label for="customer_date_of_birth" sm={3} lg={2}>
            Date Of Birth
          </Label>

          <Col sm={9} lg={4}>
            <Input
              id="customer_date_of_birth"
              name="customer_date_of_birth"
              placeholder="Enter date of birth"
              value={customer_date_of_birth}
              onChange={(e) => {
                setcustomer_date_of_birth(e.target.value.toString());
              }}
              type="date"
            />
            <p style={{ color: "red" }}>{formerrors.customer_date_of_birth}</p>
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
              value={user.password}
              onChange={changeHandler}
              type="password"
            />
            <p style={{ color: "red" }}>{formerrors.password}</p>
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

export default Register;
