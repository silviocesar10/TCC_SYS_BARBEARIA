import express from "express";
import connectDatabase from "./config/db.js"

const app = express();

app.get('/', (req, res) => {
  res.send('Hello Express app!')
});

app.listen(3000, () => {
  connectDatabase();
  console.log('server started');
});
