import React, { useState } from "react";
import axios from "axios";
import { Typography, TextField, Button, Paper, Box } from "@mui/material";
import { useNavigate } from "react-router-dom";

const initial = {
  postId: 0,
  postProfile: "",
  reqExperience: 0,
  postTechStack: [],
  postDesc: ""
};

const Create = () => {
  const skillSet = [
    { name: "Javascript" },
    { name: "Java" },
    { name: "Python" },
    { name: "Django" },
    { name: "Rust" },
  ];

  const navigate = useNavigate();
  const [form, setForm] = useState(initial);

  const handleSubmit = (e) => {
    e.preventDefault();

    axios.post("http://localhost:8080/jobPost", form)
      .then((resp) => {
        console.log("Job Post Created:", resp.data);
        navigate("/");
      })
      .catch((error) => {
        console.error("Error creating job post:", error.response || error.message);
      });
  };

  const handleChange = (e) => {
    const { value, checked } = e.target;
    setForm({
      ...form,
      postTechStack: checked
        ? [...form.postTechStack, value]
        : form.postTechStack.filter((tech) => tech !== value),
    });
  };

  const { postId, postProfile, reqExperience, postDesc } = form;

  return (
    <Paper sx={{ padding: "1%" }} elevation={0}>
      <Typography sx={{ margin: "3% auto" }} align="center" variant="h5">
        Create New Job Post
      </Typography>
      <form autoComplete="off" noValidate onSubmit={handleSubmit}>
        <Box
          sx={{
            display: "flex",
            justifyContent: "center",
            flexDirection: "column",
          }}
        >
          <TextField
            type="number"
            sx={{ width: "50%", margin: "2% auto" }}
            required
            onChange={(e) => setForm({ ...form, postId: Number(e.target.value) })}
            label="Post ID"
            variant="outlined"
            value={postId}
          />
          <TextField
            sx={{ width: "50%", margin: "2% auto" }}
            required
            onChange={(e) => setForm({ ...form, postProfile: e.target.value })}
            label="Job Profile"
            variant="outlined"
            value={postProfile}
          />
          <TextField
            type="number"
            sx={{ width: "50%", margin: "2% auto" }}
            required
            onChange={(e) => setForm({ ...form, reqExperience: Number(e.target.value) })}
            label="Years of Experience"
            variant="outlined"
            value={reqExperience}
          />
          <TextField
            multiline
            rows={4}
            sx={{ width: "50%", margin: "2% auto" }}
            required
            onChange={(e) => setForm({ ...form, postDesc: e.target.value })}
            label="Job Description"
            variant="outlined"
            value={postDesc}
          />
          <Box sx={{ margin: "1% auto" }}>
            <h3>Please mention required skills</h3>
            <ul>
              {skillSet.map(({ name }, index) => (
                <li key={index}>
                  <input
                    type="checkbox"
                    id={`custom-checkbox-${index}`}
                    value={name}
                    checked={form.postTechStack.includes(name)}
                    onChange={handleChange}
                  />
                  <label htmlFor={`custom-checkbox-${index}`}>{name}</label>
                </li>
              ))}
            </ul>
          </Box>
          <Button sx={{ width: "50%", margin: "2% auto" }} variant="contained" type="submit">
            Submit
          </Button>
        </Box>
      </form>
    </Paper>
  );
};

export default Create;
