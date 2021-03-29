import React, { Component, Fragment } from "react";
import { Box, Grid } from "@material-ui/core";
import MenuAppBar from "./MenuAppBar";
import CardCate from "./CardCate";
import ScopedCssBaseline from "@material-ui/core/ScopedCssBaseline";
import LiveGrid from "./LiveGrid";
import Live from "./Live";
import ReactPlayer from "react-player";
import Cam from "../Cam"
import axios from 'axios-react'
import SideBar from './SideBar'
import { makeStyles } from "@material-ui/core";
import ButtonDuStream from './ButtonDustream'
import { useTheme } from '@material-ui/core/styles';
import zIndex from "@material-ui/core/styles/zIndex";
import useMediaQuery from '@material-ui/core/useMediaQuery';

import {Grow} from '@material-ui/core'
// CSS
const useStyles = makeStyles({
  homeContainer: {
    color: props => props.color,
    width:'100%',
    position: 'absolute',
    zIndex : 2,
    backgroundColor: '#E9E9E9',
    paddingBottom: '100%',
    marginLeft : '100px',
    justifyContent : 'center'
  },

  title : {
    color : '#919191'
  },
  body : {
    backgroundColor: '#E9E9E9'
  } , 
  boxOne : {
    marginTop : '150px',
    marginLeft : '175px',
    justifyContent : 'center',
    textAlign: 'center',
    width:'70%'

  }
});




function Home (props){
 //to do 
  const [login , isLogin] = React.useState(false);

  //To do 
function doLogin(){
  
}
//classes permet d'acceder aux fonctionnalité makeStyl de MUI
const classes = useStyles(props);

  //fonction css
  const theme = useTheme();

    //GERER LES LIEN ROUTER 
const {history } = props; //permet de gerer les url
//Redirige vers sa catégorie respective
const handleClickCard = (url) => {
   history.push(url);
  }




  return (
    /*pour gérer les composant  enfant */
    <Fragment className={classes.homeContainer}>
      <MenuAppBar />
      <SideBar/>
      {/*<Cam />*/}
<div className={classes.boxOne} >
      <h1 className= {classes.title}> Catégorie suivis :</h1>
<Grow in={true}  timeout={'auto'}>
      <Grid
      
        container
        spacing={1}
        direction="row"
        justify="center"
        alignItems="center"
        alignContent="center"
        wrap="nowrap" /*alligne tout les item vers le centre */
      >
     
        <Grid item onClick= {()=>{handleClickCard('/cour/yoga')}}>
          {" "}
          <CardCate
            categoriesName="Yoga"
            image="https://larrogantefr.files.wordpress.com/2019/03/yoga-fertility-charlotte-muller1.jpg?w=1120s"
          />
        </Grid>
        <Grid item onClick= {()=>{handleClickCard('/cour/pdc')}} >
          {" "}
          <CardCate
            categoriesName="Muscu"
            image="https://www.ericfavre.com/lifestyle/wp-content/uploads/2020/06/methode-de-muscu.jpg"
          />
        </Grid>
        <Grid item  onClick= {()=>{handleClickCard('/cour/musculation')}}>
          {" "}
          <CardCate
            categoriesName="Exercice dos"
            image="https://d2z0k43lzfi12d.cloudfront.net/blog/vcdn316/wp-content/uploads/2016/02/thumbnail_6-helpful-exercises_1200x530.jpg"
            title="Exo dos"
          />
        </Grid>
      </Grid>
</Grow>
      <h3 className = {classes.title}>Recommandé pour vous :</h3>
      <Box marginTop={4} display="flex" justifyContent="center">
        <LiveGrid />
      </Box>
    <ButtonDuStream />
    </div>
    </Fragment>
  );
;
}
export default Home;
/*nécessite d'êtres authentifier pour accéder a cette page */
