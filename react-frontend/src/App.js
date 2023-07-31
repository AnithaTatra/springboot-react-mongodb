import React from "react";
import './App.css';
import CreateStudentComponent from './components/CreateStudentComponent';
import {BrowserRouter as Router, Route, Link, Routes} from 'react-router-dom';

function App() {
  return (
    <Routes>
          			<Route path="/add-student/:id" element={<CreateStudentComponent />} />

        		</Routes>
  );
}

export default App;
