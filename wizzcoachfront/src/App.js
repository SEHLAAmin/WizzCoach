
import React from 'react'
import './App.css';
import Home from './component/Home'
import { Router, Route, Switch,  browserHistory, IndexRoute  } from 'react-router';
import UserForm from './component/UserForm'
//config Amplify
import { BrowserRouter } from 'react-router-dom';
import Yoga from './component/CategoriesCompoment/Yoga';
import PDC from './component/CategoriesCompoment/PDC';
import Musculation from './component/CategoriesCompoment/Musculation';
import Profile from './component/Profile';
import Authent from './component/Authtent';
import { makeStyles } from '@material-ui/core';
import LiveForm from './component/CategoriesCompoment/LiveForm'
import ChooseCategorie from './component/CategoriesCompoment/ChooseCategorie';
/////

function App(props) {
  const useStyles = makeStyles((theme) => ({
   body : {
     margin : '0', 
     padding : '0'
   }
  }));
  
  const {history } = props;

  
  return (
    <div className="App">
  <BrowserRouter>
  <Switch>
    <Route exact from="/home" render = {props => <Home {...props} />}/>
    <Route exact from="/" render = {props => <Authent {...props} />}/>
    <Route exact from="/profile" render = {props => <Profile {...props} />}/>
    <Route exact from = "/UserForm" render = {props => <UserForm {...props} />}/>
    <Route exact from = "/cour/yoga" render = {props => <Yoga {...props} />}/>
    <Route exact from = "/cour/pdc" render = {props => <PDC {...props} />}/>
    <Route exact from = "/cour/categories" render = {props => <ChooseCategorie {...props} />}/>
    <Route exact from = "/cour/musculation" render = {props => <Musculation {...props} />}/>
    <Route exact from = "/cour" render = {props => <LiveForm {...props} />}/>

  </Switch>
</BrowserRouter>
    </div>
  );
}

export  default  App;
