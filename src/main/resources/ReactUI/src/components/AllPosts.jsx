import React, { useEffect, useState } from "react";
import DeleteIcon from "@mui/icons-material/Delete";
import EditIcon from "@mui/icons-material/Edit";
import SearchIcon from "@mui/icons-material/Search";
import {
  Card,
  Grid,
  Typography,
  TextField,
  InputAdornment,
  Box
} from "@mui/material";
import axios from "axios";
import { useNavigate } from "react-router-dom";

const Search = () => {
  const [query, setQuery] = useState("");
  const [posts, setPosts] = useState([]);
  const navigate = useNavigate();

  const handleEdit = (id) => {
    navigate("/edit", { state: { id } });
  };

  const handleDelete = async (id) => {
    try {
      // Deleting the job post by id
      await axios.delete(`http://localhost:8080/jobPost/${id}`);
      console.log("Post deleted successfully");

      // Remove the deleted post from the UI without reloading the page
      setPosts((prevPosts) => prevPosts.filter((post) => post.postId !== id));
    } catch (error) {
      console.error("There was an error deleting the post:", error);
    }
  };

  useEffect(() => {
    const fetchPosts = async () => {
      const response = await axios.get(`http://localhost:8080/jobPosts/keyword/${query}`);
      setPosts(response.data);
    };

    const fetchInitialPosts = async () => {
      const response = await axios.get("http://localhost:8080/jobPosts");
      setPosts(response.data);
    };

    if (query.length === 0) fetchInitialPosts();
    if (query.length > 2) fetchPosts();
  }, [query]);

  return (
    <>
      <Grid container spacing={2} sx={{ margin: "2%" }}>
        <Grid item xs={12} sx={12} md={12} lg={12}>
          <Box>
            <TextField
              InputProps={{
                startAdornment: (
                  <InputAdornment position="start">
                    <SearchIcon />
                  </InputAdornment>
                ),
              }}
              placeholder="Search..."
              sx={{ width: "75%", padding: "2% auto" }}
              fullWidth
              onChange={(e) => setQuery(e.target.value)}
            />
          </Box>
        </Grid>

        {posts &&
          posts.map((p) => (
            <Grid key={p.postId} item xs={12} md={6} lg={4}>
              <Card sx={{ padding: "3%", backgroundColor: "#ADD8E6", width: "84%" }}>
                <Typography variant="h5" sx={{ fontWeight: "600", fontFamily: "sans-serif" }}>
                  {p.postProfile}
                </Typography>
                <Typography sx={{ color: "#585858", marginTop: "2%", fontFamily: "cursive" }}>
                  Description: {p.postDesc}
                </Typography>
                <Typography variant="h6" sx={{ fontFamily: "unset", mt: 2 }}>
                  Experience: {p.reqExperience} years
                </Typography>
                <Typography sx={{ fontFamily: "serif" }} gutterBottom>
                  Skills:
                </Typography>
                {p.postTechStack.map((s, i) => (
                  <Typography key={i} variant="body2">
                    {s}.
                  </Typography>
                ))}
                <DeleteIcon
                  onClick={() => handleDelete(p.postId)}
                  style={{ cursor: "pointer", marginRight: 10 }}
                />
                <EditIcon
                  onClick={() => handleEdit(p.postId)}
                  style={{ cursor: "pointer" }}
                />
              </Card>
            </Grid>
          ))}
      </Grid>
    </>
  );
};

export default Search;
