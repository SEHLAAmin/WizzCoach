import React, { Component, Fragment } from "react";
import { Box, Grid } from "@material-ui/core";
import MenuAppBar from "./MenuAppBar";
import CardCate from "./CardCate";
import ScopedCssBaseline from "@material-ui/core/ScopedCssBaseline";
import LiveGrid from "./LiveGrid";
import Live from "./Live";
import { withAuthenticator } from "@aws-amplify/ui-react";
import ReactPlayer from "react-player";
import Cam from "../Cam"
import axios from 'axios-react'
import SideBar from './SideBar'
import { makeStyles } from "@material-ui/core";
import { useTheme } from '@material-ui/core/styles';
/*

const categories = ["Yoga", "Muscu", "Dos"];
const Listcategories = categories.map((categories) => <h2>{categories}</h2>); */
import zIndex from "@material-ui/core/styles/zIndex";
import useMediaQuery from '@material-ui/core/useMediaQuery';

const useStyles = makeStyles({
  homeContainer: {
    backgroundColor: '',
    color: props => props.color,
    width:'100%',
    marginLeft : '5%',
    position: 'absolute',
    zIndex : 2,
    paddingBottom: '100%'
  },
});




function Home (props){

  const theme = useTheme();
  const matches = useMediaQuery(theme.breakpoints.up('sm'));

    
const {history } = props; //permet de gerer les url

//Redirige vers sa catégorie respective
const handleClickCard = (url) => {
   history.push(url);
  }
 const classes = useStyles(props);




  return (
    /*pour gérer les composant  enfant */
    <Fragment>
      <MenuAppBar />
      <SideBar>{`theme.breakpoints.up('sm') matches: ${matches}`}</SideBar>
      {/*<Cam />*/}
<div className = {classes.homeContainer}>
      <h1> Catégorie suivis :</h1>

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

      <h3>Recommandé pour vous :</h3>
      <Box marginTop={4} display="flex" justifyContent="center">
        <LiveGrid />
      </Box>

    </div>
    </Fragment>
  );
;
}
export default Home;
/*nécessite d'êtres authentifier pour accéder a cette page */
